package com.wenson.litepal.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wenson.litepal.R;
import com.wenson.litepal.bean.Book;

import org.litepal.crud.DataSupport;

import java.util.List;

public class QueryActivity extends AppCompatActivity implements View.OnClickListener {
    private Button queryAllButton;
    private EditText showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        queryAllButton = findViewById(R.id.query_all);
        showResult = findViewById(R.id.show_result);
        queryAllButton.setOnClickListener(this);
    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context,QueryActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.query_all:
                List<Book> books = DataSupport.findAll(Book.class);
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < books.size(); i++) {
                    builder.append(books.get(i).toString());
                }
                showResult.setText(builder.toString());
                break;
        }
    }
}
