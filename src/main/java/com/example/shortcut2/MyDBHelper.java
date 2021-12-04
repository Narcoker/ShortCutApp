package com.example.shortcut2;

import static com.example.shortcut2.MainActivity.shortCut_apps;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper{

    static final String DATABASE_NAME = "ShortCutApp.db";

    public MyDBHelper(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    } // Person Table 생성

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ShortCutAPP(appName TEXT, appPackage TEXT, pattern TEXT)");
    } // Person Table Upgrade

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ShortCutAPP");
        onCreate(db);
    } // Person Table 데이터 입력

    public void insert(String appName, String appPackage, String pattern) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO ShortCutAPP VALUES('" + appName + "', '" + appPackage + "', '" + pattern + "')");
        db.close();
    } // Person Table 데이터 수정

    public void Update(String appName, int appPackage, String pattern) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE ShortCutAPP SET appPackage = " + appPackage + ", pattern = '" + pattern + "'" + " WHERE APPNAME = '" + appName + "'");
        db.close();
    } // Person Table 데이터 삭제

    public void Delete(String appName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM ShortCutAPP WHERE APPNAME = "+ "'" + appName + "'");
        db.close();
    } // Person Table 조회

    public void readDB() {
        shortCut_apps.clear();
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ShortCutAPP", null);
        while (cursor.moveToNext()) {
            AppListItem app = new AppListItem(cursor.getString(0),cursor.getString(1),cursor.getString(2));
            shortCut_apps.add(app);

        }
    }

    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = ""; // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM ShortCutAPP", null);
        while (cursor.moveToNext()) {
            result += " 이름 : " + cursor.getString(0) + ", package : " + cursor.getString(1) + ", pattern : " + cursor.getString(2) + "\n";
        }
        return result;
    }

    public String getAppName(){
        SQLiteDatabase db = getReadableDatabase();
        String result = ""; // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM ShortCutAPP", null);
        while (cursor.moveToNext()) {
            result += " 이름 : " + cursor.getString(0) + "\n";
        }
        return result;
    }


}
