
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main (String [] args){
        ServerSocket server;
        ExecutorService executorService = Executors.newFixedThreadPool (30);

        try {
            server = new ServerSocket ( 6666 );
            System.out.println ( "Server started" );

            while (true){

                try {
                    //Server erstellen, alle Adressen über 1000 sollten funktionieren
                    Socket client = server.accept ();

                    //             Thread thread1 = new Thread ( new Use (client) );
                    //             thread1.start ();
                    executorService.execute ( new Use (client) );

                }catch (IOException e) {
                    e.printStackTrace ();
                    //TODO Auto-generated catch block
                }
            }
        } catch (IOException e) {
            e.printStackTrace ();
            //TODO Auto-generated catch block
        }




    }



}

