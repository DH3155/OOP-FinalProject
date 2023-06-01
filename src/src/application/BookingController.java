package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import Assets.CustomerStuff.CustomerIdentification;
import Assets.Room.UsedRoom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors




public class BookingController implements Initializable{
	@FXML
	private DatePicker DOBDatePicker;
	@FXML
	private TextField NameText;
	@FXML
	private TextField IDNum;
	@FXML
	private Label StatusLabel;
	@FXML
	private  DatePicker Cin;
	@FXML
	private DatePicker Cout;
	@FXML
	private ChoiceBox<String> RoomType;
	
	private String[] Rooms = {"Outdoor 1 - Basic", "Outdoor 2 - Premium", "Outdoor 3 - Premium+"};
	
	protected String Name;
	protected LocalDate DOB;
	protected String ID;
	protected String Room;
	protected LocalDate CheckIn;
	protected LocalDate CheckOut;
	
	Random rand = new Random();
    int int_random = rand.nextInt(1000);
    
	public void getDate(ActionEvent e) {
		DOB = DOBDatePicker.getValue();
	}
	
	public void getRoom(ActionEvent e) {
		Room = RoomType.getValue();
	}
	
	public void getCheckIn(ActionEvent e) {
		CheckIn = Cin.getValue();
	}
	
	public void getCheckOut(ActionEvent e) {
		CheckOut = Cout.getValue();
	}
	
	public String MakeCID(int diff) {
	    char n1 = Name.charAt(0);
	    char n2 = Name.charAt(1);
	    char n3 = Name.charAt(2);
	    String n = "" + n1;
	    String nn = "" + n2;
	    String nnn = "" + n3;
	    
	    char r8 = Room.charAt(8);
	    String r = "" + r8;
	    
	    
		String value = n+nn+nnn+ diff + "O" + r + int_random;
		System.out.println(value);
		
		return value;
	}
	
	public String MakeRID(char r8) {
		return "O" + r8 + int_random;
	}
	
	public void UpdateCustomerFile(CustomerIdentification C) {
	    try {
	      FileWriter wr = new FileWriter("CustomerFile.txt", true);
	      wr.write(C.CID + "#" + C.Name + "#" + C.NIK + "#" + C.dob + "#" + C.ci + "#" + C.co + "#" + C.Room + "#" + C.RNum +  "#" + C.TotalCharge + "\n");
	      wr.close();
	      System.out.println();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	
	public void UpdateRoomFile(UsedRoom R) {
	    try {
		      FileWriter wr = new FileWriter("RoomFile.txt", true);
		      wr.write(R.RID + "#" + R.Rnum + "#" + R.duration + "#" + R.type + "#" + R.CID + "\n");
		      wr.close();
		      System.out.println();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void AlreadyBooked(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("fxml/CheckIn.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void PressButton(ActionEvent e) {
		Period period = Period.between(CheckIn, CheckOut);
	    int diff = period.getDays();
	    if(diff <= 0) {
	    	System.out.println("Invalid Dates");
	    	return;
	    }
	    
	    LocalDate now =  LocalDate.now();
	    Period AgePeriod = Period.between(DOB, now);
	    int Age = AgePeriod.getYears();
	    System.out.println(Age);
	    
	    if(Age < 18) {
	    	System.out.println("Can't Book under 18");
	    	return;
	    }
	    
		Name = NameText.getText();
		ID = IDNum.getText();
		
		if(Name == null || Name.contains("#")) {
			StatusLabel.setVisible(true);
			StatusLabel.setText("Invalid Name");
			return;
		}
		if(ID == null || ID.contains("#")) {
			StatusLabel.setVisible(true);
			StatusLabel.setText("Invalid ID");
			return;
		}
//		
		String CID = MakeCID(diff);

		
		char r8 = Room.charAt(8);
		int r = r8-48;
		System.out.println(r);
		String RID = MakeRID(r8);
		
		System.out.println(RID);
		
		UsedRoom BR = new UsedRoom(RID, int_random, r, diff, CID);
		int price = BR.GetPrice();
		String RNum = String.valueOf(int_random);
		
		CustomerIdentification BC = new CustomerIdentification(CID, Name, DOB, CheckIn, CheckOut, ID, Room, RNum, price);
		
		System.out.println(price);
		
		StatusLabel.setVisible(true);
		StatusLabel.setText("Customer ID (CID): " + BC.CID);
//		BC = CustomerIdentification(CID, Name, DOB, CheckIn, CheckOut, ID, Room, price);
		
		UpdateCustomerFile(BC);
		UpdateRoomFile(BR);
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
		root = FXMLLoader.load(getClass().getResource("fxml/ProfileCheckIn.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		RoomType.getItems().addAll(Rooms);
		RoomType.setOnAction(this::getRoom);
	}
}
