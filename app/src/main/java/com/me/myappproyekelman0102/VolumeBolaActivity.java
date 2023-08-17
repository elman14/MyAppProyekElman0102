package com.me.myappproyekelman0102;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VolumeBolaActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtJari;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_bola);

        edtJari= findViewById(R.id.edt_jari);
        btnCalculate = findViewById(R.id.btnHitung);
        tvResult = findViewById(R.id.tvHasil);
        btnCalculate.setOnClickListener(this);
        ActionBar menu= getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnHitung) {
            String inputJari= edtJari.getText().toString().trim();
            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;
            if (TextUtils.isEmpty(inputJari)) {
                isEmptyFields = true;
                edtJari.setError("Field ini tidak boleh kosong");
            }

            Double jari = toDouble(inputJari);

            if (jari == null) {
                isInvalidDouble = true;
                edtJari.setError("Field ini harus berupa nomer yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                double volume = 1.33 * 3.14  * jari * jari * jari;
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