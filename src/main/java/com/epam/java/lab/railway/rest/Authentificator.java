package com.epam.java.lab.railway.rest;

import com.epam.java.lab.railway.model.AuthToken;
import com.epam.java.lab.railway.model.User;
import com.epam.java.lab.railway.util.Encrypting;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by SerJey on 08.05.2015.
 */
public class Authentificator {
    private static Authentificator authentificator = null;

    public static Authentificator getInstance() {
        if ( authentificator == null ) {
            authentificator = new Authentificator();
        }
        return authentificator;
    }

    public boolean isAuthTokenValid(String token) {
        return true;
    }

    public AuthToken getToken(User user) {
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.add(Calendar.DAY_OF_MONTH, 2);
        String token = "";
        try {
            token = String.valueOf(Encrypting.encrypt(user.getUsername() + user.getPassword() + expiredDate.getTimeInMillis()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new AuthToken(user, token, expiredDate.getTime());
    }
}
