package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SetMoneyUsedActivity extends AppCompatActivity {
    private DatePickerDialog.OnDateSetListener moneyDateSetListener;
    private EditText moneyDate ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_money_used);
        moneyDate = findViewById(R.id.setmoneydate);


        moneyDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        SetMoneyUsedActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        moneyDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        moneyDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //String formatedDate = sdf.format(calendar.getTime());
                String date = month + "/" + day + "/" + year;
                moneyDate.setText(date);
            }
        };
    }
}