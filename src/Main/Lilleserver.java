package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Lilleserver implements Runnable{
    private Socket client;
    public Lilleserver(Socket client){
        this.client=client;
    }
    @Override
    public void run(){
        try {
            System.out.println("client connected");
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            //true, flush, means that the writer sends a line hop to say, "hey i am done writing"; and it flushes everyting it got
            BufferedReader readtheclient = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while (true) {

                String s;
                System.out.println("waiting the String");
                s = readtheclient.readLine();
                System.out.println("message received: " + s);
                writer.println(s.toUpperCase());
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
