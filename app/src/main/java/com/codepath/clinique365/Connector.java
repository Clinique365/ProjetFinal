package com.codepath.clinique365;

import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.codepath.clinique365.Models.Patient;
import com.codepath.clinique365.Models.Visite;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        user.setEmail(email);


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

        newPatient.setUser(Backendless.UserService.loggedInUser());
        newPatient.setNom(lastname);
        newPatient.setPrenom(firtsname);
        newPatient.setSexe(sex);
        newPatient.setAge(age);
        newPatient.setAdresse(adress);
        newPatient.setTelephone(phone);
        newPatient.setContactTelephone(phoneContact);


        Backendless.Persistence.save( newPatient, new AsyncCallback<Patient>() {
            @Override
            public void handleResponse(Patient response) {

            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }

    public static void saveVisit(String dateVisit, String symptoms, String historyMedical, String diagnostic, String notes)
    {
        Visite newVisit = new Visite();

        newVisit.setDateVisite("test");
        newVisit.setSymptomes("test");
        newVisit.setHistoireMedicale("test");
        newVisit.setDiagnostique("test");
        newVisit.setNotes("test");


        Backendless.Persistence.save(newVisit, new AsyncCallback<Visite>() {
            @Override
            public void handleResponse(Visite response) {

            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }


}
