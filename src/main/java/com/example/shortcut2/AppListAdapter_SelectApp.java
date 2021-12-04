package com.example.shortcut2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AppListAdapter_SelectApp extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<AppListItem> app;

    public AppListAdapter_SelectApp(Context context, ArrayList<AppListItem> data) {
        mContext = context;
        app = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return app.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public AppListItem getItem(int position) {
        return app.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.app_list_item, null);

        ImageView appIcon = (ImageView)view.findViewById(R.id.appIcon);
        TextView appName = (TextView)view.findViewById(R.id.appName);
        TextView appPackageName = (TextView)view.findViewById(R.id.appPackageName);

        appIcon.setImageDrawable(app.get(position).getAppIcon());
        appName.setText(app.get(position).getAppName());
        appPackageName.setText(app.get(position).getAppPackageName());


        return view;
    }
}