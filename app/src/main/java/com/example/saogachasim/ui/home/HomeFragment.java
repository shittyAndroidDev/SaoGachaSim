package com.example.saogachasim.ui.home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.saogachasim.Logic;
import com.example.saogachasim.MainActivity;
import com.example.saogachasim.R;
import com.example.saogachasim.ui.dashboard.ScoutResultActivity;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;

    public static Bundle bannerData = new Bundle();

    private View.OnClickListener scout1_listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int bannerNum = bannerData.getInt("bannerNum");
            if(bannerNum==0){
                return;
            }
            int[] chData = Logic.scout(bannerNum, MainActivity.m[bannerNum]);
            Pair<String,String> resname = Logic.constructName(chData);
            Intent i = new Intent(getActivity(), ScoutResultActivity.class);
            String[] resultData ={resname.first,resname.second};
            i.putExtra("result",resultData);
            i.putExtra("star",chData[1]);
            String tag = (String)v.getTag();
            int imgTag = Integer.parseInt(tag);
            i.putExtra("img_tag",imgTag);
            startActivity(i);
        }
    };
    private View.OnClickListener scout2_listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int bannerNum = bannerData.getInt("bannerNum");
            if(bannerNum==0){
                return;
            }
            Intent i = new Intent(getActivity(), ScoutResultActivity.class);
            int[] star_level = new int[11];
            String[] result0 = new String[11];
            String[] result1 = new String[11];
            for(int j= 0;j<11;j++){
                int[] chData = Logic.scout(bannerNum, MainActivity.m[bannerNum]);
                star_level[j]=chData[1];
                Pair<String,String> resname = Logic.constructName(chData);
                result0[j] = resname.first;
                result1[j] = resname.second;
            }
            i.putExtra("star2",star_level);
            i.putExtra("result2",result0);
            i.putExtra("result3",result1);
            String tag = (String)v.getTag();
            int imgTag = Integer.parseInt(tag);
            i.putExtra("img_tag",imgTag);
            startActivity(i);
        }
    };


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView scout1;
        ImageView scout2;
        scout1 = root.findViewById(R.id.scout1_img);
        scout1.setOnClickListener(scout1_listen);
        scout2 = root.findViewById(R.id.scout2_img);
        scout2.setOnClickListener(scout2_listen);


        int bannerNum;
        if(bannerData.isEmpty()){
        }else{
            bannerNum = bannerData.getInt("bannerNum");
            String name = Logic.getBanner(bannerNum);
            Drawable img = Logic.getImg(name, getContext());
            ImageView imgView = root.findViewById(R.id.bannerView);
            imgView.setImageDrawable(img);
        }
        return root;
    }
}