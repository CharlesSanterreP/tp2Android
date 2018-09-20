package com.example.santerrecharles.tp2listeetudiants.model;

public class Student {

    private String nom;
    private String prenom;
    private String sexe;
    private String email;
    private String age;
    private String groupe;
    private Boolean redoublant;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getGroupe() {
        return groupe;
    }

    public Boolean getRedoublant() {
        return redoublant;
    }

    @Override
    public String toString() {
        return nom +' ' + prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public void setRedoublant(Boolean redoublant) {
        this.redoublant = redoublant;
    }
}
