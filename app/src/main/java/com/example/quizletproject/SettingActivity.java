package com.example.quizletproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<SettingItem> personalInformationSettingItems = List.of(
                new SettingItem("Tên người dùng", "USERNAME"),
                new SettingItem("Đổi mật khẩu")
        );

        List<SettingItem> oflineLearningSettingItems = List.of(
                new SettingItem("Tự động tải học phần")
        );

        List<SettingItem> optionSettingItems = List.of(
                new SettingItem("Hiện thông báo"),
                new SettingItem("Hiệu ứng âm thanh")
        );

        List<SettingItem> interfaceSettingItems = List.of(
                new SettingItem("Hình nền", "CurrentBackgroundColor")
        );

        SettingItemAdapter personalInformationSettingItemAdapter = new SettingItemAdapter(this, personalInformationSettingItems);
        SettingItemAdapter offlineLearningSettingItemAdapter = new SettingItemAdapter(this, oflineLearningSettingItems);
        SettingItemAdapter optionSettingItemAdapter = new SettingItemAdapter(this, optionSettingItems);
        SettingItemAdapter interfaceSettingItemAdapter = new SettingItemAdapter(this, interfaceSettingItems);

        ListView listViewPersonalInformation = findViewById(R.id.listViewPersonalInformation);
        ListView listViewOfflineLearning = findViewById(R.id.listViewOfflineLearning);
        ListView listViewOption = findViewById(R.id.listViewOption);
        ListView listViewInterface = findViewById(R.id.listViewInterface);

        listViewPersonalInformation.setAdapter(personalInformationSettingItemAdapter);
        listViewOfflineLearning.setAdapter(offlineLearningSettingItemAdapter);
        listViewOption.setAdapter(optionSettingItemAdapter);
        listViewInterface.setAdapter(interfaceSettingItemAdapter);
    }
}