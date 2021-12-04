package com.example.shortcut2;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.shortcut2.MainActivity.shortCut_apps;

public class SelectApp extends AppCompatActivity {

    ArrayList<AppListItem> apps = new ArrayList<AppListItem>();
    AppListItem app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_app);


        // 설치된 어플리케이션 리스트 취득
        PackageManager pm = getPackageManager();
        PackageManager mPackageManager = getPackageManager();

        List<ApplicationInfo> list = mPackageManager.getInstalledApplications(0);

        for (ApplicationInfo applicationInfo : list) {
            Drawable appIcon = applicationInfo.loadIcon(pm); // 앱 아이콘
            String appName = String.valueOf(applicationInfo.loadLabel(mPackageManager));    // 앱 이름
            String appPackageName = applicationInfo.packageName;   // 앱 패키지

            app = new AppListItem(appIcon, appName, appPackageName);
            apps.add(app);

        }

        ListView appList = (ListView) findViewById(R.id.listview);
        final AppListAdapter_SelectApp myAdapter = new AppListAdapter_SelectApp(this,apps);
        appList.setAdapter(myAdapter);

        appList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                for(int i = 0; i<shortCut_apps.size(); i++){
                    if(shortCut_apps.get(i).getAppName().equals(myAdapter.getItem(position).getAppName()) ){
                        Toast.makeText(getApplicationContext(), "등록되어 있는 어플입니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }


                Intent intent = new Intent(getApplicationContext(), SetPattern.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("appName", myAdapter.getItem(position).getAppName());
                intent.putExtra("appPackageName", myAdapter.getItem(position).getAppPackageName());

                startActivity(intent);
            }
        });

    }

    // 사용자 설치 앱 여부
    boolean isUserApp(ApplicationInfo applicationInfo) {
        int mask = ApplicationInfo.FLAG_SYSTEM | ApplicationInfo.FLAG_UPDATED_SYSTEM_APP;
        return (applicationInfo.flags & mask) == 0;
    }



}
