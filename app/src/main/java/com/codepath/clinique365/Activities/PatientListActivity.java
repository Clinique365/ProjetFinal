package com.codepath.clinique365.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.newPatientList:
                add();
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void add() {
        Intent i = new Intent(this, PatientActivity.class);
        startActivity(i);
    }
}
