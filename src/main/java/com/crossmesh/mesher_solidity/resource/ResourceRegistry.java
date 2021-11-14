package com.crossmesh.mesher_solidity.resource;

import com.crossmesh.mesher_solidity.Coordinator;
import com.crossmesh.mesher_solidity.config.Config;
import com.crossmesh.mesher_solidity.contracts.Structs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ResourceRegistry {

    private final ConcurrentHashMap<Structs.URI, Resource> resources = new ConcurrentHashMap<>();

    @Autowired
    private Config config;

    @Autowired
    Coordinator coordinator;

    public void handleResourceRegisteredEvent(Structs.ResourceRegisteredEventEventResponse response) {
        this.resources.compute(response.uri, (uri, val) -> new Web3Resource(uri, Base64.getDecoder().decode(response.connection.toString())));
    }

    public Resource getResource(Structs.URI uri) {
        return resources.get(uri);
    }
}
