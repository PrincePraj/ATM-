/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdrawl,back;
    String pinnumber;
    
    Withdrawl(String pinnumber)
    {        
        this.pinnumber = pinnumber;
        setLayout(null);
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ICON/m.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(230,340,700,50);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(210,390,340,30);
        image.add(amount);
        
        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(390,485,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        back = new JButton("Back");
        back.setBounds(390,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == withdrawl)
        {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }
            else 
            {
                try
                {
                Con conn = new Con();
                String query = "Insert into bankd values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully");
                setVisible(false);
                new Transations(pinnumber).setVisible(true);
                        }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Transations(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Withdrawl("");
    }
}

