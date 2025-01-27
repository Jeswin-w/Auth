package com.me.auth;

import com.me.db.PgConnector;

public interface AuthInterface {
    default void init(){
        CacheHandler.init(new PgConnector());
    };
}
