package com.example.singh.android_bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothProfile;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeviceDetailActivity extends AppCompatActivity {

    private static final String TAG = "DeviceDetailActivity";
    private ArrayList<ArrayList<BluetoothGattCharacteristic>> mGattCharacteristics;

    private final String LIST_NAME = "NAME";
    private final String LIST_UUID = "UUID";
    private BluetoothGatt bluetoothGatt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);


        //get device from intent
        BluetoothDevice device = getIntent().getParcelableExtra(Constants.KEY.DEVICE);
        //connect to gatt profile for the device
        bluetoothGatt = device.connectGatt(this, false, gattCallback);


    }


    //    callback for all services/characteristics discovered and state changes
    BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            super.onConnectionStateChange(gatt, status, newState);

            if (newState == BluetoothProfile.STATE_CONNECTED) {
                Log.i(TAG, "Connected to GATT server.");
//                if state is connected, then discover the services and receive them in OnServicesDiscovered
                Log.i(TAG, "Attempting to start service discovery: " + bluetoothGatt.discoverServices());
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            super.onServicesDiscovered(gatt, status);
            Log.d(TAG, "onServicesDiscovered: " + status);
            displayGattServices(gatt.getServices());
        }

        @Override
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            super.onCharacteristicRead(gatt, characteristic, status);
            Log.d(TAG, "onCharacteristicRead: ");
        }

        @Override
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            super.onCharacteristicWrite(gatt, characteristic, status);
            Log.d(TAG, "onCharacteristicWrite: ");
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            super.onCharacteristicChanged(gatt, characteristic);
            Log.d(TAG, "onCharacteristicChanged: ");
        }

        @Override
        public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            super.onDescriptorRead(gatt, descriptor, status);
            Log.d(TAG, "onDescriptorRead: ");
        }

        @Override
        public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            super.onDescriptorWrite(gatt, descriptor, status);
            Log.d(TAG, "onDescriptorWrite: ");
        }

        @Override
        public void onReliableWriteCompleted(BluetoothGatt gatt, int status) {
            super.onReliableWriteCompleted(gatt, status);
            Log.d(TAG, "onReliableWriteCompleted: ");
        }

        @Override
        public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {
            super.onReadRemoteRssi(gatt, rssi, status);
            Log.d(TAG, "onReadRemoteRssi: ");
        }

        @Override
        public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
            super.onMtuChanged(gatt, mtu, status);
            Log.d(TAG, "onMtuChanged: ");
        }
    };


    private void displayGattServices(List<BluetoothGattService> gattServices) {
        if (gattServices == null) {
            Log.d(TAG, "displayGattServices: Device has not services");
            return;
        }

        //declaring strings with default values
        String uuid = null;
        String unknownServiceString = getResources().getString(R.string.unknown_service);
        String unknownCharaString = getResources().getString(R.string.unknown_characteristic);

        //save services for the device in a list
        ArrayList<HashMap<String, String>> gattServiceData = new ArrayList<>();

        //saves all characteristics as per services for connected device
        ArrayList<ArrayList<HashMap<String, String>>> gattCharacteristicData = new ArrayList<>();
        mGattCharacteristics = new ArrayList<>();

        //loop through all the services available for connected device
        for (BluetoothGattService gattService : gattServices) {
            //create a hashmap for saving current services
            HashMap<String, String> currentServiceData = new HashMap<>();
            uuid = gattService.getUuid().toString();
            //add values to the hashmap
            currentServiceData.put(LIST_NAME, SampleGattAttributes.lookup(uuid, unknownServiceString));
            currentServiceData.put(LIST_UUID, uuid);
            //add hashmap to the arraylist for services data
            gattServiceData.add(currentServiceData);
            Log.d(TAG, "displayGattServices: Service att: " + SampleGattAttributes.lookup(uuid, unknownCharaString));
            Log.d(TAG, "displayGattServices: Service uuid: " + uuid);

            //saves characteristics for each service in a arraylist
            ArrayList<HashMap<String, String>> gattCharacteristicGroupData = new ArrayList<>();
            //get characteristics for each service for the connected device
            List<BluetoothGattCharacteristic> gattCharacteristics = gattService.getCharacteristics();
            //save each charateristic in a list to set the recycler view
            ArrayList<BluetoothGattCharacteristic> bluetoothGattCharacteristics = new ArrayList<>();

            //loop through each characteristic for look up
            for (BluetoothGattCharacteristic gattCharacteristic : gattCharacteristics) {
                bluetoothGattCharacteristics.add(gattCharacteristic);
                //create a hashmap to add current characteristics for each service
                HashMap<String, String> currentCharaData = new HashMap<>();
                uuid = gattCharacteristic.getUuid().toString();
                //add values to the current characteric data hashmap
                currentCharaData.put(LIST_NAME, SampleGattAttributes.lookup(uuid, unknownCharaString));
                currentCharaData.put(LIST_UUID, uuid);
                //add the hashmap to the list
                gattCharacteristicGroupData.add(currentCharaData);
                Log.d(TAG, "displayGattServices: Char " + SampleGattAttributes.lookup(uuid, unknownCharaString));
                Log.d(TAG, "displayGattServices: Char " + uuid);

//                Enable or disable notifications/indications for a given characteristic.

//                Once notifications are enabled for a characteristic,
// a onCharacteristicChanged(BluetoothGatt, BluetoothGattCharacteristic) callback will be triggered
// if the remote device indicates that the given characteristic has changed.
                if (uuid.equals("00002a19-0000-1000-8000-00805f9b34fb")) {
                    bluetoothGatt.setCharacteristicNotification(gattCharacteristic, true);
                }
            }
            //add the results to the final lists
            mGattCharacteristics.add(bluetoothGattCharacteristics);
            gattCharacteristicData.add(gattCharacteristicGroupData);
        }

        // TODO: 21-Oct-17 setup expandable list view for services and characteristics


    }
}
