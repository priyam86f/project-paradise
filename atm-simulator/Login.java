import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    //global declaration of buttons
JButton login,clear,signup;
JTextField cardTextField;
JPasswordField ATMTextField;
    public Login(){
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("img/logo.jpg"));
        //scale image
        Image img2 = img.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel label = new JLabel(img3);
        setLayout(null);
        label.setBounds(70, 10, 100, 100);
        add(label);
        getContentPane().setBackground(Color.WHITE);

        JLabel label2 = new JLabel("Welcome to ATM");
        label2.setBounds(200,40,400,40);
        label2.setFont(new Font("Osward",Font.BOLD,38));
        add(label2);
     

        JLabel cardno = new JLabel("Card No.");
        cardno.setBounds(120,100,400,200);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,175,250,40);
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(120,160,400,200);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        add(pin);

        ATMTextField = new JPasswordField();
        ATMTextField.setBounds(300,250,250,40);
        add(ATMTextField);
        
        login = new JButton("LOGIN");
        login.setBounds(150,350,150,50);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(300,350,150,50);
        clear.setBackground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(450,350,150,50);
        signup.addActionListener(this);
        add(signup);


        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        setTitle("VirtualATM");
    }

    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==clear){
          cardTextField.setText("");
          ATMTextField.setText("");
       }else if(ae.getSource()==signup){
        setVisible(false);
        new Signup().setVisible(true);
       }else if(ae.getSource()==login){
        Conn conn = new Conn();
        String cardnumber = cardTextField.getText();
        String pinnumber = ATMTextField.getText();
        String query = "select * from login where CARD_NUMBER =  '"+cardnumber+"'and PIN_NUMBER='"+pinnumber+"'";
        try {
            ResultSet rs =conn.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new transactions(pinnumber).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
            }
        } catch (Exception e) {
           System.out.println(e);
        }
       }
    }
    public static void main(String[] args) {
        new Login();
    }
}