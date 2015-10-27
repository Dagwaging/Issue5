package me.dagwaging.issue5;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import ch.uepaa.p2pkit.ConnectionCallbacks;
import ch.uepaa.p2pkit.ConnectionResult;
import ch.uepaa.p2pkit.ConnectionResultHandling;
import ch.uepaa.p2pkit.KitClient;

public class MainActivity extends AppCompatActivity implements ConnectionCallbacks {
    private static KitClient client;
    private TextView status;

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);

        status = (TextView) findViewById(R.id.p2p_kit_status);

        if(client == null) {
            client = KitClient.getInstance(this);
        }

        client.registerConnectionCallbacks(this);
        client.connect(getString(R.string.p2p_kit_api_key));
    }

    @Override
    protected void onStop() {
        super.onStop();
        client.unregisterConnectionCallbacks(this);
        client.disconnect();
    }

    @Override
    public void onConnected() {
        status.setText(R.string.p2p_kit_installed);
    }

    @Override
    public void onConnectionSuspended() {
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        status.setText(R.string.p2p_kit_not_installed);
        ConnectionResultHandling.showAlertDialogForConnectionError(this, connectionResult.getStatusCode());
    }
}
