package com.example.kavanpatel.healdoc.Fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kavanpatel.healdoc.Adaptors.DoctorListMain_Adaptor_RecyclerView;
import com.example.kavanpatel.healdoc.R;

public class Doctor_list_main extends Fragment {

    RecyclerView recyclerViewDoctorType;
    RecyclerView.LayoutManager layoutManager;
    DoctorListMain_Adaptor_RecyclerView doctorListMain_adaptor_recyclerView;


    String[] txtDoctorType={"Heart Specialist","Surgeon","Eye Specialist","CardioLogist","MBBS","FamilyDoctor","XYZ"};
    int[] imgDoctorType={R.drawable.hs,R.drawable.sgn,R.drawable.es,R.drawable.cl,R.drawable.mbbs,R.drawable.familydoctor,R.drawable.doctornew};
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle s)
    {
        viewGroup= (ViewGroup) layoutInflater.inflate(R.layout.activity_doctor_list_main,viewGroup,false);

        recyclerViewDoctorType=viewGroup.findViewById(R.id.recyclerViewDoctorType);

        layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);

        recyclerViewDoctorType.setLayoutManager(layoutManager);

        doctorListMain_adaptor_recyclerView=new DoctorListMain_Adaptor_RecyclerView(getContext(),imgDoctorType,txtDoctorType);

        recyclerViewDoctorType.setAdapter(doctorListMain_adaptor_recyclerView);
        return viewGroup;
    }

}
