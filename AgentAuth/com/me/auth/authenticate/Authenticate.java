package com.me.auth.authenticate;

import com.me.auth.AuthInterface;

public interface Authenticate extends AuthInterface{
    @Override
    default void init() {
        Cac
    }
    void authenticate();
}
