package com.crossmesh.mesher_solidity.resource;

import com.crossmesh.mesher_solidity.contracts.Structs;
import org.web3j.protocol.core.methods.response.EthSendTransaction;

import java.util.concurrent.CompletableFuture;

public interface Resource {
    CompletableFuture<EthSendTransaction> submitNetworkTransaction(Structs.NetworkTransaction networkTx);

    CompletableFuture<EthSendTransaction> evaluateGlobalTransaction(Structs.Invocation globalTxQuery);

    CompletableFuture<String> getProofForTransaction(String txId);

    void close();
}
