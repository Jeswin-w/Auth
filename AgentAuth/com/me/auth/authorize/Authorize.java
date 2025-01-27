package com.me.auth.authorize;

import com.me.auth.AuthInterface;

@FunctionalInterface
public interface Authorize extends AuthInterface{
    boolean authorize();
}
