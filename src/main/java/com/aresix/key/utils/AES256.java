package com.aresix.key.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AES256 {
    private final static String iv = "6543210abdef1115";
    private final static String key = "abcde123456edcba";
    private final static String algorithm = "AES";
    private final static String algorithmProvider = "AES/CBC/PKCS5Padding";

    public static String decryptAES(String content) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.US_ASCII), algorithm);
        Cipher cipher=Cipher.getInstance(algorithmProvider);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decrypted = Base64.decodeBase64(content);
        byte[] res = cipher.doFinal(decrypted);
        return new String(res);
    }

    public static String encryptAES(String content) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.US_ASCII), algorithm);
        Cipher cipher=Cipher.getInstance(algorithmProvider);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = content.getBytes(StandardCharsets.UTF_8);
        byte[] res = cipher.doFinal(encrypted);
        return new String(new Base64().encode(res));
    }
}
