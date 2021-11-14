package com.crossmesh.mesher_solidity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mesher")
public class Config {

    @Value("mesher.meta-network-name")
    private String metaNetwork;

    @Value("mesher.self-network-name")
    private String selfNetwork;

    @Value("mesher.meta-chain.type")
    private String metaChainType;

    @Value("mesher.coordinator.cross-monitor-thread-num")
    private int crossMonitorThreadNum;


    public String getMetaNetwork() {
        return this.metaNetwork;
    }

    public void setMetaNetwork(String metaNetwork) {
        this.metaNetwork = metaNetwork;
    }

    public String getSelfNetwork() {
        return this.selfNetwork;
    }

    public void setSelfNetwork(String selfNetwork) {
        this.selfNetwork = selfNetwork;
    }

    public String getMetaChainType() {
        return this.metaChainType;
    }

    public void setMetaChainType(String metaChainType) {
        this.metaChainType = metaChainType;
    }

    public int getCrossMonitorThreadNum() {
        return crossMonitorThreadNum;
    }

    public void setCrossMonitorThreadNum(int crossMonitorThreadNum) {
        this.crossMonitorThreadNum = crossMonitorThreadNum;
    }
}