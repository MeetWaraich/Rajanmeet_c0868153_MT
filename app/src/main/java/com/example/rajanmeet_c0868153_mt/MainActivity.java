package com.example.rajanmeet_c0868153_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText dailyRent;
    private EditText day_no;
    private SeekBar noOfDays;
    private TextView T;

    public void setNoOfDays(SeekBar noOfDays) {
        this.noOfDays = noOfDays;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        day_no = findViewById(R.id.day);

        Spinner spinner = (Spinner) findViewById(R.id.cars_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cars_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        //Seekbar//
        SeekBar noOfDays = (SeekBar) findViewById(R.id.days);
        noOfDays.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    day_no.setText(progress);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                setNoOfDays(seekBar);
            }
        });


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        switch (item) {
            case "Mercedes":
                dailyRent.setText(String.valueOf(200));
                break;
            case "Mustang":
                dailyRent.setText(String.valueOf(250));
                break;
            case "Audi":
                dailyRent.setText(String.valueOf(110));
                break;
            case "BMW":
                dailyRent.setText(String.valueOf(100));
                break;
            case "Cadillac":
                dailyRent.setText(String.valueOf(120));
                break;
            case "Mini Cooper":
                dailyRent.setText(String.valueOf(150));
                break;
            case "G Wagon":
                dailyRent.setText(String.valueOf(400));
                break;
            case "Range Rover":
                dailyRent.setText(String.valueOf(130));
                break;
            case "Tata Nano":
                dailyRent.setText(String.valueOf(104));
                break;
            case "Tesla":
                dailyRent.setText(String.valueOf(140));
                break;

        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Please Select a Car to Rent", Toast.LENGTH_SHORT).show();

    }
}


