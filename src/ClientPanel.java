import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
     * Klasse: Die Klasse UserInterfaceClient stellt das GUI, bzw. das Interface
     * fuer den Client dar, in welchem dieser dann das Chatprogramm zu sehen
     * bekommt.
     */
    public class ClientPanel extends JPanel implements ActionListener {

        /**
         * Attribut: Ein JButton wird deklariert und initialisiert, mit welchem
         * spaeter der eingegebene Text abgeschickt wird.
         */

        private JButton send = new JButton("Senden");

        /**
         * Attribut: Ein JTextField wird deklariert und initialisiert, in welchem
         * spaeter der Text eingegeben wird, welchen der Benutzer an seinen
         * Chatpartner uebermitteln mšchte.
         */

        private JTextField message = new JTextField(10);

        /**
         * Attribut: Ein JTextArea wird deklariert und initialisiert, in welchem
         * spaeter der geschriebene und gesendete Text angezeigt wird.
         */

        private JTextArea chat = new JTextArea(20,20);

        /**
         * Attribut: Ein JTextArea wird deklariert und initialisiert, in welchem die
         * am Chat teilnehmenden Benutzer angezeigt werden.
         */

        // private JTextArea user = new JTextArea(15, 5);

        private JLabel name = new JLabel("Nickname: ");

        private JTextField username = new JTextField(10);

        private JPanel north = new JPanel();

                Client client = new Client ();



        /**
         * Methode: In dieser Methode wird das GUI erstellt, in welchem spaeter der
         * Benutzer das Chatprogramm zu sehen bekommt.
         */

        public ClientPanel() {



            this.setLayout(new FlowLayout());
            this.setSize(300, 400);
            this.setLocation(300, 250);


            // Modifizieren

            chat.setFocusable(false);

            north.add(name);
            north.add(username);

            // Hinzufuegen der Attribute zum Frame
            this.add(north);
            this.add(chat);
            this.add(message);
            this.add(send);

            this.send.addActionListener ( this );
            this.username.addActionListener ( this );
            this.message.addActionListener ( this );




        }

            @Override
            public void actionPerformed(ActionEvent e) {

                if (send == e.getSource ()){
                    System.out.println ( "Senden gedrückt " );
                    client.run ();


                }
                if (username == e.getSource()){

                    String usename = username.getText ();
                    client.setdataName ( usename );

                }
                if ( message == e.getSource ()){

                    String messageText = message.getText ();
                    client.setdataMessage ( messageText );


                }
            }






        }








