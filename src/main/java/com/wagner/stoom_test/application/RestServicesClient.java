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
import com.wagner.stoom_test.entities.dto.GeoCoordinates;
import com.wagner.stoom_test.geocoding.GeocodingMBean;
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
            updateAddress.setId(13);
            updateAddress.setCity("City");
            updateAddress.setStreetName("Street Name");
            updateAddress.setNumber(1);
            updateAddress.setNeighbourhood("Neighbourhood");
            updateAddress.setCountry("Country");
            updateAddress.setState("State");
            updateAddress.setZipCode("00000000");
            updateAddress.setLatitude("0000");
            updateAddress.setLongitude("0000");

            ClientResponse response = r.entity(updateAddress, MediaType.APPLICATION_JSON_TYPE)
                    .accept(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_OCTET_STREAM_TYPE)
                    .put(ClientResponse.class);
            
            //POST
            
            /*Address newAddress = new Address();
            newAddress.setCity("City");
            newAddress.setStreetName("Street Name");
            newAddress.setNumber(1);
            newAddress.setNeighbourhood("Neighbourhood");
            newAddress.setCountry("Country");
            newAddress.setState("CE");
            newAddress.setZipCode("00000000");
            newAddress.setLatitude("0000");
            newAddress.setLongitude("0000");

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
            
            /*Address newAddress = new Address();
            newAddress.setCity("Icó");
            newAddress.setStreetName("Rua do Rosario");
            newAddress.setNumber(291);
            newAddress.setNeighbourhood("Centro");
            newAddress.setCountry("Brasil");
            newAddress.setState("CE");
            newAddress.setZipCode("63430000");
            
            GeocodingMBean geocodingMBean = new GeocodingMBean();
            geocodingMBean.initContext();
            
            GeoCoordinates geoCoordinates = geocodingMBean.getGeoCoordinates(newAddress);
            System.out.println(geoCoordinates);
            
            geocodingMBean.shutdownContext();*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
