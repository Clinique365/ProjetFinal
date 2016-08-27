package com.codepath.clinique365.Models;

import java.util.Date;

/**
 * Created by SET JETRO on 8/22/2016.
 */
public class Visite {

    private String objectId;
    private String dateVisite;
    private String symptomes;
    private String histoireMedicale;
    private String diagnostique;
    private String notes;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(String dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getSymptomes() {
        return symptomes;
    }

    public void setSymptomes(String symptomes) {
        this.symptomes = symptomes;
    }

    public String getHistoireMedicale() {
        return histoireMedicale;
    }

    public void setHistoireMedicale(String histoireMedicale) {
        this.histoireMedicale = histoireMedicale;
    }

    public String getDiagnostique() {
        return diagnostique;
    }

    public void setDiagnostique(String diagnostique) {
        this.diagnostique = diagnostique;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    public Visite(){

    }



}
