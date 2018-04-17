import java.io.*;
import java.net.Socket;

public class Client {

    public static void main (String [] args){

        String string;

        try {
            //Client built which is pointing at the server
            Socket client = new Socket ( "localhost", 6666 );
            System.out.println ( "Client started" );

            //Streams getting
            OutputStream outputStream = client.getOutputStream ();
            //Is not working with Bytecode
            PrintWriter writer = new PrintWriter (outputStream);

            InputStream inputStream = client.getInputStream ();

            BufferedReader reader = new BufferedReader ( new InputStreamReader ( inputStream ) );

            writer.write ( " Hello World ! \n" );
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
        }
    }
}
