import java.util.concurrent.*;

public class ThreadDemo {


    

    public static void  main (String [] args){

        System.out.println ( " Countdown: " );
        ExecutorService executorService = Executors.newFixedThreadPool ( 2 );

        Thread thread1 = new Thread ( new Count () );
        Thread thread2 = new Thread ( new Count () );

       // thread1.start ();
       // thread2.start ();

        executorService.execute ( thread1 );
        executorService.execute ( thread2 );
        executorService.shutdown ();

        try {
            //Abwarten, bis der Thread fertig abgelaufen ist
           // thread1.join ();
           // thread2.join ();
            executorService.awaitTermination ( 5, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace ();
            //TODO Auto-generated catch block
        }

        System.out.println ( "GO" );


    }

    static class Count implements Runnable{

        @Override
        public void run() {
            for ( int i = 5; i >= 1; i-- ) {

                System.out.println ( i );


                try {
                    Thread.sleep ( 1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                    //TODO Auto-generated catch block
                    }
            }

        }

    }
}
