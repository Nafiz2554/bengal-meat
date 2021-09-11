 
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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.stage.Stage;

 
public class ReportGenerationController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private Button loadPieChartButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadPieChartButtonOnClick( ActionEvent event ) {
        ObservableList<Data> list=FXCollections.observableArrayList(
				new PieChart.Data("Beef",550),
				new PieChart.Data("Mutton",850),
				new PieChart.Data("Poultry",250),
				new PieChart.Data("Desi Chicken",600)
				);
		pieChart.setData(list);
    
    
        }

    @FXML
    private void backToSupplierHomeOnClick(ActionEvent event)throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SupplierHome.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
        
 
    }
    
    

