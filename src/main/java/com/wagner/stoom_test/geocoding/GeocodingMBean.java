/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wagner.stoom_test.geocoding;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.wagner.stoom_test.entities.Address;
import com.wagner.stoom_test.entities.dto.GeoCoordinates;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Wagner
 */
@Named
@ApplicationScoped
public class GeocodingMBean {

    private GeoApiContext context;
    private final String geoApiKey = "AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";

    @PostConstruct
    public void initContext() {
        context = new GeoApiContext.Builder().apiKey(geoApiKey).build();
    }

    public GeoCoordinates getGeoCoordinates(Address address) {
        GeoCoordinates geoCoordinates = new GeoCoordinates();
        String requestString = getRequestAddressString(address);
        GeocodingResult[] results = GeocodingApi.geocode(context, requestString).awaitIgnoreError();
        geoCoordinates.setLatitute(String.valueOf(results[0].geometry.location.lat));
        geoCoordinates.setLongitude(String.valueOf(results[0].geometry.location.lng));

        return geoCoordinates;
    }

    private String getRequestAddressString(Address address) {
        StringBuilder builder = new StringBuilder()
                .append(address.getNumber()).append(" ")
                .append(address.getStreetName()).append(" ")
                .append(address.getCity()).append(" ")
                .append(address.getNeighbourhood()).append(" ")
                .append(address.getState()).append(" ")
                .append(address.getZipCode()).append(" ")
                .append(address.getCountry()).append(" ");
        return builder.toString();
    }

    @PreDestroy
    public void shutdownContext() {
        context.shutdown();
    }

}
