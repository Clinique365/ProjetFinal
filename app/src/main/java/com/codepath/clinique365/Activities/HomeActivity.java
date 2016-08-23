package com.codepath.clinique365.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.codepath.clinique365.R;

import weborb.client.ant.wdm.Views;

public class HomeActivity extends AppCompatActivity {

    private ImageView order;
    private ImageView patient;
    private ImageView patientList;
    private ImageView visit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Acceuil");

        setupViews();
    }

    public void setupViews(){
        order = (ImageView) findViewById(R.id.ivPatientOrder);
        patient = (ImageView) findViewById(R.id.ivAddPatient);
        patientList = (ImageView) findViewById(R.id.ivListPatient);
        visit = (ImageView) findViewById(R.id.ivPatientVisit);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), OrderActivity.class);
                startActivity(i);
            }
        });

        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PatientActivity.class);
                startActivity(i);
            }
        });

        patientList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PatientListActivity.class);
                startActivity(i);
            }
        });

        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), VisitActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.logout:
                logout();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void logout()
    {
        Backendless.UserService.logout(new AsyncCallback<Void>() {
            @Override
            public void handleResponse(Void response) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(getApplicationContext(), "Essayer un peu plus tard", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
