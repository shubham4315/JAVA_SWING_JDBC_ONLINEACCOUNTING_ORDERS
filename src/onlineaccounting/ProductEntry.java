
package onlineaccounting;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;


public class ProductEntry extends JFrame implements ActionListener{
    
    JTextField name_text,id_text,price_text,units_text;
    JButton check,add,back;
    int id = -1;
    String name = null;
        double price = 0.0;
        int unit = 0;
        int present = 0;
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        int units_present = 0;
        JLabel lab;
        JLabel l1,l2,l3,l4;
        conn c = new conn();
        
        ProductEntry()
    {
        
        setBounds(400,100,1200,900);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("onlineaccounting/icons/main_page_1.jpg"));
        lab = new JLabel(i1);
        lab.setBounds(0,0,1200,900);
        add(lab);
        
        l1 = new JLabel("Name:");
        l1.setBounds(400,250,100,25);
        l1.setFont(new Font("serif" , Font.BOLD , 25));
        lab.add(l1);
        check = new JButton("CHECK");
        check.setBounds(750,250,100,25);
        check.addActionListener(this);
        lab.add(check);
        back = new JButton("BACK");
        back.setBounds(1020,820,100,25);
        back.addActionListener(this);
        lab.add(back);
        
        name_text = new JTextField();
        name_text.setBounds(550,250,150,30);
        lab.add(name_text);
        id_text = new JTextField();
                    id_text.setBounds(550,300,150,30);
                    //lab.add(id_text);
                    price_text = new JTextField();
                    price_text.setBounds(550,350,150,30);
                    //lab.add(price_text);
                    units_text = new JTextField();
                    units_text.setBounds(550,400,150,30);
                    //lab.add(units_text);
                    l2 = new JLabel("ID:");
                    l2.setBounds(400,300,100,25);
                    l2.setFont(new Font("serif" , Font.BOLD , 25));
                    //lab.add(l2);
                    l3 = new JLabel("PRICE:");
                    l3.setBounds(400,350,100,25);
                    l3.setFont(new Font("serif" , Font.BOLD , 25));
                    //lab.add(l3);
                    
                    l4 = new JLabel("UNITS:");
                    l4.setBounds(400,400,100,25);
                    l4.setFont(new Font("serif" , Font.BOLD , 25));
                    //lab.add(l4);
        add = new JButton("ADD");
        add.setBounds(400,450,100,25);
        add.addActionListener(this);
        
        
        setLayout(null);
        setVisible(true);
    
    }
    
    
    /*public static void main(String args[])
    {
        new ProductEntry();
        
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == check)
        {
                try{
                    ResultSet rs = c.s.executeQuery("select * from product where name = '"+name_text.getText()+"' ;");
                    while(rs.next())
                    {
                        present++;
                        units_present = rs.getInt("unit");
                    }
                    if(present == 0)
                    {
                        lab.add(name_text);
                        lab.add(price_text);
                        lab.add(id_text);
                        lab.add(units_text);
                        lab.add(l2);
                        lab.add(l3);
                        lab.add(l4);
                        lab.add(add);
                        JOptionPane.showMessageDialog(null , " Enter the values as under ");
                        revalidate();
                        repaint();
                                

                    }
                    else
                    {
                        

                        units_text.setBounds(550,300,150,30);
                        lab.add(units_text);
                        l4.setBounds(400,300,100,25);
                        lab.add(add);
                        lab.add(l4);
                        JOptionPane.showMessageDialog(null , "Item Already Present, HOW MANY MORE UNITS : ");
                        revalidate();
                        repaint();
                        }
                }
                catch(Exception ae)
                {
                    ae.printStackTrace();
                }
           }
        else if(e.getSource() == add)
        {
                    if(present == 0)
                    {
                        
                        Date date = new Date();
                        
                        
                        try {
                            c.s.executeUpdate("insert into product values ('" +id_text.getText()+ "','"+name_text.getText()+"','"+price_text.getText()+"','"+units_text.getText()+"','"+df.format(date)+"');");
                            c.s.executeUpdate("insert into purchased values ('"+name_text.getText()+"','"+price_text.getText()+"','"+units_text.getText()+"','"+df.format(date)+"');");
                            JOptionPane.showMessageDialog(null , "Added Successfully");
                            this.setVisible(false);
                            new ProductEntry();
                        } catch (SQLException ex) {
                            Logger.getLogger(ProductEntry.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    else
                    {
                        
                        try {
                            c.s.executeUpdate(" update product set unit = '"+(units_present+units_text.getText())+"' where name = '"+name_text.getText()+"' ;");
                            Date date = new Date();
                            c.s.executeUpdate("insert into purchased values ('"+name_text.getText()+"','"+price_text.getText()+"','"+units_text.getText()+"','"+df.format(date)+"');");
                            JOptionPane.showMessageDialog(null , "Added Successfully");
                            this.setVisible(false);
                            new ProductEntry();
                        } catch (SQLException ex) {
                            Logger.getLogger(ProductEntry.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    
        }
        else if(e.getSource() == back)
        {
            new OnlineAccounting();
            this.setVisible(false);
        }
      }
    }
    
 


 
    /*void Entry()
    {
        Scanner sc = new Scanner(System.in);
        
//Date date;
        
        while(true)
        {
            System.out.println("Enter Product Details :");
            System.out.print("NAME OF PRODUCT :  ");
            name = sc.nextLine();
            try{

                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from product where name = '"+name+"' ;");
                while(rs.next())
                {
                    present++;
                    units_present = rs.getInt("unit");
                }
                if(present == 0)
                {
                    System.out.print("ID :  ");
                    id = sc.nextInt();
                    System.out.print("PRICE :  ");
                    price = sc.nextDouble();
                    System.out.print("UNITS PURCHASED :  ");
                    unit = sc.nextInt();
                    
                    Date date = new Date();
                    //System.out.println("DATE IS " + date);
                    try{

                        //conn c = new conn();
                        c.s.executeQuery("select name from product");

                        c.s.executeUpdate("insert into product values ('" +id+ "','"+name+"','"+price+"','"+unit+"','"+df.format(date)+"');");
                        c.s.executeUpdate("insert into purchased values ('"+name+"','"+price+"','"+unit+"','"+df.format(date)+"');");
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    System.out.println("Item Already Present ");
                    System.out.println("HOW MANY MORE UNITS :  ");
                    unit = sc.nextInt();
                    try{

                        //conn c = new conn();
                      //  c.s.executeQuery("select name from product");
                         c.s.executeUpdate(" update product set unit = '"+(units_present+unit)+"' where name = '"+name+"' ;");
                         Date date = new Date();
                         c.s.executeUpdate("insert into purchased values ('"+name+"','"+price+"','"+unit+"','"+df.format(date)+"');");
                        //c.s.executeUpdate("insert into product values ('" +id+ "','"+name+"','"+price+"','"+unit+"','"+df.format(date)+"');");

                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }

            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
            System.out.println("Do you wish to place more orders(Y/N)?");
            char choice = sc.next().charAt(0);
            if(choice != 'Y' && choice != 'y')
            {
               //System.out.println("GHUSA"); 
               break;
            }

        }
        
        
        
    }*/
   