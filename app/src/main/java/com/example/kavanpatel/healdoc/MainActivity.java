package com.example.kavanpatel.healdoc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kavanpatel.healdoc.Adaptors.Discount_Adaptor;
import com.example.kavanpatel.healdoc.Adaptors.Tips_Adaptor;
import com.example.kavanpatel.healdoc.Fragments.Doctor_list_main;
import com.example.kavanpatel.healdoc.Fragments.Home;
import com.example.kavanpatel.healdoc.Fragments.Hospital_list_main;
import com.example.kavanpatel.healdoc.Fragments.Medicine_list_main;
import com.example.kavanpatel.healdoc.Fragments.Remedy_list_main;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //values for tips display
    String[] tipsText={"These compounds are called curcuminoids, the most important of which is curcumin. Curcumin is the main active ingredient in turmeric. It has powerful anti-inflammatory effects and is a very strong antioxidant. ... It would be very difficult to reach these levels just using the turmeric spice in your foods.",
                        "Coriander has multiple health benefits. Coriander or cilantro is a wonderful source of dietary fiber, manganese, iron and magnesium as well. ... In addition, coriander leaves are rich in Vitamin C, Vitamin K and protein. They also contain small amounts of calcium, phosphorous, potassium, thiamin, niacin and carotene.",
                       "Your body uses water in all its cells, organs, and tissues to help regulate its temperature and maintain other bodily functions. Because your body loses water through breathing, sweating, and digestion, it's important to rehydrate by drinking fluids and eating foods that contain water."};
    int[] tipsImage={R.drawable.tumeric,R.drawable.kothmi,R.drawable.water};

    //values for discount display
    int[] discountImage={R.drawable.off,R.drawable.off,R.drawable.off};
    String[] discountStoreText={"NetMeds","1mg","Practo"};
    String[] discountStoreWebsiteText={"Click Here to buy:www.netmeds.com>>","Click Here to buy:www.1mg.com>>","Click Here to buy:www.practo.com>>"};

    //declare componenet for binding activity_main.xml
    RecyclerView recyclerViewTips;
    RecyclerView recyclerViewDiscount;
    TextView txtSlider;
    BottomNavigationView navigationView;

    //declare Class and obj
    Fragment fragment;
    RecyclerView.LayoutManager layoutManagerTips;
    RecyclerView.LayoutManager layoutManagerDiscount;
    Tips_Adaptor tips_adaptor;
    Discount_Adaptor discount_adaptor;
    SharedPreferences sharedPreferences;

    //on Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Home home=new Home();
        FragmentManager fmHome=getSupportFragmentManager();
        FragmentTransaction ftHome=fmHome.beginTransaction();
        ftHome.replace(R.id.llFragment,home);
        ftHome.commit();



        //binding components
        txtSlider=(TextView) findViewById(R.id.txtSlider);
        recyclerViewTips=findViewById(R.id.recyclerViewTips);
        recyclerViewDiscount=findViewById(R.id.recyclerViewDiscount);
        navigationView=findViewById(R.id.Menu_navigation);


        //listeners
        navigationView.setOnNavigationItemSelectedListener(this);


        //give property to layout manager like linear horizontal
        layoutManagerTips=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        layoutManagerDiscount=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        //set property of layout manager to recycler view

        recyclerViewTips.setLayoutManager(layoutManagerTips);
        recyclerViewDiscount.setLayoutManager(layoutManagerDiscount);

        //initiate object of adaptors
        tips_adaptor=new Tips_Adaptor(this,tipsText,tipsImage);
        discount_adaptor=new Discount_Adaptor(this,discountImage,discountStoreText,discountStoreWebsiteText);

        //Set adaptor and other values to activity_main.xml's componenets
        txtSlider.setSelected(true);
        recyclerViewTips.setAdapter(tips_adaptor);
        recyclerViewDiscount.setAdapter(discount_adaptor);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.navigationHome:
                Home home=new Home();
                FragmentManager fmHome=getSupportFragmentManager();
                FragmentTransaction ftHome=fmHome.beginTransaction();
                ftHome.replace(R.id.llFragment,home);
                ftHome.commit();
                return true;

            case R.id.navigationDoctor:
                Doctor_list_main doctor_list_main=new Doctor_list_main();
                FragmentManager fmDoctor=getSupportFragmentManager();
                FragmentTransaction ftDoctor=fmDoctor.beginTransaction();
                ftDoctor.replace(R.id.llFragment,doctor_list_main);
                ftDoctor.commit();
                return true;

            case R.id.navigationMedicine:
                Medicine_list_main medicine_list_main=new Medicine_list_main();
                FragmentManager fmMedicine=getSupportFragmentManager();
                FragmentTransaction ftMedicine=fmMedicine.beginTransaction();
                ftMedicine.replace(R.id.llFragment,medicine_list_main);
                ftMedicine.commit();
                return true;

            case R.id.navigationHospital:
                Hospital_list_main hospital_list_main=new Hospital_list_main();
                FragmentManager fmHospital=getSupportFragmentManager();
                FragmentTransaction ftHospital=fmHospital.beginTransaction();
                ftHospital.replace(R.id.llFragment,hospital_list_main);
                ftHospital.commit();
                return true;

            case R.id.navigationRemedy:
                Remedy_list_main remedy_list_main=new Remedy_list_main();
                FragmentManager fmRemedy=getSupportFragmentManager();
                FragmentTransaction ftRemedy=fmRemedy.beginTransaction();
                ftRemedy.replace(R.id.llFragment,remedy_list_main);
                ftRemedy.commit();
                return true;
        }
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.actionbar_home,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        int id=menuItem.getItemId();
        if(R.id.menu_logout==id)
        {
           sharedPreferences=this.getSharedPreferences("userdata",this.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.remove("username").commit();
            editor.remove("password").commit();
            editor.commit();
            Toast.makeText(this,"Successful logout",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,Sign_In.class);
            this.startActivity(intent);
        }
       return true;
    }
}
