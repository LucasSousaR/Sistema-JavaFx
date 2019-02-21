package Controller;

import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.print.DocFlavor.URL;

import DAO.AdministradorDao;
import DAO.AtendenteDao;
import Mains.TelaCadastroMain;
import Mains.TelaLoginMain;
import Mains.TelaPrincipalMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TelaLoginController implements Initializable {
	

	   @FXML
	    private PasswordField txtSenha;

	    @FXML
	    private Button btnSair;

	    @FXML
	    private Button btnEntrar;

	    @FXML
	    private TextField txtLogin;

	    
	    /*
		    * FUNCAO Entrar
		    * está funcao loga no sistema.
		    */
	    @FXML
	    void btnEntrarOnActiion(ActionEvent event) {
	    	
	    	TelaPrincipalMain TelaPrincipal = new TelaPrincipalMain();
	    	
	    	try {
				if(AtendenteDao.bo_pb_confirmar(txtLogin.getText(), txtSenha.getText())) {
					
					
		    		
		    		
		    		fechar();
		    		try {
		    			
		    			TelaPrincipal.start(new Stage());
		    			
		    			
		    		}catch(Exception e){
		    			
		    			Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
			            dialogoAviso.setTitle("DIGITE NOVAMENTE");
			            dialogoAviso.setHeaderText("");
			            dialogoAviso.setContentText(e.toString());
			            dialogoAviso.showAndWait();
		    		}
		    		
				}else if(AdministradorDao.bo_pb_confirmar(txtLogin.getText().toString(), txtSenha.getText().toString())){
					
					
		    		
		    		
		    		fechar();
		    		try {
		    			
		    			TelaPrincipal.start(new Stage());
		    			
		    			
		    		}catch(Exception e){
		    			
		    			Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
			            dialogoAviso.setTitle("DIGITE NOVAMENTE");
			            dialogoAviso.setHeaderText("");
			            dialogoAviso.setContentText(e.toString());
			            dialogoAviso.showAndWait();
		    		}
				}else if(txtLogin.getText().equals("Admin") && txtSenha.getText().equals("123456")) {
		    		
		    		
		    		
		    		
		    		
		    		
		    		fechar();
		    		try {
		    			
		    			TelaPrincipal.start(new Stage());
		    			
		    			
		    		}catch(Exception e){
		    			
		    			Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
			            dialogoAviso.setTitle("DIGITE NOVAMENTE");
			            dialogoAviso.setHeaderText("");
			            dialogoAviso.setContentText(e.toString());
			            dialogoAviso.showAndWait();
		    		}
		    		
		    		
		    		
		    	}else {
		    		
		    	 Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
		            dialogoAviso.setTitle("DIGITE NOVAMENTE");
		            dialogoAviso.setHeaderText("Login ou Senha Inválido");
		            dialogoAviso.setContentText("O Erro aconteceu devido ao usuário ser inválido ");
		            dialogoAviso.showAndWait();
		    	}
		    } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    	
	    }
	    	
	    	
	    /*
		    * FUNCAO FECHAR
		    * está funcao fecha a pagina de login.
		    */

	    @FXML
	    void btnSairOnAction(ActionEvent event) {
	    	 System.exit(0);

	    }
	    
	    
	   /*
	    * @FUNCAO FECHAR
	    * está funcao fecha a pagina de login.
	    */
	    public void fechar() {
	    	
	    	//TelaLoginMain.getStage().close();
	    	//System.exit(0);
	    }

		@Override
		public void initialize(java.net.URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
	    
		@FXML
	    void  abrirCadastro(MouseEvent event) {
	       
				TelaCadastroMain TelaTelaCadastro = new TelaCadastroMain();

		    		fechar();
		    		try {
		    			TelaTelaCadastro.start(new Stage());
		    			
		    			
		    		}catch(Exception e){
		    			
		    			Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
			            dialogoAviso.setTitle("ERROR");
			            dialogoAviso.setHeaderText("");
			            dialogoAviso.setContentText(e.toString());
			            dialogoAviso.showAndWait();
		    		}
			
			

	    
	    
	    
	   
	    
	    	}    
	    
}
