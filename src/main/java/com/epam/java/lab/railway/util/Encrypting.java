package com.epam.java.lab.railway.util;

/**
 * Created by SerJey on 22.12.2014.
 */
public class Encrypting {
    public static void main(String arg[]) throws Exception {
        System.out.println(encrypt("String"));
    }

    public static byte[] encrypt(String x) throws Exception {
        java.security.MessageDigest d = null;
        d = java.security.MessageDigest.getInstance("SHA-1");
        d.reset();
        d.update(x.getBytes());
        return d.digest();
    }
}
