
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main (String [] args){


        ServerSocket server;
        String string;

    {
        try {
            //Server erstellen, alle Adressen über 1000 sollten funktionieren
            server = new ServerSocket ( 6666 );
            System.out.println ( "Server started" );

            //Client erzeugen (eingehende Verbindung)/ accept wartet auf eine neu connection
            Socket client = server.accept ();

            //Streams kommen
            OutputStream outputStream = client.getOutputStream ();
            //Geht nicht bei Bytecode
            PrintWriter writer = new PrintWriter (outputStream);

            InputStream inputStream = client.getInputStream ();

            BufferedReader reader = new BufferedReader ( new InputStreamReader ( inputStream ) );

            string = null;

            //auslesen der Zeilen, bis ein null Operator auftritt
            while ((string = reader.readLine ())!= null)System.out.println ( "Got from client" + string );

            writer.close ();
            reader.close ();





        }catch (IOException e) {
            e.printStackTrace ();
        }
    }


}
}
