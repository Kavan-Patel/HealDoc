package com.example.kavanpatel.healdoc.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kavanpatel.healdoc.Nuskha;
import com.example.kavanpatel.healdoc.Nuskhaa;
import com.example.kavanpatel.healdoc.R;

public class Remedy_list_main extends Fragment {

    Button btnNuskha;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle s)
    {
        viewGroup=(ViewGroup)layoutInflater.inflate(R.layout.activity_remedy_list_main,viewGroup,false);

        btnNuskha=viewGroup.findViewById(R.id.btnNuskha);
        btnNuskha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Nuskhaa.class);
                startActivity(i);
            }
        });
        return viewGroup;
    }
}
