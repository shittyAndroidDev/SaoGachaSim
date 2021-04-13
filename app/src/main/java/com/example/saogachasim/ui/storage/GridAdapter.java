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

import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private List<UnitEntity> data;

    GridAdapter(Context context){
        mContext = context;
    }
    public void setUnits(List<UnitEntity> units){
        data = units;
        notifyDataSetChanged();
    }
    @Override
    public int getCount(){
        if(data == null || data.isEmpty()){
            return 0;
        }else {
            return data.size();
        }
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
        UnitEntity unit = data.get(position);
        ImageView imageView = new ImageView(mContext);
        imageView.setForeground(Logic.getImg("s" + unit.star + "_frame",mContext));
        imageView.setBackground(mContext.getDrawable(R.drawable.unit_bg));
        imageView.setImageDrawable(Logic.getImg(unit.thumbnail,mContext));
        imageView.setTag(position);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(270,306));
        imageView.setPadding(12,9,12,4);
        return imageView;
    }
    public String getViewFull(int position){
        return data.get(position).full_Image;
    }
}
