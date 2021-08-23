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

        try {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client c = Client.create(clientConfig);
            WebResource r;
            /*String getAndDeletePath = "http://localhost:8084/stoom-test/services/address/15";
            r = c.resource(getAndDeletePath);*/

            //GET
            /*ClientResponse response = r.accept(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_OCTET_STREAM_TYPE).
                    get(ClientResponse.class);*/

            //DELETE
            /*ClientResponse response = r.accept(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_OCTET_STREAM_TYPE).
                    delete(ClientResponse.class);*/
            
            //UPDATE
            String postAndPutPath = "http://localhost:8084/stoom-test/services/address";
            r = c.resource(postAndPutPath);

            Address updateAddress = new Address();
            updateAddress.setId(9);
            updateAddress.setCity("City3");
            updateAddress.setStreetName("Street Name3");
            updateAddress.setNumber(12);
            updateAddress.setNeighbourhood("Neighbour Hood");
            updateAddress.setCountry("Country");
            updateAddress.setState("State");
            updateAddress.setZipCode("00000000");

            ClientResponse response = r.entity(updateAddress, MediaType.APPLICATION_JSON_TYPE)
                    .accept(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_OCTET_STREAM_TYPE)
                    .put(ClientResponse.class);
            
            //POST
            
            /*Address newAddress = new Address();
            newAddress.setCity("New City");
            //newAddress.setStreetName("New Street Name");
            newAddress.setNumber(1);
            newAddress.setNeighbourhood("New Neighbour Hood");
            newAddress.setCountry("New Country");
            newAddress.setState("New State");
            newAddress.setZipCode("00000000");

            ClientResponse response = r.entity(newAddress, MediaType.APPLICATION_JSON_TYPE)
                    .accept(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_OCTET_STREAM_TYPE)
                    .post(ClientResponse.class);*/
            
            if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
                Address address = response.getEntity(Address.class);
                System.out.println("Address: " + address);
            }
            else {
                System.out.println(response.getStatusInfo());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
