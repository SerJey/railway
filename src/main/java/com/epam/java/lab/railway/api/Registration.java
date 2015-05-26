package com.epam.java.lab.railway.api;

import com.epam.java.lab.railway.model.User;

import javax.ejb.Local;

@Local
public interface Registration {
    public boolean register(User user);
}
