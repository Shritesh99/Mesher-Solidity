package com.crossmesh.mesher_solidity;

import com.crossmesh.mesher_solidity.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Config.class)
public class MesherSolidityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MesherSolidityApplication.class, args);
    }

}
