package com.me.encryption;

public class EncryptionUtil {
    private static String masterKey = "HarryPotterIsGay";

    public static String encrypt (String value) {
        return encrypt(value, masterKey);
    }

    public static String decrypt (String value) {
        return decrypt(value, masterKey);
    }

    public static String encrypt (String value, String key) {
        int len = Math.min(value.length(), key.length());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char c1 = value.charAt(i);
            char c2 = key.charAt(i);
            result.append((char) (c1 ^ c2));
        }

        return result.toString();
    }

    public static String decrypt (String value, String key) {
        int len = Math.min(value.length(), key.length());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char c1 = value.charAt(i);
            char c2 = key.charAt(i);
            result.append((char) (c1 ^ c2));
        }

        return result.toString();

    }
}
