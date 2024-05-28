package com.pao.model;

public class MeniuProdus {

    private int idMeniu;

    private int idProdus;

    public MeniuProdus(int idMeniu, int idProdus) {
        this.idMeniu = idMeniu;
        this.idProdus = idProdus;
    }

    public int getIdMeniu() {
        return idMeniu;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public void setIdMeniu(int idMeniu) {
        this.idMeniu = idMeniu;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }
}
