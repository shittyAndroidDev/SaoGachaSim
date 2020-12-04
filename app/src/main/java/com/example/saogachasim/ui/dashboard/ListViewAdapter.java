package com.example.saogachasim.ui.dashboard;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.saogachasim.Logic;

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;

    ListViewAdapter(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public int getCount(){
        return 172;
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
    public View getView(int position, View view, ViewGroup parent){
        String s;
        if(position<9){
            s = "b00"+(position+1)+"_scout_banner";
        }else if(position<99){
            s = "b0"+(position+1)+"_scout_banner";
        }else{
            s = "b"+(position+1)+"_scout_banner";
        }
        ImageView imageView = new ImageView(mContext);
        imageView.setImageDrawable(Logic.getImg(s,mContext));
        imageView.setTag(position+1);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 555));
        Log.e("not found",""+s);
        return imageView;
    }

}
