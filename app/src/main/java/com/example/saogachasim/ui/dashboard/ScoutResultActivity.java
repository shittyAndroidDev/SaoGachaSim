package com.example.saogachasim.ui.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.saogachasim.Logic;
import com.example.saogachasim.MainActivity;
import com.example.saogachasim.R;
import com.example.saogachasim.dbHelper;
import com.example.saogachasim.ui.storage.AppDatabase;
import com.example.saogachasim.ui.storage.StorageViewModel;
import com.example.saogachasim.ui.storage.UnitEntity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class ScoutResultActivity extends AppCompatActivity {
    //dbHelper mdbHelper;
    public static final String EXTRA_REPLY =
            "com.example.saogachasim.ui.home.REPLY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scout_result);
        Bundle data = getIntent().getExtras();
        //mdbHelper = new dbHelper(this);
        if (data == null) {
            return;
        }
        ImageView[] iv = new ImageView[11];
        iv[0] = findViewById(R.id.scout_slot0);
        iv[1] = findViewById(R.id.scout_slot1);
        iv[2] = findViewById(R.id.scout_slot2);
        iv[3] = findViewById(R.id.scout_slot3);
        iv[4] = findViewById(R.id.scout_slot4);
        iv[5] = findViewById(R.id.scout_slot5);
        iv[6] = findViewById(R.id.scout_slot6);
        iv[7] = findViewById(R.id.scout_slot7);
        iv[8] = findViewById(R.id.scout_slot8);
        iv[9] = findViewById(R.id.scout_slot9);
        iv[10] = findViewById(R.id.scout_slot10);
        TextView diamonds = findViewById(R.id.amount_md);
        //diamonds.setText(""+(data.getInt("diamonds")));
        if (data.getInt("img_tag") == 1){
            iv[0].setForeground(Logic.getImg("s" + (data.getInt("star")) + "_frame", getApplicationContext()));
            iv[0].setImageDrawable(Logic.getImg(data.getStringArray("result")[0], getApplicationContext()));
            iv[0].setBackground(getDrawable(R.drawable.unit_bg));
            Intent replyIntent = new Intent();
            UnitEntity unit = new UnitEntity(data.getStringArray("result")[0],data.getStringArray("result")[1],data.getInt("star"));
            replyIntent.putExtra("unit",unit);
            replyIntent.putExtra("multi",false);
            setResult(RESULT_OK,replyIntent);
        }else if(data.getInt("img_tag")==2){
            int[] stars = data.getIntArray("star2");
            UnitEntity[] unitEntities = new UnitEntity[11];
            for(int i = 0;i<11;i++){
                iv[i].setForeground(Logic.getImg("s" + stars[i] + "_frame", getApplicationContext()));
                iv[i].setImageDrawable(Logic.getImg(data.getStringArray("result2")[i], getApplicationContext()));
                iv[i].setBackground(getDrawable(R.drawable.unit_bg));
                unitEntities[i] = (new UnitEntity(data.getStringArray("result2")[i],data.getStringArray("result3")[i],stars[i]));
            }
            Intent replyIntent = new Intent();
            replyIntent.putExtra("units",unitEntities);
            replyIntent.putExtra("multi",true);
            setResult(RESULT_OK,replyIntent);
        }
    }

}
