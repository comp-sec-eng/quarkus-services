package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rethink")
public class RethinkDBResource {

    @Inject
    RethinkDBService rethinkDBService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testConnection() {
        Connection conn = rethinkDBService.getConnection();
        return "Connected to RethinkDB: " + conn.isOpen();
    }
}
