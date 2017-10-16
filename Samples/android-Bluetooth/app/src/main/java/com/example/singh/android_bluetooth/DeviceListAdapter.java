package com.example.singh.android_bluetooth;

import android.bluetooth.BluetoothDevice;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by singh on 14-Oct-17.
 */

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.ViewHolder> {

    public static final String TAG = "DeviceListAdapterTag";
    List<BluetoothDevice> deviceList;

    public DeviceListAdapter() {
        this.deviceList = new ArrayList<>();
    }

    public void addDevice(BluetoothDevice device) {
        if(!deviceList.contains(device)){
            this.deviceList.add(device);
            notifyDataSetChanged();
        }

    }

    public BluetoothDevice getDevice(int position) {
        return this.deviceList.get(position);
    }

    public void clear(){
        this.deviceList.clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BluetoothDevice device = deviceList.get(position);
        holder.tvDeviceName.setText(device.getName());
        holder.tvDeviceAddress.setText(device.getAddress());

    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView tvDeviceAddress;
        private final TextView tvDeviceName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDeviceName = (TextView) itemView.findViewById(R.id.tvDeviceName);
            tvDeviceAddress = (TextView) itemView.findViewById(R.id.tvDeviceAddress);

        }
    }
}
