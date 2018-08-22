package com.example.kavanpatel.healdoc.Adaptors;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kavanpatel.healdoc.R;

/**
 * Created by kavanpatel on 27/11/17.
 */

public class DoctorListMain_Adaptor_RecyclerView extends RecyclerView.Adapter<DoctorListMain_Adaptor_RecyclerView.DoctorListMainViewHolder> {

    int[] imgDoctorType;
    String[] txtDoctorType;
    Context context;

    View view;
    DoctorListMainViewHolder viewHolder;
    public DoctorListMain_Adaptor_RecyclerView(Context context,int[] imgDoctorType, String[] txtDoctorType) {
        this.imgDoctorType = imgDoctorType;
        this.txtDoctorType = txtDoctorType;
        this.context = context;
    }

    @Override
    public DoctorListMainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view= LayoutInflater.from(context).inflate(R.layout.card_doctor_list_main,parent,false);
        viewHolder=new DoctorListMainViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DoctorListMainViewHolder holder, int position) {
        holder.txtDoctorType.setText(txtDoctorType[position]);
        holder.imgDoctorType.setImageResource(imgDoctorType[position]);
    }

    @Override
    public int getItemCount() {
        return txtDoctorType.length;
    }

    class DoctorListMainViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgDoctorType;
        TextView txtDoctorType;
        public DoctorListMainViewHolder(View itemView) {
            super(itemView);
            imgDoctorType=(ImageView)itemView.findViewById(R.id.imgDoctorType);
            txtDoctorType=(TextView)itemView.findViewById(R.id.txtDoctorType);
        }
    }

}
