import java.io.*;
import java.net.Socket;

public class Client {

    public static void main (String [] args){

        String string;

        try {
            //Client erzeugen der auf den Server zeigt
            Socket client = new Socket ( "localhost", 6666 );
            System.out.println ( "Client started" );

            //Streams kommen
            OutputStream outputStream = client.getOutputStream ();
            //Geht nicht bei Bytecode
            PrintWriter writer = new PrintWriter (outputStream);

            InputStream inputStream = client.getInputStream ();

            BufferedReader reader = new BufferedReader ( new InputStreamReader ( inputStream ) );

            string = null;

           writer.write ( " Hello World ! " );
           //flushes the stream
           writer.flush ();

           writer.close ();
           reader.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
