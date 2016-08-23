package com.codepath.clinique365.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.codepath.clinique365.Activities.HomeActivity;
import com.codepath.clinique365.Connector;
import com.codepath.clinique365.R;

public class RegisterActivity extends AppCompatActivity {

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

    public void setupViews()
    {

        register = (ImageView) findViewById(R.id.ivRegisterUser);

        firstname = (EditText) findViewById(R.id.edtFirsname);
        lastname = (EditText) findViewById(R.id.edtLastname);
        clinic = (EditText) findViewById(R.id.edtClinic);
        email = (EditText) findViewById(R.id.edtEmail);
        password = (EditText) findViewById(R.id.edtPassword);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userLastname = lastname.getText().toString();
                String  userFirstname = firstname.getText().toString();
                String userClinic = clinic.getText().toString();
                String userEmail = email.getText().toString() ;
                String userPassword = password.getText().toString();


                Connector.saveUser(userFirstname, userLastname, userClinic, userEmail, userPassword);
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);

            }
        });

    }
}
