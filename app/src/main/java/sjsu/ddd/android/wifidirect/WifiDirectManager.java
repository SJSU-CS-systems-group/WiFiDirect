package sjsu.ddd.android.wifidirect;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Looper;

public class WifiDirectManager {

    public WifiP2pManager manager;
    public WifiP2pManager.Channel channel;

    public WifiDirectManager(Context context) {
        this.manager = (WifiP2pManager) context.getSystemService(Context.WIFI_P2P_SERVICE);
        this.channel = this.manager.initialize(context, Looper.getMainLooper(), null);
    }

}