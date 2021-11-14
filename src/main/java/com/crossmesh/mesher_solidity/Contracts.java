package com.crossmesh.mesher_solidity;

import com.crossmesh.mesher_solidity.config.ContractsProperties;
import com.crossmesh.mesher_solidity.contracts.Structs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;

@Component
@EnableConfigurationProperties(ContractsProperties.class)
public class Contracts {

    @Autowired
    ContractsProperties contractsProperties;

    @Autowired
    Web3j web3j;

    Structs structs;

    public Structs getStructs() {
        if(structs == null){
            Credentials credentials = Credentials.create(contractsProperties.getPrivateKey());
            structs = Structs.load(contractsProperties.getStructAddress(), web3j, credentials, new DefaultGasProvider());
        }
        return structs;
    }
}
