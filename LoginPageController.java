 
package NewFx;

import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

 
public class LoginPageController implements Initializable {

    @FXML
    private TextField textUserName;
    @FXML
    private PasswordField textPassword;
    @FXML
    private Button Login;
    @FXML
    private ComboBox<String> comboBox;
    ObservableList<String> list=FXCollections.observableArrayList("Administrator/Manager","Seller/Exporter","Buyer","Supplier","Accountant");

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox.setItems(list);
    }    

    @FXML
    private void onClickLogin(ActionEvent event)throws IOException {
        if(event.getSource()==Login){
            String username=textUserName.getText();
            String password=textPassword.getText();
            String ComboBox=comboBox.getValue();
            if(username.equalsIgnoreCase("Admin")&&password.equalsIgnoreCase("Admin")&&ComboBox.equalsIgnoreCase("Seller/Exporter")){
                 System.out.println("Login Succesfull");
                 Stage primaryStage=new Stage();
                  Parent root=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                  Scene scene=new Scene(root);
                  primaryStage.setScene(scene);
                  primaryStage.show();
               
            }
            else if(username.equalsIgnoreCase("Admin")&&password.equalsIgnoreCase("Admin")&&ComboBox.equalsIgnoreCase("Buyer")){
                System.out.println("Login Succesfull");
                 Stage primaryStage=new Stage();
                  Parent root=FXMLLoader.load(getClass().getResource("HomePageOfBuyer.fxml"));
                  Scene scene=new Scene(root);
                  primaryStage.setScene(scene);
                  primaryStage.show();
            }
             else if(username.equalsIgnoreCase("Admin")&&password.equalsIgnoreCase("Admin")&&ComboBox.equalsIgnoreCase("Administrator/Manager")){
                System.out.println("Login Succesfull");
                 Stage primaryStage=new Stage();
                  Parent root=FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
                  Scene scene=new Scene(root);
                  primaryStage.setScene(scene);
                  primaryStage.show();
            }
             else if(username.equalsIgnoreCase("Admin")&&password.equalsIgnoreCase("Admin")&&ComboBox.equalsIgnoreCase("Supplier")){
             System.out.println("Login Succesfull");
             Stage primaryStage=new Stage();
             Parent root=FXMLLoader.load(getClass().getResource("SupplierHome.fxml"));
             Scene scene=new Scene(root);
             primaryStage.setScene(scene);
             primaryStage.show();
            }
             else if(username.equalsIgnoreCase("Admin")&&password.equalsIgnoreCase("Admin")&&ComboBox.equalsIgnoreCase("Accountant")){
             System.out.println("Login Succesfull");
             Stage primaryStage=new Stage();
             Parent root=FXMLLoader.load(getClass().getResource("ManagementHomeScene.fxml"));
             Scene scene=new Scene(root);
             primaryStage.setScene(scene);
             primaryStage.show();
            }
            else{
                System.out.println("Username/Password combination not found");
            }
        }
        
    }

    @FXML
    private void onClickBackToHome(ActionEvent event)throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Bengal.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void onClickRegisterPage(ActionEvent event)throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("RegistrationPage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
}
