 
package NewFx;

import extension.Complain;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

 

public class ComplainBoxController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField productID;
    @FXML
    private TextField address;
    @FXML
    private TextField phone;
    @FXML
    private TextArea problem;
    @FXML
    private Label contentDisplay;
    @FXML
    private TextField fileName;
    private ArrayList<Complain> compList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        compList = new ArrayList<Complain>();
    }    

    @FXML
    private void backToBengal(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Bengal.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void onClickAddInstance(ActionEvent event) {
                compList.add(
                new Complain(
                    
                   
                    Integer.parseInt( productID.getText()),
                    nameTextField.getText(),
                    emailTextField.getText(),
                    address.getText(),
                    Integer.parseInt( phone.getText()),
                    problem.getText()
                    
                    
                )
        );
        nameTextField.clear(); emailTextField.clear(); productID.clear(); address.clear();phone.clear();
    }

    @FXML
    private void onClickShow(ActionEvent event) {
                String str="";
        for(Complain s: compList){
            System.out.println(s);
            //s.showInfo();
            str += (s + "\n");
        }
        contentDisplay.setText(str);
    }

    @FXML
    private void onClickWrite(ActionEvent event) {
                try {
            //writing to text file
            File f = new File(fileName.getText());
            //FileWriter fw = new FileWriter(fileNameTextField.getText());
            FileWriter fw = new FileWriter(f);
            for(Complain s: compList){
                //fw.write(s.toString()+"\n");
                fw.write(s.getId()+","+s.getName()+","+s.getEmail()+","+s.getAddress()+","+s.getPhone()+","+s.getProblem()+"\n");
            }
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ComplainBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onClickLoad(ActionEvent event) {
                FileReader fr=null;
        try {
            String str="", line=""; String[] tokens;
            fr = new FileReader(fileName.getText());
            Scanner s = new Scanner(fr);
            while(s.hasNextLine()){
                line = s.nextLine();   
                tokens = line.split(",");
                str += "ProductID:"+tokens[0]+"; Name:"+tokens[1]+"; Email:"+tokens[2]+"; Address:"+tokens[3]+"; Phone NO:"+tokens[4]+"; Problem:"+   "\n";
            }
            contentDisplay.setText(str);
            
        } catch (FileNotFoundException ex) {
            try {
                fr.close();
            } catch (IOException ex1) {
                Logger.getLogger(ComplainBoxController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ComplainBoxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
