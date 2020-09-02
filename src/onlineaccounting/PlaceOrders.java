
package onlineaccounting;
import java.util.*;
import java.sql.ResultSet;

public class PlaceOrders {
    
    Scanner sc = new Scanner(System.in);
    
    PlaceOrders()
    {
        new ProductEntry();
    }
    
    
    public void showNoti(String name , int units)
    {
        System.out.println();
        System.out.println("*********************************************************************************");
        System.out.println("Only "+units+" units of "+name+" are remaining. Please place order for the same. ");           
        System.out.println("*********************************************************************************");
        System.out.println("Do you wish to place the order right now ?(Y/N)");
        char choice = sc.next().charAt(0);
        if(choice == 'Y'|| choice == 'y')
        {
           ProductEntry p = new ProductEntry();
        }
    }
    
    public void OrderToBePlaced()
    {
        String name=null;
        int units = 0;
        
        try{
        
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from product;");
            while(rs.next())
            {
                name = rs.getString("name");
                units = rs.getInt("unit");
                if(units <= 3)
                {
                    System.out.println("Only "+units+" units of "+name+" are remaining. Please place order for the same. ");
                    System.out.println("Do you wish to place the order right now ?(Y/N)");
                    char choice = sc.next().charAt(0);
                    if(choice == 'Y'|| choice == 'y')
                    {
                        ProductEntry p = new ProductEntry();
                        
                    }
                
                }
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
