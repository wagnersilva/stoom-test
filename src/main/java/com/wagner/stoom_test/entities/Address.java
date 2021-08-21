package com.wagner.stoom_test.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "address")
@Entity
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String streetName;
	
	private int number;
	
	private String complement;
	
	private String neighbourhood;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String zipCode;
	
	private String latitude;
	
	private String longitude;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getNeighbourhood() {
		return neighbourhood;
	}
	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", streetName=" + streetName + ", number=" + number + ", complement=" + complement + ", neighbourhood=" + neighbourhood + ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }
	
}
