import java.io.*;
import java.net.Socket;


public class Use implements Runnable{


    protected String string;
    protected Socket client;
    protected OutputStream outputStream;
    protected PrintWriter writer;
    protected InputStream inputStream;
    protected BufferedReader reader;

    public Use (Socket client){ this.client = client; }

    @Override
    public void run(){

        try{
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
            client.close ();

        }

        catch (IOException e) {
            e.printStackTrace ();
            //TODO Auto-generated catch block
        }
    }
}
//flush()
//The java.io.Writer.flush() method flushes the stream. If the stream has saved
//any characters from the various write() methods in a buffer, write them
//immediately to their intended destination. Then, if that destination is another
//character or byte stream, flush it. Thus one flush() invocation will flush all
//the buffers in a chain of Writers and OutputStreams.