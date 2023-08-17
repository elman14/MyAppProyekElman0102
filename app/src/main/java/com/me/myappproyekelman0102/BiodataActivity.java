package com.me.myappproyekelman0102;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class BiodataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);


        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);

    }
        @Override
        public void onBackPressed() {
            super.onBackPressed();
        }

        @Override
        public boolean onSupportNavigateUp() {
            onBackPressed();
            return true;
        }
    }