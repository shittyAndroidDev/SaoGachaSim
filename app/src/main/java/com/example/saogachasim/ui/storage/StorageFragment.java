package com.example.saogachasim.ui.storage;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.example.saogachasim.dbHelper;
import com.example.saogachasim.R;



public class StorageFragment extends Fragment {
    private ViewModel storageViewmodel;
    private static final String TAG = "StorageFragment";
    private dbHelper mdbHelper;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        storageViewmodel =
                new ViewModel() {
                    @Override
                    protected void onCleared() {
                        super.onCleared();
                    }
                };

        View root = inflater.inflate(R.layout.storage, container, false);
        mdbHelper = new dbHelper(getContext());
        //mdbHelper.deleteAll();
        GridView grid;
        grid = root.findViewById(R.id.gridView);
        Cursor data = mdbHelper.getData();
        GridAdapter gridAdapter = new GridAdapter(getContext(),data);
        grid.setAdapter(gridAdapter);
        return root;
    }
}
