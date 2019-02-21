package Mains;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaCadastroMain extends Application  {
		
	private static Stage stage;
	
		@Override
	    public void start(Stage stage) throws Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaCadastroUserFXML.fxml"));
	        stage.initStyle(StageStyle.UNDECORATED);
	        Scene scene = new Scene(root);
	        
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
	    	
	    	TelaCadastroMain.stage = stage;
	    }
	    
        
}
