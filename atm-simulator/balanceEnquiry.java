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


public class balanceEnquiry extends JFrame implements ActionListener  {
    String pinchange;
    JButton back;
    balanceEnquiry(String pinchange){
      this.pinchange=pinchange;

       setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image); 



        back = new JButton("BACK");
        back.setBounds(355, 520, 120, 30);
        back.addActionListener(this);
        image.add(back);

        
        Conn c = new Conn();
        int balance = 0;
           try {
            ResultSet rs = c.s.executeQuery("select * from bank where PIN= '"+pinchange+"'");
            
            while(rs.next()){
                if(rs.getString("TRANS_TYPE").equals("Deposit")){
                   balance+=Integer.parseInt(rs.getString("TRANS_AMT"));
                }else{
                    balance-=Integer.parseInt(rs.getString("TRANS_AMT"));
                }
            }
        }catch (Exception e){
         System.out.println(e);
        }

        JLabel balanceLabel = new JLabel("Account Balance : "+balance);
        balanceLabel.setBounds(180, 300, 400, 30);
        balanceLabel.setForeground(Color.white);
       image.add(balanceLabel);


       
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new transactions(pinchange).setVisible(true);
        if(ae.getSource()==back){

        }
    }
    public static void main(String[] args) {
        new balanceEnquiry("");
    }
}
