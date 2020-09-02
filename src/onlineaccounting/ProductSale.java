
package onlineaccounting;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.*;

public class ProductSale extends JFrame implements ActionListener{
    
    JLabel lab;
    JTextField name_text , units_text;
    JButton sell, show ,back,yes , no;
    JTable table;
    JLabel Id,Name,Price,Date,Unit,Naame,Units;
    conn c;
    int units=0;
    int units_present = 0;
    JLabel message;
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    double price = 0.0;
    int reduce = 0;
    String text = "";
    int flag;
    ProductSale()
    {
        flag = 0;
        c = new conn();
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("onlineaccounting/icons/rest1.jpg"));
        Image img = i1.getImage().getScaledInstance(1200, 900, Image.SCALE_SMOOTH);
        lab = new JLabel(new ImageIcon(img));
        lab.setBounds(0,0,1200,900);
        add(lab);
        table = new JTable();
        table.setBounds(50,50,600,150);
        table.setOpaque(false);
        table.setFont(new Font("serif" , Font.BOLD , 20));
        table.setForeground(Color.decode("#36322f"));
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
       // lab.add(table);
        message = new JLabel();
        message.setBounds(50,450,700,25);
        message.setFont(new Font("serif" , Font.BOLD , 16));
        name_text = new JTextField();
        name_text.setBounds(400,250,150,25);
        yes = new JButton("ORDER NOW");
        yes.setBounds(300,500,150,25);
        yes.addActionListener(this);
        no = new JButton("Cancel");
        no.setBounds(500,500,150,25);
        no.addActionListener(this);
//lab.add(name_text);
        Id = new JLabel("ID");
        Id.setBounds(60,20,50,20);
        Id.setFont(new Font("serif" , Font.BOLD , 20));
        Name = new JLabel("Name");
        Name.setBounds(195,20,50,20);
        Name.setFont(new Font("serif" , Font.BOLD , 20));
        Price = new JLabel("Price");
        Price.setBounds(315,20,50,20);
        Price.setFont(new Font("serif" , Font.BOLD , 20));
        Unit = new JLabel("Units");
        Unit.setBounds(455,20,50,20);
        Unit.setFont(new Font("serif" , Font.BOLD , 20));
        Date = new JLabel("Date");
        Date.setBounds(560,20,50,20);
        Date.setFont(new Font("serif" , Font.BOLD , 20));
        Naame = new JLabel("Name: ");
        Naame.setBounds(250,250,100,20);
        Naame.setFont(new Font("serif" , Font.BOLD , 20));
         
        Units = new JLabel("Units: ");
        Units.setFont(new Font("serif" , Font.BOLD , 20));
        Units.setBounds(250,300,100,20);
//lab.add(Id);
        show = new JButton("SHOW");
        show.setBounds(450,20,100,25);
        show.addActionListener(this);
        lab.add(show);
        units_text = new JTextField();
        units_text.setBounds(400,300,150,25);
        //lab.add(units_text);
        back = new JButton("BACK");
        back.setBounds(1020,820,100,25);
        back.addActionListener(this);
        
        sell = new JButton("Sell");
        sell.setBounds(300,400,150,25);
        sell.addActionListener(this);
        
        lab.add(back);
        setLayout(null);
        setBounds(400,100,1200,900);
        setVisible(true);
        
    }
    
    ProductSale(String text , int flag)
    {
        
        c = new conn();
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("onlineaccounting/icons/rest1.jpg"));
        Image img = i1.getImage().getScaledInstance(1200, 900, Image.SCALE_SMOOTH);
        lab = new JLabel(new ImageIcon(img));
        lab.setBounds(0,0,1200,900);
        add(lab);
        table = new JTable();
        table.setBounds(50,50,600,150);
        table.setOpaque(false);
        table.setFont(new Font("serif" , Font.BOLD , 20));
        table.setForeground(Color.decode("#36322f"));
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
       // lab.add(table);
       yes = new JButton("ORDER NOW");
        yes.addActionListener(this);
        yes.setBounds(300,500,150,25);
        no = new JButton("Cancel");
        no.setBounds(500,500,150,25);
        no.addActionListener(this);
       if(flag == 1)
       {
           lab.add(yes);
           lab.add(no);
           flag = 0;
       }
       else
       {
           lab.remove(yes);
           lab.remove(no);
       }
       
        message = new JLabel();
        message.setBounds(50,450,700,25);
        message.setFont(new Font("serif" , Font.BOLD , 16));
        message.setText(text);
        lab.add(message);
        name_text = new JTextField();
        name_text.setBounds(400,250,150,25);
        //lab.add(name_text);
        Id = new JLabel("ID");
        Id.setBounds(60,20,50,20);
        Id.setFont(new Font("serif" , Font.BOLD , 20));
        Name = new JLabel("Name");
        Name.setBounds(195,20,50,20);
        Name.setFont(new Font("serif" , Font.BOLD , 20));
        Price = new JLabel("Price");
        Price.setBounds(315,20,50,20);
        Price.setFont(new Font("serif" , Font.BOLD , 20));
        Unit = new JLabel("Units");
        Unit.setBounds(455,20,50,20);
        Unit.setFont(new Font("serif" , Font.BOLD , 20));
        Date = new JLabel("Date");
        Date.setBounds(560,20,50,20);
        Date.setFont(new Font("serif" , Font.BOLD , 20));
        Naame = new JLabel("Name: ");
        Naame.setBounds(250,250,100,20);
        Naame.setFont(new Font("serif" , Font.BOLD , 20));
         
        Units = new JLabel("Units: ");
        Units.setFont(new Font("serif" , Font.BOLD , 20));
        Units.setBounds(250,300,100,20);
//lab.add(Id);
        show = new JButton("SHOW");
        show.setBounds(500,20,100,25);
        show.addActionListener(this);
        lab.add(show);
        units_text = new JTextField();
        units_text.setBounds(400,300,150,25);
        //lab.add(units_text);
        back = new JButton("BACK");
        back.setBounds(1020,820,100,25);
        back.addActionListener(this);
        
        sell = new JButton("Sell");
        sell.setBounds(300,400,150,25);
        sell.addActionListener(this);
        
        lab.add(back);
        setLayout(null);
        setBounds(400,100,1200,900);
        setVisible(true);
    }
    
    
 /*   void Sell()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name of the Product");
        String name = sc.next();
        System.out.println("Enter Units to Sell");
        
        try{
        
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from product where name = '"+name+"';");
            while(rs.next())
            {
                units_present = rs.getInt("unit");
                price = rs.getDouble("price");
            }
            if(units_present >= units)
            {
                System.out.println(units + " units sold of "+name);
                System.out.println("The amount you need to collect from the customer is : " + (double)(units*price));
                reduce = units;
            }
            else
            {
                if(units_present > 0)
                {
                    System.out.println("Only "+units_present+" number of "+name+" are available at the moment, Do you wish to buy that many?(Y/N) ");
                char choice = sc.next().charAt(0);
                if(choice == 'Y')
                    reduce = units_present;
                if(reduce > 0)
                    System.out.println(" The amount you need to collect from the customer is : " + (double)(reduce*price));
                }
                else
                    System.out.println("Sorry, This product is not available at the store currently.");
                
                
            }
            if(units_present - reduce <=3 )
            {
                PlaceOrders po = new PlaceOrders();
                po.showNoti(name, units_present-reduce);
            }
            c.s.executeUpdate(" update product set unit = '"+(units_present-reduce)+"' where name = '"+name+"' ;");
            Date date = new Date();
            c.s.executeUpdate("insert into sold values ('"+name+"','"+price+"','"+reduce+"','"+df.format(date)+"');");
        }catch(Exception e)
        {
            System.out.println("Name not found");
        }
    } */

   /* public static void main(String[] args)
    {
        new ProductSale();
    }*/
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back)
        {
            this.setVisible(false);
            new OnlineAccounting();
        }
        else if(e.getSource() == show)
        {
            lab.remove(show);
            lab.add(table);
            lab.add(name_text);
            lab.add(units_text);
           // JOptionPane.showMessageDialog(null , "The Products at the shop are as under, Enter the name and units of thr product you wish to buy ");
           lab.add(Id);
           lab.remove(message);
           lab.add(Name);
           lab.add(Price);
           lab.add(Unit);
           lab.add(Date);
           lab.add(Naame);
           lab.add(Units);
           lab.add(sell);
           lab.remove(yes);
           lab.remove(no);
           revalidate();
            repaint();
            
            try {
                ResultSet rs = c.s.executeQuery("select * from product;");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                Logger.getLogger(ProductSale.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(e.getSource() == sell)
        {
            try{
                System.out.println("NAME TEXT " +name_text.getText());    
                System.out.println("UNITS TEXT " +units_text.getText());
                units = Integer.parseInt(units_text.getText());
                ResultSet rs = c.s.executeQuery("select * from product where name = '"+name_text.getText()+"';");
                
                while(rs.next())
                {
                    units_present = rs.getInt("unit");
                    price = rs.getDouble("price");
                }
                if(units_present >= units)
                {
                //    System.out.println(units + " units sold of "+Name.getText());
               //     System.out.println("The amount you need to collect from the customer is : " + (double)(units*price));
                        text = "The amount you need to collect from the customer is : " + (double)(units*price);
                    message.setText(text);
                    lab.add(message);
                    reduce = units;
                }
                else
                {
                    if(units_present > 0)
                    {
                    //  System.out.println("Only "+units_present+" number of "+name+" are available at the moment, Do you wish to buy that many?(Y/N) ");
                    //char choice = sc.next().charAt(0);
                   // if(choice == 'Y')
                        reduce = units_present;
                    if(reduce > 0)
                        text = " The amount you need to collect from the customer is : " + (double)(reduce*price);
                    }
                    else
                        text = "Sorry, This product is not available at the store currently.";


                }
                if(units_present - reduce <=3 )
                {
                    flag = 1;
                    text = text + "\n" +" You need to order more " + name_text.getText()+ " immediately. Do you need to order it right now? ";
                    //PlaceOrders po = new PlaceOrders();
                 //   po.showNoti(name, units_present-reduce);
                }
                c.s.executeUpdate(" update product set unit = '"+(units_present-reduce)+"' where name = '"+name_text.getText()+"' ;");
                Date date = new Date();
                c.s.executeUpdate("insert into sold values ('"+name_text.getText()+"','"+price+"','"+reduce+"','"+df.format(date)+"');");
                this.setVisible(false);
                new ProductSale(text , flag);
            }catch(Exception ae)
            {
                ae.printStackTrace();
            }
        }
        else if(e.getSource() == yes)
        {
            new ProductEntry();
            this.setVisible(false);
        }
        else if(e.getSource() == no)
        {
            new ProductSale();
            this.setVisible(false);
        }
                
    }
   
    
}
