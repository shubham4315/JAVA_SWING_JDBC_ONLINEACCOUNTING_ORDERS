
package onlineaccounting;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Summary extends JFrame implements ActionListener {
    
    conn c;
    JLabel lab;
    JButton show , back;
    JFrame frame ;
    JLabel label , one,two,three,four;
    double sell = 0.0;
    double purchase = 0.0;
    Summary()
    {
        sell = 0.0;
        purchase = 0.0;
        
        //frame = new JFrame();
        setLayout(null);
        c = new conn();
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("onlineaccounting/icons/rest1.jpg"));
        Image img = i1.getImage().getScaledInstance(1200, 900, Image.SCALE_SMOOTH);
        lab = new JLabel(new ImageIcon(img));
        lab.setBounds(0,0,1200,900);
        add(lab);
        show = new JButton("SHOW");
        show.setBounds(450,20,100,25);
        show.addActionListener(this);
        lab.add(show);
        back = new JButton("BACK");
        back.setBounds(1020,820,100,25);
        back.addActionListener(this);
        lab.add(back);
        label = new JLabel();
        label.setBounds(60,80,800,400);
        label.setFont(new Font("sans serif" , Font.PLAIN , 22));
        lab.add(label);
        //frame.pack();
        setBounds(400,100,1200,900);
        setVisible(true);
    
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == show)
        {
                //System.out.println("GOES HERE");
                lab.remove(show);
                try{
                    Date date = new Date();
                    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                    
                    ResultSet rs = c.s.executeQuery("select * from purchased where purchase = '" +df.format(date)+"';");

                    while(rs.next())
                    {
                        purchase = purchase + (rs.getInt("unit") * rs.getDouble("price"));
                    }
                    ResultSet rs1 = c.s.executeQuery("select * from sold where purchase = '" +df.format(date)+"';");

                    while(rs1.next())
                    {
                        sell = sell + (rs1.getInt("unit") * rs1.getDouble("price"));
                    }
                }catch(Exception ae)
                {
                    ae.printStackTrace();
                }
                String first = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
                String second = "Todays Total Purchase was of Rupees : " + purchase;
                String third = "Todays Total Sale was of Rupees : " + sell;
                String fourth = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
                label.setText("<html>"+first+"<br>"+second+"<br>" + third + "<br>" + fourth + "</html>");
                lab.add(label);
                revalidate();
                repaint();
                
        }
        else if(e.getSource() == back)
        {
            this.setVisible(false);
            new OnlineAccounting();
            
        }
    }
    
    public static void main(String[] args)
    {
        new Summary();
    }

}

/*
public void showSummary()
    {
        try{
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            
            conn c = new conn();
            double sell = 0.0;
            double purchase = 0.0;
            ResultSet rs = c.s.executeQuery("select * from purchased where purchase = '" +df.format(date)+"';");
            
            while(rs.next())
            {
                purchase = purchase + (rs.getInt("unit") * rs.getDouble("price"));
                
            }
            
            ResultSet rs1 = c.s.executeQuery("select * from sold where purchase = '" +df.format(date)+"';");
            
            while(rs1.next())
            {
                sell = sell + (rs1.getInt("unit") * rs1.getDouble("price"));
                
            }
            
            
            System.out.println();        
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println("Todays Total Purchase was of Rupees : " + purchase);
            System.out.println();
            System.out.println("Todays Total Sale was of Rupees : " + sell);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        
    }
*/
