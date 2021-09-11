 
package NewFx;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

  
public class MysqlConnect {
    Connection conn=null;
    public static Connection ConnectDb(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/bengalmeat","root","");
            JOptionPane.showMessageDialog(null,"Connection Established");
            return conn;
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
        
    }
    public static ObservableList<User> getDataUser(){
        Connection conn = ConnectDb();
        ObservableList<User> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps= conn.prepareStatement("select * from  User");
            ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 list.add(new User(Integer.parseInt(rs.getString("user_id")),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getString("type")));
             }
            
        } catch (Exception e){
            
        }
     return list;   
    }
        public static ObservableList<products> getDataProducts(){
        Connection conn = ConnectDb();
        ObservableList<products> list2 = FXCollections.observableArrayList();
        try{
            PreparedStatement pss= conn.prepareStatement("select * from  products");
            ResultSet rss = pss.executeQuery();
             while(rss.next()){
            list2.add(new products(Integer.parseInt(rss.getString("product_id")),Integer.parseInt(rss.getString("product_name")),rss.getString("product_name"),rss.getString("seller_name")));
             }
            
        } catch (Exception e){
            
        }
     return list2;   
    }
}
