package com.crossmesh.mesher_solidity.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
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
public class LockManager extends Contract {
    public static final String BINARY = "0x60806040523480156200001157600080fd5b506040516200263a3803806200263a83398101604081905262000034916200005a565b600380546001600160a01b0319166001600160a01b03929092169190911790556200008c565b6000602082840312156200006d57600080fd5b81516001600160a01b03811681146200008557600080fd5b9392505050565b61259e806200009c6000396000f3fe608060405234801561001057600080fd5b50600436106100d45760003560e01c8063b5081f2d11610081578063d6f27b581161005b578063d6f27b58146101c4578063e817aaa5146101d7578063fb24f56c146101f757600080fd5b8063b5081f2d14610163578063ba70311e14610191578063c75163d3146101a457600080fd5b806380060e66116100b257806380060e661461012a578063929c21611461013d57806399ce1fd41461015057600080fd5b80635732a361146100d957806361877d6a146100ee5780636f3566a614610117575b600080fd5b6100ec6100e7366004611e1c565b61020a565b005b6101016100fc366004611f5d565b6102c9565b60405161010e9190611fd7565b60405180910390f35b6100ec610125366004611ff1565b610389565b6100ec610138366004611ff1565b6107e1565b61010161014b366004611f5d565b61097b565b6100ec61015e366004612055565b61099f565b6101836101713660046120f8565b60009081526002602052604090205490565b60405190815260200161010e565b6100ec61019f366004612111565b610b81565b6101b76101b236600461214e565b610bb8565b60405161010e919061218b565b6101b76101d23660046120f8565b610e90565b6101836101e53660046120f8565b60009081526001602052604090205490565b6101b761020536600461214e565b6110ba565b6000828152602081815260409091208251805180518051869585939284926102359284920190611be9565b5060209182015160019091015591820151600290910180546001600160a01b0390921673ffffffffffffffffffffffffffffffffffffffff1990921691909117905582810151805161028d9260038501920190611be9565b50604082015180516102a9916004840191602090910190611be9565b50606091909101516005909101805460ff19169115159190911790555050565b6000828152600260205260409020805460609190839081106102ed576102ed612230565b90600052602060002001805461030290612246565b80601f016020809104026020016040519081016040528092919081815260200182805461032e90612246565b801561037b5780601f106103505761010080835404028352916020019161037b565b820191906000526020600020905b81548152906001019060200180831161035e57829003601f168201915b505050505090505b92915050565b600354604080516307e4b7e960e01b815290516000926001600160a01b0316916307e4b7e99160048083019286929190829003018186803b1580156103cd57600080fd5b505afa1580156103e1573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526104099190810190612281565b9050600061043b8460405160200161042191906122f8565b604051602081830303815290604052805160209091012090565b6040805160808101825280820185815246606083015281523360208083019190915260008481529081905291909120600501549192509060ff1661055d57610481611c6d565b604080820186905282825260016060830152600084815260208181529190208251805180518051869585939284926104bc9284920190611be9565b5060209182015160019091015591820151600290910180546001600160a01b0390921673ffffffffffffffffffffffffffffffffffffffff199092169190911790558281015180516105149260038501920190611be9565b5060408201518051610530916004840191602090910190611be9565b50606091909101516005909101805460ff1916911515919091179055610555866114f5565b505050505050565b60008281526020819052604090819020815161010081019092528054610784929190829060808201908390829060c085019083908290829061059e90612246565b80601f01602080910402602001604051908101604052809291908181526020018280546105ca90612246565b80156106175780601f106105ec57610100808354040283529160200191610617565b820191906000526020600020905b8154815290600101906020018083116105fa57829003601f168201915b505050918352505060019190910154602091820152908252600292909201546001600160a01b031690820152908252600383018054929091019161065a90612246565b80601f016020809104026020016040519081016040528092919081815260200182805461068690612246565b80156106d35780601f106106a8576101008083540402835291602001916106d3565b820191906000526020600020905b8154815290600101906020018083116106b657829003601f168201915b505050505081526020016004820180546106ec90612246565b80601f016020809104026020016040519081016040528092919081815260200182805461071890612246565b80156107655780601f1061073a57610100808354040283529160200191610765565b820191906000526020600020905b81548152906001019060200180831161074857829003601f168201915b50505091835250506005919091015460ff1615156020909101526115f9565b6040518060400160405280601f81526020017f4e6565642052656c656173652045787069726564204c6f636b204572726f7200815250906105555760405162461bcd60e51b81526004016107d89190611fd7565b60405180910390fd5b60006107f78360405160200161042191906122f8565b60008181526020819052604090206005015490915060ff166108e05761081c826110ba565b6000828152602081815260409091208251805180518051939492938593849261084b9284929190910190611be9565b5060209182015160019091015591820151600290910180546001600160a01b0390921673ffffffffffffffffffffffffffffffffffffffff199092169190911790558281015180516108a39260038501920190611be9565b50604082015180516108bf916004840191602090910190611be9565b50606091909101516005909101805460ff1916911515919091179055505050565b60008181526020819052604090819020815161010081019092528054610921929190829060808201908390829060c085019083908290829061059e90612246565b6040518060400160405280601f81526020017f4e6565642052656c656173652045787069726564204c6f636b204572726f7200815250906109755760405162461bcd60e51b81526004016107d89190611fd7565b50505050565b6000828152600160205260409020805460609190839081106102ed576102ed612230565b60006109b58660405160200161042191906122f8565b604080516080810182528082018781526060820187905281526001600160a01b03851660208083019190915260008481529081905291909120600501549192509060ff16610ae157610a05611c6d565b60408082018890528282526001606083015260008481526020818152919020825180518051805186958593928492610a409284920190611be9565b5060209182015160019091015591820151600290910180546001600160a01b0390921673ffffffffffffffffffffffffffffffffffffffff19909216919091179055828101518051610a989260038501920190611be9565b5060408201518051610ab4916004840191602090910190611be9565b50606091909101516005909101805460ff1916911515919091179055610ad9886114f5565b505050610b7a565b60008281526020819052604090819020815161010081019092528054610b22929190829060808201908390829060c085019083908290829061059e90612246565b6040518060400160405280601f81526020017f4e6565642052656c656173652045787069726564204c6f636b204572726f720081525090610b765760405162461bcd60e51b81526004016107d89190611fd7565b5050505b5050505050565b600082815260026020908152604082208054600181018255908352918190208351610bb3939190910191840190611be9565b505050565b610bc0611c6d565b6000610bd68360405160200161042191906122f8565b60008181526020819052604090819020815161010081019092528054929350610c1892829060808201908390829060c085019083908290829061059e90612246565b6040518060400160405280601f81526020017f4e6565642052656c656173652045787069726564204c6f636b204572726f720081525090610c6c5760405162461bcd60e51b81526004016107d89190611fd7565b5060008181526020819052604090819020815161010081019092528054829060808201908390829060c0850190839082908290610ca890612246565b80601f0160208091040260200160405190810160405280929190818152602001828054610cd490612246565b8015610d215780601f10610cf657610100808354040283529160200191610d21565b820191906000526020600020905b815481529060010190602001808311610d0457829003601f168201915b505050918352505060019190910154602091820152908252600292909201546001600160a01b0316908201529082526003830180549290910191610d6490612246565b80601f0160208091040260200160405190810160405280929190818152602001828054610d9090612246565b8015610ddd5780601f10610db257610100808354040283529160200191610ddd565b820191906000526020600020905b815481529060010190602001808311610dc057829003601f168201915b50505050508152602001600482018054610df690612246565b80601f0160208091040260200160405190810160405280929190818152602001828054610e2290612246565b8015610e6f5780601f10610e4457610100808354040283529160200191610e6f565b820191906000526020600020905b815481529060010190602001808311610e5257829003601f168201915b50505091835250506005919091015460ff1615156020909101529392505050565b610e98611c6d565b60008281526020819052604090819020815161010081019092528054829060808201908390829060c0850190839082908290610ed390612246565b80601f0160208091040260200160405190810160405280929190818152602001828054610eff90612246565b8015610f4c5780601f10610f2157610100808354040283529160200191610f4c565b820191906000526020600020905b815481529060010190602001808311610f2f57829003601f168201915b505050918352505060019190910154602091820152908252600292909201546001600160a01b0316908201529082526003830180549290910191610f8f90612246565b80601f0160208091040260200160405190810160405280929190818152602001828054610fbb90612246565b80156110085780601f10610fdd57610100808354040283529160200191611008565b820191906000526020600020905b815481529060010190602001808311610feb57829003601f168201915b5050505050815260200160048201805461102190612246565b80601f016020809104026020016040519081016040528092919081815260200182805461104d90612246565b801561109a5780601f1061106f5761010080835404028352916020019161109a565b820191906000526020600020905b81548152906001019060200180831161107d57829003601f168201915b50505091835250506005919091015460ff16151560209091015292915050565b6110c2611c6d565b6110ca611c6d565b6110d2611c9a565b6040805180820190915260608152600060208201526000805b86518110156114ea5761113d6040518060400160405280600181526020017f3a0000000000000000000000000000000000000000000000000000000000000081525060405160200161042191906122f8565b61118f88838151811061115257611152612230565b016020908101516040517fff0000000000000000000000000000000000000000000000000000000000000090911691810191909152602101610421565b141561141f578161122e5761122b600480546111aa90612246565b80601f01602080910402602001604051908101604052809291908181526020018280546111d690612246565b80156112235780601f106111f857610100808354040283529160200191611223565b820191906000526020600020905b81548152906001019060200180831161120657829003601f168201915b505050505090565b83525b81600114156112585761124f61124a600480546111aa90612246565b611759565b60208401528284525b816002141561128b57611279611274600480546111aa90612246565b61191c565b6001600160a01b031660208501528385525b816003141561132857600480546112a190612246565b80601f01602080910402602001604051908101604052809291908181526020018280546112cd90612246565b801561131a5780601f106112ef5761010080835404028352916020019161131a565b820191906000526020600020905b8154815290600101906020018083116112fd57829003601f168201915b505050505085602001819052505b81600414156113c5576004805461133e90612246565b80601f016020809104026020016040519081016040528092919081815260200182805461136a90612246565b80156113b75780601f1061138c576101008083540402835291602001916113b7565b820191906000526020600020905b81548152906001019060200180831161139a57829003601f168201915b505050505085604001819052505b81600514156113ee576113e66113e1600480546111aa90612246565b611b09565b151560608601525b60408051602081019182905260009081905261140c91600491611be9565b50816114178161232a565b9250506114d8565b600487828151811061143357611433612230565b602001015160f81c60f81b908080548061144c90612246565b80601f811461145a57611470565b83600052602060002060ff1984168155603f9350505b506002919091019091558154600116156114995790600052602060002090602091828204019190065b909190919091601f036101000a81548160ff021916907f0100000000000000000000000000000000000000000000000000000000000000840402179055505b806114e28161232a565b9150506110eb565b509295945050505050565b600354604080516307e4b7e960e01b815290516000926001600160a01b0316916307e4b7e99160048083019286929190829003018186803b15801561153957600080fd5b505afa15801561154d573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526115759190810190612281565b905060006115c86040518060400160405280600a81526020017f534944455f4d4553485f000000000000000000000000000000000000000000008152508346336040516020016104219493929190612345565b6000818152600160208181526040832080549283018155835291829020865193945061097593910191860190611be9565b600080600360009054906101000a90046001600160a01b03166001600160a01b03166307e4b7e96040518163ffffffff1660e01b815260040160006040518083038186803b15801561164a57600080fd5b505afa15801561165e573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526116869190810190612281565b835151519091506116979082611b90565b6040518060400160405280601881526020017f546869732069732061207365636f6e64617279206c6f636b0000000000000000815250906116eb5760405162461bcd60e51b81526004016107d89190611fd7565b504683600001516000015160200151146040518060400160405280600b81526020017f57726f6e6720636861696e0000000000000000000000000000000000000000008152509061174f5760405162461bcd60e51b81526004016107d89190611fd7565b5060019392505050565b8051600090829082908190819081908061177281612391565b91505060008095505b865186101561181d57600087878151811061179857611798612230565b016020015160f81c9050603081108015906117b4575060398111155b156117f7576117c46030826123a8565b6117cf85600a6123bf565b6117d991906123de565b9350856117e58161232a565b96505082806117f390612391565b9350505b80602e141561180a57600191505061181d565b50856118158161232a565b96505061177b565b80156118cf5760006118308660016123de565b90505b60128110156118cd57600088828151811061185057611850612230565b016020015160f81c90506030811080159061186c575060398111155b156118af5761187c6030826123a8565b61188786600a6123bf565b61189191906123de565b94508561189d8161232a565b96505083806118ab90612391565b9450505b836118ba57506118cd565b50806118c58161232a565b915050611833565b505b601284101561190f5760006118e58560126123a8565b905060006118f482600a6124da565b905061190081866123bf565b9b9a5050505050505050505050565b5090979650505050505050565b60008181808060025b602a811015611afe5761193a610100856124e6565b935084818151811061194e5761194e612230565b016020015160f81c9250846119648260016123de565b8151811061197457611974612230565b016020015160f81c915060616001600160a01b038416108015906119a257506066836001600160a01b031611155b156119b9576119b2605784612515565b9250611a24565b6041836001600160a01b0316101580156119dd57506046836001600160a01b031611155b156119ed576119b2603784612515565b6030836001600160a01b031610158015611a1157506039836001600160a01b031611155b15611a2457611a21603084612515565b92505b6061826001600160a01b031610158015611a4857506066826001600160a01b031611155b15611a5f57611a58605783612515565b9150611aca565b6041826001600160a01b031610158015611a8357506046826001600160a01b031611155b15611a9357611a58603783612515565b6030826001600160a01b031610158015611ab757506039826001600160a01b031611155b15611aca57611ac7603083612515565b91505b81611ad68460106124e6565b611ae0919061253d565b611aea908561253d565b9350611af76002826123de565b9050611925565b509195945050505050565b6040517f747275650000000000000000000000000000000000000000000000000000000060208201526000906024016040516020818303038152906040528051906020012082604051602001611b5f91906122f8565b604051602081830303815290604052805190602001201415611b8357506001919050565b506000919050565b919050565b600081604051602001611ba391906122f8565b6040516020818303038152906040528051906020012083604051602001611bca91906122f8565b6040516020818303038152906040528051906020012014905092915050565b828054611bf590612246565b90600052602060002090601f016020900481019282611c175760008555611c5d565b82601f10611c3057805160ff1916838001178555611c5d565b82800160010185558215611c5d579182015b82811115611c5d578251825591602001919060010190611c42565b50611c69929150611ccf565b5090565b6040518060800160405280611c80611c9a565b815260606020820181905260408201819052600091015290565b6040518060400160405280611cc2604051806040016040528060608152602001600081525090565b8152600060209091015290565b5b80821115611c695760008155600101611cd0565b634e487b7160e01b600052604160045260246000fd5b6040516080810167ffffffffffffffff81118282101715611d1d57611d1d611ce4565b60405290565b6040805190810167ffffffffffffffff81118282101715611d1d57611d1d611ce4565b604051601f8201601f1916810167ffffffffffffffff81118282101715611d6f57611d6f611ce4565b604052919050565b600067ffffffffffffffff821115611d9157611d91611ce4565b50601f01601f191660200190565b600082601f830112611db057600080fd5b8135611dc3611dbe82611d77565b611d46565b818152846020838601011115611dd857600080fd5b816020850160208301376000918101602001919091529392505050565b80356001600160a01b0381168114611b8b57600080fd5b80358015158114611b8b57600080fd5b60008060408385031215611e2f57600080fd5b8235915060208084013567ffffffffffffffff80821115611e4f57600080fd5b9085019060808288031215611e6357600080fd5b611e6b611cfa565b823582811115611e7a57600080fd5b83016040818a031215611e8c57600080fd5b611e94611d23565b813584811115611ea357600080fd5b82016040818c031215611eb557600080fd5b611ebd611d23565b813586811115611ecc57600080fd5b611ed88d828501611d9f565b82525090870135878201528152611ef0828701611df5565b818701528252508284013582811115611f0857600080fd5b611f1489828601611d9f565b85830152506040830135935081841115611f2d57600080fd5b611f3988858501611d9f565b6040820152611f4a60608401611e0c565b6060820152809450505050509250929050565b60008060408385031215611f7057600080fd5b50508035926020909101359150565b60005b83811015611f9a578181015183820152602001611f82565b838111156109755750506000910152565b60008151808452611fc3816020860160208601611f7f565b601f01601f19169290920160200192915050565b602081526000611fea6020830184611fab565b9392505050565b6000806040838503121561200457600080fd5b823567ffffffffffffffff8082111561201c57600080fd5b61202886838701611d9f565b9350602085013591508082111561203e57600080fd5b5061204b85828601611d9f565b9150509250929050565b600080600080600060a0868803121561206d57600080fd5b853567ffffffffffffffff8082111561208557600080fd5b61209189838a01611d9f565b965060208801359150808211156120a757600080fd5b6120b389838a01611d9f565b955060408801359150808211156120c957600080fd5b506120d688828901611d9f565b935050606086013591506120ec60808701611df5565b90509295509295909350565b60006020828403121561210a57600080fd5b5035919050565b6000806040838503121561212457600080fd5b82359150602083013567ffffffffffffffff81111561214257600080fd5b61204b85828601611d9f565b60006020828403121561216057600080fd5b813567ffffffffffffffff81111561217757600080fd5b61218384828501611d9f565b949350505050565b6020815260008251608060208401528051604060a08501528051604060e08601526121ba610120860182611fab565b602092830151610100870152928201516001600160a01b031660c086015250840151601f198483038101604086015290916121f58184611fab565b9250506040850151818584030160608601526122118382611fab565b925050506060840151612228608085018215159052565b509392505050565b634e487b7160e01b600052603260045260246000fd5b600181811c9082168061225a57607f821691505b6020821081141561227b57634e487b7160e01b600052602260045260246000fd5b50919050565b60006020828403121561229357600080fd5b815167ffffffffffffffff8111156122aa57600080fd5b8201601f810184136122bb57600080fd5b80516122c9611dbe82611d77565b8181528560208385010111156122de57600080fd5b6122ef826020830160208601611f7f565b95945050505050565b6000825161230a818460208701611f7f565b9190910192915050565b634e487b7160e01b600052601160045260246000fd5b600060001982141561233e5761233e612314565b5060010190565b60008551612357818460208a01611f7f565b85519083019061236b818360208a01611f7f565b01938452505060601b6bffffffffffffffffffffffff1916602082015260340192915050565b6000816123a0576123a0612314565b506000190190565b6000828210156123ba576123ba612314565b500390565b60008160001904831182151516156123d9576123d9612314565b500290565b600082198211156123f1576123f1612314565b500190565b600181815b8085111561243157816000190482111561241757612417612314565b8085161561242457918102915b93841c93908002906123fb565b509250929050565b60008261244857506001610383565b8161245557506000610383565b816001811461246b576002811461247557612491565b6001915050610383565b60ff84111561248657612486612314565b50506001821b610383565b5060208310610133831016604e8410600b84101617156124b4575081810a610383565b6124be83836123f6565b80600019048211156124d2576124d2612314565b029392505050565b6000611fea8383612439565b60006001600160a01b038083168185168183048111821515161561250c5761250c612314565b02949350505050565b60006001600160a01b038381169083168181101561253557612535612314565b039392505050565b60006001600160a01b0380831681851680830382111561255f5761255f612314565b0194935050505056fea2646970667358221220c1e4b1c7c7fec7d3441b70cec05e9ba742eb293d16f84a3f76d1d05e1125664364736f6c63430008090033";

    public static final String FUNC_LOCKDESERIALIZER = "lockDeserializer";

    public static final String FUNC_GETLOCK = "getLock";

    public static final String FUNC_PUTLOCK = "putLock";

    public static final String FUNC_GETWRITEKEYSET = "getWriteKeySet";

    public static final String FUNC_GETWRITEKEYSETLENGTH = "getWriteKeySetLength";

    public static final String FUNC_GETWSET = "getWSet";

    public static final String FUNC_GETWSETLENGTH = "getWSetLength";

    public static final String FUNC_PUTWSET = "putWSet";

    public static final String FUNC_GETSTATEMAYBELOCKED = "getStateMaybeLocked";

    public static final String FUNC_PUTSTATEMAYBELOCKED = "putStateMaybeLocked";

    public static final String FUNC_PUTLOCKEDSTATEWITHPRIMARYLOCK = "putLockedStateWithPrimaryLock";

    public static final String FUNC_PUTLOCKEDSTATEWITHNETWORKLOCK = "putLockedStateWithNetworkLock";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected LockManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LockManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LockManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LockManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> lockDeserializer(byte[] data) {
        final Function function = new Function(
                FUNC_LOCKDESERIALIZER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Lock> getLock(byte[] hash) {
        final Function function = new Function(FUNC_GETLOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Lock>() {}));
        return executeRemoteCallSingleValueReturn(function, Lock.class);
    }

    public RemoteFunctionCall<TransactionReceipt> putLock(byte[] hash, Lock lock) {
        final Function function = new Function(
                FUNC_PUTLOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash), 
                lock), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getWriteKeySet(byte[] xidKey, BigInteger i) {
        final Function function = new Function(FUNC_GETWRITEKEYSET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(xidKey), 
                new org.web3j.abi.datatypes.generated.Uint256(i)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getWriteKeySetLength(byte[] hash) {
        final Function function = new Function(FUNC_GETWRITEKEYSETLENGTH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getWSet(byte[] xidKey, BigInteger i) {
        final Function function = new Function(FUNC_GETWSET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(xidKey), 
                new org.web3j.abi.datatypes.generated.Uint256(i)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getWSetLength(byte[] hash) {
        final Function function = new Function(FUNC_GETWSETLENGTH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> putWSet(byte[] hash, String value) {
        final Function function = new Function(
                FUNC_PUTWSET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash), 
                new org.web3j.abi.datatypes.Utf8String(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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
    public static LockManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LockManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LockManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LockManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LockManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LockManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LockManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LockManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<LockManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _sidemesh) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_sidemesh)));
        return deployRemoteCall(LockManager.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<LockManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _sidemesh) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_sidemesh)));
        return deployRemoteCall(LockManager.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<LockManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _sidemesh) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_sidemesh)));
        return deployRemoteCall(LockManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<LockManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _sidemesh) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_sidemesh)));
        return deployRemoteCall(LockManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
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
