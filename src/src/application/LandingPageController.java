package application;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;




public class LandingPageController implements Initializable{
	@FXML
	private MediaView MV;
	@FXML
	private Button skip;
	
	private File file;
	private Media media;
	private MediaPlayer MP;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	Timer timer = new Timer();
	int i = 0;
	
	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		file = new File(".\\Pictures\\NewFinal.mp4");
		media = new Media(file.toURI().toASCIIString());
		MP = new MediaPlayer(media);
		MV.setMediaPlayer(MP);
		MP.play();
		switchSceneWithDelay();
	}
	
	
	   private void switchSceneWithDelay(){
	        timer = new Timer();
	        timer.schedule(new TimerTask() {
	            @Override
	            public void run() {
	                Platform.runLater(() -> {
	                    skip.fire();
	                });
	            }
	        }, 10000);
	    }
	   
		public void Home(ActionEvent e) throws IOException {
			root = FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
}
