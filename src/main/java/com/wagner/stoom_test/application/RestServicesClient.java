/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wagner.stoom_test.application;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.wagner.stoom_test.entities.Address;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Wagner
 */
public class RestServicesClient {

    public static void main(String[] args) {

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client c  = Client.create(clientConfig);
        
        WebResource r = c.resource("http://localhost:8084/stoom-test/services/address/1");
        
        ClientResponse response = r.accept(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_OCTET_STREAM_TYPE).
                get(ClientResponse.class);
        
        Address address = response.getEntity(Address.class);

        System.out.println("Address: " + address);

    }

}
