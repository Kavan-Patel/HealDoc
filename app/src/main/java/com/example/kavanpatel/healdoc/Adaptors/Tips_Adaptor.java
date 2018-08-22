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
 * Created by kavanpatel on 26/11/17.
 */

public class Tips_Adaptor extends RecyclerView.Adapter<Tips_Adaptor.TipsViewHolder>{

    //Declare Variables
    Context context;
    String[] tipsText;
    int[] tipsImage;
    View view;
    TipsViewHolder viewHolder;

    //Constructor
    public Tips_Adaptor(Context context, String[] tipsText, int[] tipsImage) {
        this.context = context;
        this.tipsText = tipsText;
        this.tipsImage = tipsImage;
    }

    //onCreateViewHolder wich get custom view and inflate on main activity here also hold the view
    @Override
    public TipsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view=LayoutInflater.from(context).inflate(R.layout.card_tips_home,parent,false);
        viewHolder=new TipsViewHolder(view);
        return viewHolder;
    }

    //set values to holded view components
    @Override
    public void onBindViewHolder(TipsViewHolder holder, int position) {
        holder.tvTips.setText(tipsText[position]);
        holder.imTips.setImageResource(tipsImage[position]);
    }

    //return the length of items
    @Override
    public int getItemCount() {
        return tipsText.length;
    }



    static class TipsViewHolder extends RecyclerView.ViewHolder{

        TextView tvTips;
        ImageView imTips;
        //Constructor wich bound the components of holded view
        public TipsViewHolder(View itemView) {
            super(itemView);

            tvTips=itemView.findViewById(R.id.tipsText);
            imTips=itemView.findViewById(R.id.tipsImage);
        }
    }


}
