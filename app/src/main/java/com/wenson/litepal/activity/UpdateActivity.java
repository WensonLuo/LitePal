package com.wenson.litepal.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wenson.litepal.R;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context,UpdateActivity.class);
        context.startActivity(intent);
    }
}
