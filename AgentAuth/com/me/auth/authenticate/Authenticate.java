package com.me.auth.authenticate;

import com.me.auth.AuthInterface;
@FunctionalInterface
public interface Authenticate extends AuthInterface{
    boolean authenticate();
}
