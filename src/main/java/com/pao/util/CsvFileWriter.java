package com.pao.util;
import com.pao.model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class CsvFileWriter {
    public static void WriteAngajatCsv(List<Angajat> angajati){

        String csvFile = "files.db/angajatNou.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {

            writer.write("nume,prenume,varsta,dataAngajare,nrTelefon,salariu\n");


            for (Angajat angajat : angajati) {
                String line = angajat.getNume() + "," +
                        angajat.getPrenume() + "," +
                        angajat.getVarsta() + "," +
                        angajat.getData_angajare() + "," +
                        angajat.getNrTelefon()+ "," +
                        angajat.getSalariu() + "\n";
                writer.write(line);
            }

            System.out.println("Datele au fost scrise cu succes în fișierul CSV.");
        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fișierul CSV: " + e.getMessage());

        }
    }

    public static void WriteAuditCsv(String numeActiune){

        String csvFile = "files.db/Audit.csv";

        try (FileWriter writer = new FileWriter(csvFile, true)) {


            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);

            String line = numeActiune + "," + timestamp + '\n';
            writer.write(line);



        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fisierul CSV: " + e.getMessage());

        }
    }


}
