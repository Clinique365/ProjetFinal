package com.codepath.clinique365.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.codepath.clinique365.Activities.HomeActivity;
import com.codepath.clinique365.Connector;
import com.codepath.clinique365.R;

public class RegisterActivity extends AppCompatActivity {

    //variable declaration
    private ImageView register;
    private EditText lastname;
    private EditText firstname;
    private EditText clinic;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Compte");

        setupViews();

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finish();
    }

    //find view by ID
    public void setupViews()
    {

        register = (ImageView) findViewById(R.id.ivRegisterUser);

        firstname = (EditText) findViewById(R.id.edtFirsname);
        lastname = (EditText) findViewById(R.id.edtLastname);
        clinic = (EditText) findViewById(R.id.edtClinic);
        email = (EditText) findViewById(R.id.edtEmail);
        password = (EditText) findViewById(R.id.edtPassword);


        //set event on click to register a new user for the app
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userLastname = lastname.getText().toString();
                String  userFirstname = firstname.getText().toString();
                String userClinic = clinic.getText().toString();
                String userEmail = email.getText().toString() ;
                String userPassword = password.getText().toString();


                //static method saveUser(...) from the class Connector for save a new user
                Connector.saveUser(userFirstname, userLastname, userClinic, userEmail, userPassword);
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Bienvenue docteur " + userFirstname, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
