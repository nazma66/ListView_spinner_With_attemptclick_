package com.example.listviewwithattemptclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] taskname = {"take a walk", "get more water", "make a personal call", "make an appointment", "take a walk", "get more water", "make a personal call", "make an appointment"};
    ListView lv1;
    Spinner spinner;
    EditText et_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


spinner = findViewById(R.id.spinner);

        et_1 = findViewById(R.id.et_1);

        lv1 = findViewById(R.id.lv1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, taskname);
        lv1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, taskname);
        spinner.setAdapter(adapter2);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedText = taskname[position];
                et_1.setText(selectedText);
                Toast.makeText(MainActivity.this, getString(R.string.selecteditem) + " " + selectedText, Toast.LENGTH_SHORT).show();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedText = taskname[position];
                et_1.setText(selectedText);
                Toast.makeText(MainActivity.this, getString(R.string.selecteditem) + " " + selectedText, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case where nothing is selected in the Spinner
            }
        });
    }
}