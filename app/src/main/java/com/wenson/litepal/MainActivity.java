package com.wenson.litepal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.wenson.litepal.adapter.TitleAdapter;
import com.wenson.litepal.bean.TitleBean;
import com.wenson.litepal.view.WaterButton;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private WaterButton waterButton;
    List<TitleBean> titleList = new ArrayList<>();
    TitleAdapter mAdatper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdatper = new TitleAdapter(this, titleList);
        recyclerView.setAdapter(mAdatper);

        waterButton = findViewById(R.id.create_database);
        waterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
                Toast.makeText(getBaseContext(),"初始化 LitePal 成功！",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        TitleBean query = new TitleBean(getResources().getString(R.string.query));
        titleList.add(query);
        TitleBean insert = new TitleBean(getResources().getString(R.string.insert));
        titleList.add(insert);
        TitleBean delete = new TitleBean(getResources().getString(R.string.delete));
        titleList.add(delete);
        TitleBean update = new TitleBean(getResources().getString(R.string.update));
        titleList.add(update);
    }
}
