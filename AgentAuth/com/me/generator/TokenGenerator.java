package com.me.generator;

import java.util.List;

public interface TokenGenerator {
    public List<String> generatorToken();

    public String getEncryptedToken(String value1, String value2);
}
