/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewFx;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
 
 
 

 
public class ProductChartController implements Initializable {

    @FXML
    private Button loadLineChartButton1;
    @FXML
    private Button loadLineChartButton2;
    @FXML
    private LineChart<String, Number> lineChart1;
    @FXML
    private LineChart<String, Number> lineChart2;
     @FXML private Label lineChartLabel1;
     @FXML private Label lineChartLabel2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadLineChartButton1OnClick(ActionEvent event) {
        lineChart1.getData().clear();
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("Jan",200));
        series.getData().add(new XYChart.Data<String,Number>("Feb",500));
        series.getData().add(new XYChart.Data<String,Number>("Mar",300));
        series.getData().add(new XYChart.Data<String,Number>("Apr",600));
        series.setName("Pay-1");
        
        XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
        series2.getData().add(new XYChart.Data<String,Number>("Jan",400));
        series2.getData().add(new XYChart.Data<String,Number>("Feb",100));
        series2.getData().add(new XYChart.Data<String,Number>("Mar",800));
        series2.getData().add(new XYChart.Data<String,Number>("Apr",500));
        series2.setName("Pay-2");
        
        XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
        series3.getData().add(new XYChart.Data<String,Number>("Jan",500));
        series3.getData().add(new XYChart.Data<String,Number>("Feb",900));
        series3.getData().add(new XYChart.Data<String,Number>("Mar",450));
        series3.getData().add(new XYChart.Data<String,Number>("Apr",650));
        series3.setName("Pay-3");
        
        lineChart1.getData().addAll(series,series2,series3);
        
        for(XYChart.Data<String,Number> data: series.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lineChartLabel1.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
        for(XYChart.Data<String,Number> data: series2.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lineChartLabel1.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
        for(XYChart.Data<String,Number> data: series3.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lineChartLabel1.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
    }

    @FXML
    private void loadLineChartButton2ONClick(ActionEvent event) {
        lineChart2.getData().clear();
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("Jan",200));
        series.getData().add(new XYChart.Data<String,Number>("Feb",500));
        series.getData().add(new XYChart.Data<String,Number>("Mar",300));
        series.getData().add(new XYChart.Data<String,Number>("Apr",600));
        series.setName("Pay-1");
        
        XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
        series2.getData().add(new XYChart.Data<String,Number>("Jan",400));
        series2.getData().add(new XYChart.Data<String,Number>("Feb",100));
        series2.getData().add(new XYChart.Data<String,Number>("Mar",800));
        series2.getData().add(new XYChart.Data<String,Number>("Apr",500));
        series2.setName("Pay-2");
        
        XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
        series3.getData().add(new XYChart.Data<String,Number>("Jan",500));
        series3.getData().add(new XYChart.Data<String,Number>("Feb",900));
        series3.getData().add(new XYChart.Data<String,Number>("Mar",450));
        series3.getData().add(new XYChart.Data<String,Number>("Apr",650));
        series3.setName("Pay-3");
        
        lineChart2.getData().addAll(series,series2,series3);
        
        for(XYChart.Data<String,Number> data: series.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lineChartLabel2.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
        for(XYChart.Data<String,Number> data: series2.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lineChartLabel2.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
        for(XYChart.Data<String,Number> data: series3.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    lineChartLabel2.setText("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue()));
                    Tooltip.install(data.getNode(),new Tooltip("X: "+String.valueOf(data.getXValue())+"\nY: "+String.valueOf(data.getYValue())));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
        
 
    }

 
    
}
