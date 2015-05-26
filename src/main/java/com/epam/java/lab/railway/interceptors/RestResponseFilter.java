package com.epam.java.lab.railway.interceptors;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

/**
 * Created by SerJey on 08.05.2015.
 */
public class RestResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add( "Access-Control-Allow-Origin", "*" );    // You may further limit certain client IPs with Access-Control-Allow-Origin instead of '*'
        responseContext.getHeaders().add( "Access-Control-Allow-Credentials", "true" );
        responseContext.getHeaders().add( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
        responseContext.getHeaders().add( "Access-Control-Allow-Headers", "auth_token" );
    }
}
