module JavaFxTest {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.media;
	
	opens application to javafx.graphics, javafx.fxml;
}
