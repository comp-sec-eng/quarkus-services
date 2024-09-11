package org.acme.getting.started;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;



@ApplicationScoped
public class RethinkDBService {

    @Inject
    RethinkDB r;  

    private String db = "domaindb" ;
    private Connection conn;

/* public boolean connect() {
    try {
        conn = r.connection()
                .hostname("localhost")
                .port(28015)
                .connect();
        return conn.isOpen();
    } catch (Exception e) {
        System.err.println("Failed to connect to RethinkDB: " + e.getMessage());
        return false;
    }
} */

	public void connect( ) {
			conn = r.connection( )
					.hostname( "localhost" )
					.port( 28015 )
					.connect( );
	}

    public void createTable( String table )  {
          r.db( db ).tableCreate( table ).run( conn ) ;
    }

    public void insertTable( String table, String value ) {
          r.db( db ).table( table ).insert( r.hashMap( "domain_name", value ) ).run( conn ) ;
    }
 
}

