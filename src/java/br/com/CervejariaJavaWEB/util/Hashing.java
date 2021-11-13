package br.com.CervejariaJavaWEB.util;

import java.security.*;
import java.math.*;

public class Hashing {
    
    //  HASH MD5
    public static String _MD5(String str) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(str.getBytes(), 0, str.length());
        str = new BigInteger(1, m.digest()).toString(16);
        return str;
    }
    
    //  HASH SHA1
    public static String _SHA1(String str) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.reset();
        md.update(str.getBytes("utf8"));
        str = String.format("%040x", new BigInteger(1, md.digest()));
        return str;
    }
    
    //  HASH SHA256
    public static String _SHA256(String str) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes("UTF-8"));
        str = new BigInteger(1, md.digest()).toString(16);
        return str;
    }
    
    //  CRIPTOGRAFIA    (SHA1(SHA256(MD5('str'))))
    public static String _criptografar(String str) throws Exception {
        return _SHA1(_SHA256(_MD5(str)));
    }
    
}
