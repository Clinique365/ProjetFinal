package com.codepath.clinique365.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.codepath.clinique365.Connector;
import com.codepath.clinique365.Fragments.DatePickerFragment;
import com.codepath.clinique365.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VisitActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private EditText dateVisitPatient;
    private EditText symptomsPatient;
    private EditText historyMedicale;
    private EditText diagnostics;
    private EditText notes;
    private ImageView registerVisit;

  //  private Date dateFinal = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);
        getSupportActionBar().setTitle("Visite");

        setupViews();
    }


    public void setupViews()
    {
        dateVisitPatient = (EditText) findViewById(R.id.edtDateVisit);
        historyMedicale = (EditText) findViewById(R.id.edtHistoryMedical);
        diagnostics =(EditText) findViewById(R.id.edtDiagnostic);
        notes =(EditText)findViewById(R.id.edtNotes);
        registerVisit = (ImageView) findViewById(R.id.ivRegisterVisit);

        registerVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dateVisitPat = dateVisitPatient.getText().toString();
                String symptoms = symptomsPatient.getText().toString();
                String history = historyMedicale.getText().toString();
                String notespat = notes.getText().toString();
                String diagnosticspat = diagnostics.getText().toString();

                Connector.saveVisit(dateVisitPat, symptoms, history, notespat, diagnosticspat);
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        // store the values selected into a Calendar instance
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");

        dateVisitPatient = (EditText) findViewById(R.id.edtDateVisit);

        dateVisitPatient.setText(formatDate.format(c.getTime()));

    }


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finish();
    }

    public void onShowDatePicker(View view) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
