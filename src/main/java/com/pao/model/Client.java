package com.pao.model;
import java.util.*;

public class Client extends Persoana{

    private int idClient;
    private String nrTelefon;
    private final List<Rezervare> rezervari;


    public Client(String nume, String prenume, int varsta, int idClient, String nrTelefon) {
        super(nume, prenume, varsta);
        this.idClient = idClient;
        this.nrTelefon = nrTelefon;
        this.rezervari = new ArrayList<>();
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public List<Rezervare> getRezervari() {
        return rezervari;
    }

    public void adaugareRezervare(Rezervare rezervare){
        rezervari.add(rezervare);
    }
    public void stergereRezervare(Rezervare rezervare){
        rezervari.remove(rezervare);
    }

    @Override
    public String toString(){
        return "idClient: " + idClient;
    }
}
