package com.example.kavanpatel.healdoc.Fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kavanpatel.healdoc.Adaptors.HospitalListMain_Adaptor;
import com.example.kavanpatel.healdoc.R;

public class Hospital_list_main extends Fragment {

    String[] txtHospitalName={"abHospital","bcHospital","cdHospital","deHospital","efHospital","fgHospital","ghHospital"};
    int[] rbRatings={4,3,5,1,3,2,4};
    String[] txtHospitalFacility={"Special ward,ICU,OperatinoTheater","24hr Open,OperationTheater","Laboratry,Ambulance","Pharmacy,MedicalStore,GoodDoctorTeam,Ambulance","Radiology/X-ray facility,Ambulance Services,Ambulance","Dental facility,Physiotherapy,ECG Services","No Data avalible"};
    String[] txtHospitalPhoneNumber={"1234567890","6787456789","9876545678","9345876487","9869545454","9999888877","4758694837"};

    RecyclerView hospitalList;
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup,Bundle s)
    {
        viewGroup=(ViewGroup)layoutInflater.inflate(R.layout.activity_hospital_list_main,viewGroup,false);

        HospitalListMain_Adaptor hospitalListMain_adaptor=new HospitalListMain_Adaptor(getContext(),txtHospitalName,rbRatings,txtHospitalFacility,txtHospitalPhoneNumber);


        hospitalList=viewGroup.findViewById(R.id.recyclerViewHospitalList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        hospitalList.setLayoutManager(linearLayoutManager);
        hospitalList.setAdapter(hospitalListMain_adaptor);


        return viewGroup;
    }
}
