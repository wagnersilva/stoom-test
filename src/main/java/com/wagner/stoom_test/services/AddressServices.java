package com.wagner.stoom_test.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wagner.stoom_test.entities.Address;
import com.wagner.stoom_test.persistence.AddressDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@Named
@RequestScoped
public class AddressServices {
    
    @Inject
    private AddressDAO addressDAO;

    @GET
    public Address readAddress() {
        Address address = new Address();
        address.setStreetName("Rua do Rosário");
        address.setNumber(291);
        address.setNeighbourhood("Centro");
        address.setCity("Icó");
        address.setState("Ceará");
        address.setZipCode("63430-000");
        address.setCountry("Brasil");
        addressDAO.persist(address);
        return address;
    }

}
