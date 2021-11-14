package com.crossmesh.mesher_solidity;

import com.crossmesh.mesher_solidity.config.Config;
import com.crossmesh.mesher_solidity.contracts.Structs;
import com.crossmesh.mesher_solidity.resource.Resource;
import com.crossmesh.mesher_solidity.resource.ResourceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class CrossTransactionMonitor {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrossTransactionMonitor.class);

    @Autowired
    private ResourceRegistry resourceRegistry;

    private final ScheduledExecutorService executorService;

    private final ConcurrentHashMap<String, ScheduledFuture<?>> transactionFutures = new ConcurrentHashMap<>();;

    public CrossTransactionMonitor(Config config) {
        this.executorService = Executors.newScheduledThreadPool(config.getCrossMonitorThreadNum());
    }

    public void monitor(Structs.NetworkTransactionPreparedEventEventResponse response) {
        this.transactionFutures.computeIfAbsent(response.PrimaryPrepareTxId.sender, s -> executorService.scheduleWithFixedDelay(() -> {
            Resource resource = resourceRegistry.getResource(response.PrimaryPrepareTxId.uri);
            resource
                    .evaluateGlobalTransaction(response.GlobalTxStatusQuery)
                    .whenComplete((v, e2) -> {
                        resource.getProofForTransaction(response.PrimaryPrepareTxId.sender)
                                .whenComplete((proof, e1) -> {
                                Resource resource1 = resourceRegistry.getResource(response.ConfirmTx.txId.uri);
                                Structs.NetworkTransaction networkTransaction = response.ConfirmTx;
                                networkTransaction.proof = proof;
                                resource1.submitNetworkTransaction(networkTransaction).whenComplete((v2, e) -> {
                                    if(e != null)LOGGER.error("submit network tx failed", v2.getError());
                                    transactionFutures.remove(response.PrimaryPrepareTxId.sender).cancel(true);
                                });
                        });
                    });
        }, 2, 1, TimeUnit.SECONDS));
    }

    public void stop() {
        this.executorService.shutdown();
    }
}
