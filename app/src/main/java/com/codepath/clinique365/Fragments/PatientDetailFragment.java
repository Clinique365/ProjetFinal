package com.codepath.clinique365.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codepath.clinique365.Models.Patient;
import com.codepath.clinique365.R;

/**
 * Created by SET JETRO on 8/19/2016.
 */
public class PatientDetailFragment extends Fragment {

    private TextView name;
    private TextView age;
    private TextView adress;
    private Button btnOrder;
    private Button btnModify;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_patient_details, container, false);

        btnOrder = (Button) v.findViewById(R.id.btOrder);
        btnModify = (Button) v.findViewById(R.id.btModify);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), LabOrderFragment.class);
                startActivity(i);
            }
        });

        name = (TextView) v.findViewById(R.id.tvDetailName);
        age = (TextView) v.findViewById(R.id.tvDetailAge);
        adress = (TextView) v.findViewById(R.id.tvDetailAdress);


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void getData(Patient patient)
    {
        name.setText(patient.getNom() + " " + patient.getPrenom());
        age.setText(patient.getAge());
        adress.setText(patient.getAdresse());
    }

}
