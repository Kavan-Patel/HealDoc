package com.example.kavanpatel.healdoc.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kavanpatel.healdoc.Adaptors.MedicineListMain_Adaptor_RecyclerView;
import com.example.kavanpatel.healdoc.R;

public class Medicine_list_main extends Fragment {

    RecyclerView recyclerViewMedicineType;
    RecyclerView.LayoutManager layoutManager;
    MedicineListMain_Adaptor_RecyclerView medicineListMain_adaptor_recyclerView;


    String[] txtMedicineDescription={"reducing fever","reducing pain","treating malaria","inhibiting germ growth","prevention of germ growth near burns","lithium and valpromide","Premarin"};
    String[] txtMedicineType={"Antipyretics","Analgesics","Antimalarial drugs","Antibiotics","Antiseptics","Mood stabilizers","Hormone replacements"};
    int[] imgMedicineType={R.drawable.tablets,R.drawable.tablets,R.drawable.tablets,R.drawable.tablets,R.drawable.tablets,R.drawable.tablets,R.drawable.tablets};


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup,Bundle s)
    {
        viewGroup= (ViewGroup) layoutInflater.inflate(R.layout.activity_medicine_list_main,viewGroup,false);

        recyclerViewMedicineType=viewGroup.findViewById(R.id.recyclerViewMedicineType);

        layoutManager=new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);

        recyclerViewMedicineType.setLayoutManager(layoutManager);

        medicineListMain_adaptor_recyclerView= new MedicineListMain_Adaptor_RecyclerView(getContext(),imgMedicineType,txtMedicineType,txtMedicineDescription);

        recyclerViewMedicineType.setAdapter(medicineListMain_adaptor_recyclerView);
        return viewGroup;
    }
}
