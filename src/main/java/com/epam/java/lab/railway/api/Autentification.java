package com.epam.java.lab.railway.api;

import com.epam.java.lab.railway.model.AuthToken;
import com.epam.java.lab.railway.model.User;

import javax.ejb.Local;

@Local
public interface Autentification {
    public AuthToken autentificate(String username, String Password);
}
