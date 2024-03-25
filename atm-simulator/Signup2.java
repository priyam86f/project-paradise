import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup2 extends JFrame implements ActionListener {
    long random;
    JButton next;
    JTextField nameTextField, fnameTextField, INCOMETextField, QUALTextField, marriedTextField, PANTextField,
            ADHAARTextField, CITIZENTextField, ACCOUNTTextField, maritalstatus;
    JRadioButton employee,business, bachelors,masters;
    JComboBox<String> religionBox;
    JComboBox<String> categoryBox;
    String formno;

    public Signup2(String formno) {
        this.formno=formno;
        setVisible(true);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        // random number on the application form.
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        setSize(800, 850);
        setLocation(350, 10);

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(250, 80, 400, 30);

        // add(additionalDetails);

        JLabel first_name = new JLabel("Religion:");
        first_name.setFont(new Font("Raleway", Font.BOLD, 22));
        first_name.setBounds(125, 160, 400, 30);
        // add(first_name);

        String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian" };
        religionBox = new JComboBox<>(valReligion);
        religionBox.setBackground(Color.gray);
        religionBox.setBounds(325, 160, 200, 30);
        religionBox.setVisible(true);
        add(religionBox);

        JLabel fathers_name = new JLabel("Category:");
        fathers_name.setFont(new Font("Raleway", Font.BOLD, 22));
        fathers_name.setBounds(125, 220, 400, 30);

        add(fathers_name);

        String valCategory[] = { "General", "OBC", "SC", "ST", "Other" };
        categoryBox = new JComboBox<>(valCategory);
        categoryBox.setBounds(325, 220, 200, 30);
        categoryBox.setVisible(true);
        add(categoryBox);

        JLabel DOB = new JLabel("Income:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 22));
        DOB.setBounds(125, 280, 200, 30);

        add(DOB);


        

        INCOMETextField = new JTextField();
        INCOMETextField.setFont(new Font("Raleway", Font.BOLD, 14));
        INCOMETextField.setBounds(325, 280, 200, 30);
        INCOMETextField.setBackground(Color.lightGray);
        add(INCOMETextField);

        // JLabel gender = new JLabel("Education:");
        // gender.setFont(new Font("Raleway", Font.BOLD,22));
        // gender.setBounds(325,240,400,30);

        // add(gender);

        masters = new JRadioButton("Masters");
        masters.setBounds(450, 340, 400, 30);
        add(masters);

        bachelors = new JRadioButton("Bachelors");
        bachelors.setBounds(325, 340, 400, 30);
        add(bachelors);

        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(masters);
        gendeGroup.add(bachelors);

        JLabel email_Address = new JLabel("Qualification:");
        email_Address.setFont(new Font("Raleway", Font.BOLD, 22));
        email_Address.setBounds(125, 400, 400, 30);

        add(email_Address);

        QUALTextField = new JTextField();
        QUALTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        QUALTextField.setBounds(325, 400, 200, 30);
        QUALTextField.setBackground(Color.lightGray);
        add(QUALTextField);

        JLabel marry_field = new JLabel("Education:");
        marry_field.setFont(new Font("Raleway", Font.BOLD, 22));
        marry_field.setBounds(125, 340, 400, 30);
        add(marry_field);

        // married = new JRadioButton("Education");
        // married.setFont(new Font("Raleway", Font.BOLD,22));
        // married.setBounds(125,340,400,30);

        // add(married);

        JLabel maritLabel = new JLabel("Occupation:");
        maritLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        maritLabel.setBounds(125, 460, 400, 30);
        add(maritLabel);

        employee = new JRadioButton("Employee");
        employee.setBounds(425, 460, 400, 30);
        add(employee);

        business = new JRadioButton("Business");
        business.setBounds(325, 460, 200, 30);
        add(business);

        ButtonGroup marriedGroup = new ButtonGroup();
        marriedGroup.add(employee);
        marriedGroup.add(business);

        JLabel address = new JLabel("PAN:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(125, 520, 400, 30);

        add(address);

        PANTextField = new JTextField();
        PANTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        PANTextField.setBounds(325, 520, 200, 30);
        PANTextField.setBackground(Color.lightGray);
        add(PANTextField);

        JLabel city = new JLabel("Adhaar:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(125, 580, 400, 30);

        add(city);

        ADHAARTextField = new JTextField();
        ADHAARTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        ADHAARTextField.setBounds(325, 580, 200, 30);
        ADHAARTextField.setBackground(Color.lightGray);
        add(ADHAARTextField);

        JLabel state = new JLabel("Senior Citizen(Yes/No):");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(50, 640, 400, 30);

        add(state);

        CITIZENTextField = new JTextField();
        CITIZENTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        CITIZENTextField.setBounds(325, 640, 200, 30);
        CITIZENTextField.setBackground(Color.lightGray);
        add(CITIZENTextField);

        JLabel pin = new JLabel("Existing Account(Yes/No):");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(30, 700, 400, 30);

        add(pin);

        ACCOUNTTextField = new JTextField();
        ACCOUNTTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        ACCOUNTTextField.setBounds(325, 700, 200, 30);
        ACCOUNTTextField.setBackground(Color.lightGray);
        add(ACCOUNTTextField);

        next = new JButton("Next");
      
        // next.setForeground(Color.white);
        // next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(550, 750, 200, 50);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        // Add components to the frame
        add(additionalDetails);
        add(first_name);
        add(religionBox);
        add(fathers_name);
        add(categoryBox);
        add(DOB);
        add(INCOMETextField);
        // add(gender);
        // add(male);
        // add(Female);
        add(email_Address);
        add(QUALTextField);
        add(maritLabel);
        // add(unmarried);
        // add(married);
        add(address);
        add(PANTextField);
        add(city);
        add(ADHAARTextField);
        add(state);
        add(CITIZENTextField);
        add(pin);
        add(ACCOUNTTextField);
        add(next);

        // Set other properties
        setSize(800, 850);
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        //comboboxes
        String sreligion = (String)religionBox.getSelectedItem();
        String scategory = (String)categoryBox.getSelectedItem();
        
        //textfield
        String sincome = INCOMETextField.getText();
        
        //radiobutton
        String seducation = null;
        if (bachelors.isSelected()) {
            seducation = "Bachelors";
        } else if (masters.isSelected()) {
            seducation = "Masters";
        }
        
        //textfield
        String squalification = QUALTextField.getText();

        //radiobutton
        String soccupation = null;
        if (business.isSelected()) {
            soccupation = "Business";
        } else if (employee.isSelected()) {
            soccupation = "Employee";
        }

        String span = PANTextField.getText();
        String sadhaar = ADHAARTextField.getText();
        String scitizen = CITIZENTextField.getText();
        String saccount = ACCOUNTTextField.getText();

        try {
              if (sincome.equals("")) {
                JOptionPane.showMessageDialog(null, "DOB is required");
            } else if (seducation.equals("")) {
                JOptionPane.showMessageDialog(null, "Gender is required");
            } else if (squalification.equals("")) {
                JOptionPane.showMessageDialog(null, "Email is required");
            } else if (soccupation.equals("")) {
                JOptionPane.showMessageDialog(null, "Marital Status is required");
            } else if (span.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is required");
            } else if (sadhaar.equals("")) {
                JOptionPane.showMessageDialog(null, "City is required");
            } else if (scitizen.equals("")) {
                JOptionPane.showMessageDialog(null, "State is required");
            } else if (saccount.equals("")) {
                JOptionPane.showMessageDialog(null, "PIN is required");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+squalification+"','"+soccupation+"','"+span+"','"+sadhaar+"','"+scitizen+"','"+saccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signup3(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        JOptionPane.showMessageDialog(next, "Data Successfully Submitted!");
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}