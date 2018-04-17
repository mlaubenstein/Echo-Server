import com.sun.xml.internal.bind.v2.TODO;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main (String [] args){

        Socket client;
        Scanner scan;
        OutputStream outputStream;
        PrintWriter writer;
        InputStream inputStream;
        BufferedReader reader;
        String string;

        try {

            //Client built which is pointing at the server
            client = new Socket ( "localhost", 6666 );
            System.out.println ( "Client started" );

            scan = new Scanner ( System.in );
            String scanner = scan.nextLine ();

            //Streams getting
            outputStream = client.getOutputStream ();
            //Is not working with Bytecode
            writer = new PrintWriter (outputStream);

            inputStream = client.getInputStream ();

            reader = new BufferedReader ( new InputStreamReader ( inputStream ) );

            writer.write (  scanner + "\n");
            //flushes the stream
            writer.flush ();

            string = null;

            //Print the Stream coming from the Server
            while ((string = reader.readLine())!= null){
                System.out.println ( "Got from Server : " + string );

            }

            writer.close ();
           reader.close ();
        } catch (IOException e) {
            e.printStackTrace ();
            //TODO Auto-generated catch block
        }
    }
}
