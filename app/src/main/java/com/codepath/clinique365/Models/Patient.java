package com.codepath.clinique365.Models;

import com.backendless.BackendlessCollection;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by SET JETRO on 8/21/2016.
 */
public class Patient implements Serializable {

    private String objectId;
    private String nom;
    private String prenom;
    private String sexe;
    private String age;
    private String adresse;
    private String telephone;
    private String user;
    private String contactTelephone;
    private String profilPatient;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }




    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public String getProfilPatient() {
        return profilPatient;
    }

    public void setProfilPatient(String profilPatient) {
        this.profilPatient = profilPatient;
    }


    public Patient(){

    }


}
