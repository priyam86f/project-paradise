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
import javax.swing.JTextField;
import java.util.*;
public class deposit extends JFrame implements ActionListener {

    JButton depositBtn, backBtn;
    String pinnumber;
    JTextField amount;
    deposit(String pinnumber){
        this.pinnumber=pinnumber;

         setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image); 

        JLabel text = new JLabel("Please Enter the Deposit Amount:");
        text.setBounds(160,300,700,35);
        text.setFont(new Font("System", Font.BOLD, 20) );
        text.setForeground(Color.WHITE);
        image.add(text);

       amount = new JTextField();
       amount.setBounds(160,350, 350, 35);
       amount.setFont(new Font("System", Font.BOLD, 20) );
       image.add(amount);

        depositBtn = new JButton("Deposit");
       depositBtn.setBounds(420, 485, 100, 30);
       depositBtn.addActionListener(this);
       image.add(depositBtn);

       backBtn = new JButton("Back");
       backBtn.setBounds(420, 520, 100, 30);
       backBtn.addActionListener(this);
       image.add(backBtn);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==depositBtn){
            String dep_Amount  = amount.getText();
            Date date = new Date();

            if(dep_Amount.isEmpty()){
                JOptionPane.showMessageDialog(null,"Amount cannot be Blank");
            }else{
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+dep_Amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rupees"+dep_Amount+" Deposited Successfully!");
                setVisible(false);  
                new transactions(pinnumber).setVisible(true);  
            }catch(Exception e){
System.out.println(e);
                }
            }

        }else if(ae.getSource()==backBtn){
            setVisible(false);
          new transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new deposit("");
    }
}
