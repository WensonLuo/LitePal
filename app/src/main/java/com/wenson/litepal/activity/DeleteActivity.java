package com.wenson.litepal.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wenson.litepal.R;
import com.wenson.litepal.bean.Book;

import org.litepal.crud.DataSupport;

public class DeleteActivity extends AppCompatActivity {
    private Button deleteAllButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        deleteAllButton = findViewById(R.id.delete_all);
        deleteAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book.class);
                Toast.makeText(getBaseContext(),"删除所有",Toast.LENGTH_SHORT);
            }
        });
    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context,DeleteActivity.class);
        context.startActivity(intent);
    }
}
