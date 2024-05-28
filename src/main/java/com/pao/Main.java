package com.pao;

import com.pao.service.impl.*;
import com.pao.service.*;
import com.pao.model.*;
import com.pao.util.*;

import java.util.List;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        MeniuService meniuService = new MeniuServiceImpl();
        ClientService clientService = new ClientServiceimpl();
        ProdusService produsService = new ProdusServiceImpl();
        AngajatService angajatService = new AngajatServiceImpl();
        MeniuProdusService meniuProdusService = new MeniuProdusServiceImpl();


        /* Etapa 1
        Produs produs1 = new Produs("Mancare", "Pizza", 35);
        Produs produs2 = new Produs("Mancare", "Shaorma", 20);
        Produs produs3 = new Produs("Bautura", "Coca Cola", 12);
        Produs produs4 = new Produs("Bautura", "Apa plata", 12);
        Produs produs5 = new Produs("Mancare", "Cartofi prajiti", 15);
         */

        //* Etapa 2

        List<Produs> produse = CsvFileReader.ReadProdusCsv();
        System.out.println('\n' + "Produse");
        for (Produs produs : produse)
            System.out.println("categorie: " + produs.getCategorie() + ", denumire: " + produs.getDenumire() + ", pret: " + produs.getPret());


        //Meniu meniu1 = new Meniu("abc123");

        List<Meniu> meniuri = CsvFileReader.ReadMeniuCsv();
        System.out.println('\n' + "Meniu");

        for (Meniu value : meniuri)
            System.out.println("parolaWifi: " + value.getParolaWifi());

        /* Etapa 1
        //Adaugare produse in meniu
        meniuService.adaugareProdus(produs1, meniu1);
        meniuService.adaugareProdus(produs2, meniu1);
        meniuService.adaugareProdus(produs3, meniu1);
        meniuService.adaugareProdus(produs4, meniu1);
        meniuService.adaugareProdus(produs5, meniu1);
        */

        for (Produs produs : produse)
            meniuService.adaugareProdus(produs, meniuri.get(0));

        //Etapa 1
        //  Client client1 = new Client("Matei", "Alex", 20, 1, "0767295774");

        List<Client> clienti = CsvFileReader.ReadClientCsv();
        System.out.println('\n' + "Client");

        for (Client value : clienti) {
            System.out.println("nume: " + value.getNume() + ", prenume: " + value.getPrenume() + ", varsta: "
                    + value.getVarsta() + ", idClient: " + value.getIdClient() + ", nrTelefon: " + value.getNrTelefon());
        }


        List<Angajat> angajati = CsvFileReader.ReadAngajatCsv();
        System.out.println('\n' + "Angajat");

        for (Angajat value : angajati) {
            System.out.println("nume: " + value.getNume() + ", prenume: " + value.getPrenume() + ", varsta: "
                    + value.getVarsta() + ", dataAngajare: " + value.getData_angajare()
                    + ", nrTelefon: " + value.getNrTelefon() + ", salariu: " + value.getSalariu());
        }

        //Etapa 2 - scriere in fisier
        Angajat angajat1 = new Angajat("Pavel", "Andrei", 20, "15.07.2023", "0767295774",2500);
        angajati.add(angajat1);

        CsvFileWriter.WriteAngajatCsv(angajati);

        System.out.println();
        /* Etapa 1
        //Stergere produs din meniu
        meniuService.stergereProdus(produs2, meniu1);
        */
        meniuService.stergereProdus(produse.get(1), meniuri.get(0));

        System.out.println();

        /* Etapa 1
        //Sortare produse dupa pret
        meniuService.sortareProduse(meniu1);
         */
        meniuService.sortareProduse(meniuri.get(0));

         /* Etapa 1
        //Afisare produse
        meniuService.afisareProduse(meniu1);
          **/
        meniuService.afisareProduse(meniuri.get(0));

        System.out.println();

         /* Etapa 1
        //Calculeaza cate produse
        meniuService.numarProduse(meniu1);
          */
         meniuService.numarProduse(meniuri.get(0));

        System.out.println();

         /* Etapa 1
        //Cautare produs dupa categorie
        meniuService.cautareProdusCategorie("Mancare",meniu1);
          */
         meniuService.cautareProdusCategorie("Mancare", meniuri.get(0));

        System.out.println();


         /* Etapa 1
        //Cautare produs dupa nume
        meniuService.cautareProdusNume("Apa plata",meniu1);
          */
         meniuService.cautareProdusNume("Apa plata", meniuri.get(0));

        System.out.println();


         /* Etapa 1
        Rezervare rezervare1 = new Rezervare("10.02.2024",client1);
          */

         /* Etapa 1
        //Adaugare rezervare
        clientService.adaugareRezervare(rezervare1,client1);
          */

        System.out.println();

         /* Etapa 1
        //Cautare rezervare dupa data rezervarii
        clientService.cautareRezervare("10.02.2024",client1);
          */

        System.out.println();

         /* Etapa 1
        //Stergere rezervare
        clientService.stergereRezervare(rezervare1,client1);
          */

         //Etapa 3


        //PRODUS

        System.out.println('\n' + "PRODUS" + '\n' + "--------------------");
        List<Produs> prod = produsService.SelectAll();
        for (Produs produs2 : prod)
            System.out.println("categorie: " + produs2.getCategorie() + ", denumire: " + produs2.getDenumire() + ", pret: " + produs2.getPret());


        System.out.println('\n');
        produsService.ReadByName("Shaorma");

        System.out.println('\n');
        produsService.InsertByName("Mancare", "Pizza", 35 );

        System.out.println('\n');
        prod = produsService.SelectAll();
        for (Produs produs1 : prod)
            System.out.println("categorie: " + produs1.getCategorie() + ", denumire: " + produs1.getDenumire() + ", pret: " + produs1.getPret());


        System.out.println('\n');
        produsService.ChangePriceByName("Pizza", 50);
        produsService.ReadByName("Pizza");

        System.out.println('\n');
        produsService.DeleteProdus("Pizza");

        System.out.println('\n');
        prod = produsService.SelectAll();
        for (Produs produs : prod)
            System.out.println("categorie: " + produs.getCategorie() + ", denumire: " + produs.getDenumire() + ", pret: " + produs.getPret());


        //MENIU
        System.out.println('\n' + "MENIU" + '\n' + "--------------------");
        List<Meniu> meniu = meniuService.SelectAll();
        for (Meniu meniu3 : meniu)
            System.out.println("Meniu " + meniu3.getIdMeniu() + " cu parolaWifi: " + meniu3.getParolaWifi());


        System.out.println('\n');
        meniuService.ReadById(1);

        System.out.println('\n');
       // meniuService.InsertNewMenu("Restaurant123");

       // System.out.println('\n');
        meniu = meniuService.SelectAll();
        for (Meniu meniu2 : meniu)
            System.out.println("Meniu " + meniu2.getIdMeniu() + " cu parolaWifi: " + meniu2.getParolaWifi());


        System.out.println('\n');
        meniuService.ChangeWifiById(5, "rest123");
        meniuService.ReadById(5);

        System.out.println('\n');
        meniuService.DeleteMeniu(7);


        System.out.println('\n');
        meniu = meniuService.SelectAll();
        for (Meniu meniu1 : meniu)
            System.out.println("Meniu " + meniu1.getIdMeniu() + " cu parolaWifi: " + meniu1.getParolaWifi());



        //CLIENT
        System.out.println('\n' + "CLIENT" + '\n' + "--------------------");
        List<Client> client = clientService.SelectAll();
        for (Client client3 : client)
            System.out.println("nume: " + client3.getNume() + "; prenume: " + client3.getPrenume() +
                    "; varsta: " + client3.getVarsta() + "; idClient: " + client3.getIdClient()
                    + "; nrTelefon: " + client3.getNrTelefon());


        System.out.println('\n');
        clientService.ReadById(1);

        System.out.println('\n');
        clientService.InsertNewClient("Ion","Andrei",25,"0753612609");

        System.out.println('\n');
        client = clientService.SelectAll();
        for (Client client2 : client)
            System.out.println("nume: " + client2.getNume() + "; prenume: " + client2.getPrenume() +
                    "; varsta: " + client2.getVarsta() + "; idClient: " + client2.getIdClient()
                    + "; nrTelefon: " + client2.getNrTelefon());


        System.out.println('\n');
        clientService.ChangePhoneByName("Tudor", "Octavian","0798252123");
        clientService.ReadById(2);

        System.out.println('\n');
        clientService.DeleteClient("Ion");

        System.out.println('\n');
        client = clientService.SelectAll();
        for (Client client1 : client)
            System.out.println("nume: " + client1.getNume() + "; prenume: " + client1.getPrenume() +
                    "; varsta: " + client1.getVarsta() + "; idClient: " + client1.getIdClient()
                    + "; nrTelefon: " + client1.getNrTelefon());




        //ANGAJAT

        System.out.println('\n' + "ANGAJAT" + '\n' + "--------------------");
        List<Angajat> angajat = angajatService.SelectAll();
        for (Angajat element : angajat)
            System.out.println("nume: " + element.getNume() + "; prenume: " + element.getPrenume() +
                    "; varsta: " + element.getVarsta() + "; dataAngajare: " + element.getData_angajare()
                    + "; nrTelefon: " + element.getNrTelefon() + "; salariu: " + element.getSalariu());


        System.out.println('\n');
        angajatService.ReadById(1);

        System.out.println('\n');
        angajatService.InsertNewAngajat("Ionascu","Corina",40, "15.04.2024", "0790634153", 3000);


        angajat = angajatService.SelectAll();
        for (Angajat item : angajat)
            System.out.println("nume: " + item.getNume() + "; prenume: " + item.getPrenume() +
                    "; varsta: " + item.getVarsta() + "; dataAngajare: " + item.getData_angajare()
                    + "; nrTelefon: " + item.getNrTelefon() + "; salariu: " + item.getSalariu());

        System.out.println('\n');
        angajatService.ChangeSalariuByDataAngajare("01.01.2023");
        angajatService.ReadById(2);

        System.out.println('\n');
        angajatService.DeleteAngajat("Ionascu");

        System.out.println('\n');
        angajat = angajatService.SelectAll();
        for (Angajat value : angajat)
            System.out.println("nume: " + value.getNume() + "; prenume: " + value.getPrenume() +
                    "; varsta: " + value.getVarsta() + "; dataAngajare: " + value.getData_angajare()
                    + "; nrTelefon: " + value.getNrTelefon() + "; salariu: " + value.getSalariu());



    meniuProdusService.CreareTabel();

   // meniuProdusService.AdaugaProdusinMeniu(1,1);
   // meniuProdusService.AdaugaProdusinMeniu(1,2);


    }


}



