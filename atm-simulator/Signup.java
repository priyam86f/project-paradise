import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener {
long random;
JButton next;
JTextField nameTextField,fnameTextField,dobTextField,emailTextField,marriedTextField,addressTextField,
cityTextField,stateTextField,pinTextField,maritalstatus;
 JRadioButton married,unmarried,male,Female;
    public Signup(){
        //random number on the application form.
        Random ran = new Random();
         random = Math.abs((ran.nextLong()%9000L)+1000L);
        setSize(800,850);
        setLocation(350,10);
        setVisible(true);

        JLabel myJLabel = new JLabel("APPLICATION FORM NO."+random);
        myJLabel.setFont(new Font("Raleway", Font.BOLD,38));
        myJLabel.setBounds(140,20,600,40);
        setLayout(null);
        add(myJLabel);

        JLabel personal_details = new JLabel("Page 1 : Personal Details");
        personal_details.setFont(new Font("Raleway", Font.BOLD,22));
        personal_details.setBounds(250,80,400,30);
       
        add(personal_details);

        JLabel first_name = new JLabel("Name:");
        first_name.setFont(new Font("Raleway", Font.BOLD,22));
        first_name.setBounds(125,160,400,30);
       
        add(first_name);
        

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextField.setBounds(325,160,200,30);
        nameTextField.setBackground(Color.lightGray);
        add(nameTextField);

        JLabel fathers_name = new JLabel("Father's Name:");
        fathers_name.setFont(new Font("Raleway", Font.BOLD,22));
        fathers_name.setBounds(125,220,400,30);
       
        add(fathers_name);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        fnameTextField.setBounds(325,220,200,30);
        fnameTextField.setBackground(Color.lightGray);
        add(fnameTextField);

        JLabel DOB = new JLabel("Date of Birth:");
        DOB.setFont(new Font("Raleway", Font.BOLD,22));
        DOB.setBounds(125,280,200,30);
       
        add(DOB);

    dobTextField = new JTextField();
        dobTextField.setFont(new Font("Raleway", Font.BOLD,14));
        dobTextField.setBounds(325,280,200,30);
        dobTextField.setBackground(Color.lightGray);
        add(dobTextField);

        

        

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD,22));
        gender.setBounds(125,340,400,30);
       
        add(gender);

        

        Female = new JRadioButton("Female");
        Female.setBounds(450,340,400,30);
        add(Female);

        male = new JRadioButton("Male");
        male.setBounds(325,340,400,30);
        add(male);

        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(male);
        gendeGroup.add(Female);


        

        JLabel email_Address = new JLabel("Email Address:");
        email_Address.setFont(new Font("Raleway", Font.BOLD,22));
        email_Address.setBounds(125,400,400,30);
       
        add(email_Address);

         emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextField.setBounds(325,400,200,30);
        emailTextField.setBackground(Color.lightGray);
        add(emailTextField);


        

        

        // JRadioButton married = new JRadioButton("Married");
        // married.setFont(new Font("Raleway", Font.BOLD,22));
        // married.setBounds(325,460,400,30);
       
        // add(married);

        JLabel maritLabel = new JLabel("Marital Status:");
        maritLabel.setFont(new Font("Raleway", Font.BOLD,22));
        maritLabel.setBounds(125,460,400,30);
        add(maritLabel);

       
       
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(425,460,400,30);
        add(unmarried);

      
        married = new JRadioButton("Married");
        married.setBounds(325,460,200,30);
        add(married);

        ButtonGroup marriedGroup = new ButtonGroup();
        marriedGroup.add(married);
        marriedGroup.add(unmarried);


        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD,22));
        address.setBounds(125,520,400,30);
       
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD,14));
        addressTextField.setBounds(325,520,200,30);
        addressTextField.setBackground(Color.lightGray);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD,22));
        city.setBounds(125,580,400,30);
       
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD,14));
        cityTextField.setBounds(325,580,200,30);
        cityTextField.setBackground(Color.lightGray);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD,22));
        state.setBounds(125,640,400,30);
       
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD,14));
        stateTextField.setBounds(325,640,200,30);
        stateTextField.setBackground(Color.lightGray);
        add(stateTextField);

        JLabel pin = new JLabel("PIN Code:");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(125,700,400,30);
       
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD,14));
        pinTextField.setBounds(325,700,200,30);
        pinTextField.setBackground(Color.lightGray);
        add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        // next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(550, 750, 200, 50);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob=dobTextField.getText();
        String gender = null;
        if(male.isSelected()){
            gender="Male";
        }else if(Female.isSelected()){
            gender="Female";
        }

        String email = emailTextField.getText();

        String marital = null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's Name is required");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "DOB is required");
            }
            else if(gender.equals("")){
                JOptionPane.showMessageDialog(null, "Gender is required");
            }
            else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Email is required");
            }
            else if(marital.equals("")){
                JOptionPane.showMessageDialog(null, "Marital Status is required");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is required");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City is required");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State is required");
            }
            else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "PIN is required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signup2(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        JOptionPane.showMessageDialog(next,"Data Successfully Submitted!");
    }
    public static void main(String[] args) {
        new Signup();
    }
}
