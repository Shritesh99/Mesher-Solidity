package com.crossmesh.mesher_solidity;

import com.crossmesh.mesher_solidity.config.ContractsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.websocket.WebSocketClient;
import org.web3j.protocol.websocket.WebSocketService;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@ConditionalOnClass(Web3j.class)
@EnableConfigurationProperties(ContractsProperties.class)
public class Web3 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Web3.class);

    @Autowired
    private ContractsProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public Web3j web3j(){
        WebSocketClient webSocketClient = null;
        try {
            webSocketClient = new WebSocketClient(new URI(properties.getServer()));
        } catch (URISyntaxException e) {
            LOGGER.error(e.getMessage());
        }
        Web3jService web3jService = new WebSocketService(webSocketClient, false);
        return Web3j.build(web3jService);
    }
}
