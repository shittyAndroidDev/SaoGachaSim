package com.example.saogachasim.ui.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saogachasim.Logic;
import com.example.saogachasim.R;
import com.example.saogachasim.ui.home.HomeFragment;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {
    private String[] data;
    Context mContext;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView imgView;
        public ViewHolder(View view){
            super(view);
            imgView = view.findViewById(R.id.bannerView);
            view.setOnClickListener(v -> {
               // int tag = (int)view.getTag();
                HomeFragment.bannerData.putInt("bannerNum",getAdapterPosition()+1);
            });
        }
        public ImageView getImgView(){
            return imgView;
        }

    }
    public BannerAdapter(Context context, String[] data) {
        mContext = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.banner_image, viewGroup, false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getImgView().setImageDrawable(Logic.getImg(data[position],mContext));
        viewHolder.getImgView().setTag(position+1);
    }
    @Override
    public int getItemCount() {
        return 191;
    }
}
