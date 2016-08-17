package com.codepath.clinique365.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.codepath.clinique365.R;

public class HomeActivity extends AppCompatActivity {

    private ImageView order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        order = (ImageView) findViewById(R.id.ivPatientOrder);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), OrderActivity.class);
                startActivity(i);
            }
        });
    }
}
