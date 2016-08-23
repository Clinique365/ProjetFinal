package com.codepath.clinique365.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.codepath.clinique365.ClinicClient;
import com.codepath.clinique365.R;

public class LoginActivity extends AppCompatActivity {

    public static final String APP_ID = "8E03CCAA-E054-6D08-FF6B-BBCDFF930100" ;
    public static final String SECRET_KEY = "557A461D-A632-F486-FF5D-CBAF6F137600";
    public static final String VERSION = "v1";

    private TextView register;
    private ImageView login;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");

        Backendless.initApp(this, APP_ID, SECRET_KEY, VERSION);

        setupViews();
    }

    public void setupViews(){
        register = (TextView) findViewById(R.id.tvRegister);
        login = (ImageView) findViewById(R.id.ivLogin);
        email = (EditText) findViewById(R.id.edtEmail);
        password = (EditText) findViewById(R.id.edtPassword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMail = email.getText().toString();
                String userPassword = password.getText().toString();

                Backendless.UserService.login(userMail, userPassword, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(getApplicationContext(), "Verifier vos saisies", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
