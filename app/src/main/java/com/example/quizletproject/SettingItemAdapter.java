package com.example.quizletproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SettingItemAdapter extends BaseAdapter {
    Context context;
    List<SettingItem> settingItems;
    LayoutInflater inflater;

    public SettingItemAdapter(Context context, List<SettingItem> settingItems) {
        this.context = context;
        this.settingItems = settingItems;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return settingItems.size();
    }

    @Override
    public SettingItem getItem(int i) {
        return settingItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_setting_item, null);
        TextView textViewSettingItemName = view.findViewById(R.id.textViewSettingItemName);
        TextView textViewSettingItemDescription = view.findViewById(R.id.textViewSettingItemDescription);
        textViewSettingItemName.setText(settingItems.get(i).getName());
        String settingItemDescription = settingItems.get(i).getDescription();
        if (settingItemDescription == null) {
            textViewSettingItemDescription.setVisibility(View.GONE);
        }
        else {
            textViewSettingItemDescription.setText(settingItemDescription);
        }
        return view;
    }
}
