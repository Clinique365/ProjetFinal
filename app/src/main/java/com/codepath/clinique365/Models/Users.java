package com.codepath.clinique365.Models;

import java.util.List;

/**
 * Created by SET JETRO on 8/21/2016.
 */
public class Users {

    private String objectId;
    private String lastname;
    private String firstname;
    private String clinic;
    private String email;
    private String password;
    private List<Patient> patients;

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }



    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(){

    }

    public String getObjectId()
    {
        return objectId;
    }
    public void setObjectId( String objectId )
    {
        this.objectId = objectId;
    }

}
