 
package NewFx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class UploadedProductListController implements Initializable {

    @FXML
    private CheckBox beef;
    @FXML
    private CheckBox mutton;
    @FXML
    private CheckBox desiChicken;
    @FXML
    private CheckBox poultry;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back2(ActionEvent event)throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AccountantHome.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void checkEvent(ActionEvent event) {
        int count =0;
        String items="New Uploaded Products: \n";
        String item2="Total: ";
        String item3="Mofizul Islam";
        String item4="Jinnat Hossen";
        String item5="Mohidul Haque";
        String item6="Lokman Hasan";
        if(beef.isSelected()){
            count++;
            items+=beef.getText()+"\n";
            item3=item3+" Price:650TK "+beef.getText();
        }
        if(mutton.isSelected()){
            count++;
            items+=mutton.getText()+"\n";
            item4=item4+" Price:850Tk "+mutton.getText();
        }
        if(desiChicken.isSelected()){
            count++;
            items+=desiChicken.getText()+"\n";
            item5=item5+" Price:600Tk "+desiChicken.getText();
            
        }
        if(poultry.isSelected()){
            count++;
            items+=poultry.getText()+"\n";
            item6=item6+" Price:250Tk "+poultry.getText();
        }
        label2.setText(item2+" "+count+"");
        label1.setText(items);
        label3.setText(item3);
        label4.setText(item4);
        label5.setText(item5);
        label6.setText(item6);
    }
    
}
