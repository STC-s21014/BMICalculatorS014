package com.example.bmicalculators014;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSend = findViewById(R.id.bt_cal);
        Listener listener = new Listener();
        btSend.setOnClickListener(listener);

        Button btConfirm = findViewById(R.id.bt_cle);
        btConfirm.setOnClickListener(listener);
    }

    private class Listener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText inAge = findViewById(R.id.et_age);
            EditText inHeight = findViewById(R.id.et_hei);
            EditText inWeight = findViewById(R.id.et_wei);

            TextView your_bmi = findViewById(R.id.tv_bmi);
            TextView your_kg = findViewById(R.id.tv_kg);
            TextView youbmi = findViewById(R.id.tv_youbmi);
            TextView youkg = findViewById(R.id.tv_youkg);
            TextView kg = findViewById(R.id.tv_ykg);



            int id = view.getId();

            switch (id) {
                case R.id.bt_cal:

                    if (inAge.getText().toString().equals("") == true || inHeight.getText().toString().equals("") == true || inWeight.getText().toString().equals("") == true) {
                        Toast.makeText(MainActivity.this, "値を入力してください。", Toast.LENGTH_LONG).show();
                        return;
                    }

                    int i_age = Integer.parseInt(inAge.getText().toString());
                    float f_cm = Float.parseFloat(inHeight.getText().toString());
                    float f_kg = Float.parseFloat(inWeight.getText().toString());

                    if (i_age >= 150) {
                        Toast.makeText(MainActivity.this, "年齢が大きすぎます。", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (f_cm >= 300) {
                        Toast.makeText(MainActivity.this, "身長が大きすぎます。", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (f_kg >= 200) {
                        Toast.makeText(MainActivity.this, "体重が重すぎます。", Toast.LENGTH_LONG).show();
                        return;
                    }

                    float f_m = f_cm / 100;

                    float f_bkg = 0;
                    float f_nkg = 0;

                    float f_bmi = f_kg / (f_m * f_m);

                    if (f_bmi < 18.5) {
                        your_bmi.setText(R.string.tx_lobmi);
                    } else if (f_bmi < 25) {
                        your_bmi.setText(R.string.tx_nombmi);
                    } else if (f_bmi < 30) {
                        your_bmi.setText(R.string.tx_bmi1);
                    } else if (f_bmi < 35) {
                        your_bmi.setText(R.string.tx_bmi2);
                    } else if (f_bmi < 40) {
                        your_bmi.setText(R.string.tx_bmi3);
                    } else {
                        your_bmi.setText(R.string.tx_bmi4);
                    }
                    f_nkg = 22 * f_m * f_m;

                    your_kg.setText(String.format("%.1f",f_nkg));

                    youbmi.setText(R.string.tx_bmi);
                    youkg.setText(R.string.tx_youkg);
                    kg.setText(R.string.tx_kg);

                   if (i_age < 16) {
                       new BMIlog().show(getSupportFragmentManager(),"BMIlog");
                   }
                    break;
                case R.id.bt_cle:
                    inAge.setText("");
                    inHeight.setText("");
                    inWeight.setText("");

                    your_bmi.setText("");
                    youbmi.setText("");
                    your_kg.setText("");
                    youkg.setText("");
                    kg.setText("");
                    break;
            }

        }
    }
}