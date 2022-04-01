package rcsl.robotblock.kebbi2;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.content.ComponentName;
import android.os.RemoteException;
import android.content.Context;

public class BindBackgroundService{

    Context context;
    private ISwitchTrack mSwitchTrack;

    public BindBackgroundService(Context context){
        this.context = context;
    }

    public ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mSwitchTrack = ISwitchTrack.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mSwitchTrack = null;
        }
    };

    public void BindBGService(){
        Intent intent = new Intent();
        intent.setPackage("com.example.kebbifacetracking");
        intent.setAction("com.example.kebbifacetracking.KCamera2");
        boolean a = this.context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void DisableTrack(){
        try {
            mSwitchTrack.disableTrack();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void EnableTrack(){
        try {
            mSwitchTrack.enableTrack();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}