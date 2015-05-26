package com.epam.java.lab.railway.rest;

import com.epam.java.lab.railway.api.Autentification;
import com.epam.java.lab.railway.model.AuthToken;
import com.epam.java.lab.railway.model.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/auth")
public class AutentificationRestService implements Autentification {

    @EJB
    private Autentification autentification;

    @Override
    public AuthToken autentificate(String login, String Password) {

        return null;
    }

    @POST
    @Path("/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response autentificate1(Credentials credentials) {
        AuthToken authToken = autentification.autentificate(credentials.username, credentials.password);
        if (authToken != null)
        {
            String token = "auth_token:" + authToken.getToken();
            return Response.status(200).entity(token).build();
        }
        else
            return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
