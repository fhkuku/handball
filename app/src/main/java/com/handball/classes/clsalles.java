package com.handball.classes;

public class clsalles {

    private String id;
    private String nom;
    private String img;
    private String latitud;
    private String longitud;
    private String idclub;
    private String adresse;

    public clsalles() {
    }


    public clsalles(String id, String nom, String img, String latitud, String longitud, String idclub, String adresse) {
        this.id = id;
        this.nom = nom;
        this.img = img;
        this.latitud = latitud;
        this.longitud = longitud;
        this.idclub = idclub;
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getIdclub() {
        return idclub;
    }

    public void setIdclub(String idclub) {
        this.idclub = idclub;
    }
}
