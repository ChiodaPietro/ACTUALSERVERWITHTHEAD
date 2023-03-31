package Main;
//SERVER_SERVER

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6666);
            while(true) {

                System.out.println("client connected");
                 // accept() == blocking method, waits until the client connects
                ////after the connection i create the thread
                new Thread(new Lilleserver(server.accept())).start();
            }
            //client.close;
        } catch (IOException e) {
            System.out.println("exception during the connection" + e);
        }
    }
}