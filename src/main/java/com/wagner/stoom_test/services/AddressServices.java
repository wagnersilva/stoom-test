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
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@Named
@RequestScoped
public class AddressServices {
    
    @Inject
    private AddressDAO dao;

    @GET
    @Path("/{id}")
    public Address readAddress(@PathParam("id") int id) {
        return dao.find(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Address createAddress(Address address) {
        dao.persist(address);
        return address;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Address updateAddress(Address address) {
        Address oldAddress = dao.find(address.getId()); 
        if ( oldAddress != null) {
                oldAddress = address;
                dao.update(oldAddress);
        }
        return oldAddress;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Address deleteAddress(@PathParam("id") int id) {
        Address address = dao.find(id); 
        if ( address != null) {
                dao.remove(address);
        }
        return address;
    }

}
