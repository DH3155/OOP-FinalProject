package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.ResourceBundle;

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
	
	private String[] Rooms = {"Outdoor 1", "Outdoor 2", "Outdoor 3"};
	
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
	
	public void UpdateCustomerJSON(CustomerIdentification Customer) {
		
	}
	
	public void UpdateRoomJSON(UsedRoom Room) {
		
	}
	
	public void AlreadyBooked(ActionEvent e) {
		System.out.println("Go To Check In");
	}
	
	public void PressButton(ActionEvent e) {
		Period period = Period.between(CheckIn, CheckOut);
	    int diff = Math.abs(period.getDays());
	    
		Name = NameText.getText();
		ID = IDNum.getText();
		String CID = MakeCID(diff);

		
		char r8 = Room.charAt(8);
		int r = r8-48;
		System.out.println(r);
		String RID = MakeRID(r8);
		
		System.out.println(RID);
		
		CustomerIdentification BookCustomer = new CustomerIdentification(CID, Name, DOB, CheckIn, CheckOut, 1, ID, Room);
		UsedRoom BookRoom = new UsedRoom(RID, int_random, diff, r, BookCustomer);
		
		
		UpdateCustomerJSON(BookCustomer);
		UpdateRoomJSON(BookRoom);
	}
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void Home(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void Menu(ActionEvent e) {
		System.out.println("Menu Chosen");
	}
	
	public void Room(ActionEvent e) {
		System.out.println("Room Chosen");
	}
	
	public void Facility(ActionEvent e) {
		System.out.println("Facility Chosen");
	}
	
	public void CheckIn(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Booking.fxml"));
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
