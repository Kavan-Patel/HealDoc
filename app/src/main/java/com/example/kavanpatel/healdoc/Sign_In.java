package com.example.kavanpatel.healdoc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_In extends Activity {

    Button btnLogIn;
    String username="kavan";
    String password="yashvi";
    EditText edtUsername,edtPassword;
    TextView txtGotosignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign__in);


        edtUsername=findViewById(R.id.edt_UserName);
        edtPassword=findViewById(R.id.edt_Password);
        btnLogIn=findViewById(R.id.btn_LogIn);
        txtGotosignup=findViewById(R.id.txt_signin_gotosignup);


        txtGotosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Sign_In.this,Sign_up.class);
                startActivity(i);
            }
        });


        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edtUsername.getText().toString().trim().toLowerCase();
                String password=edtPassword.getText().toString().trim();
                new UserLogin(Sign_In.this).execute(username,password);


            }
        });
    }
}
