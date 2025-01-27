package com.me.auth;

import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.me.db.PgConnector;

public class CacheHandler {
    static SoftReference<Map<Integer, List<String>>> mapRef = null; 
    public static void init(PgConnector pgConnector) {
        if (mapRef == null) {
            Optional<Map<Integer, List<String>>> optionalMap = pgConnector.get();
            if (optionalMap.isPresent()) {
                mapRef = new SoftReference<Map<Integer,List<String>>>(optionalMap.get());
            }
        }
    }

    public static String getFromCache(int rid, int index) {
        if (mapRef.get() == null) {
            init(new PgConnector());
        }
        return mapRef.get().get(rid).get(index);
    }
}
