package com.pao.service.impl;
import com.pao.model.Meniu;
import com.pao.model.Produs;
import com.pao.service.*;
import com.pao.util.CsvFileWriter;

import java.sql.*;
import java.util.*;

public class MeniuServiceImpl implements MeniuService{

    @Override
    public void adaugareProdus(Produs produs, Meniu meniu) {
        if(meniu.getProduse().contains(produs))
            System.out.println("Produsul se afla deja in meniu");
        else {
            System.out.println("Produsul " + produs.getDenumire() + " a fost adaugat in meniu");
            meniu.adaugareProdus(produs); }

        CsvFileWriter.WriteAuditCsv("adaugareProdus");
    }

    @Override
    public void stergereProdus(Produs produs, Meniu meniu) {
        if(!meniu.getProduse().contains(produs))
            System.out.println("Produsul nu se afla in meniu");
        else {
            System.out.println("Produsul " + produs.getDenumire() + " a fost sters din meniu");
            meniu.stergereProdus(produs); }

        CsvFileWriter.WriteAuditCsv("stergereProdus");

    }

    @Override
    public void sortareProduse(Meniu meniu) {

        List<Produs> produse = meniu.getProduse();

        Comparator<Produs> comparator = new Comparator<Produs>() {
            @Override
            public int compare(Produs p1, Produs p2) {
                int rezultatCompararePret = Double.compare(p1.getPret(), p2.getPret());
                if (rezultatCompararePret != 0) {

                    return rezultatCompararePret;
                } else {

                    return p1.getDenumire().compareTo(p2.getDenumire());
                }
            }
        };

        produse.sort(comparator);

        CsvFileWriter.WriteAuditCsv("sortareProduse");
    }

    @Override
    public void numarProduse(Meniu meniu) {
        int nrProduse = meniu.getProduse().size();
        System.out.println("Meniul are " + nrProduse + " produse");
        CsvFileWriter.WriteAuditCsv("numarareProduse");
    }

    @Override
    public void afisareProduse(Meniu meniu) {
        List<Produs> produse = meniu.getProduse();

        System.out.println(produse);
        CsvFileWriter.WriteAuditCsv("afisareProduse");
    }

    @Override
    public void cautareProdusCategorie(String categorie, Meniu meniu) {
        List<Produs> produse = meniu.getProduse();
        int ok = 0;
        for(Produs p: produse){
            if(p.getCategorie().equals(categorie)){
                System.out.println(p.toString());
                ok = 1;
            }
        }
        if(ok == 0){
            System.out.println("Nu exista niciun produs cu categoria aceasta.");
        }

        CsvFileWriter.WriteAuditCsv("cautareProdusCategorie");
    }

    @Override
    public void cautareProdusNume(String nume, Meniu meniu) {
        List<Produs> produse = meniu.getProduse();
        int ok = 0;
        for(Produs p: produse){
            if(p.getDenumire().equals(nume)){
                System.out.println(p);
                ok = 1;
            }
        }
        if(ok == 0){
            System.out.println("Nu exista niciun produs cu denumirea aceasta.");
        }
        CsvFileWriter.WriteAuditCsv("cautareProdusNume");
    }


    @Override
    public List<Meniu> SelectAll(){
        List<Meniu> meniuri = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex"))

        {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            ResultSet resultSet = statement.executeQuery("SELECT * FROM meniu");


            while (resultSet.next()) {
                String parolaWifi = resultSet.getString("parolaWifi");
                int idMeniu = resultSet.getInt("id");
                Meniu meniu = new Meniu(idMeniu, parolaWifi);
                meniuri.add(meniu);

            }
        }

        catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }


        return meniuri;
    }


    @Override
    public Meniu ReadById(int id) {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            ResultSet resultSet = statement.executeQuery("SELECT * FROM meniu WHERE id = " + id);


            while (resultSet.next()) {
                String parolaWifi = resultSet.getString("parolaWifi");
                int idMeniu = resultSet.getInt("id");

                Meniu meniu = new Meniu(idMeniu,parolaWifi);
                System.out.println("Meniul cu id-ul: " + idMeniu + " si parolaWifi: " + parolaWifi);
                return meniu;
            }
        } catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }

        return new Meniu("-");
    }



    @Override
    public void ChangeWifiById(int id, String parolaNoua) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate("UPDATE meniu SET parolaWifi = '" + parolaNoua + "' WHERE id = " + id);
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
    public void InsertNewMenu(String parolaWifi) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate("INSERT INTO meniu(parolaWifi) VALUES ('" + parolaWifi +"')");
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
    public void DeleteMeniu(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate("DELETE from meniu WHERE id = " + id);
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

            statement.executeUpdate("CREATE TABLE Meniu (id SERIAL PRIMARY KEY, parolaWifi VARCHAR(255))");
            System.out.println("Tabela Meniu a fost creata cu succes.");

        } catch (SQLException e) {

            if (e.getSQLState().equals("42P07")) {
                System.out.println("Tabela Meniu deja există.");
            } else {
                System.out.println("Eroare: " + e);
            }
        }
    }


}
