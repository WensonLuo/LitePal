package com.wenson.litepal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wenson.litepal.R;
import com.wenson.litepal.bean.TitleBean;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Wenson_Luo on 2017/10/28.
 */

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {
    private List<TitleBean> mTitleList = new ArrayList<>();
    private Context mContext;


    public TitleAdapter(Context context, List<TitleBean> mTitleList) {
        mContext = context;
        this.mTitleList = mTitleList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: -------- position = " + position);
        TitleBean titleBean = mTitleList.get(position);
        holder.itemTitle.setText(titleBean.getTitle());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: List =  " + mTitleList.size());
        return mTitleList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View titleView;
        TextView itemTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            titleView = itemView;
            itemTitle = itemView.findViewById(R.id.item_title);
        }
    }
}
