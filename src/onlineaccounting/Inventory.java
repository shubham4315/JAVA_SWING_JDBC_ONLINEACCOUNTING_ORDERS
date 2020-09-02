
package onlineaccounting;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

public class Inventory extends JFrame implements ActionListener {

    
    conn c;
    JLabel lab;
    JTable table;
    JButton show , back;
    JLabel Id,Name,Price,Date,Unit,Naame,Units;
    
    Inventory()
    {
        c = new conn();
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("onlineaccounting/icons/rest1.jpg"));
        Image img = i1.getImage().getScaledInstance(1200, 900, Image.SCALE_SMOOTH);
        lab = new JLabel(new ImageIcon(img));
        lab.setBounds(0,0,1200,900);
        add(lab);
        table = new JTable();
        table.setBounds(50,70,600,150);
        table.setOpaque(false);
        table.setFont(new Font("serif" , Font.BOLD , 20));
        table.setForeground(Color.decode("#36322f"));
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        Id = new JLabel("ID");
        Id.setBounds(60,40,50,20);
        Id.setFont(new Font("serif" , Font.BOLD , 20));
        Name = new JLabel("Name");
        Name.setBounds(195,40,50,20);
        Name.setFont(new Font("serif" , Font.BOLD , 20));
        Price = new JLabel("Price");
        Price.setBounds(315,40,50,20);
        Price.setFont(new Font("serif" , Font.BOLD , 20));
        Unit = new JLabel("Units");
        Unit.setBounds(455,40,50,20);
        Unit.setFont(new Font("serif" , Font.BOLD , 20));
        Date = new JLabel("Date");
        Date.setBounds(560,40,50,20);
        Date.setFont(new Font("serif" , Font.BOLD , 20));
        
        show = new JButton("SHOW");
        show.setBounds(450,20,100,25);
        show.addActionListener(this);
        lab.add(show);
        back = new JButton("BACK");
        back.setBounds(1020,820,100,25);
        back.addActionListener(this);
        lab.add(back);
        setLayout(null);
        setBounds(400,100,1200,900);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == show)
        {
            lab.remove(show);
            lab.add(table);
            lab.add(Id);
           lab.add(Name);
           lab.add(Price);
           lab.add(Unit);
           lab.add(Date);
           revalidate();
           repaint();
           try {
                ResultSet rs = c.s.executeQuery("select * from product;");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                Logger.getLogger(ProductSale.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            
        }else if(e.getSource() == back)
        {
            new OnlineAccounting();
            this.setVisible(false);
        }
    }
    
    
    
}



/*
public void showAll()
    {
        try{
        
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from product");
            System.out.println();
            System.out.println("PRODUCT ID            NAME             PRICE              UNIT          DATE-OF-PRUCHASE " );        
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            while(rs.next())
            {
                
                System.out.print("  "+rs.getInt("id")+"                   " + rs.getString("name") +"            " + rs.getDouble("price") +"              "+ rs.getInt("unit") + "                 " + rs.getDate("purchase"));
                System.out.println();
                System.out.println("--------------------------------------------------------------------------------------------------------");
                System.out.println();
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
*/