package jp.techacademy.obata.tomohisa.calcapp;

import android.content.Intent;
import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String value = intent.getStringExtra("result");

        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText(String.valueOf(value));
    }
}
