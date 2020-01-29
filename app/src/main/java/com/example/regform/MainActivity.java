package com.example.regform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Details";
    Button submit,reset;
    EditText name,address,age,phone;
    DatePicker dob;
    String gender,addiction,birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        address=findViewById(R.id.address);
        dob=findViewById(R.id.dob);
        birth=dob.getDayOfMonth()+"-"+dob.getMonth()+"-"+dob.getYear();
        phone=findViewById(R.id.phone);
        Spinner spinner =  findViewById(R.id.marital);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Marital, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

    public void onRadioButtonClicked(View view){
        boolean checked=((RadioButton)view).isChecked();
        switch(view.getId())
        {
            case R.id.male:
                if(checked) gender="male";
                break;
            case R.id.female:
                if(checked) gender="female";
                break;

        }
    }
    public void onCheckBoxClicked(View view)
    {
        boolean checked=((CheckBox)view).isChecked();
        switch(view.getId())
        {
            case R.id.alco:
                if(checked)
                    addiction="alcohol";
                    break;
            case R.id.smoke:
                if(checked)
                    addiction="smoking";
                    break;
        }
    }
    public void onSubmitClicked(View view)
    {
        String n=name.getText().toString();
        String a=age.getText().toString();
        String addr=address.getText().toString();
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);

    }
}
