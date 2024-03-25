import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.*;


public class pinchange extends JFrame implements ActionListener {
String pinnumber;
JButton change,repinButton;
JPasswordField repinTextField,pinchangeTextField;
    pinchange(String pinnumber){
    this.pinnumber=pinnumber;

         setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image); 


        JLabel text = new JLabel("Change your PIN:");
        text.setBounds(260,300,700,35);
        text.setFont(new Font("System", Font.BOLD, 18) );
        text.setForeground(Color.WHITE);
        image.add(text);  

        JLabel newpin = new JLabel("Enter New PIN:");
        newpin.setBounds(180,380,700,35);
        newpin.setFont(new Font("System", Font.BOLD, 18) );
        newpin.setForeground(Color.WHITE);
        image.add(newpin);

        pinchangeTextField = new JPasswordField ();
        pinchangeTextField.setBounds(390,380,100,35);
        image.add(pinchangeTextField);

        JLabel repin = new JLabel("Re-Enter New Pin:");
        repin.setBounds(180,440,700,35);
        repin.setFont(new Font("System", Font.BOLD, 18) );
        repin.setForeground(Color.WHITE);
        image.add(repin);

       repinTextField = new JPasswordField ();
        repinTextField.setBounds(390,440,100,35);
        image.add(repinTextField);

        change = new JButton("CHANGE");
        change.setBounds(380, 480, 120, 30);
        change.addActionListener(this);
        image.add(change);

        repinButton = new JButton("BACK");
        repinButton.setBounds(380, 480, 120, 30);
        repinButton.addActionListener(this);
        image.add(repinButton);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new pinchange("").setVisible(true);
    }



public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==change){
    try {
        String PIN = pinchangeTextField.getText();
        String NEWPIN = repinTextField.getText();

        if(!PIN.equals(NEWPIN)){
            JOptionPane.showMessageDialog(null, "PINs do not Match!");
            return;
        }

        if(PIN.equals("")){
            JOptionPane.showMessageDialog(null, "PIN cannot be empty.");
            return;
        }

        if(NEWPIN.equals("")){
            JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
            return;
        }

        Conn conn = new Conn();
        String query1 = "update bank set PIN= '"+NEWPIN+"' where PIN='"+pinnumber+"'  ";
        String query2 = "update login set PIN_NUMBER= '"+NEWPIN+"' where PIN_NUMBER='"+pinnumber+"'  ";
        String query3 = "update signupthree set PIN_NUMBER= '"+NEWPIN+"' where PIN_NUMBER='"+pinnumber+"'  ";

        conn.s.executeUpdate(query1);
        conn.s.executeUpdate(query2);
        conn.s.executeUpdate(query3);

        JOptionPane.showMessageDialog(null, "PIN Changed Successfully!");

        setVisible(false);
        new transactions(NEWPIN).setVisible(true);
    } 
        
     catch (Exception e) {
       System.out.println(e);
    }
}else{
    setVisible(false);
    new transactions(pinnumber).setVisible(true);
}
}

}
