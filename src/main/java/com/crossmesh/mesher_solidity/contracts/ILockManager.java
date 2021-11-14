package com.crossmesh.mesher_solidity.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class ILockManager extends Contract {
    public static final String BINARY = "0x";

    public static final String FUNC_GETSTATEMAYBELOCKED = "getStateMaybeLocked";

    public static final String FUNC_PUTSTATEMAYBELOCKED = "putStateMaybeLocked";

    public static final String FUNC_PUTLOCKEDSTATEWITHPRIMARYLOCK = "putLockedStateWithPrimaryLock";

    public static final String FUNC_PUTLOCKEDSTATEWITHNETWORKLOCK = "putLockedStateWithNetworkLock";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected ILockManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ILockManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ILockManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ILockManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Lock> getStateMaybeLocked(String key) {
        final Function function = new Function(FUNC_GETSTATEMAYBELOCKED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Lock>() {}));
        return executeRemoteCallSingleValueReturn(function, Lock.class);
    }

    public RemoteFunctionCall<TransactionReceipt> putStateMaybeLocked(String key, byte[] value) {
        final Function function = new Function(
                FUNC_PUTSTATEMAYBELOCKED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(key), 
                new org.web3j.abi.datatypes.DynamicBytes(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> putLockedStateWithPrimaryLock(String key, byte[] value) {
        final Function function = new Function(
                FUNC_PUTLOCKEDSTATEWITHPRIMARYLOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(key), 
                new org.web3j.abi.datatypes.DynamicBytes(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> putLockedStateWithNetworkLock(String key, byte[] value, String primaryNetwork, BigInteger primaryChain, String primaryTxSender) {
        final Function function = new Function(
                FUNC_PUTLOCKEDSTATEWITHNETWORKLOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(key), 
                new org.web3j.abi.datatypes.DynamicBytes(value), 
                new org.web3j.abi.datatypes.Utf8String(primaryNetwork), 
                new org.web3j.abi.datatypes.generated.Uint256(primaryChain), 
                new org.web3j.abi.datatypes.Address(primaryTxSender)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ILockManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ILockManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ILockManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ILockManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ILockManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ILockManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ILockManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ILockManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ILockManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ILockManager.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ILockManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ILockManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ILockManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ILockManager.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ILockManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ILockManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
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

    public static class Lock extends DynamicStruct {
        public TransactionID primaryPrepareTxId;

        public byte[] prevState;

        public byte[] updatingState;

        public Boolean isValid;

        public Lock(TransactionID primaryPrepareTxId, byte[] prevState, byte[] updatingState, Boolean isValid) {
            super(primaryPrepareTxId,new org.web3j.abi.datatypes.DynamicBytes(prevState),new org.web3j.abi.datatypes.DynamicBytes(updatingState),new org.web3j.abi.datatypes.Bool(isValid));
            this.primaryPrepareTxId = primaryPrepareTxId;
            this.prevState = prevState;
            this.updatingState = updatingState;
            this.isValid = isValid;
        }

        public Lock(TransactionID primaryPrepareTxId, DynamicBytes prevState, DynamicBytes updatingState, Bool isValid) {
            super(primaryPrepareTxId,prevState,updatingState,isValid);
            this.primaryPrepareTxId = primaryPrepareTxId;
            this.prevState = prevState.getValue();
            this.updatingState = updatingState.getValue();
            this.isValid = isValid.getValue();
        }
    }
}
