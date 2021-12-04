package com.example.shortcut2;

import static com.example.shortcut2.MainActivity.shortCut_apps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SetPattern extends AppCompatActivity {
    private static StringBuilder pattern = new StringBuilder();
    Button btn1, btn2, btn3, btn4, btn_ok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        pattern.setLength(0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_pattern);

        btn1 = (Button) findViewById(R.id.setPattern_btn_btn1);
        btn2 = (Button) findViewById(R.id.setPattern_btn_btn2);
        btn3 = (Button) findViewById(R.id.setPattern_btn_btn3);
        btn4 = (Button) findViewById(R.id.setPattern_btn_btn4);
        btn_ok = (Button) findViewById(R.id.setPattern_btn_ok);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pattern.append('1');
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pattern.append('2');
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pattern.append('3');
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pattern.append('4');
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<shortCut_apps.size(); i++){
                    if(shortCut_apps.get(i).getPattern().equals(pattern.toString()) ){
                        Toast.makeText(getApplicationContext(), "등록되어 있는 패턴입니다.", Toast.LENGTH_SHORT).show();
                        pattern.setLength(0);
                        return;
                    }
                }
                Intent preIntent = getIntent();
                Intent intent = new Intent(getApplicationContext(), RegPattern.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("appName",preIntent.getStringExtra("appName"));
                intent.putExtra("appPackageName",preIntent.getStringExtra("appPackageName"));
                intent.putExtra("firstPattern", pattern.toString());

                startActivity(intent);
            }
        });








    }
}
