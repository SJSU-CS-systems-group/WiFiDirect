package sjsu.ddd.android.wifidirect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

public class WifiDirectBroadcastReceiver extends BroadcastReceiver {

    public WifiDirectBroadcastReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean startService = true;
        //Intent serviceIntent = new Intent(context, WifiDirectActivity.class);
        switch (intent.getAction()) {
            case WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION:
                intent.setAction("STATE_CHANGED");
                int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
                intent.putExtra("P2P_ENABLED", (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED));
                break;
            case WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION:
                Log.d("P2P", "Peers changed");
                intent.setAction("PEERS_CHANGED");
                break;
            case WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION:
                Log.d("P2P", "Connection changed");
                intent.setAction("CONNECTION_CHANGED");
                break;
            default:
                startService = false;
                break;
        }
        if (startService) {
            context.startService(intent);
        }
    }

}