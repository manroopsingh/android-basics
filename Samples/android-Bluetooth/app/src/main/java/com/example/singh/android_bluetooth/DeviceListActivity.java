package com.example.singh.android_bluetooth;

import android.Manifest;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DeviceListActivity extends AppCompatActivity implements DeviceListAdapter.ItemClickListener{

    private static final int REQUEST_ENABLE_BT = 10;
    private static final String TAG = "BluetoothActivityTag";
    private static final int REQUEST_LOCATION = 20;
    private BluetoothAdapter mBluetoothAdapter;
    private boolean mScanning;
    private Handler mHandler = new Handler();
    private static final long SCAN_PERIOD = 10000;
    private DeviceListAdapter deviceListAdapter;
    BluetoothLeScanner mLeScanner;
    private ScanSettings settings;
    List<ScanFilter> filters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

//        Check if device support ble
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(this, "BLE is not supported", Toast.LENGTH_SHORT).show();
            finish();
        }

//        Request location permission
        requestLocationPermission();


//        Initializes Bluetooth adapter.
        initializeBLE();

//        setup recycler view for to list nearby devices
        setupRecyclerView();

    }

    private void requestLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION);

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(this)
                            .setTitle("Allow location")
                            .setMessage(R.string.location_permission_rationale)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    requestLocationPermission();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(DeviceListActivity.this, "Location denied. Results might not be accurate", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create();
                    alertDialog.show();


                }
                return;

            }

            case REQUEST_ENABLE_BT:

                break;

        }


    }

    private void initializeBLE() {
        final BluetoothManager bluetoothManager =
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            mBluetoothAdapter = bluetoothManager.getAdapter();
        }


        if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                mLeScanner = mBluetoothAdapter.getBluetoothLeScanner();
                settings = new ScanSettings.Builder()
                        .setScanMode(ScanSettings.SCAN_MODE_BALANCED)
                        .build();
                filters = new ArrayList<>();
            }
            scanLeDevice(true);
        }
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvDeviceList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        deviceListAdapter = new DeviceListAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(deviceListAdapter);
    }

    private void scanLeDevice(final boolean enable) {
        if (enable) {
            // Stops scanning after a pre-defined scan period.
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mScanning = false;
                    if (Build.VERSION.SDK_INT < 21) {
                        mBluetoothAdapter.stopLeScan(leScanCallback);
                    } else {
                        mLeScanner.stopScan(scanCallback);
                    }
                }
            }, SCAN_PERIOD);

            mScanning = true;
            if (Build.VERSION.SDK_INT < 21) {
                mBluetoothAdapter.startLeScan(leScanCallback);
            } else {
                // mLeScanner.startScan(filters, settings, scanCallback);
                mLeScanner.startScan(scanCallback);

            }
        } else {
            mScanning = false;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                mBluetoothAdapter.stopLeScan(leScanCallback);
            } else {
                mLeScanner.stopScan(scanCallback);
            }
        }
    }


    //callback for Android versions <21
    BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {

            if (device.getName() != null) {
                deviceListAdapter.addDevice(device);
            }
        }
    };

    //callback for Android versions > 21
    ScanCallback scanCallback = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);
            BluetoothDevice device = result.getDevice();
            deviceListAdapter.addDevice(device);
        }

        @Override
        public void onBatchScanResults(List<ScanResult> results) {
            super.onBatchScanResults(results);
        }

        @Override
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
        }
    };

    //button click for scanning the devices
    public void scanDevices(View view) {

        deviceListAdapter.clear();
        scanLeDevice(true);


    }

    @Override
    public void onItemClick(BluetoothDevice device) {
        Intent intent = new Intent(this, DeviceDetailActivity.class);
        intent.putExtra(Constants.KEY.DEVICE, device);
        startActivity(intent);

    }
}
