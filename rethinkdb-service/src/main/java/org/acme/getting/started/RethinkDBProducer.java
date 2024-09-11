
package org.acme.getting.started;

import jakarta.enterprise.context.ApplicationScoped;

import jakarta.enterprise.inject.Produces;
import com.rethinkdb.RethinkDB;

@ApplicationScoped
public class RethinkDBProducer {

    @Produces
    public RethinkDB produceRethinkDB() {
        return RethinkDB.r;
    }
}