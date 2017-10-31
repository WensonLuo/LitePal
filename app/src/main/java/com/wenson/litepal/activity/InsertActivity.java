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

public class InsertActivity extends AppCompatActivity {
    private Button insertButton;
    private EditText showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        insertButton = findViewById(R.id.insert_one);
        showResult = findViewById(R.id.show_result_insert);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("Chinese");
                book.setAuthor("HaHa");
                book.setPages(454);
                book.setPrice(16.96);
                book.save();
                List<Book> books = DataSupport.findAll(Book.class);
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < books.size(); i++) {
                    builder.append(books.get(i).toString());
                }
                showResult.setText(builder.toString());
            }
        });
    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context,InsertActivity.class);
        context.startActivity(intent);
    }
}
