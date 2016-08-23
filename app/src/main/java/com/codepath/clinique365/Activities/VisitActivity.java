package com.codepath.clinique365.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codepath.clinique365.R;

public class VisitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);
        getSupportActionBar().setTitle("Visite");
    }
}
