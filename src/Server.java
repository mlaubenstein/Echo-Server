
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main (String [] args){


        ServerSocket server;
        String string;
        Socket client;
        OutputStream outputStream;
        PrintWriter writer;
        InputStream inputStream;
        BufferedReader reader;

    {
        try {
            //Server erstellen, alle Adressen über 1000 sollten funktionieren
            server = new ServerSocket ( 6666 );
            System.out.println ( "Server started" );

            //Client erzeugen (eingehende Verbindung)/ accept wartet auf eine neu connection
            client = server.accept ();

            //Streams kommen
            outputStream = client.getOutputStream ();
            //Geht nicht bei Bytecode
            writer = new PrintWriter (outputStream);

            inputStream = client.getInputStream ();

            reader = new BufferedReader ( new InputStreamReader ( inputStream ) );

            string = null;

            //Auslesen der Zeilen, bis ein null Operator auftritt
            while ((string = reader.readLine())!= null){

                //Zurückgeben an Client
                writer.write ( string + "\n" );
                writer.flush ();

                System.out.println ( "Got from client : " + string );

            }

            writer.close ();
            reader.close ();





        }catch (IOException e) {
            e.printStackTrace ();
            //TODO Auto-generated catch block
        }
    }


    //flush()
        //The java.io.Writer.flush() method flushes the stream. If the stream has saved
        //any characters from the various write() methods in a buffer, write them
        //immediately to their intended destination. Then, if that destination is another
        //character or byte stream, flush it. Thus one flush() invocation will flush all
        //the buffers in a chain of Writers and OutputStreams.
}
}
