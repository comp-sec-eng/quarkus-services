package org.acme.getting.started;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@Path("/rethink")
public class RethinkDBResource {

   @Inject
   RethinkDBService rethinkDBService;

   @GET
   @Produces(MediaType.TEXT_PLAIN) 
   public String testConnection() {
	   
	try {
      rethinkDBService.connect() ;
    } catch (Exception e) {
      System.err.println("Failed to connect to RethinkDB: " + e.getMessage());
	}

	try {
      rethinkDBService.createTable( "domains" ) ;
    } catch (Exception e) {
      System.err.println("Failed to create table: " + e.getMessage());
	}
     
	try {
      rethinkDBService.insertTable( "domains", "example.com" ) ;
	  rethinkDBService.insertTable( "domains", "example1.com" ) ;
	} catch (Exception e) {
      System.err.println("Failed to insert into table: " + e.getMessage());
	}
	
	
     return "Table created" ;
   }
}
