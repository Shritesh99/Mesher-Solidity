package com.crossmesh.mesher_solidity.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
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
public class Verifier extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b5061074f806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c8063a17185491461003b578063f9c2af8614610050575b600080fd5b61004e61004936600461051c565b61007a565b005b61006361005e3660046105b7565b61015b565b604051610071929190610658565b60405180910390f35b60006100d06040518060400160405280600a815260200169534944455f4d4553485f60b01b81525086866040516020016100b69392919061068f565b604051602081830303815290604052805160209091012090565b60408051808201825273ffffffffffffffffffffffffffffffffffffffff86811682526020808301878152600086815280835294909420835181547fffffffffffffffffffffffff000000000000000000000000000000000000000016931692909217825592518051949550919390926101519260018501929101906103e0565b5050505050505050565b600060606040518060400160405280600a815260200169534944455f4d4553485f60b01b81525084846040516020016101969392919061068f565b60408051601f19818403018152919052805160208201206101b690610335565b6040518060400160405280601d81526020017f5b56657269666965725d2043616e742061626c652066696e64207572690000008152509061022d576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161022491906106c4565b60405180910390fd5b50600061026a6040518060400160405280600a815260200169534944455f4d4553485f60b01b81525087876040516020016100b69392919061068f565b600081815260208190526040902080546001909101805492935073ffffffffffffffffffffffffffffffffffffffff9091169181906102a8906106de565b80601f01602080910402602001604051908101604052809291908181526020018280546102d4906106de565b80156103215780601f106102f657610100808354040283529160200191610321565b820191906000526020600020905b81548152906001019060200180831161030457829003601f168201915b505050505090509350935050509250929050565b600081815260208190526040812060010180546103da9190610356906106de565b80601f0160208091040260200160405190810160405280929190818152602001828054610382906106de565b80156103cf5780601f106103a4576101008083540402835291602001916103cf565b820191906000526020600020905b8154815290600101906020018083116103b257829003601f168201915b505050505051151590565b92915050565b8280546103ec906106de565b90600052602060002090601f01602090048101928261040e5760008555610454565b82601f1061042757805160ff1916838001178555610454565b82800160010185558215610454579182015b82811115610454578251825591602001919060010190610439565b50610460929150610464565b5090565b5b808211156104605760008155600101610465565b634e487b7160e01b600052604160045260246000fd5b600082601f8301126104a057600080fd5b813567ffffffffffffffff808211156104bb576104bb610479565b604051601f8301601f19908116603f011681019082821181831017156104e3576104e3610479565b816040528381528660208588010111156104fc57600080fd5b836020870160208301376000602085830101528094505050505092915050565b6000806000806080858703121561053257600080fd5b843567ffffffffffffffff8082111561054a57600080fd5b6105568883890161048f565b9550602087013594506040870135915073ffffffffffffffffffffffffffffffffffffffff8216821461058857600080fd5b9092506060860135908082111561059e57600080fd5b506105ab8782880161048f565b91505092959194509250565b600080604083850312156105ca57600080fd5b823567ffffffffffffffff8111156105e157600080fd5b6105ed8582860161048f565b95602094909401359450505050565b60005b838110156106175781810151838201526020016105ff565b83811115610626576000848401525b50505050565b600081518084526106448160208601602086016105fc565b601f01601f19169290920160200192915050565b73ffffffffffffffffffffffffffffffffffffffff83168152604060208201526000610687604083018461062c565b949350505050565b600084516106a18184602089016105fc565b8451908301906106b58183602089016105fc565b01928352505060200192915050565b6020815260006106d7602083018461062c565b9392505050565b600181811c908216806106f257607f821691505b6020821081141561071357634e487b7160e01b600052602260045260246000fd5b5091905056fea26469706673582212203e19a7aa3d1d2ea44c097a6ae2375a8f268372261e15b819832e32fde240fd6164736f6c63430008090033";

    public static final String FUNC_REGISTER = "register";

    public static final String FUNC_RESOLVE = "resolve";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Verifier(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Verifier(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Verifier(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Verifier(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> register(String network, BigInteger chain, String contractC, String functionC) {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(network), 
                new org.web3j.abi.datatypes.generated.Uint256(chain), 
                new org.web3j.abi.datatypes.Address(contractC), 
                new org.web3j.abi.datatypes.Utf8String(functionC)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple2<String, String>> resolve(String network, BigInteger chain) {
        final Function function = new Function(FUNC_RESOLVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(network), 
                new org.web3j.abi.datatypes.generated.Uint256(chain)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple2<String, String>>(function,
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    @Deprecated
    public static Verifier load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Verifier(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Verifier load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Verifier(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Verifier load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Verifier(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Verifier load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Verifier(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Verifier> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Verifier.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Verifier> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Verifier.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Verifier> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Verifier.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Verifier> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Verifier.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
