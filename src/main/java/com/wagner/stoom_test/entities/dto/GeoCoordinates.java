/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wagner.stoom_test.entities.dto;

/**
 *
 * @author Wagner
 */
public class GeoCoordinates {
    
    private String latitute;
    private String longitude;

    public String getLatitute() {
        return latitute;
    }

    public void setLatitute(String latitute) {
        this.latitute = latitute;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "GeoCoordinates{" + "latitute=" + latitute + ", longitude=" + longitude + '}';
    }
    
}
