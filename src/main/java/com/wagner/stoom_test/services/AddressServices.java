package com.wagner.stoom_test.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wagner.stoom_test.entities.Address;
import com.wagner.stoom_test.entities.dto.GeoCoordinates;
import com.wagner.stoom_test.geocoding.GeocodingMBean;
import com.wagner.stoom_test.persistence.AddressDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@Named
@RequestScoped
public class AddressServices {

    @Inject
    private AddressDAO dao;
    
    @Inject
    private GeocodingMBean geocodingMBean;

    @GET
    @Path("/{id}")
    public Response readAddress(@PathParam("id") int id) {
        ResponseBuilder builder;
        Address address = dao.find(id);
        if (address == null) {
            builder = Response.status(Status.NOT_FOUND);
        } else {
            builder = Response.ok(address, MediaType.APPLICATION_JSON);
        }

        return builder.build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAddress(Address address) {
        ResponseBuilder builder;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        if (validator.validate(address).size() > 0)
            builder = Response.status(Status.BAD_REQUEST);
        else {
            if (!address.containsGeoCoordinates()){
                GeoCoordinates geoCoordinates = geocodingMBean.getGeoCoordinates(address);
                address.setLatitude(geoCoordinates.getLatitute());
                address.setLongitude(geoCoordinates.getLongitude());
            }
            dao.persist(address);
            builder = Response.ok(address, MediaType.APPLICATION_JSON);
        }

        return builder.build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAddress(Address address) {
        ResponseBuilder builder = null;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        if (validator.validate(address).size() > 0)
            builder = Response.status(Status.BAD_REQUEST); 
        else {
            Address oldAddress = dao.find(address.getId());
            if (oldAddress == null)
               builder = Response.status(Status.NOT_FOUND); 
            else {
                if (!address.containsGeoCoordinates()){
                    GeoCoordinates geoCoordinates = geocodingMBean.getGeoCoordinates(address);
                    address.setLatitude(geoCoordinates.getLatitute());
                    address.setLongitude(geoCoordinates.getLongitude());
                }
                oldAddress = address;
                dao.update(oldAddress);
                builder = Response.ok(oldAddress, MediaType.APPLICATION_JSON);
            }
        }
        return builder.build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteAddress(@PathParam("id") int id) {
        ResponseBuilder builder;
        Address address = dao.find(id);
        if (address == null)
            builder = Response.status(Status.NOT_FOUND);
        else {
            dao.remove(address);
            builder = Response.ok(address, MediaType.APPLICATION_JSON);
        }
        return builder.build();
    }

}
