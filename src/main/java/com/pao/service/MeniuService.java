package com.pao.service;
import com.pao.model.*;

import java.util.List;

public interface MeniuService {

    public void adaugareProdus(Produs produs, Meniu meniu);
    public void stergereProdus(Produs produs, Meniu meniu);

    public void sortareProduse(Meniu meniu);

    public void numarProduse(Meniu meniu);

    public void afisareProduse(Meniu meniu);


    public void cautareProdusCategorie(String categorie, Meniu meniu);

    public void cautareProdusNume(String nume, Meniu meniu);

    //Etapa 3

    List<Meniu> SelectAll();

    Meniu ReadById(int id);

    void ChangeWifiById(int id, String parolaNoua);

    void InsertNewMenu(String parolaWifi);

    void DeleteMeniu(int id);

    public void CreareTabel();

}
