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

public class SignupTwo extends JFrame implements ActionListener{
    
    long random;
    JTextField pinTextField,fnameTextField,emailTextField,adhar,stateTextField,pan;
    JButton next;
    JRadioButton yes,no,Eyes,Eno;
    JComboBox religion,category,occupation,education,income;
    String formno;     
    
    SignupTwo(String formno)
            {
                this.formno = formno;
                System.out.println(formno);
                setLayout(null);
               
                setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
                        
                JLabel additionaldetails = new JLabel("Page 2: Additional Details");
                additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
                additionaldetails.setBounds(290,80,400,30);
                add(additionaldetails);
                
                JLabel name = new JLabel("RELIGION:");
                name.setFont(new Font("Raleway", Font.BOLD,20));
                name.setBounds(100,140,200,30);
                add(name);
                
                
                String valreligion[] = {"Hindu","Muslim","Sikh","Christian","Others"};
                religion = new JComboBox(valreligion);
                religion.setBounds(300,140,400,30);
                religion.setBackground(Color.WHITE);
                add(religion);
                 
                
                JLabel fname = new JLabel("CATEGORY:");
                fname.setFont(new Font("Raleway", Font.BOLD, 20));
                fname.setBounds(100,190,200,30);
                add(fname);
                
                String valcategory[] = {"General","OBC","SC","ST","Others"};
                category = new JComboBox(valcategory);
                category.setBounds(300,190,400,30);
                category.setBackground(Color.WHITE);
                add(category);
                
 
                JLabel dob = new JLabel("INCOME:");
                dob.setFont(new Font("Raleway", Font.BOLD, 22));
                dob.setBounds(100,240,200,30);
                add(dob);
                
                String incomecategory[] = {"NULL","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
                income = new JComboBox(incomecategory);
                income.setBounds(300,240,400,30);
                income.setBackground(Color.WHITE);
                add(income);
               
                JLabel gender = new JLabel("EDUCATIONAL");
                gender.setFont(new Font("Raleway", Font.BOLD, 22));
                gender.setBounds(100,290,200,30);
                add(gender);
                
                JLabel email = new JLabel("QUALIFICATION:");
                email.setFont(new Font("Raleway", Font.BOLD, 22));
                email.setBounds(100,315,200,30);
                add(email);
                
                String educationvalues[] = {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
                education = new JComboBox(educationvalues);
                education.setBounds(300,315,400,30);
                education.setBackground(Color.WHITE);
                add(education);
                
               
                JLabel mar = new JLabel("OCCUPATION:");
                mar.setFont(new Font("Raleway", Font.BOLD, 20));
                mar.setBounds(100,390,200,30);
                add(mar);
                
                String occupationvalues[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
                occupation = new JComboBox(occupationvalues);
                occupation.setBounds(300,390,400,30);
                occupation.setBackground(Color.WHITE);
                add(occupation);
                
                JLabel address = new JLabel("PAN NUMBER:");
                address.setFont(new Font("Raleway", Font.BOLD, 22));
                address.setBounds(100,440,200,30);
                add(address);
                
                pan = new JTextField();
                pan.setFont(new Font("Raleway",Font.BOLD,14));
                pan.setBounds(300,440,400,30);
                add(pan);
                
                JLabel  city = new JLabel("ADHAR NUMBER:");
                city.setFont(new Font("Raleway", Font.BOLD, 22));
                city.setBounds(100,490,200,30);
                add(city);
                
                adhar = new JTextField();
                adhar.setFont(new Font("Raleway",Font.BOLD,14));
                adhar.setBounds(300,490,400,30);
                add(adhar);
                
                JLabel sat = new JLabel("SENIOR CITIZEN:");
                sat.setFont(new Font("Raleway", Font.BOLD, 22));
                sat.setBounds(100,540,200,30);
                add(sat);
                
                yes = new JRadioButton("YES");
                yes.setBounds(300,540,60,30);
                yes.setBackground(Color.WHITE);
                add(yes);
                no = new JRadioButton("NO");
                no.setBounds(450,540,120,30);
                no.setBackground(Color.WHITE);
                add(no);
                
                ButtonGroup gg = new ButtonGroup();
                gg.add(yes);
                gg.add(no);
                
                
                JLabel pin = new JLabel("EXISITING ACCOUNT:");
                pin.setFont(new Font("Raleway", Font.BOLD, 20));
                pin.setBounds(100,590,200,30);
                add(pin);
                
                Eyes = new JRadioButton("YES");
                Eyes.setBounds(300,590,60,30);
                Eyes.setBackground(Color.WHITE);
                add(Eyes);
                Eno = new JRadioButton("NO");
                Eno.setBounds(450,590,120,30);
                Eno.setBackground(Color.WHITE);
                add(Eno);
                
                ButtonGroup Egg = new ButtonGroup();
                Egg.add(Eyes);
                Egg.add(Eno);
                
               
                
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
        String sformno = formno;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome =  (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(yes.isSelected())
        {
            seniorcitizen = "YES";
        }
        else if(no.isSelected())
        {
            seniorcitizen = "NO";
        }
        
        String exisitingaccount = null;
        if(Eyes.isSelected())
        {
            exisitingaccount = "YES";
        }
        else if(Eno.isSelected())
        {
            exisitingaccount = "NO";
        }
        
        String span = pan.getText();
        String sadhar = adhar.getText();
        
        System.out.println(formno);
        
        try
        {
           
                Con c = new Con();
                String query = "Insert into signuptwo values ('"+sformno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+sadhar+"', '"+seniorcitizen+"','"+exisitingaccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public static void main(String args[])
    {
        new SignupTwo("");
    }
}

