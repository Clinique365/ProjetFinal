package com.codepath.clinique365.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.codepath.clinique365.Fragments.PatientDetailFragment;
import com.codepath.clinique365.Fragments.PatientListFragment;
import com.codepath.clinique365.Models.Patient;
import com.codepath.clinique365.R;
import com.codepath.clinique365.adapter.ArrayAdapterPatient;

import java.util.ArrayList;
import java.util.Iterator;

public class PatientListActivity extends AppCompatActivity implements PatientListFragment.shareObject {

    //variable declaration
    private ArrayList<Patient> listPatient;
    private ArrayAdapterPatient patientArrayAdapter;
    ListView patientList;
    ProgressBar progress;
    PatientListFragment.shareObject sharePatient;

    //string for get the ID of the current loggin user
    String idUser = Backendless.UserService.loggedInUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);
        getSupportActionBar().setTitle("Liste Patient");

    }

    //implement method from the interface shareObject
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

    //inflate menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        MenuItem addPatientItem = menu.findItem(R.id.newPatientList);
        MenuItem searchItem = menu.findItem(R.id.action_search);

        //set on item menu click call a new method
        addPatientItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                add();
                finish();
                return true;
            }
        });

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String querySubmit) {
                // perform query here
                // workaround to avoid issues with some emulators and keyboard devices firing twice if a keyboard enter is used
                searchPatient(querySubmit);
                searchView.clearFocus();
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

       return true;
    }

    //method use to call PatientActivity for add new Patient
    private void add() {
        Intent i = new Intent(this, PatientActivity.class);
        startActivity(i);
    }


    //method for search
    private void searchPatient(String userQuery){

        patientList = (ListView) findViewById(R.id.lvPatientList);
        progress = (ProgressBar) findViewById(R.id.progressBarList);
        listPatient = new ArrayList<>();
        //listPatient = new ArrayList<>();
        //patientArrayAdapter = new ArrayAdapter<Patient>(getActivity(), android.R.layout.simple_list_item_1, listPatient);
        patientArrayAdapter = new ArrayAdapterPatient(this, listPatient);
        patientList.setAdapter(patientArrayAdapter);
        progress.setVisibility(View.VISIBLE);

        String query = " user = '" + idUser + "' and prenom = '" +  userQuery + "'";
        BackendlessDataQuery dataQuery = new BackendlessDataQuery();
        dataQuery.setWhereClause(query);

        //backendless api to find a patient with query search
        Backendless.Persistence.of( Patient.class).find(dataQuery, new AsyncCallback<BackendlessCollection<Patient>>(){
            @Override
            public void handleResponse( BackendlessCollection<Patient> foundPatients )
            {
                Iterator<Patient> patientIterator = foundPatients.getCurrentPage().iterator();
                while (patientIterator.hasNext())
                {
                    Patient newPatient = patientIterator.next();
                    listPatient.add(newPatient);

                }
     //           patientArrayAdapter.clear();
                patientArrayAdapter.notifyDataSetChanged();
                progress.setVisibility(View.GONE);

            }
            @Override
            public void handleFault( BackendlessFault fault )
            {
                //progress.setVisibility(View.GONE);
            }

        });

    }
}
