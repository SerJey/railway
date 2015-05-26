package com.epam.java.lab.railway.interceptors;

import com.epam.java.lab.railway.rest.Authentificator;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by SerJey on 08.05.2015.
 */
public class RestRequestFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (requestContext.getRequest().getMethod().equals("OPTIONS")) {
            requestContext.abortWith(Response.status(Response.Status.OK).build());
            return;
        }

        String path = requestContext.getUriInfo().getPath();
        if (!path.startsWith("/demo-business-resource/login/")) {
            String authToken = requestContext.getHeaderString("auth_token");

            // if it isn't valid, just kick them out.
            Authentificator authentificator = Authentificator.getInstance();
            if (!authentificator.isAuthTokenValid(authToken)) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
        }
    }
}
