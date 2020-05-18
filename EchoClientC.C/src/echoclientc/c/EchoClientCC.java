/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoclientc.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Mirko
 */
public class EchoClientCC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String hostName = "127.0.0.1";
        int portNumber = 3000;

        try {
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            //bufferedReader da tastiera
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String response;            
            String userInput;
            System.out.println("1) Login   ||  2) Crea account");
            System.out.print("--> ");
            int opzione = input.nextInt();
            
            switch (opzione) {
                case 1:
                    userInput = "LOG: ";
                    System.out.print("Inserisci nome utente: ");
                    userInput += (input.next() + ": ");
                    System.out.print("Inserisci password: ");
                    userInput += (input.next());
                    out.println(userInput);
                    out.flush();
                    response = in.readLine();   //non risponde il server
                    System.out.println("response: " + response);
                    break;
                case 2:
                    userInput = "CA: ";
                    System.out.print("Inserisci nome: ");
                    userInput += (input.next() + ": ");
                    System.out.print("Inserisci cognome: ");
                    userInput += (input.next() + ": ");
                    System.out.print("Inserisci un recapito telefonico: ");
                    userInput += (input.next() + ": ");
                    System.out.print("Inserisci codice fiscale: ");
                    userInput += input.next();
                    out.println(userInput);
                    break;
                default:
            }

            boolean uscita = false;
            do {
                menu();
                System.out.print("Scegli una opzione: ");
                opzione = input.nextInt();

                switch (opzione) {
                    case 1:
                        userInput = "PREL: ";
                        System.out.print("Inserisci il valore da prelevare in \"€\": ");
                        userInput += input.nextDouble();
                        out.println(userInput);
                        break;
                    case 2:
                        userInput = "VERS: ";
                        System.out.print("Inserisci il valore da versare in \"€\": ");
                        userInput += input.nextDouble();
                        out.println(userInput);
                        break;
                    case 3:
                        userInput = "GC: ";
                        System.out.print("Inserisci l'iban del debitore: ");
                        userInput += (input.next() + ": ");
                        System.out.print("Inserisci l'iban del creditore: ");
                        userInput += (input.next() + ": ");
                        System.out.print("Inserisci la quota in \"€\": ");
                        userInput += input.nextDouble();
                        out.println(userInput);
                        break;
                    case 4:
                        userInput = "SALDO";
                        out.println(userInput);
                        break;
                    case 5:
                        userInput = "LMOV";
                        out.println(userInput);
                        break;
                    case 6:
                        userInput = "ANG";
                        out.println(userInput);
                        break;
                    case 7:
                        System.out.print("Inserisci primo numero: ");
                        userInput = (input.nextInt() + ": ");
                        System.out.print("Inserisci codice corrispondente al primo numero: ");
                        userInput += (input.nextInt() + ": ");
                        System.out.print("Inserisci secondo numero: ");
                        userInput += (input.nextInt() + ": ");
                        System.out.print("Inserisci codice corrispondente al secondo numero: ");
                        userInput += (input.nextInt() + ": ");
                        out.println(userInput);
                        break;
                    case 8:
                        userInput = "BON: ";
                        System.out.print("Inserisci nome creditore: ");
                        userInput += (input.next() + ": ");
                        System.out.print("Inserisci quota creditore in \"€\": ");
                        userInput += input.nextDouble();
                        out.println(userInput);
                        break;
                    case 9:
                        uscita = true;
                        break;
                    default:
                        System.out.println("Attenzione scelta non corretta.");

                }
            } while (uscita == false);

            //scrive sulla soket
            //System.out.println("echo: " + in.readLine());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to "
                    + hostName);
            System.exit(1);
        }
    }

    public static void menu() {
        System.out.println("----- MENU -----");
        System.out.println("1- Prelievo");
        System.out.println("2- Versamento");
        System.out.println("3- Giroconto");
        System.out.println("4- Saldo");
        System.out.println("5- Lista Movimenti");
        System.out.println("6- Visualizza Anagrafica");
        System.out.println("7- Fornisce Codice Carta");
        System.out.println("8- Bonifico");
        System.out.println("9- esci");
        System.out.println("\n");
    }

}
