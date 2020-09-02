
package onlineaccounting;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlineAccounting extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;
    
    OnlineAccounting()
    {
        setBounds(400,50,1200,900);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("onlineaccounting/icons/main_page.png"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1200,900);
        add(l1);
        b1 = new JButton("Place Orders");
        b1.setBounds(500,200,150,25);
        b1.addActionListener(this);
        l1.add(b1);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.decode("#7671de"));
        
        b2 = new JButton("Product Sale");
        b2.setBounds(500,260,150,25);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBackground(Color.decode("#7671de"));
        l1.add(b2);
        b3 = new JButton("Inventory");
        b3.setBounds(500,315,150,25);
        b3.addActionListener(this);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.decode("#7671de"));
        l1.add(b3);
        b4 = new JButton("Todays Purchase");
        b4.setBounds(500,373,150,25);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        b4.setBackground(Color.decode("#7671de"));
        l1.add(b4);
        b5 = new JButton("Todays Sale");
        b5.setBounds(500,430,150,25);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        b5.setBackground(Color.decode("#7671de"));
        l1.add(b5);
        b6 = new JButton("Summary");
        b6.setBounds(500,485,150,25);
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        b6.setBackground(Color.decode("#7671de"));
        l1.add(b6);
        b7 = new JButton("QUIT");
        b7.setBounds(500,540,150,25);
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        b7.setBackground(Color.decode("#7671de"));
        l1.add(b7);
        
        
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        
        
        OnlineAccounting oa = new OnlineAccounting();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == b1)
        {
            ProductEntry pe = new ProductEntry();
            this.setVisible(false);
        }
        else if(e.getSource() == b2)
        {
            ProductSale s = new ProductSale();
            this.setVisible(false);
        }
        else if(e.getSource() == b3)
        {
            Inventory i = new Inventory();
            this.setVisible(false);
        }
        else if(e.getSource() == b4)
        {
            TodaysPurchase tp = new TodaysPurchase();
            this.setVisible(false);
        }
        else if(e.getSource() == b5)
        {
            TodaysSale ts = new TodaysSale();
            this.setVisible(false);
        }
        else if(e.getSource() == b6)
        {
            Summary s = new Summary();
            this.setVisible(false);
        }
        else if(e.getSource() == b7)
        {
            System.exit(0);
        }
        
    }
    
}
