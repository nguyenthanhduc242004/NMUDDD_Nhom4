package com.example.quizletproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final int MAIN_HORIZONTAL_PADDING = 40;
    String currentTab = "module";

    ProgressBar progressBarHome;
    TextView textViewModuleFilter;
    EditText editTextModuleFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressBarHome = findViewById(R.id.progressBarHome);
        textViewModuleFilter = findViewById(R.id.textViewModuleFilter);
        editTextModuleFilter = findViewById(R.id.editTextModuleFilter);

// Edittext Module Filter:
        EditText editTextModuleFilter = findViewById(R.id.editTextModuleFilter);
        editTextModuleFilter.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    TextView textViewModuleFilter = findViewById(R.id.textViewModuleFilter);
                    textViewModuleFilter.setVisibility(View.VISIBLE);
                    editTextModuleFilter.setText("");
                }
            }
        });

        List<Flashcard> flashcards = new ArrayList<>();
        flashcards.add(new Flashcard("Term 1", "Definition 1"));
        flashcards.add(new Flashcard("Term 2", "Definition 2"));
        flashcards.add(new Flashcard("Term 3", "Definition 3"));

        Module module1 = new Module("Module 1", flashcards);
        Module module2 = new Module("Module 2", flashcards);
        Module module3 = new Module("Module 3", flashcards);
        Module module4 = new Module("Module 3", flashcards);
        Module module5 = new Module("Module 3", flashcards);
        Module module6 = new Module("Module 3", flashcards);
        Module module7 = new Module("Module 3", flashcards);
        Module module8 = new Module("Module 3", flashcards);
        Module module9 = new Module("Module 3", flashcards);
        Module module10 = new Module("Module 3", flashcards);
        Module module11 = new Module("Module 3", flashcards);

        ModuleAdapter moduleAdapter = new ModuleAdapter(this, List.of(module1, module2, module3, module4, module5, module6, module7, module8, module9, module10, module11));
        ListView listViewHome = findViewById(R.id.listViewHome);
        listViewHome.setAdapter(moduleAdapter);

        Folder folder1 = new Folder("folder1", List.of(module1, module2, module3, module4));
        Folder folder2 = new Folder("folder2", List.of(module1, module2, module3, module4, module5, module6, module7));
        Folder folder3 = new Folder("folder2", List.of(module1, module2, module3, module4, module5, module6, module7));
        Folder folder4 = new Folder("folder2", List.of(module1, module2, module3, module4, module5, module6, module7));
        Folder folder5 = new Folder("folder2", List.of(module1, module2, module3, module4, module5, module6, module7));
        Folder folder6 = new Folder("folder2", List.of(module1, module2, module3, module4, module5, module6, module7));
        Folder folder7 = new Folder("folder2", List.of(module1, module2, module3, module4, module5, module6, module7));
        Folder folder8 = new Folder("folder2", List.of(module1, module2, module3, module4, module5, module6, module7));
        Folder folder9 = new Folder("folder2", List.of(module1, module2, module3, module4, module5, module6, module7));

        FolderAdapter folderAdapter = new FolderAdapter(this, List.of(folder1, folder2, folder3, folder4, folder5, folder6, folder7, folder8, folder9));

// Button Add Module:
        Button buttonAddModule = findViewById(R.id.buttonAddModule);
        buttonAddModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

// Button Folder:
        Button buttonFolder = findViewById(R.id.buttonFolder);
        buttonFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentTab.equals("module")) {
                    listViewHome.setAdapter(folderAdapter);
                    progressBarHome.setRotation(180);
                    textViewModuleFilter.setVisibility(View.GONE);
                    editTextModuleFilter.setVisibility(View.GONE);
                    currentTab = "folder";
                }
            }
        });

// Button Module:
        Button buttonModule = findViewById(R.id.buttonModule);
        buttonModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentTab.equals("folder")) {
                    listViewHome.setAdapter(moduleAdapter);
                    progressBarHome.setRotation(0);
                    textViewModuleFilter.setVisibility(View.INVISIBLE);
                    editTextModuleFilter.setVisibility(View.VISIBLE);
                    editTextModuleFilter.setText("Bộ lọc");
                    currentTab = "module";
                }
            }
        });

// Button Footer Setting:
        Button buttonSetting = findViewById(R.id.buttonSetting);
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}