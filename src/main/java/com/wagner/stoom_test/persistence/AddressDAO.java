/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wagner.stoom_test.persistence;

import com.wagner.stoom_test.entities.Address;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author Wagner
 */

@Named
@RequestScoped
public class AddressDAO {
    
    @Inject
    private EntityManager entityManager;
    
    public AddressDAO(){}
    
    public void persist(Address address) {
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
    }
    
}
