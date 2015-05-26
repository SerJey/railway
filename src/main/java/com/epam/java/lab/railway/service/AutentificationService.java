package com.epam.java.lab.railway.service;

import com.epam.java.lab.railway.api.Autentification;
import com.epam.java.lab.railway.model.AuthToken;
import com.epam.java.lab.railway.model.User;
import com.epam.java.lab.railway.rest.Authentificator;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AutentificationService implements Autentification {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    private User findUserByName(String username) {
        Query query = em.createNamedQuery("findUserByUsername");
        List results = query.setParameter("username", username).getResultList();
        if (results.isEmpty()) return null;
        return (User) results.get(0);
    }

    @Override
    public AuthToken autentificate(String username, String password) {
        User user = findUserByName(username);
        if (user != null)
            if (password.equals(user.getPassword())) {
                Authentificator authentificator = Authentificator.getInstance();
                AuthToken authToken = authentificator.getToken(user);
                if (authToken != null)
                    return authToken;
            }
        return null;
    }
}
