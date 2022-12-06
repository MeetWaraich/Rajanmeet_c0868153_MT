package com.example.rajanmeet_c0868153_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText dailyRent;
    private EditText day_no;
    private SeekBar noOfDays;
    private CheckBox gps;
    private CheckBox childSeat;
    private CheckBox unlimitedMilage;
    private RadioGroup ageDriver;
    private Button btnDetails;
    private EditText cost;
    private EditText ttlAmount;
    private String ageGroup;


    public void setNoOfDays(SeekBar noOfDays) {
        this.noOfDays = noOfDays;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        day_no = findViewById(R.id.day);
        ageDriver = findViewById(R.id.age);
        cost = findViewById(R.id.amt);
        ttlAmount = findViewById(R.id.totalAmount);
        gps = findViewById(R.id.gps);
        childSeat = findViewById(R.id.childSeat);
        unlimitedMilage = findViewById(R.id.unlimitedMilage);



        if(gps.isChecked()){
            cost.setText((Integer.parseInt(String.valueOf(cost)) +5));
        }
        if (childSeat.isChecked()){
            cost.setText((Integer.parseInt(String.valueOf(cost)) +7));
        }
        if (unlimitedMilage.isChecked()){
            cost.setText((Integer.parseInt(String.valueOf(cost)) +15));
        }
        ageDriver.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.age_20:
                    ageGroup = "Less than 20";
                    cost.setText((Integer.parseInt(String.valueOf(cost)) +5));
                    break;
                case R.id.ageBtw21_60:
                    ageGroup = "Between 21 and 50";
                    break;
                case R.id.above60:
                    ageGroup = "above 60";
                    cost.setText((Integer.parseInt(String.valueOf(cost)) +10));
                    break;
                default:
                    System.out.println(checkedId);
            }
        });

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

        btnDetails.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("Car Model", spinner.getSelectedItem().toString());
            intent.putExtra("Rented Days" , noOfDays.getProgress());
            intent.putExtra("Age Group", ageGroup);
            intent.putExtra("Cost", String.valueOf(cost));
            ttlAmount.setText(Integer.parseInt(String.valueOf(cost)) * Integer.parseInt(String.valueOf(noOfDays)));
            intent.putExtra("Total Amount", String.valueOf(ttlAmount));
            startActivity(intent);
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


