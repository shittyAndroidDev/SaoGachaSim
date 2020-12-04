package com.example.saogachasim.ui.storage;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.saogachasim.Logic;
import com.example.saogachasim.R;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private Cursor data;
    private ArrayList[] img;

    GridAdapter(Context context, Cursor data){
        mContext = context;
        this.data = data;
        img = new ArrayList[3];
        img[0] = new ArrayList();
        img[1] = new ArrayList();
        img[2] = new ArrayList();
        while(data.moveToNext()){
            img[0].add(data.getString(1));
            img[1].add(data.getString(2));
            img[2].add(data.getInt(3));
        }
    }
    @Override
    public int getCount(){
        return data.getCount();
    }
    @Override
    public long getItemId(int pos){
        return 0;
    }
    @Override
    public Object getItem(int pos){
        return null;
    }
    @Override
    public View getView(int position , View convert, ViewGroup parent){
        int star = (int)img[2].get(position);
        ImageView imageView = new ImageView(mContext);
        imageView.setForeground(Logic.getImg("s" + star + "_frame",mContext));
        imageView.setBackground(mContext.getDrawable(R.drawable.unit_bg));
        imageView.setImageDrawable(Logic.getImg((String)img[0].get(position),mContext));
        imageView.setTag(position);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(270,306));
        imageView.setPadding(12,9,12,4);
        return imageView;
    }
    public String getViewFull(int position){
        return (String)img[1].get(position);
    }
}
