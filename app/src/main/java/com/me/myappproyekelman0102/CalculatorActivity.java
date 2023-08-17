package com.me.myappproyekelman0102;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class CalculatorActivity extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnBagi,btnKali,btnTambah,
            btnpersen,btnHasil,btnhapus,btnBackSpace,btnkoma,btnKurang;
    TextView angkaMasuk, angkaKeluar;
    String proses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        btn0= findViewById(R.id.btn0);
        btn1= findViewById(R.id.btn1);
        btn2= findViewById(R.id.btn2);
        btn3= findViewById(R.id.btn3);
        btn4= findViewById(R.id.btn4);
        btn5= findViewById(R.id.btn5);
        btn6= findViewById(R.id.btn6);
        btn7= findViewById(R.id.btn7);
        btn8= findViewById(R.id.btn8);
        btn9= findViewById(R.id.btn9);

        btnTambah= findViewById(R.id.btnTambah);
        btnKurang= findViewById(R.id.btnKurang);
        btnKali= findViewById(R.id.btnKali);
        btnBagi= findViewById(R.id.btnBagi);
        btnHasil= findViewById(R.id.btnHasil);
        btnkoma= findViewById(R.id.btnKoma);
        btnpersen= findViewById(R.id.btnPersen);
        btnhapus= findViewById(R.id.btnHapus);
        btnBackSpace= findViewById(R.id.btnBackSpace);

        angkaKeluar= findViewById(R.id.angkaKeluar);
        angkaMasuk= findViewById(R.id.angkaMasuk);

        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angkaMasuk.setText("");
                angkaKeluar.setText("");
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"+");
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"-");
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"÷");
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"×");
            }
        });

        btnkoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+".");

            }
        });

        btnpersen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"%");

            }
        });

        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angkaKeluar.setText("");
                String word = angkaMasuk.getText().toString();
                int input = word.length();
                if(input > 0){
                    angkaMasuk.setText(word.substring(0,input-1));
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                angkaMasuk.setText(proses+"9");
            }
        });

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proses = angkaMasuk.getText().toString();
                proses = proses.replaceAll("÷", "/");
                proses = proses.replaceAll("%", "/100");
                proses = proses.replaceAll("×", "*");
                proses = proses.replaceAll("-", "-");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult= "";
                try{
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,proses,"javascript", 2 , null).toString();

                }catch (Exception e){
                    finalResult="0";
                }
                angkaKeluar.setText(finalResult);
            }
        });
    }
}