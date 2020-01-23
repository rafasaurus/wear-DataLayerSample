package com.example.android.wearable.datalayer;

import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.data.FreezableUtils;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;

import java.util.ArrayList;

public class MobileWearableService extends WearableListenerService
        implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private GoogleApiClient mGoogleApiClient;
    private boolean nodeConnected = false;

    @Override
    public void onCreate() {
        super.onCreate();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        nodeConnected = true;
    }

    @Override
    public void onConnectionSuspended(int i) {
        nodeConnected = false;
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        nodeConnected = false;
    }

//    @Override
//    public void onDataChanged(DataEventBuffer dataEvents) {
//        final ArrayList<DataEvent> events = FreezableUtils.freezeIterable(dataEvents);
//
//        for (DataEvent event : events) {
//            PutDataMapRequest putDataMapRequest =
//                    PutDataMapRequest.createFromDataMapItem(DataMapItem.fromDataItem(event.getDataItem()));
//
//            String path = event.getDataItem().getUri().getPath();
//            if (event.getType() == DataEvent.TYPE_CHANGED) {
//                // if (PATH_DATA.equals(path)) {
//                if (true) {
//                    DataMap data = putDataMapRequest.getDataMap();
//                    String data_ = data.getString("data");
//                } else if (event.getType() == DataEvent.TYPE_DELETED) {
//
//                }
//            }
//        }
//    }
}
