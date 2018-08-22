package com.example.kavanpatel.healdoc;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by kavanpatel on 08/04/18.
 */

public class UserRegistration extends AsyncTask<String,Void,String> {
    private static final String REGISTERED_URL = "https://healdoc.000webhostapp.com/signup.php";
    private ProgressDialog progressDialog;
    private Context context;

            public UserRegistration(Context context)
            {
                this.context=context;
            }

            @Override
            protected void onPreExecute()
            {
                super.onPreExecute();
                progressDialog=ProgressDialog.show(context,"Plese wait",null,true,true);
            }


            @Override
            protected String doInBackground(String... strings) {
                BufferedReader bufferedReader;
                String link;
                String data;

                String firstname=strings[0];
                String lastname=strings[1];
                String phoneno=strings[2];
                String email=strings[3];
                String gender=strings[4];
                String password=strings[5];
                String confirmpassword=strings[6];
                String DD=strings[7];
                String MM=strings[8];
                String YYYY=strings[9];
                String dob=YYYY+"-"+MM+"-"+DD;
                try{

                    data ="?firstname="+ URLEncoder.encode(firstname,"UTF-8");
                    data +="&lastname="+ URLEncoder.encode(lastname,"UTF-8");
                    data +="&phoneno="+ URLEncoder.encode(phoneno,"UTF-8");
                    data +="&email="+ URLEncoder.encode(email,"UTF-8");
                    data +="&gender="+ URLEncoder.encode(gender,"UTF-8");
                    data +="&dob="+ URLEncoder.encode(dob,"UTF-8");
                    data +="&password="+ URLEncoder.encode(password,"UTF-8");
                    data +="&confirmpassword="+ URLEncoder.encode(confirmpassword,"UTF-8");


                    URL url=new URL(REGISTERED_URL+data);
                    HttpURLConnection con= (HttpURLConnection) url.openConnection();
                    bufferedReader=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result=bufferedReader.readLine();
                    return result;

                }catch (Exception e)
                {
                    return null;
                }

            }

            @Override
            protected void onPostExecute(String result)
            {
                super.onPostExecute(result);
                String jsonStr=result;
                if(jsonStr!=null)
                {
                    try{
                        JSONObject jsonObject=new JSONObject(jsonStr);
                        String query_result=jsonObject.getString("query_result");

                        if(query_result.equals("SUCCESS"))
                        {
                            Intent intent=new Intent(context,Sign_In.class);
                            context.startActivity(intent);
                            Toast.makeText(context,"Signup Successfully",Toast.LENGTH_SHORT).show();
                        }
                        else if(query_result.equals("FAILURE"))
                        {
                            Toast.makeText(context,"Data could not be inserted",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(context,"Couden't connect remote database",Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                        Toast.makeText(context,"Error in parsing Json data",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(context,"Couden't get Json data",Toast.LENGTH_SHORT).show();
                }

                progressDialog.dismiss();


            }


}
