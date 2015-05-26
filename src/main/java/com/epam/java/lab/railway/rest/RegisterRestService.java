package com.epam.java.lab.railway.rest;

import com.epam.java.lab.railway.api.Autentification;
import com.epam.java.lab.railway.api.Registration;
import com.epam.java.lab.railway.model.User;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/register")
public class RegisterRestService implements Registration{

    @EJB
    private Registration registration;

    @Override
    public boolean register(User user) {
        registration.register(user);
        return false;
    }

    @POST
    @Path("/user")
    @Consumes("application/json")
    @Produces("application/json")
    public Response register1(User user) {
        registration.register(user);
        return Response.status(200).build();
    }
}
