package com.example.quizletproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

public class ModuleAdapter extends BaseAdapter {
    Context context;
    List<Module> modules;
    LayoutInflater inflater;

    public ModuleAdapter(Context context, List<Module> modules) {
        this.context = context;
        this.modules = modules;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return modules.size();
    }

    @Override
    public Module getItem(int i) {
        return modules.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_module, null);
        TextView tvModuleName = view.findViewById(R.id.textViewModuleName);
        TextView tvNumberOfFlashcards = view.findViewById(R.id.textViewNumberOfFlashcards);
        TextView tvUserCreated = view.findViewById(R.id.textViewUserCreated);
        TextView tvCreatedTime = view.findViewById(R.id.textViewCreatedTime);

        tvModuleName.setText(modules.get(i).getName());
        tvNumberOfFlashcards.setText(modules.get(i).getFlashcards().size() + " thuật ngữ");
        tvUserCreated.setText("USERNAME");
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd-MM-yy HH:mm");
        String createdTimeString = formatter.format(modules.get(i).getCreatedTime());
        tvCreatedTime.setText(createdTimeString);
        return view;
    }
}
