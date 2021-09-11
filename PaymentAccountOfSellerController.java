 
package NewFx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

 



public class PaymentAccountOfSellerController implements Initializable {

    @FXML
    private ImageView imageView;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickBack(ActionEvent event)throws IOException {
           Parent tableViewParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void onClickLoadImage(ActionEvent event) {
    }

    @FXML
    private void onClickSelectPhoto(ActionEvent event) {
        FileChooser fc=new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("PNG Files","*.png"));
        List<File> f=fc.showOpenMultipleDialog(null);
        for(File file : f){
            
            imageView.getImage();
        }
    }
    
}
