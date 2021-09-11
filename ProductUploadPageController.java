/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewFx;

import static NewFx.MysqlConnect.ConnectDb;
import com.sun.jdi.connect.spi.Connection;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
//import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
//import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ProductUploadPageController implements Initializable {

    @FXML
    private Button uploadPhoto;
   
    
    @FXML
    private TextField Location;
    @FXML
    private TextField txt_product_id;
    @FXML
    private TextField txt_product_name;
    @FXML
    private TextField txt_seller_name;
    @FXML
    private TextField txt_price;
    @FXML
    private TableView<products> table_products;
    @FXML
    private TableColumn<products, Integer> col_product_id;
    @FXML
    private TableColumn<products, String> col_product_name;
    @FXML
    private TableColumn<products, String> col_seller_name;
    @FXML
    private TableColumn<products, Integer> col_product_price;
    ObservableList<products> listM;
    int index =-1;
    Connection con= null;
    ResultSet rs= null;
    PreparedStatement pst=null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          col_product_id.setCellValueFactory(new PropertyValueFactory<products,Integer>("product_id"));
          col_product_price.setCellValueFactory(new PropertyValueFactory<products,Integer>("price"));
          col_product_name.setCellValueFactory(new PropertyValueFactory<products,String>("product_name"));
          col_seller_name.setCellValueFactory(new PropertyValueFactory<products,String>("seller_name"));
           listM=MysqlConnect.getDataProducts();
           table_products.setItems(listM);
          
    }    

    @FXML
    private void onClickUploadPhoto(ActionEvent event) {
           FileChooser fc= new FileChooser();
           fc.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.PNG"));
           File f=fc.showOpenDialog(null);
           if(f!=null)
           {   
               Location.setText("Selected File::"+f.getAbsolutePath());
           }
            }

 

    @FXML
    private void onClickBack2(ActionEvent event)throws IOException  {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private ObservableList<products> onClickAddData(ActionEvent event)throws SQLException {
        java.sql.Connection conn = ConnectDb();
        ObservableList<products> list = FXCollections.observableArrayList();
        String sql="INSERT INTO `products` (`product_id`, `price`, `product_name`, `seller_name`) VALUES (?,?,?,?);";
        try{
             pst=conn.prepareStatement(sql);
             pst.setString(1,txt_product_id.getText());
             pst.setString(2,txt_price.getText());
              pst.setString(3,txt_product_name.getText());
              pst.setString(4,txt_seller_name.getText());
                
               pst.execute();
               
               JOptionPane.showMessageDialog(null,"Product Added");
             
        
            
        } catch (Exception e){
    JOptionPane.showMessageDialog(null,e);
            
        }
        return list;
    }
}
        
        
    
        
    
    

