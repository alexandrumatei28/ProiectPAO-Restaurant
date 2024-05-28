package com.pao.service;
import java.util.*;
import com.pao.model.*;
public interface ClientService {

    void adaugareRezervare(Rezervare rezervare,Client client);
    void stergereRezervare(Rezervare rezervare,Client client);
    void cautareRezervare(String data,Client client);

    List<Client> SelectAll();

    Client ReadById(int id);

    void ChangePhoneByName(String nume, String prenume, String telefonNou);

    void InsertNewClient(String nume, String prenume, int varsta, String nrTelefon);

    void DeleteClient(String nume);

    void CreareTabel();


}
