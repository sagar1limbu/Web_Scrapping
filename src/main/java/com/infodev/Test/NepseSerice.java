package com.infodev.Test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by reddevil on 3/10/2017.
 */

@Path("/json/product")
public class NepseSerice {
    @GET
    @Path("/get")
    @Produces("application/json")
    public Response getProductInJSON() {
        Response response = new Response();
        return response;
    }
}




