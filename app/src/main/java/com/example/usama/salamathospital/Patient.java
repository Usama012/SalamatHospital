package com.example.usama.salamathospital;

public class Patient {

    String patientCnic;
    String patientName;
    String patientAge;
    String doctorName;
    String totalCharges;
    String dateOfDay;
    String send;
    String recive;
    public Patient()
    {

    }

    public Patient(String patientCnic, String patientName, String patientAge, String doctorName, String totalCharges, String dateOfDay, String send, String recive) {
        this.patientCnic = patientCnic;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.doctorName = doctorName;
        this.totalCharges = totalCharges;
        this.dateOfDay = dateOfDay;
        this.send = send;
        this.recive = recive;
    }

    public String getPatientCnic() {
        return patientCnic;
    }

    public void setPatientCnic(String patientCnic) {
        this.patientCnic = patientCnic;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(String totalCharges) {
        this.totalCharges = totalCharges;
    }

    public String getDateOfDay() {
        return dateOfDay;
    }

    public void setDateOfDay(String dateOfDay) {
        this.dateOfDay = dateOfDay;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getRecive() {
        return recive;
    }

    public void setRecive(String recive) {
        this.recive = recive;
    }
}
