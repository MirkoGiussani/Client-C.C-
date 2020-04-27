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

/**
 *
 * @author Mirko
 */
public class EchoClientCC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String hostName = "127.0.0.1";
        int portNumber = 3000;

        try {
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            //bufferedReader da tastiera
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            
            String userInput;
            System.out.print("insert new line: ");
            while ((userInput = stdIn.readLine()) != null) {
                
                out.println(userInput); //scrive sulla soket
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to "
                    + hostName);
            System.exit(1);
        }
    }
    
}
