package com.example.singh.securingdata;

import android.util.Base64;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Author: singh on: 13-Dec-17.
 */

public class CipherWrapper {

    private final Cipher cipher;
    private String transformation;

    public CipherWrapper(String transformation) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.transformation = transformation;

        cipher = Cipher.getInstance(transformation);
    }

    public String encrypt(String data, Key key) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(data.getBytes());
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    public String decrypt(String data, Key key) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] encryptedData = Base64.decode(data, Base64.DEFAULT);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        return new String(decryptedData);
    }
}
