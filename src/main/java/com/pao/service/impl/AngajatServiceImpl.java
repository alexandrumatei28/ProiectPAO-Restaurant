package com.pao.service.impl;
import com.pao.model.Angajat;
import com.pao.service.AngajatService;

import java.sql.*;
import java.util.*;


public class AngajatServiceImpl implements AngajatService {

    @Override
    public List<Angajat> SelectAll(){
        List<Angajat> angajati = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex"))

        {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            ResultSet resultSet = statement.executeQuery("SELECT * FROM angajat");


            while (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                int varsta = resultSet.getInt("varsta");
                String dataAngajare = resultSet.getString("dataAngajare");
                String nrTelefon = resultSet.getString("nrTelefon");
                int salariu = resultSet.getInt("salariu");
                //System.out.println("Nume: " + nume + ", Prenume: " + prenume + ", Varsta: " + varsta + ", Data Angajare: " + dataAngajare + ", Numar de telefon: " + nrTelefon + ", Salariu: " + salariu);
                Angajat angajat = new Angajat(nume,prenume,varsta,dataAngajare,nrTelefon,salariu);
                angajati.add(angajat);

            }
        }

        catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }

        return angajati;
    }

    @Override
    public void ReadById(int id) {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            ResultSet resultSet = statement.executeQuery("SELECT * FROM angajat WHERE id = " + id);

            while (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                int varsta = resultSet.getInt("varsta");
                String dataAngajare = resultSet.getString("dataAngajare");
                String nrTelefon = resultSet.getString("nrTelefon");
                int salariu = resultSet.getInt("salariu");

                Angajat angajat = new Angajat(nume,prenume,varsta,dataAngajare,nrTelefon,salariu);
                System.out.println("nume: " + nume + "; prenume: " + prenume + "; varsta: " + varsta + "; dataAngajare: " + dataAngajare
                        + "; nrTelefon: " + nrTelefon  + "; salariu: " + salariu);

                return;
            }
        } catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }

        new Angajat("-", "-", 0, "-", "-", 0);
    }


    @Override
    public void ChangeSalariuByDataAngajare(String dataAngajare) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate("UPDATE angajat SET salariu = salariu * 1.10"
                    + " WHERE TO_DATE(dataAngajare, 'DD.MM.YYYY') <= TO_DATE('" + dataAngajare + "', 'DD.MM.YYYY')");
            if (rowsUpdated > 0) {
                System.out.println("Actualizare efectuata cu succes.");
            } else {
                System.out.println("Nu s-a efectuat nicio actualizare.");
            }

        } catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }
    }



    public void InsertNewAngajat(String nume, String prenume, int varsta, String dataAngajare, String nrTelefon, int salariu){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate( "INSERT INTO angajat(nume, prenume, varsta, dataAngajare, nrTelefon, salariu) VALUES ('"
                    + nume + "', '" + prenume + "', " + varsta + ", '" + dataAngajare + "', '" + nrTelefon + "', " + salariu + ")");
            if (rowsUpdated > 0) {
                System.out.println("Inserare efectuata cu succes.");
            } else {
                System.out.println("Nu s-a efectuat nicio inserare.");
            }

        } catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }
    }


    @Override
    public void DeleteAngajat(String nume) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate("DELETE from angajat WHERE nume like '" + nume + "'");
            if (rowsUpdated > 0) {
                System.out.println("Stergere efectuata cu succes.");
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

            statement.executeUpdate("CREATE TABLE Angajat (id SERIAL PRIMARY KEY, nume VARCHAR(255), prenume VARCHAR(255), varsta INT, dataAngajare VARCHAR(255), nrTelefon VARCHAR(255), salariu INT)");
            System.out.println("Tabela Angajat a fost creata cu succes.");

        } catch (SQLException e) {

            if (e.getSQLState().equals("42P07")) {
                System.out.println("Tabela Angajat deja exista.");
            } else {
                System.out.println("Eroare: " + e);
            }
        }
    }




}






