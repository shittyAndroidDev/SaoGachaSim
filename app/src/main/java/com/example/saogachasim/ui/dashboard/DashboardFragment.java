package com.example.saogachasim.ui.dashboard;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.saogachasim.R;
import com.example.saogachasim.ui.home.HomeFragment;

import java.util.List;

public class DashboardFragment extends Fragment {
    private DashboardViewModel dashboardViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        GridView grid_b= root.findViewById(R.id.banner_grid);
        ListViewAdapter listViewAdapter = new ListViewAdapter(getContext());
        grid_b.setAdapter(listViewAdapter);
        grid_b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int tag = (int)view.getTag();
                HomeFragment.bannerData.putInt("bannerNum",tag);
            }
        });
        return root;
    }
}