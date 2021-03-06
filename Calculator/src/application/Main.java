package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		mainWindow();
	}
	
	public void mainWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindowView.fxml"));
			AnchorPane pane = loader.load();
			
			Scene scene = new Scene(pane);
			
			//MainWindowController controller = loader.getController();
			//controller.setMain(this);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void println(String text) {
		System.out.println(text);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
