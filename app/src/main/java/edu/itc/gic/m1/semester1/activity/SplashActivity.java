package edu.itc.gic.m1.semester1.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import edu.itc.gic.m1.semester1.R;

public class SplashActivity extends AppCompatActivity {
    // Extras that can be passed from NFC (see SplashScreenActivity)
    public static final String EXTRA_APP = "application/vnd.no.nordicsemi.type.app";
    public static final String EXTRA_ADDRESS = "application/vnd.no.nordicsemi.type.address";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        final Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_APP) && intent.hasExtra(EXTRA_ADDRESS)) {
            final String app = intent.getStringExtra(EXTRA_APP);
            switch (app) {
                case "HRM":
                    final Intent newIntent = new Intent(this, HomeActivity.class);
                    newIntent.putExtra(EXTRA_ADDRESS, intent.getByteArrayExtra(EXTRA_ADDRESS));
                    newIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(newIntent);
                    break;
                default:
                    // other are not supported yet
                    break;
            }
        }
    }
}
