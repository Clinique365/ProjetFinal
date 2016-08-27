package com.codepath.clinique365.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.astuetz.PagerSlidingTabStrip;
import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.codepath.clinique365.Models.Patient;
import com.codepath.clinique365.R;
import com.codepath.clinique365.adapter.ArrayAdapterPatient;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by SET JETRO on 8/19/2016.
 */
public class PatientListFragment extends Fragment {

    ProgressBar progress;

    shareObject sharePatient;
    String idUser = Backendless.UserService.loggedInUser();

    String query = "user = 4C8492B4-01E2-5457-FFBB-D23CE2EC3800";
    private ArrayList<Patient> listPatient;
    //private ArrayAdapter<Patient> patientArrayAdapter;
    private ArrayAdapterPatient patientArrayAdapter;
    ListView patientList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.patient_list_fragment, container, false);

        progress = (ProgressBar) v.findViewById(R.id.progressBarList);
        patientList = (ListView) v.findViewById(R.id.lvPatientList);
        listPatient = new ArrayList<>();
        //listPatient = new ArrayList<>();
        //patientArrayAdapter = new ArrayAdapter<Patient>(getActivity(), android.R.layout.simple_list_item_1, listPatient);
        patientArrayAdapter = new ArrayAdapterPatient(getActivity(), listPatient);
        patientList.setAdapter(patientArrayAdapter);

        patientList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               //get the object by position
                Patient patientDetails = listPatient.get(position);
                //
                sharePatient.patientShare(patientDetails);

            }
        });

        BackendlessDataQuery dataQuery = new BackendlessDataQuery();
        dataQuery.setWhereClause(query);


        Backendless.Persistence.of( Patient.class).find(new AsyncCallback<BackendlessCollection<Patient>>(){
            @Override
            public void handleResponse( BackendlessCollection<Patient> foundPatients )
            {
                Iterator<Patient> patientIterator = foundPatients.getCurrentPage().iterator();
                while (patientIterator.hasNext())
                {
                    Patient newPatient = patientIterator.next();
                    listPatient.add(newPatient);

                }
                patientArrayAdapter.notifyDataSetChanged();
                progress.setVisibility(View.GONE);

            }
            @Override
            public void handleFault( BackendlessFault fault )
            {

            }

    });
        return v;
    }

    public interface shareObject
    {
        public void patientShare(Patient patient);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try
        {
            sharePatient = (shareObject) activity;
        }
        catch (ClassCastException e){
            e.printStackTrace();
        }


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
