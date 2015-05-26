package com.epam.java.lab.railway.service;

import com.epam.java.lab.railway.api.Registration;
import com.epam.java.lab.railway.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RegistrationService implements Registration{

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    public void create(User user) {
        em.persist(user);
    }

    @Override
    public boolean register(User user) {
        create(user);
        return true;
    }
}
