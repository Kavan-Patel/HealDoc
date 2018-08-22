package com.example.kavanpatel.healdoc;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class Booking extends AppCompatActivity {

    DatePickerDialog datePickerDialog;
    ImageView imgDataPickerdob,imgTimepicker;
    Calendar calendar;
    TextView textView,textViewDD,textViewMM,textViewYYYY;
    Button btnBackhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        btnBackhome=findViewById(R.id.btnBackhome);
        imgDataPickerdob=findViewById(R.id.imgPicker);
        imgTimepicker=findViewById(R.id.imgTimePicker);
        textView=findViewById(R.id.textView);
        textViewDD=findViewById(R.id.textViewDD);
        textViewMM=findViewById(R.id.textViewMM);
        textViewYYYY=findViewById(R.id.textViewYYYY);

        imgDataPickerdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar= Calendar.getInstance();
                int day=calendar.get(Calendar.DAY_OF_MONTH);
                int month=calendar.get(Calendar.MONTH);
                int year=calendar.get(Calendar.YEAR);

                datePickerDialog=new DatePickerDialog(Booking.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String y= "2018";
                        String m= Integer.toString(month+1);
                        String d= Integer.toString(day);
                     //   String s=getText(d).toString()+getText(m).toString()+getText(y).toString();
                        textView.setText("Your appointment booking is done on");
                        textViewDD.setText(d);
                        textViewMM.setText(m);
                        textViewYYYY.setText(y);
                    }
                },day,month,year);
                datePickerDialog.show();
            }
        });
        btnBackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
