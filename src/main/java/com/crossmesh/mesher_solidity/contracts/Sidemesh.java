package com.crossmesh.mesher_solidity.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class Sidemesh extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b506104b4806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806307e4b7e91461003b578063818edaec14610059575b600080fd5b61004361006e565b604051610050919061032d565b60405180910390f35b61006c610067366004610376565b61020b565b005b60606101036000805461008090610427565b80601f01602080910402602001604051908101604052809291908181526020018280546100ac90610427565b80156100f95780601f106100ce576101008083540402835291602001916100f9565b820191906000526020600020905b8154815290600101906020018083116100dc57829003601f168201915b5050505050610222565b6040518060400160405280601081526020017f4e6574776f726b20697320656d707479000000000000000000000000000000008152509061017a576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610171919061032d565b60405180910390fd5b506000805461018890610427565b80601f01602080910402602001604051908101604052809291908181526020018280546101b490610427565b80156102015780601f106101d657610100808354040283529160200191610201565b820191906000526020600020905b8154815290600101906020018083116101e457829003601f168201915b5050505050905090565b805161021e906000906020840190610264565b5050565b60408051600080825260208201808452825190209092909161024691859101610462565b60405160208183030381529060405280519060200120149050919050565b82805461027090610427565b90600052602060002090601f01602090048101928261029257600085556102d8565b82601f106102ab57805160ff19168380011785556102d8565b828001600101855582156102d8579182015b828111156102d85782518255916020019190600101906102bd565b506102e49291506102e8565b5090565b5b808211156102e457600081556001016102e9565b60005b83811015610318578181015183820152602001610300565b83811115610327576000848401525b50505050565b602081526000825180602084015261034c8160408501602087016102fd565b601f01601f19169190910160400192915050565b634e487b7160e01b600052604160045260246000fd5b60006020828403121561038857600080fd5b813567ffffffffffffffff808211156103a057600080fd5b818401915084601f8301126103b457600080fd5b8135818111156103c6576103c6610360565b604051601f8201601f19908116603f011681019083821181831017156103ee576103ee610360565b8160405282815287602084870101111561040757600080fd5b826020860160208301376000928101602001929092525095945050505050565b600181811c9082168061043b57607f821691505b6020821081141561045c57634e487b7160e01b600052602260045260246000fd5b50919050565b600082516104748184602087016102fd565b919091019291505056fea26469706673582212204187b1870acbfbdb79eddced2f2f049487da668fafd07eddfa8fdb7f097c3b3164736f6c63430008090033";

    public static final String FUNC_GETNETWORK = "getNetwork";

    public static final String FUNC_SETNETWORK = "setNetwork";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Sidemesh(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Sidemesh(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Sidemesh(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Sidemesh(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> getNetwork() {
        final Function function = new Function(FUNC_GETNETWORK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setNetwork(String networkC) {
        final Function function = new Function(
                FUNC_SETNETWORK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(networkC)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Sidemesh load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sidemesh(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Sidemesh load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sidemesh(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Sidemesh load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Sidemesh(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Sidemesh load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Sidemesh(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Sidemesh> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Sidemesh.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Sidemesh> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Sidemesh.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Sidemesh> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Sidemesh.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Sidemesh> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Sidemesh.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
