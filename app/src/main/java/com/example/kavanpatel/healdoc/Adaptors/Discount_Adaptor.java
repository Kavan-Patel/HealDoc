package com.example.kavanpatel.healdoc.Adaptors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kavanpatel.healdoc.MainActivity;
import com.example.kavanpatel.healdoc.R;

/**
 * Created by kavanpatel on 26/11/17.
 */

public class Discount_Adaptor extends RecyclerView.Adapter<Discount_Adaptor.DiscountViewHolder> {

    int[] imgView;
    String[] txtStoreName;
    String[] txtStoreWeb;
    Context context;
    View view;
    DiscountViewHolder viewHolder;

    public Discount_Adaptor(MainActivity context, int[] imgView, String[] txtStoreName, String[] txtStoreWeb) {
        this.imgView = imgView;
        this.txtStoreName = txtStoreName;
        this.txtStoreWeb = txtStoreWeb;
        this.context = context;
    }



    @Override
    public DiscountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view= LayoutInflater.from(context).inflate(R.layout.card_discount_home,parent,false);
        viewHolder=new DiscountViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DiscountViewHolder holder, int position) {
        holder.imgView.setImageResource(imgView[position]);
        holder.txtStore.setText(txtStoreName[position]);
        holder.txtWeb.setText(txtStoreWeb[position]);

    }

    @Override
    public int getItemCount() {
        return txtStoreName.length;
    }

    class DiscountViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgView;
        TextView txtStore;
        TextView txtWeb;
        public DiscountViewHolder(View itemView) {
            super(itemView);
            imgView=(ImageView)itemView.findViewById(R.id.imgDiscout);
            txtStore=(TextView)itemView.findViewById(R.id.txtStoreName);
            txtWeb=(TextView)itemView.findViewById(R.id.txtStoreWeb);
        }
    }
}
