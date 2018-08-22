package com.example.kavanpatel.healdoc.Splash_Screen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.example.kavanpatel.healdoc.MainActivity;
import com.example.kavanpatel.healdoc.R;
import com.example.kavanpatel.healdoc.Sign_In;
import com.example.kavanpatel.healdoc.UserSession;

public class Splash_Screen extends AppCompatActivity {


    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
//        RelativeLayout rl=(RelativeLayout)findViewById(R.id.relativeLayoutSplash);
//        rl.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim));

        //Hiding action bar because of splash screen
        getSupportActionBar().hide();

        //To hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                    sharedPreferences=getApplicationContext().getSharedPreferences("userdata",0);
                    if(sharedPreferences.getString("username",null)!=null&&sharedPreferences.getString("password",null)!=null) {

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.putExtra("username",sharedPreferences.getString("username",null));
                        i.putExtra("userpassword",sharedPreferences.getString("userpassword",null));
                        startActivity(i);
                        finish();

                    }
                    else
                    {
                        Intent intent=new Intent(getApplicationContext(),Sign_In.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }
}
