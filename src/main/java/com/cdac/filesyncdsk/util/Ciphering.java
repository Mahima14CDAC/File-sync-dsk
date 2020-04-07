package com.cdac.filesyncdsk.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Handles Password encryption
 *
 * @author Sujata Aher
 * @version 1
 * @since 1
 */
public class Ciphering {


    /**
     * encrypts string using MD5.
     *
     * @param password
     * @return
     */
    public static String stringToMD5(String password) {
        String hashedPass = null;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes(), 0, password.length());
            hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Exception e) {
            System.err.print("Encode password String: " + e.getMessage());
        }
        return hashedPass;
    }

    /**
     * encrypts byte using MD5.
     *
     * @param a
     * @return
     * @throws Exception
     */
    public static String MD5String(byte[] a) throws Exception {
        // string to be encoded

        // get the instances for a given digest scheme MD5 or SHA
        MessageDigest m = MessageDigest.getInstance("MD5");

        // generate the digest ; pass in the text as bytes,
        // length to the bytes(offset) to be hashed; for full string 
        // pass 0 to text.length()
        m.update(a, 0, a.length);

        // get the String representation of hash bytes, 
        // create a big integer out of bytes
        // then convert it into hex value (16 as input to toString method)
        String digest = new BigInteger(1, m.digest()).toString(16);
        return digest;
    }

    /**
     * encrypts string using SHA1.
     *
     * @param a
     * @return
     * @throws Exception
     */
    public static String stringToSHA1(byte[] a) throws Exception {

        // get the instances for a given digest scheme MD5 or SHA
        MessageDigest m = MessageDigest.getInstance("SHA-1");

        // generate the digest ; pass in the text as bytes,
        // length to the bytes(offset) to be hashed; for full string 
        // pass 0 to text.length()
        m.update(a, 0, a.length);

        // get the String representation of hash bytes, 
        // create a big integer out of bytes
        // then convert it into hex value (16 as input to toString method)
        String digest = new BigInteger(1, m.digest()).toString(16);
        return digest;
    }
}
