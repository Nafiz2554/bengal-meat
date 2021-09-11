 
package NewFx;

import com.mysql.cj.protocol.Resultset;
//import java.net.*;
import com.sun.javafx.logging.PlatformLogger.Level;
//import com.mysql.cj.xdevapi.Statement;
//import com.sun.javafx.logging.PlatformLogger.Level;
//import java.io.FileNotFoundException;
//import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.PreparedStatement;
//import com.sun.jdi.connect.spi.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;




 
public class RegistrationPageController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private TextField emailId;
    @FXML
    private ComboBox<String> comboBox;
    ObservableList<String> list=FXCollections.observableArrayList("Administrator/Manager","Seller/Exporter","Buyer","Supplier","Accountant");
    //Connection conn=null;
    Resultset rs=null;
    //Statement pst=null;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         comboBox.setItems(list);
        
    }    

    @FXML
    private void signUpOnClick(ActionEvent event)throws IOException, SQLException  {
          
         String uname = username.getText();
         String pass1 = String.valueOf(password.getText());
        // String pass2 = String.valueOf(confirmPassword.getText());
         String email = emailId.getText();
         String combo = String.valueOf(comboBox.getValue());
         
         
        
        
 
 
            
                 PreparedStatement ps;
                 
                 String registerUserQuery = "INSERT INTO `user info`(`Username`, `Password`, `Email`, `Category`) VALUES ('uname','pass1','email','combo') ";
                 
                 try {
                     
                     ps = MysqlConnect.ConnectDb().prepareStatement(registerUserQuery);
                     ps.setString(1,uname);
                     ps.setString(2, pass1);
                    // ps.setString(3, pass2);
                     ps.setString(4,email);
                     ps.setString(5,combo);
                     
                     
                     if(ps.executeUpdate() != 0){
                         JOptionPane.showMessageDialog(null, "Your Account Has Been Created");
                     }else{
                         JOptionPane.showMessageDialog(null, "Error: Check Your Information");
                     }
                     
                 } catch (SQLException ex) {
                      
              //Logger.getLogger(RegistrationPageController.class.getName()).log(Level.SEVERE, null, ex);
                 }
              }
             
         
        
                                                    

    

    
 

    @FXML
    private void logInOnClick(ActionEvent event)throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void backToHomeOnClick(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Bengal.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    private boolean verifyFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
