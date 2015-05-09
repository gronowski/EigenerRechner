package eigenerrechner;

/**
 *
 * @author t.gronowski
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EigenerRechner extends JFrame
        implements ActionListener {

    private final JLabel jl = new JLabel("");
    private final JTextField tf = new JTextField("0");
    JButton jb1 = new JButton("1");
    JButton jb2 = new JButton("2");
    JButton jbplus = new JButton("+");
    JButton jbminus = new JButton("-");

    JButton jbgleich = new JButton("=");
    JButton jbclear = new JButton("C");

    //globale Variablen um Zustände zu speichern
    //aktuelle Eingabe
    static Integer eingabe = 0;
    //vorangehende Summe bzw. Zwischenwert
    static Integer alterwert = 0;
    //Aktuelles Resultat schon ausgerechnet, also eingabe+-alterwert
    static Integer aktuell = 0;
    static char operator = ' '; //true = +
    
    static char letzteszeichen=' ';
    

    public EigenerRechner() {
        super("Eigner Rechner");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(null);

        tf.setBounds(20, 200, 100, 20);
        this.add(tf);

        jb1.setBounds(20, 20, 60, 50);
        this.add(jb1);
        jb1.addActionListener(this);

        jb2.setBounds(150, 20, 60, 50);
        this.add(jb2);
        jb2.addActionListener(this);

        jbplus.setBounds(100, 20, 60, 50);
        this.add(jbplus);
        jbplus.addActionListener(this);

        jbminus.setBounds(200, 20, 60, 50);
        this.add(jbminus);
        jbminus.addActionListener(this);

        jbgleich.setBounds(100, 70, 60, 50);
        this.add(jbgleich);
        jbgleich.addActionListener(this);

        jbclear.setBounds(100, 120, 60, 50);
        this.add(jbclear);
        jbclear.addActionListener(this);

        jl.setBounds(20, 230, 200, 50);
        this.add(jl);
    }

    public void actionPerformed(ActionEvent e) {

        //Knopf mit Zahl 1
        if (e.getSource() == jb1) {
            alterwert = aktuell;
            String schontext = jl.getText();
            schontext = schontext + "1";
            //in Label schreiben
            jl.setText(schontext);
            //alterwert=Integer.parseInt(tf.getText());

            tf.setText("1");
            
            eingabe = 1;
            if (letzteszeichen=='1')
                eingabe=11;
            if (letzteszeichen=='2')
                eingabe=21;

            if (operator == '+') {
                aktuell = eingabe + alterwert;
            }
            if (operator == '-') {
                aktuell = alterwert - eingabe;
            }
            if (operator == ' ') {
                aktuell = eingabe;
            }

            letzteszeichen='1';
            
            System.out.println("Alterwert: " + alterwert + " Eingabe: " + eingabe + " Aktuell: " + aktuell);
        }

        //Knopf mit Zahl 2
        if (e.getSource() == jb2) {
            alterwert = aktuell;
            String schontext = jl.getText();
            schontext = schontext + "2";
            jl.setText(schontext);

            tf.setText("2");
            eingabe = 2;
              if (letzteszeichen=='1')
                eingabe=12;
            if (letzteszeichen=='2')
                eingabe=22;


            //Operator muss gespeichert werden, damit man weiss, ob die nächste 
            //eingegebene Zahl addiert oder subtrahiert werden muss.
            if (operator == '+') {
                aktuell = eingabe + alterwert;
            }
            if (operator == '-') {
                aktuell = alterwert - eingabe;
            }
            if (operator == ' ') {
                aktuell = eingabe;
            }
             letzteszeichen='2';

        }

        if (e.getSource() == jbplus) {
            String schontext = jl.getText();
            schontext = schontext + "+";
            jl.setText(schontext);
            operator = '+';
            letzteszeichen='+';

            //falsch, bei Eingabe von + ist nächste Zahl unbekannt
            // String s = tf.getText();  //aktuellen Text einlesen
            // Integer zahl = Integer.parseInt(s, 10);
            // aktuell = eingabe + alterwert;
            // String szahl = aktuell.toString();
            // tf.setText(szahl);
        }

        if (e.getSource() == jbminus) {
            String schontext = jl.getText();
            schontext = schontext + "-";
            jl.setText(schontext);
            operator = '-';
             letzteszeichen='-';
            //String s = tf.getText();  //aktuellen Text einlesen
            //Integer zahl = Integer.parseInt(s, 10);
            //aktuell = eingabe - alterwert;
            //String szahl = aktuell.toString();
            //tf.setText(szahl);

        }

        if (e.getSource() == jbgleich) {

            String schontext = jl.getText();
            //aktuell = alterwert + eingabe;
            schontext = schontext + "=" + aktuell.toString();
            jl.setText(schontext);
            tf.setText(aktuell.toString());
             letzteszeichen='=';
        }

        if (e.getSource() == jbclear) {
            jl.setText("");
            tf.setText("0");
            operator = ' ';
            eingabe = 0;
            aktuell = 0;
            alterwert = 0;
            letzteszeichen=' ';
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EigenerRechner er = new EigenerRechner();
        er.setVisible(true);
    }

}
