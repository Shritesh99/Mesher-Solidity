package com.crossmesh.mesher_solidity.services;

import com.crossmesh.mesher_solidity.Contracts;
import com.crossmesh.mesher_solidity.Coordinator;
import com.crossmesh.mesher_solidity.resource.Web3Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;

import javax.annotation.PostConstruct;

@Service
public class SidemeshService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SidemeshService.class);

    @Autowired
    Web3j web3j;

    @Autowired
    Contracts contracts;

    @Autowired
    Coordinator coordinator;

    @PostConstruct
    public void init(){
        contracts.getStructs()
                .resourceRegisteredEventEventFlowable(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                .subscribe(v -> {
                    coordinator.handleResourceRegisteredEvent(v);
                });

        contracts.getStructs()
                .primaryTransactionPreparedEventEventFlowable(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                .subscribe(v -> {
//                    v.PrimaryConfirmTx.invocation.contractC = ;
//                    v.GlobalTxStatusQuery.contractC = ;
                    Web3Resource resource = (Web3Resource) coordinator.getResourceRegistry().getResource(v.PrimaryPrepareTxId.uri);
//                    resource.addTransactionEvent(v.PrimaryConfirmedTxId.sender, );
                    coordinator.handlePrimaryTransactionPrepared(v);
                });

        contracts.getStructs()
                .primaryTransactionConfirmedEventEventFlowable(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                .subscribe(v -> {
                    Web3Resource resource = (Web3Resource) coordinator.getResourceRegistry().getResource(v.PrimaryConfirmedTxId.uri);
//                    resource.addTransactionEvent(v.PrimaryConfirmedTxId.sender, );
                    coordinator.handlePrimaryTransactionConfirmed(v);
                });

        contracts.getStructs()
                .networkTransactionPreparedEventEventFlowable(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                .subscribe(v -> {
                    coordinator.handleNetworkTransactionPrepared(v);
                });
    }
}
