package org.acme.getting.started;

// RethinkDB imports
import com.rethinkdb.RethinkDB ;
import com.rethinkdb.net.Connection ; 
// Jakarta EE imports 
import jakarta.enterprise.context.ApplicationScoped ;
import jakarta.inject.Inject ;

// If we, annotate a class with @ApplicationScoped in CDI (Contexts and Dependency Injection), 
// CDI ensures that only one instance of that class is created per application context.

@ApplicationScoped
public class RethinkDBService {

    @Inject
    private RethinkDB  r ;

    // RethinkDB connection constants
    private static final String DBNAME = "domaindb" ;
    private static final String DBHOST = "localhost" ;
    private static final int    DBPORT = 28015 ;
    
    // RethinkDB connection
    private static Connection conn ;

     
    // Methos to create a database connection
    public void connect() {
        conn = r.connection()
                .hostname( DBHOST )
                .port( DBPORT )
                .connect() ;
    }

    // Method to create a table via the table parameter
    public void createTable( String table ) {
        r.db( DBNAME ).tableCreate( table ).run( conn ) ;
    }

    // Method to insert a table
    public void insertTable(String table, String value) {
        r.db( DBNAME ).table(table).insert( r.hashMap("domain_name", value) ).run( conn ) ;
    }

}
