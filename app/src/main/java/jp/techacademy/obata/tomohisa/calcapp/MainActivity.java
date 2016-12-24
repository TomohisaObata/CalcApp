package jp.techacademy.obata.tomohisa.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText1 = (EditText)findViewById(R.id.editText1);
        this.editText2 = (EditText)findViewById(R.id.editText2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        BigDecimal bdValue1;
        BigDecimal bdValue2;
        String txResult = "Error";

        if(!editText1.getText().toString().isEmpty() & !editText2.getText().toString().isEmpty()){
            bdValue1 = new BigDecimal(editText1.getText().toString());
            bdValue2 = new BigDecimal(editText2.getText().toString());

            if(v.getId() == R.id.button1){
                txResult = String.valueOf(bdValue1.add(bdValue2));
            } else if(v.getId() == R.id.button2){
                txResult = String.valueOf(bdValue1.subtract(bdValue2));
            } else if(v.getId() == R.id.button3) {
                txResult = String.valueOf(bdValue1.multiply(bdValue2));
            } else {
                if(!bdValue2.toString().equals("0")){
                    txResult = String.valueOf(bdValue1.divide(bdValue2, 6, BigDecimal.ROUND_HALF_UP));
                }
            }
        }

        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("result",txResult);
        startActivity(intent);

    }
}
