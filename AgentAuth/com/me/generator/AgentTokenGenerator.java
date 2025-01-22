package com.me.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.me.encryption.EncryptionUtil;

public class AgentTokenGenerator implements TokenGenerator{

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    @Override
    public List<String> generatorToken() {
        List<String> tokens = new ArrayList<>(2);

        String value1 = getRandomValue(24);
        String value2 = getRandomValue(12);
        tokens.add(value1);
        tokens.add(value2);

        return tokens;
    }

    private String getRandomValue(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());  // Get a random index
            sb.append(CHARACTERS.charAt(index));  // Append the character at the index
        }

        return sb.toString();
    }

    @Override
    public String getEncryptedToken(String value1, String value2) {
        String encValue1 = EncryptionUtil.encrypt(value1);
        return EncryptionUtil.encrypt(value2, encValue1);

    }

    
}
