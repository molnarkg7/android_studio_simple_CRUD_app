package com.example.kolokvijum;

public class Knjiga {

    int id;
    String autor;
    String naslov;
    int godina;

    public Knjiga(int id, String autor, String naslov, int godina) {
        this.id = id;
        this.autor = autor;
        this.naslov = naslov;
        this.godina = godina;
    }

    @Override
    public String toString() {
        return "Knjiga{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", naslov='" + naslov + '\'' +
                ", godina=" + godina +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }
}
