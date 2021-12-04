package com.example.shortcut2;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegPattern extends AppCompatActivity {
    private static StringBuilder pattern = new StringBuilder();
    Button btn1, btn2, btn3, btn4, btn_reg;

    MyDBHelper dbHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        pattern.setLength(0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_pattern);

        btn1 = (Button) findViewById(R.id.regPattern_btn_btn1);
        btn2 = (Button) findViewById(R.id.regPattern_btn_btn2);
        btn3 = (Button) findViewById(R.id.regPattern_btn_btn3);
        btn4 = (Button) findViewById(R.id.regPattern_btn_btn4);
        btn_reg = (Button) findViewById(R.id.regPattern_btn_reg);

        dbHelper = new MyDBHelper(getApplicationContext(), 1);

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

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent preIntent = getIntent();

                if (preIntent.getStringExtra("firstPattern").equals(pattern.toString())) { //                setpattern에서 가져온 패턴이랑 같으면

                    Toast.makeText(getApplicationContext(), "등록이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                    //db에 저장
                    dbHelper.insert(preIntent.getStringExtra("appName"), preIntent.getStringExtra("appPackageName"), pattern.toString());
                    Toast.makeText(getApplicationContext(), "DB등록완료", Toast.LENGTH_SHORT).show();
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else { //                같지않으면
                    Toast.makeText(getApplicationContext(), "패턴이 일치하지 않습니다..", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SelectApp.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
            }
        });


    }
}
