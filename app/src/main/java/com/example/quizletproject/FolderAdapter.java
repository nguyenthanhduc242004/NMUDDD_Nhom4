package com.example.quizletproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class FolderAdapter extends BaseAdapter {
    Context context;
    List<Folder> folders;
    LayoutInflater inflater;

    public FolderAdapter(Context context, List<Folder> folders) {
        this.context = context;
        this.folders = folders;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return folders.size();
    }

    @Override
    public Folder getItem(int i) {
        return folders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_folder, null);
        TextView tvFolderName = view.findViewById(R.id.textViewFolderName);
        TextView tvNumberOfModules = view.findViewById(R.id.textViewNumberOfModules);
        TextView tvUserCreated = view.findViewById(R.id.textViewUserCreated);
//
        tvFolderName.setText(folders.get(i).getName());
        tvNumberOfModules.setText(folders.get(i).getModules().size() + " học phần");
        tvUserCreated.setText("USERNAME");
        return view;
    }
}
