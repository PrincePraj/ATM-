/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,pinTextField,fnameTextField,emailTextField,addTextField,cityTextField,stateTextField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChosser;
            
    SignupOne()
            {
                setLayout(null);
                
                Random ran = new Random();
                random = Math.abs((ran.nextLong() % 9000L) + 1000L);
                setTitle("APPLICATION FORM");
                JLabel formno = new JLabel("APPLICATION FORM NO. :- " + random);
                formno.setFont(new Font("Raleway", Font.BOLD, 38));
                formno.setBounds(140,20,600,40);
                add(formno);
                
                JLabel personaldetails = new JLabel("Page 1: Personal Details");
                personaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
                personaldetails.setBounds(290,80,400,30);
                add(personaldetails);
                
                JLabel name = new JLabel("NAME:");
                name.setFont(new Font("Raleway", Font.BOLD, 22));
                name.setBounds(100,140,100,30);
                add(name);
                
                nameTextField = new JTextField();
                nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
                nameTextField.setBounds(300,140,400,30);
                add(nameTextField);
                
                JLabel fname = new JLabel("FATHER'S NAME:");
                fname.setFont(new Font("Raleway", Font.BOLD, 22));
                fname.setBounds(100,190,200,30);
                add(fname);
                
                fnameTextField = new JTextField();
                fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
                fnameTextField.setBounds(300,190,400,30);
                add(fnameTextField);
                
                JLabel dob = new JLabel("DATE OF BIRTH:");
                dob.setFont(new Font("Raleway", Font.BOLD, 22));
                dob.setBounds(100,240,200,30);
                add(dob);
                
                dateChosser = new JDateChooser();
                dateChosser.setBounds(300,240,400,30);
                add(dateChosser);
                
                JLabel gender = new JLabel("GENDER:");
                gender.setFont(new Font("Raleway", Font.BOLD, 22));
                gender.setBounds(100,290,200,30);
                add(gender);
                
                male = new JRadioButton("MALE");
                male.setBounds(300,290,60,30);
                male.setBackground(Color.WHITE);
                add(male);
                female = new JRadioButton("FEMALE");
                female.setBounds(450,290,120,30);
                female.setBackground(Color.WHITE);
                add(female);
                
                ButtonGroup gg = new ButtonGroup();
                gg.add(male);
                gg.add(female);
                
                JLabel email = new JLabel("EMAIL:");
                email.setFont(new Font("Raleway", Font.BOLD, 22));
                email.setBounds(100,340,200,30);
                add(email);
                
                emailTextField = new JTextField();
                emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
                emailTextField.setBounds(300,340,400,30);
                add(emailTextField);
                
                JLabel mar = new JLabel("MARITAL STATUS:");
                mar.setFont(new Font("Raleway", Font.BOLD, 20));
                mar.setBounds(100,390,200,30);
                add(mar);
                
                married = new JRadioButton("MARRIED");
                married.setBounds(300,390,100,30);
                married.setBackground(Color.WHITE);
                add(married);
                
                unmarried = new JRadioButton("UNMARRIED");
                unmarried.setBounds(450,390,100,30);
                unmarried.setBackground(Color.WHITE);
                add(unmarried);
                
                other = new JRadioButton("OTHER");
                other.setBounds(630,390,100,30);
                other.setBackground(Color.WHITE);
                add(other);
                
                 ButtonGroup mm = new ButtonGroup();
                mm.add(married);
                mm.add(unmarried);
                mm.add(other);
                
                JLabel address = new JLabel("ADDRESS:");
                address.setFont(new Font("Raleway", Font.BOLD, 22));
                address.setBounds(100,440,200,30);
                add(address);
                
                addTextField = new JTextField();
                addTextField.setFont(new Font("Raleway",Font.BOLD,14));
                addTextField.setBounds(300,440,400,30);
                add(addTextField);
                
                JLabel  city = new JLabel("CITY:");
                city.setFont(new Font("Raleway", Font.BOLD, 22));
                city.setBounds(100,490,200,30);
                add(city);
                
                cityTextField = new JTextField();
                cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
                cityTextField.setBounds(300,490,400,30);
                add(cityTextField);
                
                JLabel sat = new JLabel("STATE:");
                sat.setFont(new Font("Raleway", Font.BOLD, 22));
                sat.setBounds(100,540,200,30);
                add(sat);
                
                stateTextField = new JTextField();
                stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
                stateTextField.setBounds(300,540,400,30);
                add(stateTextField);
                
                JLabel pin = new JLabel("PIN CODE:");
                pin.setFont(new Font("Raleway", Font.BOLD, 22));
                pin.setBounds(100,590,200,30);
                add(pin);
                
                pinTextField = new JTextField();
                pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
                pinTextField.setBounds(300,590,400,30);
                add(pinTextField);
                
                JButton next = new JButton("Next");
                next.setBackground(Color.BLACK);
                next.setForeground(Color.WHITE);
                next.setFont(new Font(("Raleway"),Font.BOLD,14));
                next.setBounds(620,660,80,30);
                next.addActionListener(this);
                add(next);
                
                getContentPane().setBackground(Color.WHITE);
                
                setSize(850,800);
                setLocation(350,10);
                setVisible(true);
            }
    
    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChosser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected())
        {
            gender = "Male";
        }
        else if(female.isSelected())
        {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String mar = null;
        if(married.isSelected())
        {
            mar = "Married";
        }
        else if(unmarried.isSelected())
        {
            mar = "Unmarried";
        }
        else if(other.isSelected())
        {
            mar = "Other";
        }
        String address = addTextField.getText();
        String City = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        
        try
        {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else
            {
                Con c = new Con();
                String query = "Insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+mar+"','"+address+"','"+City+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public static void main(String args[])
    {
        new SignupOne();
    }
}
