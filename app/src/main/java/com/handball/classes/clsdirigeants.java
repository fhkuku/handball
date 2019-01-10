package com.handball.classes;

public class clsdirigeants {

    private String id;
    private String nom;
    private String img;
    private String email;
    private String idtype;
    private String rol;
    private String idclub;

    public String getIdclub() {
        return idclub;
    }

    public void setIdclub(String idclub) {
        this.idclub = idclub;
    }

    public clsdirigeants() {
    }

    public clsdirigeants(String id, String nom, String img, String email, String idtype, String rol, String idclub) {
        this.id = id;
        this.nom = nom;
        this.img = img;
        this.email = email;
        this.idtype = idtype;
        this.rol = rol;
        this.idclub = idclub;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
