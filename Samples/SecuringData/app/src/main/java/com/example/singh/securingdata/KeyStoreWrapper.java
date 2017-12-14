package com.example.singh.securingdata;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Calendar;

import javax.security.auth.x500.X500Principal;

/**
 * Author: singh on: 13-Dec-17.
 */

public class KeyStoreWrapper {


    private Context context;
    private static final String TAG = "KeyStoreWrapTag";
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    public static final String CURRENT_ALGORITHM = "RSA";
    private KeyPairGenerator keyPairGenerator;
    private KeyStore keyStore;

    public KeyStoreWrapper(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.context = context;
        initWrapper();

    }

    private void initWrapper() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
        keyStore.load(null);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public KeyPair createAKSKeyPair(String alias) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {


        keyPairGenerator = KeyPairGenerator.getInstance(CURRENT_ALGORITHM, KEYSTORE_PROVIDER);

//        if (hasMarshmallow()) {
//            initGeneratorWithKeyGenParamSpec(keyPairGenerator, alias);
//        } else {
        initGeneratorWithKeyPairParamSpec(keyPairGenerator, alias);
//        }

        return keyPairGenerator.generateKeyPair();

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void initGeneratorWithKeyPairParamSpec(KeyPairGenerator keyPairGenerator, String alias) throws InvalidAlgorithmParameterException {


        Log.d(TAG, "initGeneratorWithKeyPairParamSpec: ");
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        endDate.add(Calendar.YEAR, 20);

        KeyPairGeneratorSpec keyPairSpec = new KeyPairGeneratorSpec.Builder(context)
                .setAlias(alias)
                .setSerialNumber(BigInteger.ONE)
                .setSubject(new X500Principal("CN=${alias} CA Certificate"))
                .setStartDate(startDate.getTime())
                .setEndDate(endDate.getTime())
                .build();

        keyPairGenerator.initialize(keyPairSpec);
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void initGeneratorWithKeyGenParamSpec(KeyPairGenerator keyPairGenerator, String alias) throws InvalidAlgorithmParameterException {

        Log.d(TAG, "initGeneratorWithKeyGenParamSpec: ");

        KeyGenParameterSpec keyGenSpec = new KeyGenParameterSpec.Builder(alias, KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
                .build();

        keyPairGenerator.initialize(keyGenSpec);
    }

    public boolean hasMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }


    public KeyPair getAKSAsymmetricKeyPair(String alias) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {

        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, null);
        PublicKey publicKey = keyStore.getCertificate(alias).getPublicKey();

        if (privateKey != null && publicKey != null)
            return new KeyPair(publicKey, privateKey);
        else
            return null;

    }

    public void removeAKSKey(String alias) throws KeyStoreException {
        keyStore.deleteEntry(alias);
    }
}
