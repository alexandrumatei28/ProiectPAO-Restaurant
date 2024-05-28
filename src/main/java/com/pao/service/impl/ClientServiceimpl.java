package com.pao.service.impl;
import com.pao.model.Client;
import com.pao.model.Rezervare;
import com.pao.service.*;

import java.sql.*;
import java.util.*;

public class ClientServiceimpl implements ClientService{
    @Override
    public void adaugareRezervare(Rezervare rezervare, Client client) {
        if(client.getRezervari().contains(rezervare))
            System.out.println("Rezervarea exista deja.");
        else {
            System.out.println("Rezervarea a fost adaugata");
            client.adaugareRezervare(rezervare); }
    }

    @Override
    public void stergereRezervare(Rezervare rezervare, Client client) {
        if(!client.getRezervari().contains(rezervare))
            System.out.println("Rezervarea nu exista.");
        else {
            System.out.println("Rezervarea clientului " + client.getNume() + ' ' + client.getPrenume() + " din data de " +
                    rezervare.getDataRez() + " a fost stearsa");
            client.stergereRezervare(rezervare); }
    }

    @Override
    public void cautareRezervare(String data, Client client) {
        List<Rezervare> rezervari = client.getRezervari();
        int ok = 0;
        for(Rezervare rezervare : rezervari){
            if (rezervare.getDataRez().equals(data)) {
                System.out.println("Clientul " + client.getNume() + ' ' + client.getPrenume() + " are rezervare in data de " + data);
                ok =1;
            }
        }
        if(ok==0){
            System.out.println("Clientul " + client.getNume() + ' ' + client.getPrenume() + " nu are rezervare in data de " + data);
        }
    }


    @Override
    public List<Client> SelectAll(){
        List<Client> clienti = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex"))

        {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            ResultSet resultSet = statement.executeQuery("SELECT * FROM client");


            while (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                int varsta = resultSet.getInt("varsta");
                int idClient = resultSet.getInt("idClient");
                String nrTelefon = resultSet.getString("nrTelefon");
                Client client = new Client(nume,prenume,varsta,idClient,nrTelefon);
                clienti.add(client);

            }
        }

        catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }

        return clienti;
    }

    @Override
        public Client ReadById(int id) {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            ResultSet resultSet = statement.executeQuery("SELECT * FROM client WHERE idClient = " + id);


            while (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                int varsta = resultSet.getInt("varsta");
                int idClient = resultSet.getInt("idClient");
                String nrTelefon = resultSet.getString("nrTelefon");

                Client client = new Client(nume,prenume,varsta,idClient,nrTelefon);
                System.out.println("nume: " + nume + "; prenume: " + prenume + "; varsta: " + varsta + "; idClient: " + idClient
                + "; nrTelefon: " + nrTelefon);

                return client;
            }
        } catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }

        return new Client("-", "-", 0, 0, "-");
    }





    @Override
    public void ChangePhoneByName(String nume, String prenume, String telefonNou) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate("UPDATE client SET nrTelefon = '" + telefonNou + "' WHERE nume like '" + nume + "' AND prenume like '" + prenume + "'");
            if (rowsUpdated > 0) {
                System.out.println("Actualizare efectuată cu succes.");
            } else {
                System.out.println("Nu s-a efectuat nicio actualizare.");
            }

        } catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }
    }


    @Override
    public void InsertNewClient(String nume, String prenume, int varsta, String nrTelefon) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate( "INSERT INTO client(nume, prenume, varsta, nrTelefon) VALUES ('"
                    + nume + "', '" + prenume + "', " + varsta + ", '" + nrTelefon + "')");
            if (rowsUpdated > 0) {
                System.out.println("Inserare efectuată cu succes.");
            } else {
                System.out.println("Nu s-a efectuat nicio inserare.");
            }

        } catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }
    }


    @Override
    public void DeleteClient(String nume) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate("DELETE from client WHERE nume like '" + nume + "'");
            if (rowsUpdated > 0) {
                System.out.println("Stergere efectuată cu succes.");
            } else {
                System.out.println("Nu s-a efectuat nicio stergere.");
            }

        } catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }
    }

    @Override
    public void CreareTabel() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            statement.executeUpdate("CREATE TABLE Client (nume VARCHAR(255), prenume VARCHAR(255), varsta INT, idClient SERIAL PRIMARY KEY, nrTelefon VARCHAR(255))");
            System.out.println("Tabela Client a fost creata cu succes.");

        } catch (SQLException e) {

            if (e.getSQLState().equals("42P07")) {
                System.out.println("Tabela Client deja există.");
            } else {
                System.out.println("Eroare: " + e);
            }
        }
    }

}
