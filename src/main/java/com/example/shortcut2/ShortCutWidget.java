package com.example.shortcut2;


import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;


public class ShortCutWidget extends AppWidgetProvider {
    private static final String MyOnClick1 = "myOnClickTag1";
    private static final String MyOnClick2 = "myOnClickTag2";
    private static final String MyOnClick3 = "myOnClickTag3";
    private static final String MyOnClick4 = "myOnClickTag4";
    private static final String MyOnClick_OK = "myOnClickTag_OK";


    private static StringBuilder pattern = new StringBuilder();

    private static long startTime = System.currentTimeMillis();
    private static long endTime = System.currentTimeMillis();
    private static long termTime;


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetsId : appWidgetIds) {
//             Intent intent = new Intent(context, MainActivity.class);
//             PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0); // 버튼 클릭시 mainActivity로 이동

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.short_cut_widget);
            views.setOnClickPendingIntent(R.id.widget_btn1, getPendingSelfIntent(context, MyOnClick1));
            views.setOnClickPendingIntent(R.id.widget_btn2, getPendingSelfIntent(context, MyOnClick2));
            views.setOnClickPendingIntent(R.id.widget_btn3, getPendingSelfIntent(context, MyOnClick3));
            views.setOnClickPendingIntent(R.id.widget_btn4, getPendingSelfIntent(context, MyOnClick4));
            views.setOnClickPendingIntent(R.id.widget_ok, getPendingSelfIntent(context, MyOnClick_OK));

            appWidgetManager.updateAppWidget(appWidgetsId, views);
        }
    }

    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (MyOnClick1.equals(intent.getAction())) {
            endTime = System.currentTimeMillis();
            termTime = (endTime - startTime) / 100;

            if (termTime > 15) {
                pattern.setLength(0); //  pattern 비우기
            }

            pattern.append('1');
//            Toast.makeText(context, pattern, Toast.LENGTH_SHORT).show(); // 패턴 생성

            startTime = System.currentTimeMillis();
        } else if (MyOnClick2.equals(intent.getAction())) {
            endTime = System.currentTimeMillis();
            termTime = (endTime - startTime) / 100;

            if (termTime > 15) {
                pattern.setLength(0); //  pattern 비우기
            }

            pattern.append('2');
//            Toast.makeText(context, pattern, Toast.LENGTH_SHORT).show();

            startTime = System.currentTimeMillis();
        } else if (MyOnClick3.equals(intent.getAction())) {
            endTime = System.currentTimeMillis();
            termTime = (endTime - startTime) / 100;

            if (termTime > 15) {
                pattern.setLength(0); //  pattern 비우기
            }

            pattern.append('3');
//            Toast.makeText(context, pattern, Toast.LENGTH_SHORT).show();

            startTime = System.currentTimeMillis();
        } else if (MyOnClick4.equals(intent.getAction())) {
            endTime = System.currentTimeMillis();
            termTime = (endTime - startTime) / 100;

            if (termTime > 15) {
                pattern.setLength(0); //  pattern 비우기
            }

            pattern.append('4');
//            Toast.makeText(context, pattern, Toast.LENGTH_SHORT).show();

            startTime = System.currentTimeMillis();
        }else if(MyOnClick_OK.equals(intent.getAction())){
            Intent start_intent = new Intent(context, startApp.class);
            start_intent.putExtra("pattern", pattern.toString());
            start_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(start_intent);


        }


    }
}
