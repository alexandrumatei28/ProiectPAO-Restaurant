package com.pao.service;

import com.pao.model.Produs;

import java.util.List;
import java.util.Optional;

public interface ProdusService {

    List<Produs> SelectAll();

    Produs ReadByName(String nume);

    void ChangePriceByName(String nume, int pretNou);

    void InsertByName(String categorie, String nume, int pret);

    void DeleteProdus(String nume);

    public void CreareTabel();
}
