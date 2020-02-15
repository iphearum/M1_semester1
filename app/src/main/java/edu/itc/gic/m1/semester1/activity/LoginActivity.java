package edu.itc.gic.m1.semester1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.annotation.Nullable;
import edu.itc.gic.m1.semester1.BaseActivity;
import edu.itc.gic.m1.semester1.R;

public class LoginActivity extends BaseActivity {
    protected String phone;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login Screen");
    }

    public void logIn(View view) {
        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(intent);
    }
    public void writeJSON() {
        JSONObject object = new JSONObject();
        try {
            object.put("phone", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(object);
    }
}
