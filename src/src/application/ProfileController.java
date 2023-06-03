package application;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import Assets.CustomerStuff.CustomerIdentification;
import Assets.MenuItems.*;

public class ProfileController {
	
	@FXML
	private Label NameText;
	@FXML
	private Label RType;
	@FXML
	private Label CheckIn;
	@FXML
	private Label CheckOutTime;
	@FXML
	private Label CID;
	@FXML
	private Label RNum;
	@FXML
	private Label TotalCharge;
	@FXML
	private Label Towel;
	
	@FXML
	private TextField pizza;
	@FXML
	private TextField spaghetti;
	@FXML
	private TextField burger;
	@FXML
	private TextField watermelon;
	@FXML
	private TextField blackberry;
	@FXML
	private TextField triple;

	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	ArrayList<CustomerIdentification> files = new ArrayList<CustomerIdentification>();
	public int TCharge;
	public int tow;
	public int index;
	
	public void Name(String UserName) {
		NameText.setText(UserName);
	}
	public void Room(String Room) {
		RType.setText(Room);
	}
	public void CheckIn(LocalDate cin) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fincin = cin.format(formatter);
		CheckIn.setText(fincin);
	}
	public void CheckOutTime(LocalDate cout) {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String out = cout.format(date);
		CheckOutTime.setText(out);
	}
	public void CID(String CusID) {
		CID.setText(CusID);
	}
	public void RNum(String RoomNum) {
		RNum.setText(RoomNum);
	}
	public void TotCharge(int TC) {
		TCharge = TC;
		String charge = String.valueOf(TC);
		TotalCharge.setText(charge);
	}
	public void AddFiles(ArrayList<CustomerIdentification> temp, int idx) {
		files = (ArrayList)temp.clone();
		index = idx;
	}
	
	
	public void towel(int towel) {
		tow = towel;
		String fintow = String.valueOf(tow);
		Towel.setText(fintow);
	}
	
	public void updateFile(){
	    try {
		      FileWriter wr = new FileWriter("CustomerFile.txt", false);
		      for(int i = 0; i < files.size(); i++) {
		    	  wr.write(files.get(i).CID + "#" + files.get(i).Name + "#" + files.get(i).NIK + "#" + files.get(i).dob + "#" + files.get(i).ci + "#" + files.get(i).co + "#" + files.get(i).Room + "#" + files.get(i).RNum +  "#" + files.get(i).TotalCharge + "\n");
		      }
		      wr.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void CheckOut(ActionEvent e) throws IOException {
//		Update main files
		files.get(index).TotalCharge = TCharge;
		updateFile();
		
		root = FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void addPizza() {
		String text = pizza.getText();
		int temp = Integer.parseInt(text);
		PepperoniPizza Order = new PepperoniPizza(temp);
		TCharge = TCharge + Order.GetPrice();
		TotCharge(TCharge);
	}
	
	public void addSpaghetti() {
		String text = spaghetti.getText();
		int temp = Integer.parseInt(text);
		SpaghettiCarbonara Order = new SpaghettiCarbonara(temp);
		TCharge = TCharge + Order.GetPrice();
		TotCharge(TCharge);
	}
	
	public void addBurger() {
		String text = burger.getText();
		int temp = Integer.parseInt(text);
		StovetopBurger Order = new StovetopBurger(temp);
		TCharge = TCharge + Order.GetPrice();
		TotCharge(TCharge);
	}
	
	public void addWatermelon() {
		String text = watermelon.getText();
		int temp = Integer.parseInt(text);
		WatermelonAguaFresca Order = new WatermelonAguaFresca(temp);
		TCharge = TCharge + Order.GetPrice();
		TotCharge(TCharge);
	}
	
	public void addBlackberry() {
		String text = blackberry.getText();
		int temp = Integer.parseInt(text);
		BlackberryMojito Order = new BlackberryMojito(temp);
		TCharge = TCharge + Order.GetPrice();
		TotCharge(TCharge);
	}
	
	public void addTriple() {
		String text = triple.getText();
		int temp = Integer.parseInt(text);
		TripleBerrySparklers Order = new TripleBerrySparklers(temp);
		TCharge = TCharge + Order.GetPrice();
		TotCharge(TCharge);
	}
	
	public void addTowel() {
		tow = tow + 1;
		towel(tow);
	}
	
	public void addSpa() {
		TCharge = TCharge + 25000;
		TotCharge(TCharge);
	}
	
	public void addWork() {
		TCharge = TCharge + 100000;
		TotCharge(TCharge);
	}
	
	
}
