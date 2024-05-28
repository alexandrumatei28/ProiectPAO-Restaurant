package com.pao.model;

public class Rezervare {

    private String dataRez;

    private Client client;

    public String getDataRez() {
        return dataRez;
    }

    public Client getClient() {
        return client;
    }

    public void setDataRez(String dataRez) {
        this.dataRez = dataRez;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Rezervare(String dataRez, Client client) {
        this.dataRez = dataRez;
        this.client = client;
    }

    public Rezervare() {
    }
}
