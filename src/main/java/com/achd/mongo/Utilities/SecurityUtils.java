package com.achd.mongo.Utilities;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SecurityUtils {

    public static final String KEY_SHA = "SHA";

    public static String SHAEncryption(String text) {
        BigInteger sha;
        byte[] inputData = text.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
            return sha.toString(32);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
