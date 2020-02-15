package edu.itc.gic.m1.semester1;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    ActionBar appbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        appbar = getSupportActionBar();
        appbar.setDisplayShowHomeEnabled(true);
        appbar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setTitle(int titleId) {
        appbar.setTitle(titleId);
    }

    @Override
    public void setTitle(CharSequence title) {
        appbar.setTitle(title);
    }
}
