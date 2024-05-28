package com.pao.service.impl;

import com.pao.model.Produs;
import com.pao.service.ProdusService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdusServiceImpl implements ProdusService {

    @Override
    public Produs ReadByName(String denumire) {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            ResultSet resultSet = statement.executeQuery("SELECT * FROM produs WHERE denumire like '" + denumire + "'");


            while (resultSet.next()) {
                String categorie = resultSet.getString("categorie");
                denumire = resultSet.getString("denumire");
                int pret = resultSet.getInt("pret");
                Produs produs = new Produs(categorie, denumire, pret);
                System.out.println("Categorie: " + categorie + ", Denumire: " + denumire + ", Pret: " + pret);
                return produs;
            }
        } catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }

        return new Produs("-", "-", 0);
    }


    @Override
    public void InsertByName(String categorie, String denumire, int pret) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate("INSERT INTO produs(categorie,denumire,pret) VALUES ('" + categorie + "','" + denumire + "','" + pret+"')");
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
    public void ChangePriceByName(String denumire, int pretNou) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate("UPDATE produs SET pret =" + pretNou + " WHERE denumire like '" + denumire + "'");
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
    public void DeleteProdus(String denumire) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate("DELETE from produs WHERE denumire like '" + denumire + "'");
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
    public List<Produs> SelectAll(){
        List<Produs> produse = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex"))

        {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            ResultSet resultSet = statement.executeQuery("SELECT * FROM produs");


            while (resultSet.next()) {
                String categorie = resultSet.getString("categorie");
                String denumire = resultSet.getString("denumire");
                int pret   = resultSet.getInt("pret");
                Produs produs = new Produs(categorie,denumire,pret);
                produse.add(produs);

            }
        }

        catch (SQLException e) {
            System.out.println("Eroare: " + e);
        }


        return produse;
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

            statement.executeUpdate("CREATE TABLE Produs (categorie VARCHAR(255), denumire VARCHAR(255), pret INT)");
            System.out.println("Tabela Produs a fost creata cu succes.");

        } catch (SQLException e) {

            if (e.getSQLState().equals("42P07")) {
                System.out.println("Tabela Produs deja există.");
            } else {
                System.out.println("Eroare: " + e);
            }
        }
    }

}


