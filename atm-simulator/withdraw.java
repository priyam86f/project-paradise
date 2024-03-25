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
import javax.swing.JTextField;
import java.util.*;
public class withdraw extends JFrame implements ActionListener {

    JButton withdrawBtn, backBtn;
    String pinnumber;
    JTextField amount;
    withdraw(String pinnumber){
        this.pinnumber=pinnumber;

         setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image); 

        JLabel text = new JLabel("Please Enter the Withdrawal Amount:");
        text.setBounds(160,300,700,35);
        text.setFont(new Font("System", Font.BOLD, 18) );
        text.setForeground(Color.WHITE);
        image.add(text);

       amount = new JTextField();
       amount.setBounds(160,350, 350, 35);
       amount.setFont(new Font("System", Font.BOLD, 20) );
       image.add(amount);

       withdrawBtn = new JButton("Withdraw");
       withdrawBtn.setBounds(420, 485, 100, 30);
       withdrawBtn.addActionListener(this);
       image.add(withdrawBtn);

       backBtn = new JButton("Back");
       backBtn.setBounds(420, 520, 100, 30);
       backBtn.addActionListener(this);
       image.add(backBtn);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{        
            String withDrawamount = amount.getText();
            Date date = new Date();
            if(ae.getSource()==withdrawBtn){
                if(amount.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("TRANS_TYPE").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("TRANS_AMT"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("TRANS_AMT"));
                       }
                    }
                    if(balance < Integer.parseInt(withDrawamount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+withDrawamount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+withDrawamount+" Debited Successfully");
                    
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);
                }
            }else if(ae.getSource()==backBtn){
                setVisible(false);
                new transactions(pinnumber).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
    public static void main(String[] args) {
        new withdraw("");
    }
}
