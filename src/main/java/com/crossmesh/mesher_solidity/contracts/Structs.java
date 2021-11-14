package com.crossmesh.mesher_solidity.contracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Structs extends Contract {
    public static final String BINARY = "0x60566037600b82828239805160001a607314602a57634e487b7160e01b600052600060045260246000fd5b30600052607381538281f3fe73000000000000000000000000000000000000000030146080604052600080fdfea26469706673582212208c1917bd7d84b7d3d309b157530ad3f4ceb79d27dbf1755cb256dd56d5af0ae564736f6c63430008090033";

    public static final Event NETWORKTRANSACTIONPREPAREDEVENT_EVENT = new Event("NetworkTransactionPreparedEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<TransactionID>() {}, new TypeReference<Invocation>() {}, new TypeReference<NetworkTransaction>() {}));
    ;

    public static final Event NETWORKTRANSACTIONRESPONSEEVENT_EVENT = new Event("NetworkTransactionResponseEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<NetworkTransactionResponse>() {}));
    ;

    public static final Event PRIMARYTRANSACTIONCONFIRMEDEVENT_EVENT = new Event("PrimaryTransactionConfirmedEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<TransactionID>() {}, new TypeReference<DynamicArray<NetworkTransaction>>() {}));
    ;

    public static final Event PRIMARYTRANSACTIONPREPAREDEVENT_EVENT = new Event("PrimaryTransactionPreparedEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<TransactionID>() {}, new TypeReference<NetworkTransaction>() {}, new TypeReference<Invocation>() {}, new TypeReference<DynamicArray<NetworkTransaction>>() {}, new TypeReference<DynamicArray<NetworkTransaction>>() {}));
    ;

    public static final Event RESOURCEREGISTEREDEVENT_EVENT = new Event("ResourceRegisteredEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<URI>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Structs(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Structs(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Structs(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Structs(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<NetworkTransactionPreparedEventEventResponse> getNetworkTransactionPreparedEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NETWORKTRANSACTIONPREPAREDEVENT_EVENT, transactionReceipt);
        ArrayList<NetworkTransactionPreparedEventEventResponse> responses = new ArrayList<NetworkTransactionPreparedEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NetworkTransactionPreparedEventEventResponse typedResponse = new NetworkTransactionPreparedEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.PrimaryPrepareTxId = (TransactionID) eventValues.getNonIndexedValues().get(0);
            typedResponse.GlobalTxStatusQuery = (Invocation) eventValues.getNonIndexedValues().get(1);
            typedResponse.ConfirmTx = (NetworkTransaction) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NetworkTransactionPreparedEventEventResponse> networkTransactionPreparedEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NetworkTransactionPreparedEventEventResponse>() {
            @Override
            public NetworkTransactionPreparedEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NETWORKTRANSACTIONPREPAREDEVENT_EVENT, log);
                NetworkTransactionPreparedEventEventResponse typedResponse = new NetworkTransactionPreparedEventEventResponse();
                typedResponse.log = log;
                typedResponse.PrimaryPrepareTxId = (TransactionID) eventValues.getNonIndexedValues().get(0);
                typedResponse.GlobalTxStatusQuery = (Invocation) eventValues.getNonIndexedValues().get(1);
                typedResponse.ConfirmTx = (NetworkTransaction) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Flowable<NetworkTransactionPreparedEventEventResponse> networkTransactionPreparedEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NETWORKTRANSACTIONPREPAREDEVENT_EVENT));
        return networkTransactionPreparedEventEventFlowable(filter);
    }

    public List<NetworkTransactionResponseEventEventResponse> getNetworkTransactionResponseEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NETWORKTRANSACTIONRESPONSEEVENT_EVENT, transactionReceipt);
        ArrayList<NetworkTransactionResponseEventEventResponse> responses = new ArrayList<NetworkTransactionResponseEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NetworkTransactionResponseEventEventResponse typedResponse = new NetworkTransactionResponseEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.response = (NetworkTransactionResponse) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NetworkTransactionResponseEventEventResponse> networkTransactionResponseEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NetworkTransactionResponseEventEventResponse>() {
            @Override
            public NetworkTransactionResponseEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NETWORKTRANSACTIONRESPONSEEVENT_EVENT, log);
                NetworkTransactionResponseEventEventResponse typedResponse = new NetworkTransactionResponseEventEventResponse();
                typedResponse.log = log;
                typedResponse.response = (NetworkTransactionResponse) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Flowable<NetworkTransactionResponseEventEventResponse> networkTransactionResponseEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NETWORKTRANSACTIONRESPONSEEVENT_EVENT));
        return networkTransactionResponseEventEventFlowable(filter);
    }

    public List<PrimaryTransactionConfirmedEventEventResponse> getPrimaryTransactionConfirmedEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PRIMARYTRANSACTIONCONFIRMEDEVENT_EVENT, transactionReceipt);
        ArrayList<PrimaryTransactionConfirmedEventEventResponse> responses = new ArrayList<PrimaryTransactionConfirmedEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PrimaryTransactionConfirmedEventEventResponse typedResponse = new PrimaryTransactionConfirmedEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.PrimaryConfirmedTxId = (TransactionID) eventValues.getNonIndexedValues().get(0);
            typedResponse.NetworkConfirmTxs = (List<NetworkTransaction>) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PrimaryTransactionConfirmedEventEventResponse> primaryTransactionConfirmedEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PrimaryTransactionConfirmedEventEventResponse>() {
            @Override
            public PrimaryTransactionConfirmedEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PRIMARYTRANSACTIONCONFIRMEDEVENT_EVENT, log);
                PrimaryTransactionConfirmedEventEventResponse typedResponse = new PrimaryTransactionConfirmedEventEventResponse();
                typedResponse.log = log;
                typedResponse.PrimaryConfirmedTxId = (TransactionID) eventValues.getNonIndexedValues().get(0);
                typedResponse.NetworkConfirmTxs = (List<NetworkTransaction>) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PrimaryTransactionConfirmedEventEventResponse> primaryTransactionConfirmedEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRIMARYTRANSACTIONCONFIRMEDEVENT_EVENT));
        return primaryTransactionConfirmedEventEventFlowable(filter);
    }

    public List<PrimaryTransactionPreparedEventEventResponse> getPrimaryTransactionPreparedEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PRIMARYTRANSACTIONPREPAREDEVENT_EVENT, transactionReceipt);
        ArrayList<PrimaryTransactionPreparedEventEventResponse> responses = new ArrayList<PrimaryTransactionPreparedEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PrimaryTransactionPreparedEventEventResponse typedResponse = new PrimaryTransactionPreparedEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.PrimaryPrepareTxId = (TransactionID) eventValues.getNonIndexedValues().get(0);
            typedResponse.PrimaryConfirmTx = (NetworkTransaction) eventValues.getNonIndexedValues().get(1);
            typedResponse.GlobalTxStatusQuery = (Invocation) eventValues.getNonIndexedValues().get(2);
            typedResponse.NetworkPrepareTxs = (List<NetworkTransaction>) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.NetworkConfirmTxs = (List<NetworkTransaction>) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PrimaryTransactionPreparedEventEventResponse> primaryTransactionPreparedEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PrimaryTransactionPreparedEventEventResponse>() {
            @Override
            public PrimaryTransactionPreparedEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PRIMARYTRANSACTIONPREPAREDEVENT_EVENT, log);
                PrimaryTransactionPreparedEventEventResponse typedResponse = new PrimaryTransactionPreparedEventEventResponse();
                typedResponse.log = log;
                typedResponse.PrimaryPrepareTxId = (TransactionID) eventValues.getNonIndexedValues().get(0);
                typedResponse.PrimaryConfirmTx = (NetworkTransaction) eventValues.getNonIndexedValues().get(1);
                typedResponse.GlobalTxStatusQuery = (Invocation) eventValues.getNonIndexedValues().get(2);
                typedResponse.NetworkPrepareTxs = (List<NetworkTransaction>) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.NetworkConfirmTxs = (List<NetworkTransaction>) eventValues.getNonIndexedValues().get(4).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PrimaryTransactionPreparedEventEventResponse> primaryTransactionPreparedEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PRIMARYTRANSACTIONPREPAREDEVENT_EVENT));
        return primaryTransactionPreparedEventEventFlowable(filter);
    }

    public List<ResourceRegisteredEventEventResponse> getResourceRegisteredEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESOURCEREGISTEREDEVENT_EVENT, transactionReceipt);
        ArrayList<ResourceRegisteredEventEventResponse> responses = new ArrayList<ResourceRegisteredEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ResourceRegisteredEventEventResponse typedResponse = new ResourceRegisteredEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.uri = (URI) eventValues.getNonIndexedValues().get(0);
            typedResponse.connection = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.chainid = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ResourceRegisteredEventEventResponse> resourceRegisteredEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ResourceRegisteredEventEventResponse>() {
            @Override
            public ResourceRegisteredEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESOURCEREGISTEREDEVENT_EVENT, log);
                ResourceRegisteredEventEventResponse typedResponse = new ResourceRegisteredEventEventResponse();
                typedResponse.log = log;
                typedResponse.uri = (URI) eventValues.getNonIndexedValues().get(0);
                typedResponse.connection = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.chainid = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ResourceRegisteredEventEventResponse> resourceRegisteredEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESOURCEREGISTEREDEVENT_EVENT));
        return resourceRegisteredEventEventFlowable(filter);
    }

    @Deprecated
    public static Structs load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Structs(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Structs load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Structs(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Structs load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Structs(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Structs load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Structs(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Structs> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Structs.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Structs> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Structs.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Structs> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Structs.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Structs> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Structs.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class URI extends DynamicStruct {
        public String network;

        public BigInteger chain;

        public URI(String network, BigInteger chain) {
            super(new org.web3j.abi.datatypes.Utf8String(network),new org.web3j.abi.datatypes.generated.Uint256(chain));
            this.network = network;
            this.chain = chain;
        }

        public URI(Utf8String network, Uint256 chain) {
            super(network,chain);
            this.network = network.getValue();
            this.chain = chain.getValue();
        }
    }

    public static class Invocation extends DynamicStruct {
        public String contractC;

        public String functionC;

        public List<Utf8String> args;

        public Invocation(String contractC, String functionC, List<Utf8String> args) {
            super(new org.web3j.abi.datatypes.Address(contractC),new org.web3j.abi.datatypes.Utf8String(functionC),new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(args));
            this.contractC = contractC;
            this.functionC = functionC;
            this.args = args;
        }

        public Invocation(Address contractC, Utf8String functionC, DynamicArray<Utf8String> args) {
            super(contractC,functionC,args);
            this.contractC = contractC.getValue();
            this.functionC = functionC.getValue();
            this.args = args.getValue();
        }
    }

    public static class TransactionID extends DynamicStruct {
        public URI uri;

        public String sender;

        public TransactionID(URI uri, String sender) {
            super(uri,new org.web3j.abi.datatypes.Address(sender));
            this.uri = uri;
            this.sender = sender;
        }

        public TransactionID(URI uri, Address sender) {
            super(uri,sender);
            this.uri = uri;
            this.sender = sender.getValue();
        }
    }

    public static class NetworkTransaction extends DynamicStruct {
        public TransactionID txId;

        public Invocation invocation;

        public String proof;

        public NetworkTransaction(TransactionID txId, Invocation invocation, String proof) {
            super(txId,invocation,new org.web3j.abi.datatypes.Utf8String(proof));
            this.txId = txId;
            this.invocation = invocation;
            this.proof = proof;
        }

        public NetworkTransaction(TransactionID txId, Invocation invocation, Utf8String proof) {
            super(txId,invocation,proof);
            this.txId = txId;
            this.invocation = invocation;
            this.proof = proof.getValue();
        }
    }

    public static class NetworkTransactionResponse extends DynamicStruct {
        public TransactionID txId;

        public BigInteger response;

        public byte[] proof;

        public NetworkTransactionResponse(TransactionID txId, BigInteger response, byte[] proof) {
            super(txId,new org.web3j.abi.datatypes.generated.Uint8(response),new org.web3j.abi.datatypes.DynamicBytes(proof));
            this.txId = txId;
            this.response = response;
            this.proof = proof;
        }

        public NetworkTransactionResponse(TransactionID txId, Uint8 response, DynamicBytes proof) {
            super(txId,response,proof);
            this.txId = txId;
            this.response = response.getValue();
            this.proof = proof.getValue();
        }
    }

    public static class NetworkTransactionPreparedEventEventResponse extends BaseEventResponse {
        public TransactionID PrimaryPrepareTxId;

        public Invocation GlobalTxStatusQuery;

        public NetworkTransaction ConfirmTx;
    }

    public static class NetworkTransactionResponseEventEventResponse extends BaseEventResponse {
        public NetworkTransactionResponse response;
    }

    public static class PrimaryTransactionConfirmedEventEventResponse extends BaseEventResponse {
        public TransactionID PrimaryConfirmedTxId;

        public List<NetworkTransaction> NetworkConfirmTxs;
    }

    public static class PrimaryTransactionPreparedEventEventResponse extends BaseEventResponse {
        public TransactionID PrimaryPrepareTxId;

        public NetworkTransaction PrimaryConfirmTx;

        public Invocation GlobalTxStatusQuery;

        public List<NetworkTransaction> NetworkPrepareTxs;

        public List<NetworkTransaction> NetworkConfirmTxs;
    }

    public static class ResourceRegisteredEventEventResponse extends BaseEventResponse {
        public URI uri;

        public byte[] connection;

        public BigInteger chainid;
    }
}
