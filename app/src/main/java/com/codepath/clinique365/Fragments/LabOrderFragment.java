package com.codepath.clinique365.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.codepath.clinique365.R;

public class LabOrderFragment extends Fragment{

    private ImageView shareLab;
    private EditText labOrder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lab_order, container, false);

        shareLab = (ImageView) v.findViewById(R.id.ivLabShare);
        labOrder = (EditText) v.findViewById(R.id.edtOrderLab);

        shareLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = labOrder.getText().toString();

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, str);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
