/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewFx;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
 
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
 
/**
 * FXML Controller class
 *
 * @author hp
 */
public class AccountantHomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickGoUploadedProductList(ActionEvent event) throws IOException {
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("UploadedProductList.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void onClickGoPaymentReceivePage(ActionEvent event)throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("PaymentReceive.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void onClickGoGenerateDoccumentPage(ActionEvent event) {
                try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
            File f = fc.showSaveDialog(null);
            if(f!=null){              
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                //PdfWriter pw = new PdfWriter(new FileOutputStream("testPDF.pdf"));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
                
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                String paraText1 
                        = "Product Id: 1111, Product Name: Beef, Bengal Meat Processing Industry is an export oriented world class meat industry. We produce safe wholesome meat and meat products that are of the highest ...\n"
                        + "Product Id: 1112, Product Name: Mutton, From raw cuts to delicious marinated ready to cook recipes, we have it all to match your appetite and needs! Mutton. Wide range of Mutton cut and prepared... \n"
                        + "Product Id: 1113, Product Name: Desi Chicken, This product is really very fantastic and sold out all over the city.....\n"
                        + "Product Id: 1114, Product Name: Poultry, This was sold in the western zone of the city mostly....\n";
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("This is the final report of the newly sold products: ");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();

                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
                Text title = new Text("Product Report(Final)").setFont(fontBold);
                Text author = new Text("Accountant").setFont(font2);
                author.setFontColor(Color.BLUE);
                Paragraph bookInfo = new Paragraph().add(title).add(" -- by ").add(author);
                
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                doc.add(bookInfo);
                doc.add(lineSpace);
                
            
                List progLangList = new List();
                progLangList.add("BEEF Price: 650 Tk");
                progLangList.add("MUTTON Price: 1000 TK");
                progLangList.add("DESI CHICKEN Price: 650 TK");
                progLangList.add("POULTRY Price: 250 TK");
                progLangList.add("PAKISTANI CHICKEN Price: 400 TK");
                doc.add(progLangList);
                doc.add(lineSpace);
                
           
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Try And Add Product Images.");
                Optional<ButtonType> result = a.showAndWait();
                if(result.get() == ButtonType.OK){ 
                    File imageFile = fc.showOpenDialog(null);
                    String imagePath = imageFile.getAbsolutePath();
                    ImageData data = ImageDataFactory.create(imagePath);
                    Image image = new Image(data);  
                    
                    doc.add(image);
                    doc.add(lineSpace);
                    a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Product Image is added successfully.");
                    a.showAndWait();
                }
              
                float colWidthArr[] = {70f, 200f, 100f};
                Table pdfTable = new Table(colWidthArr); 
               
                Cell cell_00 = new Cell(); 
                cell_00.add("Product ID");
                cell_00.setBackgroundColor(Color.YELLOW);
                pdfTable.addCell(cell_00);
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Product Name"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Price"));
                
                
                pdfTable.addCell(new Cell().add("1111"));
                pdfTable.addCell(new Cell().add("BEEF"));
                pdfTable.addCell(new Cell().add("650TK"));
                
                
                pdfTable.addCell(new Cell().add("1112"));
                pdfTable.addCell(new Cell().add("MUTTON"));
                pdfTable.addCell(new Cell().add("1000TK"));
                
                 
                pdfTable.addCell(new Cell().add("1113"));
                pdfTable.addCell(new Cell().add("DESI CHICKEN"));
                pdfTable.addCell(new Cell().add("650TK"));
                
                pdfTable.addCell(new Cell().add("1113"));
                pdfTable.addCell(new Cell().add("POULTRY"));
                pdfTable.addCell(new Cell().add("250TK"));

                doc.add(pdfTable);
                
                doc.close();
                
                a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("The PDF is saved successfully.");
                a.showAndWait();    
            }
            else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Saving as PDF: cancelled!");
                a.showAndWait();               
            }
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Exception: " + e.toString()+ " occured.");
            a.showAndWait(); 
             
        }
    }

    @FXML
    private void onClickGoHome(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Bengal.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
}
