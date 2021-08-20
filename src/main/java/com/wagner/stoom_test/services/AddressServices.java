package com.wagner.stoom_test.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wagner.stoom_test.entities.Address;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
public class AddressServices {
	
	@GET
	@Path("/read")
	public Address readAddress() {
		Address address = new Address();
		address.setStreetName("Rua do Rosário");
		address.setNumber(291);
		address.setNeighbourhood("Centro");
		address.setCity("Icó");
		address.setState("Ceará");
		address.setZipCode("63430-000");
		address.setCountry("Brasil");
		return address;
	}
	
}
