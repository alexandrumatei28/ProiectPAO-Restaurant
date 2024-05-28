package com.pao.service.impl;

import com.pao.service.MeniuProdusService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MeniuProdusServiceImpl implements MeniuProdusService {

    @Override
    public void AdaugaProdusinMeniu(int id1, int id2) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            int rowsUpdated = statement.executeUpdate("INSERT INTO meniuprodus(idMeniu,idProdus) VALUES (" + id1 + ", " + id2 + ")");
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
    public void CreareTabel() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant", "postgres", "alex")) {
            Statement statement;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            statement.executeUpdate("CREATE TABLE MeniuProdus (idMeniu INT, idProdus INT, PRIMARY KEY (idMeniu, idProdus))");
            System.out.println("Tabela a fost creata cu succes.");

        } catch (SQLException e) {

            if (e.getSQLState().equals("42P07")) {
                System.out.println("Tabela deja există.");
            } else {
                System.out.println("Eroare: " + e);
            }
        }
    }

}
