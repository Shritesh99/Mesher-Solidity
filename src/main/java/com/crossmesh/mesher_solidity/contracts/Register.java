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
public class Register extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b5061071c806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c8063637a08321461003b578063f9c2af8614610050575b600080fd5b61004e610049366004610503565b610079565b005b61006361005e366004610570565b610153565b6040516100709190610611565b60405180910390f35b60006040518060400160405280600a815260200169534944455f4d4553485f60b01b81525084846040516020016100b29392919061062b565b6040516020818303038152906040529050816000806100d684805160209091012090565b815260200190815260200160002090805190602001906100f79291906103c7565b507f6c77d70149bc8968ea0a7b8e403aa4ddc97d5b8056aa3918b49dfd6a08f78c256040518060400160405280868152602001858152506101358490565b4660405161014593929190610660565b60405180910390a150505050565b60606040518060400160405280600a815260200169534944455f4d4553485f60b01b815250838360405160200161018c9392919061062b565b60408051601f19818403018152919052805160208201206101ac9061031f565b6040518060400160405280601d81526020017f5b52656769737465725d2043616e742061626c652066696e642075726900000081525090610223576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161021a9190610611565b60405180910390fd5b50600061027a6040518060400160405280600a815260200169534944455f4d4553485f60b01b81525086866040516020016102609392919061062b565b604051602081830303815290604052805160209091012090565b6000818152602081905260409020805491925090610297906106ab565b80601f01602080910402602001604051908101604052809291908181526020018280546102c3906106ab565b80156103105780601f106102e557610100808354040283529160200191610310565b820191906000526020600020905b8154815290600101906020018083116102f357829003601f168201915b50505050509250505092915050565b600081815260208190526040812080546103c1919061033d906106ab565b80601f0160208091040260200160405190810160405280929190818152602001828054610369906106ab565b80156103b65780601f1061038b576101008083540402835291602001916103b6565b820191906000526020600020905b81548152906001019060200180831161039957829003601f168201915b505050505051151590565b92915050565b8280546103d3906106ab565b90600052602060002090601f0160209004810192826103f5576000855561043b565b82601f1061040e57805160ff191683800117855561043b565b8280016001018555821561043b579182015b8281111561043b578251825591602001919060010190610420565b5061044792915061044b565b5090565b5b80821115610447576000815560010161044c565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261048757600080fd5b813567ffffffffffffffff808211156104a2576104a2610460565b604051601f8301601f19908116603f011681019082821181831017156104ca576104ca610460565b816040528381528660208588010111156104e357600080fd5b836020870160208301376000602085830101528094505050505092915050565b60008060006060848603121561051857600080fd5b833567ffffffffffffffff8082111561053057600080fd5b61053c87838801610476565b945060208601359350604086013591508082111561055957600080fd5b5061056686828701610476565b9150509250925092565b6000806040838503121561058357600080fd5b823567ffffffffffffffff81111561059a57600080fd5b6105a685828601610476565b95602094909401359450505050565b60005b838110156105d05781810151838201526020016105b8565b838111156105df576000848401525b50505050565b600081518084526105fd8160208601602086016105b5565b601f01601f19169290920160200192915050565b60208152600061062460208301846105e5565b9392505050565b6000845161063d8184602089016105b5565b8451908301906106518183602089016105b5565b01928352505060200192915050565b60608152600084516040606084015261067c60a08401826105e5565b905060208601516080840152828103602084015261069a81866105e5565b915050826040830152949350505050565b600181811c908216806106bf57607f821691505b602082108114156106e057634e487b7160e01b600052602260045260246000fd5b5091905056fea2646970667358221220a16f18608ce84bde87aa3c1b4c6bbdb6317a5de24c4fd26d958bcb419fb0f89b64736f6c63430008090033";

    public static final String FUNC_REGISTER = "register";

    public static final String FUNC_RESOLVE = "resolve";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Register(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Register(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Register(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Register(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> register(String network, BigInteger chain, String connection) {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(network), 
                new org.web3j.abi.datatypes.generated.Uint256(chain), 
                new org.web3j.abi.datatypes.Utf8String(connection)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> resolve(String network, BigInteger chain) {
        final Function function = new Function(FUNC_RESOLVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(network), 
                new org.web3j.abi.datatypes.generated.Uint256(chain)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Register load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Register(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Register load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Register(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Register load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Register(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Register load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Register(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Register> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Register.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Register> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Register.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Register> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Register.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Register> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Register.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
