package com.example.rajanmeet_c0868153_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         EditText carModel, rentedDays, ageGroup, cost, ttlAmount;

        System.out.println("quantity" + String.valueOf(getIntent().getIntExtra("quantity", 0)).toString());
        System.out.println("tipPercent" + getIntent().getIntExtra("tip", 0));
        System.out.println("name" + getIntent().getStringExtra("name"));
    }
}