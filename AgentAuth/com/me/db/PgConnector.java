package com.me.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.me.generator.AgentTokenGenerator;


public class PgConnector {
    static int counts = 0;
    public static void insert (AgentTokenGenerator agentTokenGenerator) {
        Connection conn = null;
        PreparedStatement pr = null;

        List<String> tokens = agentTokenGenerator.generatorToken();
        String token = agentTokenGenerator.getEncryptedToken(tokens.get(0), tokens.get(1));

        try {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/auth", "postgres", "postgres");

        pr = conn.prepareStatement("insert into resource (rid, cid, domain, value1, value2, token) values (?, ?, ?, ? , ? , ? )");
        pr.setInt(1, ++counts);
        pr.setInt(2, counts);
        pr.setInt(3, counts);
        pr.setString(4, tokens.get(0));
        pr.setString(5, tokens.get(1));
        pr.setString(6, token);
        pr.execute();

        
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {

                conn.close();
                pr.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public Optional<Map<Integer, List<String>>> get() {
        Connection conn = null;
        PreparedStatement pr = null;

        try {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/auth", "postgres", "postgres");

        pr = conn.prepareStatement("select * from resource");
        ResultSet result = pr.executeQuery();
        Map<Integer, List<String>> map = new HashMap<>();
        while(result.next()) {
            List<String> list = new ArrayList<>();
            list.add(result.getString("token"));
            list.add(result.getString("cid"));
            list.add(result.getString("domain"));
            map.put(result.getInt("rid"), list);
        }
        return Optional.of(map);

    }
    catch (Exception e){
        e.printStackTrace();
    }
    finally {
        try {

            conn.close();
            pr.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    return Optional.empty();

    }
}
