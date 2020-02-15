package edu.itc.gic.m1.semester1;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;
import edu.itc.gic.m1.semester1.activity.HomeActivity;
import edu.itc.gic.m1.semester1.activity.SplashActivity;

public class SplashscreenActivity extends Activity {
    public static final int DELAY_MILLIS = 2000;//for testing i use 5 seconds
    private Handler handler = null;
    private static boolean isLogin = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isLogin == false){
            Intent intent = new Intent(SplashscreenActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashscreenActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY_MILLIS);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacksAndMessages(null);
    }
}
