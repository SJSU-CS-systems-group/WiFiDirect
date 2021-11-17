package sjsu.ddd.android.wifidirect;

import android.content.Context;
import android.net.wifi.WpsInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.android.wifidirect.DeviceDetailFragment;
import com.example.android.wifidirect.DeviceListFragment;
import com.example.android.wifidirect.R;
import com.example.android.wifidirect.WiFiDirectActivity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class WifiDirectManager {

    public WifiP2pManager manager;
    public WifiP2pManager.Channel channel;

    public WifiDirectManager(Context context) {
        this.initOwner(context);
    }

    public void initOwner(Context context) {
        this.manager = (WifiP2pManager) context.getSystemService(Context.WIFI_P2P_SERVICE);
        this.channel = this.manager.initialize(context, Looper.getMainLooper(), null);
    }

    public void initClient(Context context) {
        this.manager = (WifiP2pManager) context.getSystemService(Context.WIFI_P2P_SERVICE);
        this.channel = this.manager.initialize(context, Looper.getMainLooper(), null);
    }

    /**
     * Discovers WifiDirect peers for this device.
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Future<Boolean> discoverPeers() {
        CompletableFuture<Boolean> cFuture = new CompletableFuture<>();
        this.manager.discoverPeers(this.channel, new WifiP2pManager.ActionListener() {

            @Override
            public void onSuccess() {
             cFuture.complete(true);
            }

            @Override
            public void onFailure(int reasonCode) {
                cFuture.complete(false);
            }
        });
        return cFuture;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Future<Boolean>  connect(WifiP2pConfig config) {
        CompletableFuture<Boolean> cFuture = new CompletableFuture<>();
        this.manager.connect(channel, config, new WifiP2pManager.ActionListener() {

            @Override
            public void onSuccess() {
                cFuture.complete(true);
            }

            @Override
            public void onFailure(int reasonCode) {
                cFuture.complete(false);
            }
        });
        return cFuture;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Future<Boolean>  disconnect() {
        CompletableFuture<Boolean> cFuture = new CompletableFuture<>();
        this.manager.removeGroup(this.channel, new WifiP2pManager.ActionListener() {


            @Override
            public void onSuccess() {
                cFuture.complete(true);
            }

            @Override
            public void onFailure(int reasonCode) {
                cFuture.complete(false);
            }

        });
        return cFuture;
    }

    public void directConnection(WifiP2pDevice device) {
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        config.wps.setup = WpsInfo.PBC;

        //((DeviceListFragment.DeviceActionListener) getActivity()).connect(config);
    }

}