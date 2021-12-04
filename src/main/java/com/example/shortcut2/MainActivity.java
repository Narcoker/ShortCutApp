package com.example.shortcut2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;

import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<AppListItem> shortCut_apps = new ArrayList<AppListItem>();
    Button main_btn_add;
    MyDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        main_btn_add = (Button) findViewById(R.id.main_btn_add);
        dbHelper = new MyDBHelper(MainActivity.this, 1);


        //출력
        dbHelper.readDB();
        ListView appList = (ListView) findViewById(R.id.main_appListView);
        final AppListAdapter_ShorCutApp myAdapter = new AppListAdapter_ShorCutApp(this, shortCut_apps);
        appList.setAdapter(myAdapter);

        main_btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelectApp.class);
                startActivity(intent);
            }
        });

        appList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dbHelper.Delete(myAdapter.getItem(position).getAppName());

                Toast.makeText(getApplicationContext(), "삭제되었습니다.", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return false;
            }
        });

    }

}
