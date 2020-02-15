package edu.itc.gic.m1.semester1.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.Nullable;
import edu.itc.gic.m1.semester1.BaseActivity;
import edu.itc.gic.m1.semester1.R;

public class HomeActivity extends BaseActivity {

    public HomeActivity(){}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
        Context context = null;
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("users");
            formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            String phone = null;
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String user_name = jo_inside.getString("user_name");
                phone = jo_inside.getString("phone");
                m_li = new HashMap<String, String>();
                m_li.put("user_name", user_name);
                m_li.put("phone", phone);
                formList.add(m_li);
            }
            if (phone != null) {
                setContentView(R.layout.activity_home);
                setTitle("Home Screen");
            }else{
                Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("temp/login.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
