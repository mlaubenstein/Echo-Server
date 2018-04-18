import javax.swing.*;
import java.awt.*;

public class ClientFrame extends JFrame {

    ClientFrame(){
    setTitle("ClientChat");
    setForeground ( Color.BLACK );
    ClientPanel panel = new ClientPanel ();
    panel.setSize ( 400,400 );
    add(panel);
    pack(); }
}
