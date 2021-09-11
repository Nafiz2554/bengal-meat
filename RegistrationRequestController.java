 
package NewFx;

import static NewFx.MysqlConnect.ConnectDb;
import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
 
 


/**
 * FXML Controller class
 *
 * @author hp
 */
public class RegistrationRequestController implements Initializable {

    @FXML
    private TableView<User> table_users;
    @FXML
    private TableColumn<User, Integer> col_id;
    @FXML
    private TableColumn<User, String> col_username;
    @FXML
    private TableColumn<User, String> col_password;
    @FXML
    private TableColumn<User, String> col_email;
    @FXML
    private TableColumn<User, String> col_type;
  
    
  
    
   
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_type;
    ObservableList<User> listM;
    int index =-1;
    Connection con= null;
    ResultSet rs= null;
    PreparedStatement pst=null;
    @FXML
    private TextField txt_userId;
    @FXML
    private Button update;

   
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       col_id.setCellValueFactory(new PropertyValueFactory<User,Integer>("id"));
        col_username.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
         col_password.setCellValueFactory(new PropertyValueFactory<User,String>("password"));
          col_email.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
           col_type.setCellValueFactory(new PropertyValueFactory<User,String>("type"));
           
           listM=MysqlConnect.getDataUser();
           table_users.setItems(listM);
    }   
  

  

 

    private void onClickBack3(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private ObservableList<User> onClickAddData(ActionEvent event) throws SQLException {
         java.sql.Connection conn = ConnectDb();
        ObservableList<User> list = FXCollections.observableArrayList();
        String sql="INSERT INTO `user` (`user_id`, `username`, `password`, `email`, `type`) VALUES (?,?,?,?,?);";
        try{
             pst=conn.prepareStatement(sql);
             pst.setString(1,txt_userId.getText());
             pst.setString(2,txt_username.getText());
              pst.setString(3,txt_password.getText());
              pst.setString(4,txt_email.getText());
               pst.setString(5,txt_type.getText());
               pst.execute();
               
               JOptionPane.showMessageDialog(null,"Users Added");
             
        
            
        } catch (Exception e){
    JOptionPane.showMessageDialog(null,e);
            
        }
        return list;
       
    }

      
}
         

   

    

    

