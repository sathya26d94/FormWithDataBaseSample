package com.example.sathya.formdemo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Calendar;

public class FormDetails extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button submitButton;
    TextView dob;
    EditText name;
    RadioGroup gender;
    CheckBox cricket, football;
    RatingBar ratingBar;
    private String genderType = "male";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formdetails);

        submitButton = findViewById(R.id.submit_button);
        name = findViewById(R.id.name_edit_text);
        dob = findViewById(R.id.dob_text_view);
        gender = findViewById(R.id.gender_Radio);
        cricket = findViewById(R.id.cri_checkbox);
        football = findViewById(R.id.foo_checkbox);
        ratingBar = findViewById(R.id.rating_bar);

        gender.check(R.id.male);
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.male:
                        genderType = "male";
                        break;
                    case R.id.female:
                        genderType = "female";
                        break;
                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAndSetValuesFromUser();
            }
        });

        final DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, FormDetails.this, 1990 , 1, 1);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });



    }

    void getAndSetValuesFromUser(){
        int formDBSize = Util.getDBSize();
        if (formDBSize > 0) {
            FormData formData1 = Util.getFormEntry(0);
            formData1.delete();
        }


        FormData formData = new FormData();
        formData.name = name.getText().toString();
        formData.dob = dob.getText().toString();
        formData.gender = genderType;

        if (football.isChecked()) {
            formData.interest.add("FootBall");
        }

        if (cricket.isChecked()) {
            formData.interest.add("Cricket");
        }

        formData.rating = ratingBar.getRating();

        formData.save();

        setResult(Activity.RESULT_OK);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        setResult(Activity.RESULT_CANCELED);

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        dob.setText(i +"/" + i1 +"/" + i2);
    }
}

