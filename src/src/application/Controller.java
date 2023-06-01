package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;

public class Controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void Home(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void Menu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("fxml/Menu.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void Room(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("fxml/Rooms.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void Facility(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("fxml/Facility.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void CheckIn(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("fxml/Booking.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
