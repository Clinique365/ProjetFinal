package com.codepath.clinique365.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codepath.clinique365.Fragments.PatientDetailFragment;
import com.codepath.clinique365.Fragments.PatientListFragment;
import com.codepath.clinique365.Models.Patient;
import com.codepath.clinique365.R;

public class PatientListActivity extends AppCompatActivity implements PatientListFragment.shareObject {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);
        getSupportActionBar().setTitle("Liste Patient");
    }

    @Override
    public void patientShare(Patient patient)
    {
        PatientDetailFragment details = (PatientDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        details.getData(patient);

    }

}
