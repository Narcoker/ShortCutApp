package com.example.shortcut2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

class AppListAdapter_ShorCutApp extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<AppListItem> app;

    public AppListAdapter_ShorCutApp(Context context, ArrayList<AppListItem> data) {
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
        View view = mLayoutInflater.inflate(R.layout.short_cut_app_list_item, null);

        TextView appName = (TextView)view.findViewById(R.id.appName);
        TextView pattern = (TextView)view.findViewById(R.id.pattern);

        appName.setText(app.get(position).getAppName());
        pattern.setText("Pattern: " + app.get(position).getPattern());

        return view;
    }
}