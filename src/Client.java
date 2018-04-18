import com.sun.xml.internal.bind.v2.TODO;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

    private String usename;
    private String message;

    public static void main (String [] args){

        //new Thread ( new Client () ).start ();


        ClientFrame clientFrame = new ClientFrame ();
        clientFrame.setVisible ( true );





    }

    @Override
    public void run() {

        Socket client;
        OutputStream outputStream;
        PrintWriter writer;
        InputStream inputStream;
        BufferedReader reader;
        String string;




        try {


            //Client built which is pointing at the server
            client = new Socket ( "localhost", 6666 );
            System.out.println ( "Client started" );

            //scan = new Scanner ( System.in );
            //String scanner = scan.nextLine ();

            //Streams getting
            outputStream = client.getOutputStream ();
            //Is not working with Bytecode
            writer = new PrintWriter (outputStream);

            inputStream = client.getInputStream ();

            reader = new BufferedReader ( new InputStreamReader ( inputStream ) );

            writer.write (  getdataName () + " : " +getdataMessage () + "\n");
            //flushes the stream
            writer.flush ();

            //Print the Stream coming from the Server
            while ((string = reader.readLine())!= null){

                System.out.println ( "Got from Server : " + string );

            }

            writer.close ();
            reader.close ();

        }
        catch (IOException e){
            e.printStackTrace ();
            //TODO Auto-generated catch block
        }


    }
    public void setdataName(String usename){
        System.out.println ( usename );
        this.usename = usename;
    }
    public String getdataName (){
        return this.usename;
    }

    public void setdataMessage(String message) {
        System.out.println ( message );
        this.message = message;
    }
    public String getdataMessage(){
        return this.message;
    }


}

//Runnable
//In addition, Runnable provides the means for a class to be active while
// not subclassing Thread. A class that implements Runnable can run without
// subclassing Thread by instantiating a Thread instance and passing itself
// in as the target. In most cases, the Runnable interface should be used if
// you are only planning to override the run() method and no other Thread
// methods. This is important because classes should not be subclassed unless
// the programmer intends on modifying or enhancing the fundamental behavior of the class.