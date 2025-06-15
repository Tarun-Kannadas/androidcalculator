package com.example.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;

    ImageButton add,subtract,multiply,divide;

    TextView result,clear_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.into);
        divide = findViewById(R.id.divide);
        result = findViewById(R.id.result);
        clear_text = findViewById(R.id.clear);
        clear_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText("");
                num2.setText("");
                result.setText("");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no1 = Integer.parseInt(num1.getText().toString());
                int no2 = Integer.parseInt(num2.getText().toString());
                int res = add(no1,no2);
                result.setText(String.valueOf(res));
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no1 = Integer.parseInt(num1.getText().toString());
                int no2 = Integer.parseInt(num2.getText().toString());
                int res = sub(no1,no2);
                result.setText(String.valueOf(res));
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no1 = Integer.parseInt(num1.getText().toString());
                int no2 = Integer.parseInt(num2.getText().toString());

                if (no2 == 0) {
                    Toast.makeText(getApplicationContext(), "Can't Divide by Zero", Toast.LENGTH_SHORT).show();
                    result.setText("Undefined");
                } else {
                    float res = (float) no1 / no2; // force float division
                    result.setText(String.format("%.2f", res)); // round to 2 decimal places
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no1 = Integer.parseInt(num1.getText().toString());
                int no2 = Integer.parseInt(num2.getText().toString());
                int res = mul(no1,no2);
                result.setText(String.valueOf(res));
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private int add(int no1, int no2){
        return no1+no2;
    }

    private int sub(int no1, int no2){
        return no1-no2;
    }

//    private int div(int no1, int no2){
//        if (no2 == 0)
//        {
//            Toast.makeText(getApplicationContext(),"Can't Divide by Zero", Toast.LENGTH_SHORT).show(); //to avoid division by zero
//            return 0;
//        }
//        return no1/no2;
//    }

    private int mul(int no1, int no2){
        return no1*no2;
    }
}