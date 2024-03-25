import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class transactions extends JFrame implements ActionListener{
JButton deposit,withdrawal,fastcash,ministatement,pinchange,balanceenq,exit;
String pinnumber;
    transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image); 

        JLabel text = new JLabel("Please Select your Transaction:");
        text.setBounds(160,300,700,35);
        text.setFont(new Font("System", Font.BOLD, 22) );
        text.setForeground(Color.WHITE);
        image.add(text);


        //buttons
        deposit = new JButton("Deposit");
        deposit.setBounds(150, 415, 100, 36);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(420, 415, 100, 36);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(150, 448, 100, 36);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(420, 448, 100, 36);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("PIN Change");
        pinchange.setBounds(150, 481, 100, 36);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenq = new JButton("Balance Enquiry");
        balanceenq.setBounds(420, 481, 100, 36);
        balanceenq.addActionListener(this);
        image.add(balanceenq);

        exit = new JButton("EXIT");
        exit.setBounds(280, 514, 100, 36);
        exit.addActionListener(this);
        image.add(exit);



        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawal){
            setVisible(false);
            new withdraw(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            new fastcash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            setVisible(false);
            new ministatement(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenq){
            setVisible(false);
            new balanceEnquiry(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new transactions("");
    }
}
