package com.crossmesh.mesher_solidity.resource;

import com.crossmesh.mesher_solidity.contracts.Structs;
import com.crossmesh.mesher_solidity.modals.Connection;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.*;

public class Web3Resource implements Resource {
    private static final Logger LOGGER = LoggerFactory.getLogger(Web3Resource.class);

    private final Structs.URI uri;
    private final ConcurrentHashMap<String, ScheduledFuture<?>> proofFutures;
    private final ConcurrentHashMap<String, CompletableFuture<EthSendTransaction>> transactionResults;

    Gson gson;
    Web3j web3j;
    Connection connection;
    Credentials credentials;

    private final ScheduledExecutorService scheduledExecutorService;

    public Web3Resource(Structs.URI uri, byte[] _connection) {
        this.uri = uri;
        this.transactionResults = new ConcurrentHashMap<>();
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        this.gson = new Gson();
        this.connection = gson.fromJson(new String(_connection), Connection.class);

        this.web3j = Web3j.build(new HttpService(connection.getServer()));
        this.credentials = Credentials.create(connection.getPrivatekey());
        this.proofFutures = new ConcurrentHashMap<>();
    }

    @Override
    public CompletableFuture<EthSendTransaction> submitNetworkTransaction(Structs.NetworkTransaction networkTx) {
        if(!networkTx.txId.uri.equals(this.uri)){
            throw new RuntimeException("resource uri not match transaction uri");
        }

        Function function = new Function(networkTx.invocation.functionC, Arrays.<Type>asList((Type) networkTx.invocation.args), Collections.<TypeReference<?>>emptyList());
        String encodedFunction = FunctionEncoder.encode(function);
        Transaction transaction = Transaction.createFunctionCallTransaction(
                credentials.getAddress(),
                BigInteger.ONE,
                new BigInteger(connection.getGasprice()),
                new BigInteger(connection.getGaslimit()),
                networkTx.invocation.contractC,
                encodedFunction);
        return web3j.ethSendTransaction(transaction).sendAsync();
    }

    @Override
    public CompletableFuture<EthSendTransaction> evaluateGlobalTransaction(Structs.Invocation globalTxQuery) {
        Function function = new Function(globalTxQuery.functionC, Arrays.<Type>asList((Type) globalTxQuery.args), Collections.<TypeReference<?>>emptyList());
        String encodedFunction = FunctionEncoder.encode(function);
        Transaction transaction = Transaction.createFunctionCallTransaction(
                credentials.getAddress(),
                BigInteger.ONE,
                new BigInteger(connection.getGasprice()),
                new BigInteger(connection.getGaslimit()),
                globalTxQuery.contractC,
                encodedFunction);
        return web3j.ethSendTransaction(transaction).sendAsync();
    }

    public void addTransactionEvent(String sender, EthSendTransaction tx) {
        this.transactionResults.putIfAbsent(sender, CompletableFuture.completedFuture(tx));
    }

    @Override
    public CompletableFuture<String> getProofForTransaction(String sender) {
        CompletableFuture<EthSendTransaction> future = transactionResults.remove(sender);
        return future.thenApply(EthSendTransaction::getTransactionHash);
    }

    @Override
    public void close() {
        this.scheduledExecutorService.shutdown();
    }
}
