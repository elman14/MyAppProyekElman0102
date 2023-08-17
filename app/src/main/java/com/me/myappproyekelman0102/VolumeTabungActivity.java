package com.me.myappproyekelman0102;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VolumeTabungActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtJari, edtTinggi;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_tabung);

        edtJari= findViewById(R.id.edtJari);
        edtTinggi= findViewById(R.id.edtTinggi);
        btnCalculate = findViewById(R.id.btn_calculateTbg);
        tvResult = findViewById(R.id.tv_resultbg);
        btnCalculate.setOnClickListener(this);
        ActionBar menu= getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculateTbg) {
            String inputJari= edtJari.getText().toString().trim();
            String inputTinggi= edtTinggi.getText().toString().trim();
            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;
            if (TextUtils.isEmpty(inputJari)) {
                isEmptyFields = true;
                edtJari.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputTinggi)) {
                isEmptyFields = true;
                edtJari.setError("Field ini tidak boleh kosong");
            }


            Double jari = toDouble(inputJari);
            Double tinggi = toDouble(inputTinggi);

            if (jari == null) {
                isInvalidDouble = true;
                edtJari.setError("Field ini harus berupa nomer yang valid");
            }
            if (tinggi == null) {
                isInvalidDouble = true;
                edtTinggi.setError("Field ini harus berupa nomer yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                double volume =  3.14  * jari * jari * tinggi;
                tvResult.setText(String.valueOf(volume));

            }
        }
    }
    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
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