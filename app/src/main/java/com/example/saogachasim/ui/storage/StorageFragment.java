package com.example.saogachasim.ui.storage;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.example.saogachasim.dbHelper;


import com.example.saogachasim.R;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class StorageFragment extends Fragment {
    private ViewModel storageViewmodel;
    private static final String TAG = "StorageFragment";
    private ListView listView;
    dbHelper mdbHelper;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        storageViewmodel =
               // ViewModelProviders.of(this).get(StorageViewModel.class);
                new ViewModel() {
                    @Override
                    protected void onCleared() {
                        super.onCleared();
                    }
                };

        View root = inflater.inflate(R.layout.storage, container, false);
        mdbHelper = new dbHelper(getContext());
        listView = root.findViewById(R.id.lView);
        populateListView();

        return root;
    }
    public void populateListView(){
        Cursor data = mdbHelper.getData();
        ArrayList[] save = new ArrayList[2];
        save[0] = new ArrayList<String>();
        while(data.moveToNext()){
            save[0].add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,save[0]);
        listView.setAdapter(adapter);
    }

}
