package com.ficat.easyble.gatt;


import com.ficat.easyble.BleDevice;
import com.ficat.easyble.gatt.callback.BleConnectCallback;
import com.ficat.easyble.gatt.callback.BleMtuCallback;
import com.ficat.easyble.gatt.callback.BleNotifyCallback;
import com.ficat.easyble.gatt.callback.BleQueryServicesCallback;
import com.ficat.easyble.gatt.callback.BleReadCallback;
import com.ficat.easyble.gatt.callback.BleRssiCallback;
import com.ficat.easyble.gatt.callback.BleWriteByBatchCallback;
import com.ficat.easyble.gatt.callback.BleWriteCallback;

import java.util.List;

public interface BleGatt {
    void connect(BleDevice device, BleConnectCallback callback);

    void disconnect(BleDevice device);

    void disconnectAll();

    void queryServices(BleDevice device, BleQueryServicesCallback callback);

    void notify(BleDevice device, String serviceUuid, String notifyUuid, BleNotifyCallback callback);

    void cancelNotify(BleDevice device, String serviceUuid, String characteristicUuid);

    void read(BleDevice device, String serviceUuid, String readUuid, BleReadCallback callback);

    void write(BleDevice device, String serviceUuid, String writeUuid, byte[] data, BleWriteCallback callback);

    void writeByBatch(BleDevice device, String serviceUuid, String writeUuid, byte[] data, int lengthPerPackage, BleWriteByBatchCallback callback);

    void readRssi(BleDevice device, BleRssiCallback callback);

    void setMtu(BleDevice device, int mtu, BleMtuCallback callback);

    List<BleDevice> getConnectedDevices();

    void destroy();
}