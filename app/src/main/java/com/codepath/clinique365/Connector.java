package com.codepath.clinique365;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.codepath.clinique365.Models.Patient;
import com.codepath.clinique365.Models.Users;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SET JETRO on 8/21/2016.
 */
public class Connector extends AppCompatActivity {

    public static void saveUser(String firstname, String lastname, String clinic, String email, String password)
    {
        BackendlessUser user = new BackendlessUser();
        user.setProperty("name", firstname);
        user.setProperty("lastname", lastname);
        user.setProperty("clinic", clinic);
        user.setPassword(password);
        user.setEmail("juniorbest@yahoo.fr");

        //Users saveMeddecin = Backendless.Persistence.save(med);

        Backendless.UserService.register( user, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {

            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }

    public static void savePatient(String firtsname, String lastname, String sex, String age, String adress,
                    String phone, String phoneContact)
    {
        Patient newPatient = new Patient();

        newPatient.setNom(lastname);
        newPatient.setPrenom(firtsname);
        newPatient.setSexe(sex);
        newPatient.setAge(age);
        newPatient.setAdresse(adress);
        newPatient.setTelephone(phone);
        newPatient.setContactTelephone(phoneContact);

        //Users saveMeddecin = Backendless.Persistence.save(med);

        Backendless.Persistence.save( newPatient, new AsyncCallback<Patient>() {
            @Override
            public void handleResponse(Patient response) {

            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }




}
