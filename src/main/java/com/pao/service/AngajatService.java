package com.pao.service;
import java.util.*;
import com.pao.model.*;
public interface AngajatService {
    List <Angajat> SelectAll();

    void ReadById(int id);

    void ChangeSalariuByDataAngajare(String dataAngajare);

    void InsertNewAngajat(String nume, String prenume, int varsta, String dataAngajare, String nrTelefon, int salariu);

    void DeleteAngajat(String nume);

    void CreareTabel();


}
