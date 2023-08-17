package com.me.myappproyekelman0102;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnBiodata = findViewById(R.id.btn_biodata);
        btnBiodata.setOnClickListener(this);

        Button btnVolumeBalok = findViewById(R.id.btn_volume_balok);
        btnVolumeBalok.setOnClickListener(this);

        Button btnVolumeBola = findViewById(R.id.btn_volume_bola);
        btnVolumeBola.setOnClickListener(this);

        Button btnCalculator = findViewById(R.id.btn_calculator);
        btnCalculator.setOnClickListener(this);

        Button btnVolumeTabung = findViewById(R.id.btn_vTabung);
        btnVolumeTabung.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_biodata:
                Intent biodata = new Intent(MenuActivity.this, BiodataActivity.class);
                startActivity(biodata);
                break;
            case R.id.btn_volume_balok:
                Intent volumeBalok = new Intent(MenuActivity.this, VolumeBalokActivity.class);
                startActivity(volumeBalok);
                break;
            case R.id.btn_volume_bola:
                Intent volumeBola = new Intent(MenuActivity.this, VolumeBolaActivity.class);
                startActivity(volumeBola);
                break;
            case R.id.btn_calculator:
                Intent calculator = new Intent(MenuActivity.this, CalculatorActivity.class);
                startActivity(calculator);
                break;
            case R.id.btn_vTabung:
                Intent volumeTabung = new Intent(MenuActivity.this, VolumeTabungActivity.class);
                startActivity(volumeTabung);
                break;



        }
    }
}