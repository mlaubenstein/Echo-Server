public class ThreadDemo {


    

    public static void  main (String [] args){

        new Thread (new Count ()).start();
        

    }

    static class Count implements Runnable{

        @Override
        public void run() {
            for ( int i = 5; i >= 0; i-- ) System.out.println ( "Count:"+ i  );
        }
    }
}
