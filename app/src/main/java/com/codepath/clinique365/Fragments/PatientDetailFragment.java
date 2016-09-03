package com.codepath.clinique365.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codepath.clinique365.Activities.OrderActivity;
import com.codepath.clinique365.Models.Patient;
import com.codepath.clinique365.R;

/**
 * Created by SET JETRO on 8/19/2016.
 */
public class PatientDetailFragment extends Fragment {

    private TextView name;
    private TextView age;
    private TextView adress;
    private TextView phone;
    private Button btnOrder;
//    private Button btnModify;
    showOrder showOrd;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_patient_details, container, false);

        btnOrder = (Button) v.findViewById(R.id.btOrder);
        btnOrder.setVisibility(View.VISIBLE);


        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), OrderActivity.class);
                startActivity(i);
            }
        });

        name = (TextView) v.findViewById(R.id.tvDetailName);
        age = (TextView) v.findViewById(R.id.tvDetailAge);
        adress = (TextView) v.findViewById(R.id.tvDetailAdress);
        phone = (TextView) v.findViewById(R.id.tvDetailTelephone);


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void getData(Patient patient)
    {
        name.setText(patient.getNom() + " " + patient.getPrenom());
        age.setText(patient.getAge() + " ans");
        adress.setText(patient.getAdresse());
        phone.setText(patient.getTelephone());

        name.setVisibility(View.VISIBLE);
        age.setVisibility(View.VISIBLE);
        adress.setVisibility(View.VISIBLE);
        phone.setVisibility(View.VISIBLE);
    }

    public interface showOrder
    {
        public void showActivity();
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try
        {
            showOrd = (showOrder) activity;
        }
        catch (ClassCastException e){
            e.printStackTrace();
        }


    }
}
