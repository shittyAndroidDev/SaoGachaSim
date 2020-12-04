package com.example.saogachasim.ui.storage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import com.example.saogachasim.Logic;
import com.example.saogachasim.dbHelper;
import com.example.saogachasim.R;

public class StorageFragment extends Fragment {

    private ViewModel storageViewmodel;
    private static final String TAG = "StorageFragment";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        storageViewmodel =
                new ViewModel() {
                    @Override
                    protected void onCleared() {
                        super.onCleared();
                    }
                };

        final View root = inflater.inflate(R.layout.storage, container, false);
        dbHelper mdbHelper = new dbHelper(getContext());
        //mdbHelper.deleteAll();
        GridView grid;
        grid = root.findViewById(R.id.gridView);
        Cursor data = mdbHelper.getData();
        final GridAdapter gridAdapter = new GridAdapter(getContext(),data);
        grid.setAdapter(gridAdapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int tag = (int)view.getTag();
                String s = gridAdapter.getViewFull(tag);
                    ImageView img = new ImageView(getContext());
                    img.setImageDrawable(Logic.getImg(s,getContext()));
                    Dialog builder = new Dialog(getContext());
                    builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    builder.getWindow().setBackgroundDrawable(
                            new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialogInterface) {
                        }
                    });
                    builder.addContentView(img, new RelativeLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT));
                    builder.show();
            }
        });


        return root;

    }

}
