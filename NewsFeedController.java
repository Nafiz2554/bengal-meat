/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewFx;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class NewsFeedController implements Initializable {

    @FXML
    private AnchorPane pauseButton;
    @FXML
    private MediaView mediaView;
    @FXML
    private Button playButton;
    @FXML
    private Button resetButton;
    
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         file=new File("C:/Users/hp/Desktop/Media/bengalMeatAdd.mp4");
         media=new Media(file.toURI().toString());
         mediaPlayer=new MediaPlayer(media);
         mediaView.setMediaPlayer(mediaPlayer);
         
         
    }    

    @FXML
    private void playMedia(ActionEvent event) {
        mediaPlayer.play();
    }

    @FXML
    private void pauseMedia(ActionEvent event) {
         mediaPlayer.pause();
    }

    @FXML
    private void resetMedia(ActionEvent event) {
         mediaPlayer.stop();
    }
    
}
