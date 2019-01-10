package com.handball.classes;

public class clsvideos {


    private String id;
    private String url;
    private String titre;

    public clsvideos(String id, String url, String titre) {
        this.id = id;
        this.url = url;
        this.titre = titre;
    }

    public clsvideos() {
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitre() {
        return titre;
    }
}
