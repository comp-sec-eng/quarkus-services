package org.acme.getting.started;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RethinkDBService {

    @Inject
    RethinkDB r; // RethinkDB instance

    private Connection conn;

    public void connect() {
        conn = r.connection()
                .hostname(System.getProperty("rethinkdb.host", "localhost"))
                .port(Integer.parseInt(System.getProperty("rethinkdb.port", "28015")))
                .db(System.getProperty("rethinkdb.db"))
                .user(System.getProperty("rethinkdb.user", "admin"),
                      System.getProperty("rethinkdb.password", ""))
                .connect();
    }

    public Connection getConnection() {
        if (conn == null || !conn.isOpen()) {
            connect();
        }
        return conn;
    }

    // Optionally, methods to close connection or other database operations
}

