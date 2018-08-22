package com.example.kavanpatel.healdoc.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kavanpatel.healdoc.Adaptors.Discount_Adaptor;
import com.example.kavanpatel.healdoc.Adaptors.Tips_Adaptor;
import com.example.kavanpatel.healdoc.Booking;
import com.example.kavanpatel.healdoc.MainActivity;
import com.example.kavanpatel.healdoc.R;

public class Home extends Fragment {


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


    //declare Class and obj
    RecyclerView.LayoutManager layoutManagerTips;
    RecyclerView.LayoutManager layoutManagerDiscount;
    Tips_Adaptor tips_adaptor;
    Discount_Adaptor discount_adaptor;
    Button booking;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup,Bundle s)
    {
        viewGroup=(ViewGroup)layoutInflater.inflate(R.layout.activity_home,viewGroup,false);


        //binding components
        txtSlider=(TextView) viewGroup.findViewById(R.id.txtSlider);
        recyclerViewTips=viewGroup.findViewById(R.id.recyclerViewTips);
        recyclerViewDiscount=viewGroup.findViewById(R.id.recyclerViewDiscount);
        booking=viewGroup.findViewById(R.id.btnBook);



        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Booking.class);
                startActivity(i);
            }
        });

        //give property to layout manager like linear horizontal
        layoutManagerTips=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        layoutManagerDiscount=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        //set property of layout manager to recycler view

        recyclerViewTips.setLayoutManager(layoutManagerTips);
        recyclerViewDiscount.setLayoutManager(layoutManagerDiscount);

        //initiate object of adaptors
        tips_adaptor=new Tips_Adaptor(getContext(),tipsText,tipsImage);
        discount_adaptor=new Discount_Adaptor((MainActivity) getContext(),discountImage,discountStoreText,discountStoreWebsiteText);

        //Set adaptor and other values to activity_main.xml's componenets
        txtSlider.setSelected(true);
        recyclerViewTips.setAdapter(tips_adaptor);
        recyclerViewDiscount.setAdapter(discount_adaptor);

        return viewGroup;
    }
}
