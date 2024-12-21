/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    
    String pinnumber;
    JButton one,two,three,four,five,six,back;
    Fastcash(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ICON/m.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(250,340,700,80);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);
        
        one = new JButton("Rs 100");
        one.setBounds(210,440,140,30);
        one.addActionListener(this);
        image.add(one);
        
        two = new JButton("Rs 500");
        two.setBounds(410,440,140,30);
        two.addActionListener(this);
        image.add(two);
        
        three = new JButton("Rs 1000");
        three.setBounds(210,475,140,30);
        three.addActionListener(this);
        image.add(three);
        
        four = new JButton("Rs 2000");
        four.setBounds(410,475,140,30);
        four.addActionListener(this);
        image.add(four);
        
        five = new JButton("Rs 5000");
        five.setBounds(210,510,140,30);
        five.addActionListener(this);
        image.add(five);
        
        six = new JButton("Rs 10,000");
        six.setBounds(410,510,140,30);
        six.addActionListener(this);
        image.add(six);
        
        back = new JButton("BACK");
        back.setBounds(410,545,140,15);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Transations(pinnumber).setVisible(true);
                    
        }
        else
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Con c = new Con();
            try
            {
                ResultSet rs = c.s.executeQuery("select * from bankd where pin = '"+pinnumber+"'");
                int balance = 0;
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
                if(ae.getSource()!= back && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bankd values('"+pinnumber+"','"+date+"','Withdarwl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount +" Debited Successfully");
                
                setVisible(false);
                new Transations(pinnumber).setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
    }
    
    public static void main(String args[])
    {
        new Fastcash("");
    }
}
