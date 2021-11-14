package com.crossmesh.mesher_solidity;

import com.crossmesh.mesher_solidity.contracts.Structs;
import com.crossmesh.mesher_solidity.resource.Resource;
import com.crossmesh.mesher_solidity.resource.ResourceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.protocol.core.methods.response.EthSendTransaction;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class Coordinator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Coordinator.class);


    @Autowired
    private ResourceRegistry resourceRegistry;

    @Autowired
    private CrossTransactionMonitor crossTransactionMonitor;

    public void handleResourceRegisteredEvent(Structs.ResourceRegisteredEventEventResponse response) {
        this.resourceRegistry.handleResourceRegisteredEvent(response);
    }
    public void handleNetworkTransactionPrepared(Structs.NetworkTransactionPreparedEventEventResponse response) {
        this.crossTransactionMonitor.monitor(response);
    }

    public void handlePrimaryTransactionPrepared(Structs.PrimaryTransactionPreparedEventEventResponse response){
        prepareNetworkTransaction(response).thenAccept(completableFutures ->
                {
                    try {
                        commitOrRollbackGlobalTransaction(response, completableFutures);
                    } catch (Exception e) {
                        LOGGER.error("prepare network transactions error", e.getMessage());
                    }
                })
                .exceptionally(throwable -> {
                    LOGGER.error("prepare network transactions error", throwable);
                    return null;
        });
    }

    public void handlePrimaryTransactionConfirmed(Structs.PrimaryTransactionConfirmedEventEventResponse response) {
        commitOrRollbackNetworkTransaction(response);
    }

    private CompletableFuture<List<CompletableFuture<EthSendTransaction>>> prepareNetworkTransaction(Structs.PrimaryTransactionPreparedEventEventResponse response){
        return resourceRegistry.getResource(response.PrimaryPrepareTxId.uri)
                .getProofForTransaction(response.PrimaryPrepareTxId.sender)
                .thenApply(proof ->{
                    List<CompletableFuture<EthSendTransaction>> futureResList = new ArrayList<>();
                    for (int i = 0; i < response.NetworkPrepareTxs.size(); i++){
                        Structs.NetworkTransaction tx = response.NetworkPrepareTxs.get(i);
                        tx.invocation.args.add(new Utf8String(response.GlobalTxStatusQuery.contractC));
                        tx.invocation.args.add(new Utf8String(response.GlobalTxStatusQuery.functionC));
                        tx.invocation.args.add(new Utf8String(response.PrimaryPrepareTxId.uri.network));
                        tx.invocation.args.add(new Utf8String(response.PrimaryPrepareTxId.uri.chain.toString()));
                        tx.invocation.args.add(new Utf8String(response.PrimaryPrepareTxId.sender));
                        tx.invocation.args.add(new Utf8String(proof));
                        CompletableFuture<EthSendTransaction> response1 = resourceRegistry.getResource(tx.txId.uri).submitNetworkTransaction(tx);
                        futureResList.add(response1);
                    }
                    return futureResList;
                });
    }

    private void commitOrRollbackGlobalTransaction(Structs.PrimaryTransactionPreparedEventEventResponse response, List<CompletableFuture<EthSendTransaction>> completableFutures) throws ExecutionException, InterruptedException {
        Structs.NetworkTransaction tx = response.PrimaryConfirmTx;
        for (int i = 0; i < response.NetworkPrepareTxs.size(); i++){
            CompletableFuture<EthSendTransaction> networkTxResCompletableFuture = completableFutures.get(i);
            EthSendTransaction txResponse = networkTxResCompletableFuture.get();
            tx.invocation.args.add(new Utf8String(response.NetworkPrepareTxs.get(i).txId.uri.network));
            tx.invocation.args.add(new Utf8String(response.NetworkPrepareTxs.get(i).txId.uri.chain.toString()));
            tx.invocation.args.add(new Utf8String(response.NetworkPrepareTxs.get(i).txId.sender));
            if(!txResponse.hasError())
                tx.invocation.args.add(new Utf8String(txResponse.getTransactionHash()));
        }
        Resource resource = resourceRegistry.getResource(tx.txId.uri);
        resource.submitNetworkTransaction(tx).whenComplete((response2, throwable) -> {
            if (throwable != null) {
                LOGGER.error("submit primary commit tx failed", throwable);
            }
        });
    }

    private void commitOrRollbackNetworkTransaction(Structs.PrimaryTransactionConfirmedEventEventResponse response){
        resourceRegistry.getResource(response.PrimaryConfirmedTxId.uri)
                .getProofForTransaction(response.PrimaryConfirmedTxId.sender)
                .thenAccept(proof ->
                    response
                            .NetworkConfirmTxs
                            .parallelStream()
                            .forEach(tx -> {
                                tx.invocation.args.add(new Utf8String(proof));
                                resourceRegistry.getResource(tx.txId.uri).submitNetworkTransaction(tx);
                            })
                ).exceptionally(throwable -> {
                    LOGGER.error("commit or rollback network transaction error", throwable);
                    return null;
                });
    }

    @PreDestroy
    public void stop() {
        this.crossTransactionMonitor.stop();
    }

    public ResourceRegistry getResourceRegistry() {
        return resourceRegistry;
    }
}
