package com.handball.classes;

public class clsclub {


    private String idclub;
    private String url;
    private String nom;

    public clsclub(String idclub, String url, String nom) {
        this.idclub = idclub;
        this.url = url;
        this.nom = nom;
    }


    public clsclub() {
    }


    public String getIdclub() {
        return idclub;
    }

    public void setIdclub(String idclub) {
        this.idclub = idclub;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
