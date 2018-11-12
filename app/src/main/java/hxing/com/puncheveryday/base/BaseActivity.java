package hxing.com.puncheveryday.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public static final String TAG = "PUNCH_DAYLIY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        setContentView(setContentView());
        super.onCreate(savedInstanceState);
    }

    protected abstract int setContentView();
}
