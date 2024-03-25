import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    public Signup3(String formno) {
        this.formno=formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel account = new JLabel("Account Type");
        account.setFont(new Font("Raleway", Font.BOLD, 22));
        account.setBounds(100, 140, 200, 30);
        add(account);

        // radio buttons
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 200, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(300, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(300, 240, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(100, 240, 250, 20);
        add(r4);

        // buttongroup
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        // card number
        JLabel cardnumber = new JLabel("Card Number:");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cardnumber.setBounds(100, 360, 200, 30);
        add(cardnumber);

        //example
        JLabel example = new JLabel("XXXX-XXXX-XXXX-4184");
        example.setFont(new Font("Raleway", Font.BOLD, 22));
        example.setBounds(300, 360, 400, 30);
        add(example);


        JLabel PROMPT1 = new JLabel("Your 16 Digit Card Number");
        PROMPT1.setFont(new Font("Raleway", Font.BOLD, 15));
        PROMPT1.setBounds(100, 385, 400, 30);
        add(PROMPT1);

        //pin
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 420, 400, 30);
        add(pin);

        //pinexample
        JLabel pinexample = new JLabel("XXXX");
        pinexample.setFont(new Font("Raleway", Font.BOLD, 22));
        pinexample.setBounds(300, 420, 400, 30);
        add(pinexample);

        JLabel PROMPT2 = new JLabel("Your 4 Digit PIN");
        PROMPT2.setFont(new Font("Raleway", Font.BOLD, 15));
        PROMPT2.setBounds(100, 440, 400, 30);
        add(PROMPT2);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 525, 400, 30);
        add(services);

        //checkboxes
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 560, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(100, 590, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 620, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(300, 560, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(300, 590, 200, 30);
        add(c5);

        c6 = new  JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(300, 620, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 690, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBounds(100, 740, 150, 30);
        submit.setFont(new Font("Raleway", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(300, 740, 150, 30);
        cancel.setFont(new Font("Raleway", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
           String accountType=null;
           if(r1.isSelected()){
            accountType="Saving Account";
           }
           else if(r2.isSelected()){
            accountType="FD Account";
           }
           else if(r3.isSelected()){
            accountType="Current Account";
           }
           else if(r4.isSelected()){
            accountType="Recurring Account";
           }
//generating account card number...
           Random random = new Random();
           String cardNumber = ""+ Math.abs((random.nextLong() % 90000000L + 5040936000000000L ));
        String pinNumber = ""+Math.abs((random.nextLong() % 9000L + 1000L ));

        String facility="";
        if(c1.isSelected()){
          facility = facility+"ATM Card";
        }else if(c2.isSelected()){
            facility = facility+"Internet Banking";
        }else if(c3.isSelected()){
            facility = facility+"Mobile Banking";
        }
        else if(c4.isSelected()){
            facility = facility+"Email & SMS Alerts";
        }
        else if(c5.isSelected()){
            facility = facility+"Cheque Book";
        }
        else if(c6.isSelected()){
            facility = facility+"E Statement";
        }

        try {
            if(accountType.equals("")){
                JOptionPane.showMessageDialog(null, "Account Type is Required");
            }else{
                Conn conn = new Conn();
                String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Card Number :"+ cardNumber+"\n PIN :"+pinNumber);
            }
           setVisible(false); 
           new deposit(pinNumber).setVisible(false);

        } catch (Exception e) {
           System.out.println(e);
        }
        
        }else if(ae.getSource()==cancel){
          setVisible(false);
          new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
