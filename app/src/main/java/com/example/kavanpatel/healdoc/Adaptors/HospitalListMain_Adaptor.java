package com.example.kavanpatel.healdoc.Adaptors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.kavanpatel.healdoc.Fragments.Hospital_list_main;
import com.example.kavanpatel.healdoc.R;

/**
 * Created by kavanpatel on 03/12/17.
 */

public class HospitalListMain_Adaptor extends RecyclerView.Adapter<HospitalListMain_Adaptor.HospitalListMainViewHolder>{


    Context context;
    String[] txtHospitalName,txtHospitalFacility,txtHospitalPhoneNumber;
    int[] rbRatings;

    public HospitalListMain_Adaptor(Context context, String[] txtHospitalName, int[] rbRatings, String[] txtHospitalFacility, String[] txtHospitalPhoneNumber)
    {
        this.context=context;
        this.txtHospitalFacility=txtHospitalFacility;
        this.txtHospitalName=txtHospitalName;
        this.txtHospitalPhoneNumber=txtHospitalPhoneNumber;
        this.rbRatings=rbRatings;
    }

    @Override
    public HospitalListMainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_hospital_list_main,parent,false);
        HospitalListMainViewHolder hospitalListMainViewHolder=new HospitalListMainViewHolder(view);
        return hospitalListMainViewHolder;
    }

    @Override
    public void onBindViewHolder(HospitalListMainViewHolder holder, int position) {
        holder.txtHospitalName.setText(txtHospitalName[position]);
        holder.txtHospitalPhoneNumber.setText("Phone Number : "+txtHospitalPhoneNumber[position]);
        holder.txtHospitalFacility.setText("Facilities : "+txtHospitalFacility[position]);
        holder.rbRatings.setRating(rbRatings[position]);
    }

    @Override
    public int getItemCount() {
        return txtHospitalFacility.length;
    }


    class HospitalListMainViewHolder extends RecyclerView.ViewHolder{

        TextView txtHospitalName;
        TextView txtHospitalFacility;
        TextView txtHospitalPhoneNumber;
        RatingBar rbRatings;
        public HospitalListMainViewHolder(View itemView) {
            super(itemView);
            txtHospitalFacility=itemView.findViewById(R.id.txtHospitalFacility);
            txtHospitalName=itemView.findViewById(R.id.txtHospitalName);
            txtHospitalPhoneNumber=itemView.findViewById(R.id.txtHospitalPhoneNumber);
            rbRatings=itemView.findViewById(R.id.rbRatings);
        }
    }
}
