/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener
{
    String pinnumber;
    JButton back;
    
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ICON/m.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(385,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
         Con c = new Con();
         int balance = 0;
            try
            {
                ResultSet rs = c.s.executeQuery("select * from bankd where pin = '"+pinnumber+"'");
                
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
            JLabel text = new JLabel("Your Current Account Balance is Rs:"+ balance);
            text.setForeground(Color.BLACK);
            text.setBounds(250,310,700,80);
            image.add(text);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transations(pinnumber).setVisible(true);
    }
    
    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }
    
}
