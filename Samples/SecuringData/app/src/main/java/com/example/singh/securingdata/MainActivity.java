package com.example.singh.securingdata;

import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    private static final java.lang.String TRANSFORMATION_ASYMMETRIC = "RSA/ECB/PKCS1Padding";
    private String alias = "master_key";

    private KeyguardManager keyguardManager;
    private KeyStoreWrapper keyStoreWrapper;
    private CipherWrapper cipherWrapper;
    private EditText etRawData;
    private TextView tvEncryptedData;
    private TextView tvRawData;
    private KeyPair masterKey;
    private String encryptedData;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindViews();
        checkLockScreen();


        try {
            //init cipher, keystore, keys for encryption and decryption
            initEncryptor();

        } catch (CertificateException
                | NoSuchAlgorithmException
                | KeyStoreException
                | NoSuchPaddingException
                | IOException
                | NoSuchProviderException
                | InvalidAlgorithmParameterException
                | UnrecoverableKeyException e) {
            e.printStackTrace();
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void initEncryptor() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, NoSuchPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException, UnrecoverableKeyException {

        //initialize wrapper classes
        keyStoreWrapper = new KeyStoreWrapper(this);
        cipherWrapper = new CipherWrapper(TRANSFORMATION_ASYMMETRIC);

        //create asymmetric key pair
        keyStoreWrapper.createAKSKeyPair(alias);

        //get asymmetric key pair
        masterKey = keyStoreWrapper.getAKSAsymmetricKeyPair(alias);
    }

    private void bindViews() {
        etRawData = findViewById(R.id.etRawData);
        tvEncryptedData = findViewById(R.id.tvEncryptedData);
        tvRawData = findViewById(R.id.tvRawData);
    }

    private void checkLockScreen() {
        keyguardManager = (KeyguardManager) this.getSystemService(Context.KEYGUARD_SERVICE);


        boolean isDeviceSecure;

        if (hasMarshmallow()) {
            isDeviceSecure = keyguardManager.isDeviceSecure();
        } else isDeviceSecure = keyguardManager.isKeyguardSecure();

        Log.d(TAG, "onCreate: " + isDeviceSecure);

        if (!isDeviceSecure) {
            showDialogForLockSettings();

        }
    }


    private void showDialogForLockSettings() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.lock_title)
                .setMessage(R.string.lock_body)
                .setPositiveButton(R.string.lock_settings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // TODO: 13-Dec-17 Go to lock screen to setup a lock
                    }
                })
                .setNegativeButton(R.string.lock_exit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // TODO: 13-Dec-17
                    }
                })
                .setCancelable(BuildConfig.DEBUG)
                .create();

        alertDialog.show();
    }


    public boolean hasMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }


    public void onEncrypt(View view) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        String data = etRawData.getText().toString();

        //encrypt data using cipher, public key
        encryptedData = cipherWrapper.encrypt(data, masterKey.getPublic());

        tvEncryptedData.setText(encryptedData);
        Toast.makeText(this, "Encrypted", Toast.LENGTH_SHORT).show();
    }

    public void onDecrypt(View view) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {

        //decrypt data using cipher, private key
        String decryptedData = cipherWrapper.decrypt(encryptedData, masterKey.getPrivate());

        tvRawData.setText(decryptedData);
        Toast.makeText(this, "Decrypted", Toast.LENGTH_SHORT).show();
    }
}
