package com.example.kavanpatel.healdoc;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_up extends Activity {


    EditText firstname,lastname,phoneno,email,password,confirmpassword,DD,MM,YYYY;
    RadioButton male,female;
    Button signup;
    RadioGroup radioGroup;
    RadioButton radioButton;
    ImageButton imgDataPickerdob;
    Calendar calendar;
    DatePickerDialog datePickerDialog;
    Pattern pattern;
    Matcher matcher;
    final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
    Boolean validatePhoneno=false;
    Boolean validateEmail=false;
    Boolean validatePassword=false;
    Boolean validateConfirmpassword=false;
    Boolean validateBothpassword=false;
    /*private static final String REGISTERED_URL = "https://healdoc.000webhostapp.com/signup.php";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_up);

        //Bind all the stuff
        firstname=findViewById(R.id.edt_signup_firstname);
        firstname.setSelected(false);
        lastname=findViewById(R.id.edt_signup_lastname);
        phoneno=findViewById(R.id.edt_signup_phoneno);
        email=findViewById(R.id.edt_signup_email);
        password=findViewById(R.id.edt_signup_password);
        confirmpassword=findViewById(R.id.edt_signup_confirmpassword);
        male=findViewById(R.id.rb_signup_male);
        female=findViewById(R.id.rb_signup_female);
        radioGroup=findViewById(R.id.rg_male_female);
        signup=findViewById(R.id.btn_signup_submit);
        imgDataPickerdob=findViewById(R.id.imgDatePickerdob);
        DD=findViewById(R.id.edtDD);
        MM=findViewById(R.id.edtMM);
        YYYY=findViewById(R.id.edtYYYY);

        //All the validation perfom here
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if(!email.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+"))
                {
                    email.setError("Enter Valid Email Address");
                }
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                pattern = Pattern.compile(PASSWORD_PATTERN);
                matcher = pattern.matcher(password.getText().toString());

                if(!matcher.matches())
                {
                    password.setError("Password should have length 8 or more\nPassword must contain capital latter,number,special charactor(@,$,&...)");
                }
            }
        });

        confirmpassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                pattern = Pattern.compile(PASSWORD_PATTERN);
                matcher = pattern.matcher(confirmpassword.getText().toString());

                if(!matcher.matches())
                {
                    confirmpassword.setError("Password should have length 8 or more\nPassword must contain capital latter,number,special charactor(@,$,&...)");
                }
            }
        });

        phoneno.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(phoneno.getText().toString().length()!=10)
                {
                    phoneno.setError("Enter valid phoneno");
                }
            }
        });

        firstname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(firstname.getText().toString().length()==0)
                {
                    firstname.setError("Plese fill empty field");
                }
            }
        });

        lastname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(lastname.getText().toString().length()==0)
                {
                    lastname.setError("plese fill empty field");
                }
            }
        });



        imgDataPickerdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar=Calendar.getInstance();
                int day=calendar.get(Calendar.DAY_OF_MONTH);
                int month=calendar.get(Calendar.MONTH);
                int year=calendar.get(Calendar.YEAR);

                datePickerDialog=new DatePickerDialog(Sign_up.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String y= Integer.toString(year);
                        String m= Integer.toString(month+1);
                        String d= Integer.toString(day);
                        DD.setText(d);
                        MM.setText(m);
                        YYYY.setText(y);
                    }
                },day,month,year);
                datePickerDialog.show();
            }
        });





        //On signup click action
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser(view);
            }
        });
    }



    //method after on click signup
    private void registerUser(View view)
    {

        //get all the staff from UI
        int radioid=radioGroup.getCheckedRadioButtonId();

        radioButton=(RadioButton) findViewById(radioid);

        String firstname=this.firstname.getText().toString().trim().toLowerCase();
        String lastname=this.lastname.getText().toString().trim().toLowerCase();
        String phoneno=this.phoneno.getText().toString().trim();
        String email=this.email.getText().toString().toLowerCase();
        String gender=radioButton.getText().toString().toLowerCase();
        final String password=this.password.getText().toString();
        String confirmpassword=this.confirmpassword.getText().toString();
        String DD=this.DD.getText().toString().trim();
        String MM=this.MM.getText().toString().trim();
        String YYYY=this.YYYY.getText().toString().trim();

        Toast.makeText(view.getContext(),"Signing up....",Toast.LENGTH_SHORT).show();
        new UserRegistration(this).execute(firstname,lastname,phoneno,email,gender,password,confirmpassword,DD,MM,YYYY);



    }

}