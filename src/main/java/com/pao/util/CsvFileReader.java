package com.pao.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.pao.model.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {

    public static List<Produs> ReadProdusCsv(){
        String csvFile = "files.db/produs.csv";
        CSVReader reader = null;
        List<Produs> produse = new ArrayList<>();

            try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            // verifica header
            reader.readNext();
            while ((line = reader.readNext()) != null) {

                //System.out.println("categorie: " + line[0] + ", denumire: " + line[1] + ", pret: " + line[2]);
                Produs produs = new Produs(line[0], line[1], Integer.parseInt(line[2]));
                produse.add(produs);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return produse;
    }

    public static List<Meniu> ReadMeniuCsv(){
        String csvFile = "files.db/meniu.csv";
        CSVReader reader = null;
        List<Meniu> meniuri = new ArrayList<Meniu>();

        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            // verifica header
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                // Assuming CSV file has three columns
                //System.out.println("parolaWifi: " + line[0]);
                Meniu meniu = new Meniu(line[0]);
                meniuri.add(meniu);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return meniuri;
    }

    public static List<Angajat> ReadAngajatCsv(){
        String csvFile = "files.db/angajat.csv";
        CSVReader reader = null;
        List<Angajat> angajati = new ArrayList<Angajat>();

        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            // verifica header
            reader.readNext();
            while ((line = reader.readNext()) != null) {

                //System.out.println("nume: " + line[0] + "prenume: " + line[1] + "varsta: " + line[2] + "dataAngajare: " + line[3] + ", nrTelefon: " + line[4] + ", salariu: " + line[5]);
                Angajat angajat = new Angajat(line[0], line[1], Integer.parseInt(line[2]), line[3], line[4], Integer.parseInt(line[5]) );
                angajati.add(angajat);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return angajati;
    }


    public static List<Client> ReadClientCsv(){
        String csvFile = "files.db/client.csv";
        CSVReader reader = null;
        List<Client> clienti = new ArrayList<Client>();

        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            // verifica header
            reader.readNext();
            while ((line = reader.readNext()) != null) {

                //System.out.println("nume: " + line[0] + ", prenume: " + line[1] + ", varsta: " + line[2] + ", idClient: " + line[3] + ", nrTelefon: " + line[4]);
                Client client = new Client(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), line[4]);
                clienti.add(client);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return clienti;
    }



}
