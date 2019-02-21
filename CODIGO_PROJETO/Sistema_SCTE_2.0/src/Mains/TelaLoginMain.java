package Mains;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaLoginMain extends Application  {
	
	private static Stage stage;
	
	
	/**
     * @param args the command line arguments
     */
 
	
	
	@Override
    public void start(Stage stage) throws Exception {
		 Parent root = FXMLLoader.load(getClass().getResource("/View/TelaLoginFXML.fxml"));
	        stage.initStyle(StageStyle.UNDECORATED);
	        Scene scene = new Scene(root);
	     //  stage.setTitle("Login");
	        
	        
	        
	        stage.setScene(scene);
	        stage.show();
	    }

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        launch(args);
	    }
	    public static Stage getStage() {
	    	return stage;
	    }
	    
	    public static void setStage(Stage stage) {
	    	
	    	TelaLoginMain.stage = stage;
	    }

	}
