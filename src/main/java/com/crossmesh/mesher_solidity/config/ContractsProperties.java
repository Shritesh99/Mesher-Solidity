package com.crossmesh.mesher_solidity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigInteger;

@ConfigurationProperties(prefix = "contracts")
public class ContractsProperties {

    @Value("contracts.server")
    private String server;

    @Value("contracts.structs")
    String structAddress;

    @Value("contracts.privatekey")
    String privateKey;

    @Value("contracts.gasprice")
    private String gasPrice;

    @Value("contracts.gaslimit")
    private String gasLimit;

    @Value("contracts.chainid")
    private Integer chainID;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getChainID() {
        return chainID;
    }

    public void setChainID(Integer chainID) {
        this.chainID = chainID;
    }

    public String getStructAddress() {
        return structAddress;
    }

    public void setStructAddress(String structAddress) {
        this.structAddress = structAddress;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
    }

    public BigInteger getGasLimitBigInteger() {
        return new BigInteger(this.gasLimit);
    }

    public BigInteger getGasPriceBigInteger(){
        return new BigInteger(this.gasPrice);
    }
}
