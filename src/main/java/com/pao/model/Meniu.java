package com.pao.model;
import java.util.*;

public class Meniu {

    private int idMeniu;
    private List<Produs> produse;

    private String parolaWifi;

    public List<Produs> getProduse() {
        return produse;
    }

    public String getParolaWifi() {
        return parolaWifi;
    }

    public int getIdMeniu() {
        return idMeniu;
    }

    public void setParolaWifi(String parolaWifi) {
        this.parolaWifi = parolaWifi;
    }

    public Meniu( String parolaWifi) {
        this.produse = new ArrayList<>();
        this.parolaWifi = parolaWifi;
    }

    public Meniu(int idMeniu, String parolaWifi) {
        this.idMeniu = idMeniu;
        this.produse = new ArrayList<>();
        this.parolaWifi = parolaWifi;
    }

    public Meniu() {
    }

    public void adaugareProdus(Produs produs){
        this.produse.add(produs);
    }

    public void stergereProdus(Produs produs){
        this.produse.remove(produs);
    }
}
