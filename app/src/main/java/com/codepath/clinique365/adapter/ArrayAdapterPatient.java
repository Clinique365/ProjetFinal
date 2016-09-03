package com.codepath.clinique365.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.clinique365.Models.Patient;
import com.codepath.clinique365.R;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by SET JETRO on 8/22/2016.
 */
public class ArrayAdapterPatient extends ArrayAdapter<Patient> {

    //constructor
    public ArrayAdapterPatient(Context context, ArrayList<Patient> patients)
    {
        super(context, android.R.layout.simple_list_item_1, patients);
    }

    //custom view to populate data
   @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            Patient patient = getItem(position);
            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.item_patient, parent, false);
            }

        //Find views
        ImageView img = (ImageView) convertView.findViewById(R.id.ivItemPatientProfil);

        TextView name = (TextView) convertView.findViewById(R.id.tvItemFirstname);
        TextView adress = (TextView) convertView.findViewById(R.id.tvItemAdress);

        //populate data
        name.setText(patient.getPrenom());
        adress.setText(patient.getAdresse());

        return convertView;
        }
}

