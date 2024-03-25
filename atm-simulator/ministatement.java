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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.*;

public class ministatement extends JFrame {
String pinnumber;
    ministatement(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
     setTitle("Mini Statement");

     JLabel text = new JLabel();
     text.setFont(new Font("Raleway",Font.ITALIC, 10));
     text.setBounds(20, 20,600,600);
     add(text);

     JLabel mini = new JLabel();
     mini.setBounds(70, 10,300,200);
     add(mini);

     JLabel bank = new JLabel("HDFC Bank");
     bank.setFont(new Font("Raleway",Font.BOLD, 25));
     bank.setBounds(130, 20, 300, 20);
     add(bank);

     JLabel stars = new JLabel("***************");
     stars.setFont(new Font("Raleway",Font.BOLD, 25));
     stars.setBounds(110, 60, 300, 20);
     add(stars);

    //  JLabel cardnumber = new JLabel("Card Number :");
    //  cardnumber.setFont(new Font("Raleway",Font.BOLD, 20));
    //  cardnumber.setBounds(20, 120, 300, 20);
    //  add(cardnumber);

     try {
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from login where PIN_NUMBER = '"+pinnumber+"'");

        while(rs.next()){
            mini.setText("Card Number :"+ rs.getString("CARD_NUMBER").substring(0, 4)+"XXXXXXXX"+rs.getString("CARD_NUMBER").substring(12));
        }
     } catch (Exception e) {
        System.out.println(e);
     }

     try {
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from bank where PIN = '"+pinnumber+"'");

        while(rs.next()){
           text.setText(text.getText()+"<html>"+rs.getString("TRANS_DATE")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"<br><br>"+rs.getString("TRANS_TYPE")+"<br><br>"+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("TRANS_AMT")+"<br><br>");
        }
     } catch (Exception e) {
        System.out.println(e);
     }

     setSize(400,600);
     setLocation(20, 20);
     getContentPane().setBackground(Color.WHITE);
     setVisible(true);
    }
    public static void main(String[] args) {
        new ministatement("");
    }
}
