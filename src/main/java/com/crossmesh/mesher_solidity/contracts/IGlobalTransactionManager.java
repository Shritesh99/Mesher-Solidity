package com.crossmesh.mesher_solidity.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class IGlobalTransactionManager extends Contract {
    public static final String BINARY = "0x";

    public static final String FUNC_STARTGLOBALTRANSACTION = "startGlobalTransaction";

    public static final String FUNC_REGISTERNETWORKTRANSACTION = "registerNetworkTransaction";

    public static final String FUNC_PREPAREPRIMARYTRANSACTION = "preparePrimaryTransaction";

    public static final String FUNC_CONFIRMPRIMARYTRANSACTION = "confirmPrimaryTransaction";

    public static final String FUNC_STARTNETWORKTRANSACTION = "startNetworkTransaction";

    public static final String FUNC_PREPARENETWORKTRANSACTION = "prepareNetworkTransaction";

    public static final String FUNC_CONFIRMNETWORKTRANSACTION = "confirmNetworkTransaction";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected IGlobalTransactionManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IGlobalTransactionManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IGlobalTransactionManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IGlobalTransactionManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> startGlobalTransaction(BigInteger ttlHeight, BigInteger ttlTime) {
        final Function function = new Function(
                FUNC_STARTGLOBALTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(ttlHeight), 
                new org.web3j.abi.datatypes.generated.Uint256(ttlTime)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> registerNetworkTransaction(String network, BigInteger chain, String contractC, String functionC, List<String> args) {
        final Function function = new Function(
                FUNC_REGISTERNETWORKTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(network), 
                new org.web3j.abi.datatypes.generated.Uint256(chain), 
                new org.web3j.abi.datatypes.Address(contractC), 
                new org.web3j.abi.datatypes.Utf8String(functionC), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(
                        org.web3j.abi.datatypes.Utf8String.class,
                        org.web3j.abi.Utils.typeMap(args, org.web3j.abi.datatypes.Utf8String.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> preparePrimaryTransaction(String functionC) {
        final Function function = new Function(
                FUNC_PREPAREPRIMARYTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(functionC)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> confirmPrimaryTransaction(String primaryPrepareTxSender, List<List<String>> networkTxRes) {
        final Function function = new Function(
                FUNC_CONFIRMPRIMARYTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(primaryPrepareTxSender), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicArray>(
                        org.web3j.abi.datatypes.DynamicArray.class,
                        org.web3j.abi.Utils.typeMap(networkTxRes, org.web3j.abi.datatypes.DynamicArray.class,
                org.web3j.abi.datatypes.Utf8String.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> startNetworkTransaction(String primaryNetwork, BigInteger primaryChain, String primaryTxSender, String primaryTxProof) {
        final Function function = new Function(
                FUNC_STARTNETWORKTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(primaryNetwork), 
                new org.web3j.abi.datatypes.generated.Uint256(primaryChain), 
                new org.web3j.abi.datatypes.Address(primaryTxSender), 
                new org.web3j.abi.datatypes.Utf8String(primaryTxProof)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> prepareNetworkTransaction(String primaryNetwork, BigInteger primaryChain, String primaryTxSender, String globalTxQueryContract, String globalTxQueryFunc, String functionC) {
        final Function function = new Function(
                FUNC_PREPARENETWORKTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(primaryNetwork), 
                new org.web3j.abi.datatypes.generated.Uint256(primaryChain), 
                new org.web3j.abi.datatypes.Address(primaryTxSender), 
                new org.web3j.abi.datatypes.Address(globalTxQueryContract), 
                new org.web3j.abi.datatypes.Utf8String(globalTxQueryFunc), 
                new org.web3j.abi.datatypes.Utf8String(functionC)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> confirmNetworkTransaction(String networkPrepareTxSender, BigInteger globalTxStatus, String primaryNetwork, BigInteger primaryChain, String primaryConfirmTxSender, String primaryConfirmTxProof) {
        final Function function = new Function(
                FUNC_CONFIRMNETWORKTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(networkPrepareTxSender), 
                new org.web3j.abi.datatypes.generated.Uint256(globalTxStatus), 
                new org.web3j.abi.datatypes.Utf8String(primaryNetwork), 
                new org.web3j.abi.datatypes.generated.Uint256(primaryChain), 
                new org.web3j.abi.datatypes.Address(primaryConfirmTxSender), 
                new org.web3j.abi.datatypes.Utf8String(primaryConfirmTxProof)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IGlobalTransactionManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IGlobalTransactionManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IGlobalTransactionManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IGlobalTransactionManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IGlobalTransactionManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IGlobalTransactionManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IGlobalTransactionManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IGlobalTransactionManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IGlobalTransactionManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IGlobalTransactionManager.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IGlobalTransactionManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IGlobalTransactionManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IGlobalTransactionManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IGlobalTransactionManager.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IGlobalTransactionManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IGlobalTransactionManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
