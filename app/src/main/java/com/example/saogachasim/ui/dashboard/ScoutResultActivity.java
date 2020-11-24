package com.example.saogachasim.ui.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import com.example.saogachasim.MainActivity;
import com.example.saogachasim.R;
import com.example.saogachasim.dbHelper;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class ScoutResultActivity extends AppCompatActivity {
    public static ImageView[] iv = new ImageView[11];
    private static final String TAG = "ScoutResultActivity";
    dbHelper mdbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scout_result);
        Bundle data = getIntent().getExtras();
        mdbHelper = new dbHelper(this);
        if (data == null) {
            return;
        }
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

        if (data.getInt("img_tag") == 1){
            iv[0].setForeground(MainActivity.logic.getImg("s" + (data.getInt("star")) + "_frame", getApplicationContext()));
            iv[0].setImageDrawable(MainActivity.logic.getImg(data.getStringArray("result")[0], getApplicationContext()));
            iv[0].setBackground(getDrawable(R.drawable.unit_bg));
            AddData(data.getStringArray("result")[0],data.getStringArray("result")[1]);
        }else if(data.getInt("img_tag")==2){
            int[] stars = data.getIntArray("star2");
            String[] results = data.getStringArray("result2");
            for(int i =0;i<11;i++){
                //int id = getApplicationContext().getResources().getIdentifier(slot,"layout",getApplicationContext().getPackageName());
                iv[i].setForeground(MainActivity.logic.getImg("s" + stars[i] + "_frame", getApplicationContext()));
                iv[i].setImageDrawable(MainActivity.logic.getImg(data.getStringArray("result2")[i], getApplicationContext()));
                iv[i].setBackground(getDrawable(R.drawable.unit_bg));
                AddData(data.getStringArray("result2")[i],data.getStringArray("result3")[i]);
            }
        }else{

        }

    }
    public void AddData(String th, String full){
        boolean insertData = mdbHelper.addData(th,full);
        if(insertData == false){
            Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "succes", Toast.LENGTH_SHORT).show();
        }
    }

}
