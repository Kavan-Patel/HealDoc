package com.example.kavanpatel.healdoc.Adaptors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kavanpatel.healdoc.R;

/**
 * Created by kavanpatel on 30/11/17.
 */

public class MedicineListMain_Adaptor_RecyclerView extends RecyclerView.Adapter<MedicineListMain_Adaptor_RecyclerView.MedicineListMainViewHolder>
{
    int[] imgMedicineType;
    String[] txtMedicineDescription;
    String[] txtMedicineType;
    Context context;

    View view;
    MedicineListMain_Adaptor_RecyclerView.MedicineListMainViewHolder viewHolder;


    public MedicineListMain_Adaptor_RecyclerView(Context context,int[] imgMedicineType, String[] txtMedicineType,String[] txtMedicineDescription) {
        this.imgMedicineType = imgMedicineType;
        this.txtMedicineType = txtMedicineType;
        this.txtMedicineDescription= txtMedicineDescription;
        this.context = context;
    }

    @Override
    public MedicineListMain_Adaptor_RecyclerView.MedicineListMainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view= LayoutInflater.from(context).inflate(R.layout.card_medicine_main,parent,false);
        viewHolder=new MedicineListMain_Adaptor_RecyclerView.MedicineListMainViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(MedicineListMain_Adaptor_RecyclerView.MedicineListMainViewHolder holder, int position) {
        holder.txtMedicineType.setText(txtMedicineType[position]);
        holder.txtMedicineDescription.setText(txtMedicineDescription[position]);
        holder.imgMedicineType.setImageResource(imgMedicineType[position]);
    }

    @Override
    public int getItemCount() {
        return txtMedicineType.length;
    }

    class MedicineListMainViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgMedicineType;
        TextView txtMedicineType;
        TextView txtMedicineDescription;
        public MedicineListMainViewHolder(View itemView) {
            super(itemView);
            txtMedicineDescription=(TextView)itemView.findViewById(R.id.txtMedicineDescription);
            imgMedicineType=(ImageView)itemView.findViewById(R.id.imgMedicineType);
            txtMedicineType=(TextView)itemView.findViewById(R.id.txtMedicineType);
        }
    }

}
