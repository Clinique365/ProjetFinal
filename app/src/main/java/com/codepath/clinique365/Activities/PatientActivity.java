package com.codepath.clinique365.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.codepath.clinique365.Connector;
import com.codepath.clinique365.R;

import java.util.ArrayList;
import java.util.List;

public class PatientActivity extends AppCompatActivity {

    //variable declaration
    Spinner spinner;
    private ImageView registerPatient;
    private EditText firstname;
    private EditText lastname;
    private EditText age;
    private EditText adress;
    private EditText phoneNumber;
    private EditText phoneNumberContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        getSupportActionBar().setTitle("Ajouter Patient");
        spinner();
        setupViews();
    }


    //find view an initialize variable
    public void setupViews(){
        firstname = (EditText) findViewById(R.id.edtfirstnamePatient);
        lastname = (EditText) findViewById(R.id.edtlastnamePatient);
        age = (EditText) findViewById(R.id.edtAgePatient);
        adress = (EditText) findViewById(R.id.edtAdressPatient);
        phoneNumber = (EditText) findViewById(R.id.edtPhonePatient);
        spinner = (Spinner) findViewById(R.id.spinner);
        phoneNumberContact = (EditText) findViewById(R.id.edtPhoneContact);
        registerPatient = (ImageView) findViewById(R.id.ivNewPatient);

        //set on click event to register a new patient
        registerPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = lastname.getText().toString();
                String firstnamePatient = firstname.getText().toString();
                String sex = spinner.getSelectedItem().toString();
                String agePatient = age.getText().toString();
                String adressePatient = adress.getText().toString();
                String phone = phoneNumber.getText().toString();
                String phoneContact = phoneNumberContact.getText().toString();

                //call the static methode savePatient(...) from the class Connector
                Connector.savePatient(firstnamePatient, name, sex, agePatient, adressePatient, phone, phoneContact);
                Intent i = new Intent(getApplicationContext(), PatientListActivity.class);
                startActivity(i);
                finish();
            }
        });


    }

    //put element in the spinner
    public Spinner spinner() {
        //fetch the spinner in the xml file
        spinner = (Spinner) findViewById(R.id.spinner);
        //Create the arrayList to put elemet in the spinner
        List exempleList = new ArrayList();
        exempleList.add("M");
        exempleList.add("F");

        //use an adapter to bind data
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                exempleList
        );


        // set the dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Enfin on passe l'adapter au Spinner et c'est tout
        spinner.setAdapter(adapter);

        return spinner;
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finish();
    }
}
