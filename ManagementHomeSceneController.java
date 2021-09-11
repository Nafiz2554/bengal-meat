/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewFx;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ManagementHomeSceneController implements Initializable {

    @FXML
    private TextField user_id;
    @FXML
    private TextField name;
    @FXML
    private TextField mobile_no;
    @FXML
    private TableColumn<Supplier, Integer> user_id_col;
    @FXML
    private TableColumn<Supplier, Integer> name_col;
    @FXML
    private TableColumn<Supplier, Integer> mobile_no_col;
    @FXML
    private TableColumn<Supplier, String> tradeLisence_no_col;
    @FXML
    private TextField tradeLisence_no;
    ObservableList<Supplier> listM;
     PreparedStatement pst=null;
    @FXML
    private TableView<Supplier> tableView;
    @FXML
    private ComboBox<String> comboBox;
    ObservableList<String> list=FXCollections.observableArrayList("GrameenPhone","Banglalink","Robi","Teletalk","Airtel");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                user_id_col.setCellValueFactory(new PropertyValueFactory<Supplier,Integer>("User_id"));
          name_col.setCellValueFactory(new PropertyValueFactory<Supplier,Integer>("Name"));
          mobile_no_col.setCellValueFactory(new PropertyValueFactory<Supplier,Integer>("Mobile_no"));
          tradeLisence_no_col.setCellValueFactory(new PropertyValueFactory<Supplier,String>("seller_name"));
     
           
        // TODO
         comboBox.setItems(list);
    }    

    @FXML
    private ObservableList<Supplier>  onClickAdd(ActionEvent event) {
          
        ObservableList<Supplier> list = FXCollections.observableArrayList();
        
        try{
             
             pst.setString(1,user_id.getText());
             pst.setString(2,name.getText());
              pst.setString(3,mobile_no.getText());
              pst.setString(4,tradeLisence_no.getText());
                
               pst.execute();
               
               JOptionPane.showMessageDialog(null,"Product Added");
             
        
            
        } catch (Exception e){
    JOptionPane.showMessageDialog(null,e);
            
        }
        return list;
        
    }

    @FXML
    private void onClickView(ActionEvent event) {
    }
    
}
