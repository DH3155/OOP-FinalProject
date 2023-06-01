package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;

import Assets.CustomerStuff.Credentials;
import Assets.CustomerStuff.CustomerIdentification;

public class CheckInController {
	@FXML
	private TextField Name;
	@FXML
	private TextField CID;
	@FXML
	private TextField NIK;

	
	public void SetActiveCustomerFile(CustomerIdentification C, int TotalPrice) {
	    try {
	      FileWriter wr = new FileWriter("ActiveCustomerFile.txt", false);
	      wr.write(C.CID + "#" + C.Name + "#" + C.NIK + "#" + C.dob + "#" + C.ci + "#" + C.co + "#" + C.Room + "#" + TotalPrice + "\n");
	      wr.close();
	      System.out.println();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	
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
	
	public void LogIn(ActionEvent e) throws IOException {
		ArrayList<CustomerIdentification> data = new ArrayList<CustomerIdentification>();
		
		try {
			File CsFile = new File("CustomerFile.txt");
			try (Scanner FileReader = new Scanner (CsFile).useDelimiter("#")) {
				
				while(FileReader.hasNextLine()) {
					String CID = FileReader.next();
					String Name = FileReader.next();
					String NIK = FileReader.next();
					String filedob = FileReader.next();
					String fileci = FileReader.next();
					String fileco = FileReader.next();
					String Room = FileReader.next();
					String RNum = FileReader.next();
					String TC = FileReader.nextLine();
					int len = TC.length();
					String Convert = TC.substring(1, len);
					
					int TotalCharge=Integer.parseInt(Convert);  
					
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate dob = LocalDate.parse(filedob, formatter);
					LocalDate ci = LocalDate.parse(fileci, formatter);
					LocalDate co = LocalDate.parse(fileco, formatter);
					
					CustomerIdentification temp = new CustomerIdentification(CID, Name, dob, ci, co, NIK, Room, RNum, TotalCharge);
					data.add(temp);
				}
			}catch(Exception e1) {
				
			}
		}catch(Exception e1) {
			
		}
		
		String SearchCID = CID.getText();
		String SearchName = Name.getText();
		String SearchNIK = NIK.getText();
		CustomerIdentification temp = new CustomerIdentification(SearchCID, SearchName, null, null, null, SearchNIK, null, null, 0);
		System.out.println(temp.CID);
		System.out.println(temp.Name);
		System.out.println(temp.NIK);
		
		if(data.contains(temp)) {
			System.out.println("DING");
			int index = data.indexOf(temp);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ProfileCheckIn.fxml"));
			root = loader.load();
			
			ProfileController profileController = loader.getController();
			profileController.Name(data.get(index).Name);
			profileController.Room(data.get(index).Room);
			profileController.CheckIn(data.get(index).ci);
			profileController.CheckOutTime(data.get(index).co);
			profileController.CID(data.get(index).CID);
			profileController.RNum(data.get(index).RNum);
			profileController.TotCharge(data.get(index).TotalCharge);
			profileController.AddFiles(data, index);
			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}else {
			System.out.println("Credentials Are invalid");
		}
		
	}
}
