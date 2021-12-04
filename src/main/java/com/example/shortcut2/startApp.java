package com.example.shortcut2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import static com.example.shortcut2.MainActivity.shortCut_apps;

public class startApp extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String pattern = intent.getStringExtra("pattern");
        int index;
        for (index = 0; index < shortCut_apps.size(); index++) {
            if (pattern.equals(shortCut_apps.get(index).getPattern())) {
                Toast.makeText(getApplicationContext(), shortCut_apps.get(index).getAppName() + "을 실행합니다.", Toast.LENGTH_SHORT).show();

                try{
                    Intent appintent = getPackageManager().getLaunchIntentForPackage(shortCut_apps.get(index).getAppPackageName());
                    appintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(appintent);
                    finish();
                    return;
                }
                catch (Exception e){

                    Toast.makeText(getApplicationContext(), "앱이 설치되어 있지 않습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                    return;

                }
            }
        }

        if(index == shortCut_apps.size()){
            Toast.makeText(getApplicationContext(), "패턴이 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            Intent homeIntent = new Intent(Intent.ACTION_MAIN); //태스크의 첫 액티비티로 시작
            homeIntent.addCategory(Intent.CATEGORY_HOME);   //홈화면 표시
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //새로운 태스크를 생성하여 그 태스크안에서 액티비티 추가
            startActivity(homeIntent);
        }

        finish();


    }
}
