package com.example.kavanpatel.healdoc;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class UserLogin extends AsyncTask<String,Void,String> {

    private static final String REGISTERED_URL = "https://healdoc.000webhostapp.com/mycode.php";
    ProgressDialog progressDialog;
    Context context;
    String email,password;
    HttpURLConnection httpURLConnection;
    SharedPreferences sharedPreferences;


    public UserLogin(Context context)
    {
        this.context=context;
    }
    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        progressDialog= ProgressDialog.show(context,"Plese wait",null,true,true);
    }



    @Override
    protected String doInBackground(String... strings) {

        String data;
        BufferedReader bufferedReader;
        email=strings[0];
        password=strings[1];

        try {

            data = "?email="+ URLEncoder.encode(email,"UTF-8");
            data += "&password="+ URLEncoder.encode(password,"UTF-8");

            URL url=new URL(REGISTERED_URL+data);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            bufferedReader=new BufferedReader(new InputStreamReader(con.getInputStream()));
            String result;
            result=bufferedReader.readLine();


             sharedPreferences=context.getSharedPreferences("userdata",0);

            SharedPreferences.Editor editor=sharedPreferences.edit();

            editor.putString("username",email);
            editor.putString("password",password);

            editor.commit();


            return result;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    protected void onPostExecute(String result)
    {

        super.onPostExecute(result);

        String jsonStr=result;
        if(jsonStr!=null)
        {
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                String query_result = jsonObject.getString("query_result");

                if(query_result.equals("SUCCESS"))
                {
                    Intent intent=new Intent(context,MainActivity.class);
                    context.startActivity(intent);
                }
                else
                {
                    Toast.makeText(context,"Plese Enter Valid Username and password",Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            Toast.makeText(context,"Couden't get Json data",Toast.LENGTH_SHORT).show();
        }
        progressDialog.dismiss();
    }
}
