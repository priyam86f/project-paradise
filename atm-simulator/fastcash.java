import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.*;

public class fastcash extends JFrame implements ActionListener{
JButton hundred,fivehundred,thousand,twothousand,fivethousand,tenthousand,exit;
String pinnumber;
fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image); 

        JLabel text = new JLabel("Select Fast Cash Amount");
        text.setBounds(160,300,700,35);
        text.setFont(new Font("System", Font.BOLD, 20) );
        text.setForeground(Color.WHITE);
        image.add(text);


        //buttons
        hundred = new JButton("₹100");
        hundred.setBounds(150, 415, 100, 36);
        hundred.addActionListener(this);
        image.add(hundred);

        fivehundred = new JButton("₹500");
        fivehundred.setBounds(420, 415, 100, 36);
        fivehundred.addActionListener(this);
        image.add(fivehundred);

        thousand = new JButton("₹1000");
        thousand.setBounds(150, 448, 100, 36);
        thousand.addActionListener(this);
        image.add(thousand);

        twothousand = new JButton("₹2000");
        twothousand.setBounds(420, 448, 100, 36);
        twothousand.addActionListener(this);
        image.add(twothousand);

        fivethousand = new JButton("₹5000");
        fivethousand.setBounds(150, 481, 100, 36);
        fivethousand.addActionListener(this);
        image.add(fivethousand);

        tenthousand = new JButton("₹10000");
        tenthousand.setBounds(420, 481, 100, 36);
        tenthousand.addActionListener(this);
        image.add(tenthousand);

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
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }else{
           String TRANS_AMT = ((JButton)ae.getSource()).getText().substring(1);
           Conn c = new Conn();
           try {
            ResultSet rs = c.s.executeQuery("select * from bank where PIN= '"+pinnumber+"'");
            int balance = 0;
            while(rs.next()){
                if(rs.getString("TRANS_TYPE").equals("Deposit")){
                   balance+=Integer.parseInt(rs.getString("TRANS_AMT"));
                }else{
                    balance-=Integer.parseInt(rs.getString("TRANS_AMT"));
                }
            }



            if(ae.getSource()!=exit && balance<Integer.parseInt(TRANS_AMT)){
                JOptionPane.showMessageDialog(null, "Transaction Failed. \n Insufficient Balance.");
                return;
            }

            Date date = new Date();
            String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+TRANS_AMT+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs"+TRANS_AMT+" Debited Successfully!");


            setVisible(false);
            new transactions(pinnumber).setVisible(true);
           } catch (Exception e) {
            System.out.println(e);
           }
        }
    }
    public static void main(String[] args) {
        new fastcash("");
    }
}
