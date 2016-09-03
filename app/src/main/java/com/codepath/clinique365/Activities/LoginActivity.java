package com.codepath.clinique365.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.codepath.clinique365.R;

public class LoginActivity extends AppCompatActivity {

    //variable declaration
    private ProgressBar progress;

    public static final String APP_ID = "272A47E2-AABF-E5EE-FFD1-DDBCDF73C100" ;
    public static final String SECRET_KEY = "6C364D36-4714-4B99-FF27-BBCA588A1100";
    public static final String VERSION = "v1";

    private TextView register;
    private ImageView login;
    private EditText email;
    private EditText password;
    private ProgressBar spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");

        Backendless.initApp(this, APP_ID, SECRET_KEY, VERSION);

        setupViews();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finish();
    }

    //find view
    public void setupViews(){
        register = (TextView) findViewById(R.id.tvRegister);
        login = (ImageView) findViewById(R.id.ivLogin);
        email = (EditText) findViewById(R.id.edtEmail);
        password = (EditText) findViewById(R.id.edtPassword);
        progress = (ProgressBar) findViewById(R.id.progressBar);

        //set event on click for register a new user
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });

        //set event to connect a user an use the app
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMail = email.getText().toString();
                String userPassword = password.getText().toString();
                progress.setVisibility(View.VISIBLE);

                //use the backendless login api
                Backendless.UserService.login(userMail, userPassword, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        progress.setVisibility(View.GONE);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                       // spinner.setVisibility(View.GONE);
                        progress.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Verifier vos saisies", Toast.LENGTH_SHORT).show();
                    }
                },true);
            }
        });
    }
}
