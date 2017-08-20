package com.example.aidl_client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.aidl_server.IRemoteService;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivityTag";
    TextView textView;
    IRemoteService remoteService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void connectRemoteService(View view) throws RemoteException {

        switch (view.getId()){

            case R.id.btnBindService:
                Log.d(TAG, "connectRemoteService: bindService");

                ComponentName aidlComponent = new ComponentName("com.example.aidl_server","com.example.aidl_server.MyAIDLService");
                Intent remoteIntent = new Intent();
                remoteIntent.setComponent(aidlComponent);
                bindService(remoteIntent, serviceConnection,BIND_AUTO_CREATE);

                break;

            case R.id.btnSavePerson:

                remoteService.savePerson(new Person("John" + getRandom(), getRandom(), "male", new Date()));

                break;
            case R.id.btnGetPersonList:

                Log.d(TAG, "connectRemoteService: " + remoteService.getPersonList().size());
                break;
        }


    }


    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            Log.d(TAG, "onServiceConnected: ");
            remoteService = IRemoteService.Stub.asInterface(iBinder);

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

            Log.d(TAG, "onServiceDisconnected: ");
        }
    };


    public String getRandom() {
        Random random = new Random();
        return String.valueOf(random.nextInt(100));


    }
}
