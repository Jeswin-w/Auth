package com.me.auth;

import com.me.auth.authenticate.Authenticate;
import com.me.auth.authorize.Authorize;

public class AuthFilter  {

   public static boolean filter (int rid) {
        //authenticate
        Authenticate authenticate = () -> CacheHandler.getFromCache(rid, 0).equals("test");
        boolean a = authenticate.authenticate();

        Authorize cust = () -> CacheHandler.getFromCache(rid, 1).equals("test");
        Authorize dom = () -> CacheHandler.getFromCache(rid, 2).equals("test");

        boolean b = cust.authorize();
        boolean c = dom.authorize();

        return a && b && c;
   }
    
}
