package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.AdministradorDao;
import DAO.AtendenteDao;
import DAO.ClienteDao;
import DAO.ConvenioDao;
import DAO.EnderecoDao;
import DAO.EnderecoPessoaDao;
import DAO.PessoaDao;
import Mains.TelaCadastroMain;
import Mains.TelaLoginMain;
import Mains.TelaPrincipalMain;
import Model.Administrador;
import Model.Atendente;
import Model.Cliente;
import Model.Convenio;
import Model.EnderecoPessoa;
import Model.Endereço;
import Model.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastroUserCotroller implements Initializable {
	
	
	
	
	
	@FXML private TextField txtCadastroCpfUser;

    @FXML private TextField txtCadastroRgUser;

    @FXML private TextField txtCadastroNomeUser;

    @FXML private TextField txtCadastroSenhaUser;

    @FXML private TextField txtCadastroLoginUser;

    @FXML private TextField txtCadastroCelularUser;

    @FXML private TextField txtCadastroSenhaUser2;

    @FXML private ComboBox<String> comoboxCadastroUsuario;

    @FXML private Button tbnSair;

    @FXML private Button BtnCadastrarUser;

    @FXML private TextField txtSenhaAdmin;

    @FXML private TextField txtLoginAdmin;
    
    
    private List<String> ListCadastroUser = new ArrayList<>();
    private ObservableList<String >obsCadastroUser;

    @FXML
    void BtnCadastrarUserOnAction(ActionEvent event) {
    	
    	try {
    		CadastrarUsuario();
    	  txtCadastroCpfUser.clear();
    		txtCadastroRgUser.clear();
        	txtCadastroNomeUser.clear();
          txtCadastroSenhaUser.clear();
         	txtCadastroLoginUser.clear();
      	txtCadastroCelularUser.clear();
        	
       txtCadastroSenhaUser2.clear();
        	txtSenhaAdmin.clear();
       	txtLoginAdmin.clear();
        
    		
    	}catch (Exception e){
			
			Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setHeaderText("");
            dialogoAviso.setContentText(e.toString());
            dialogoAviso.showAndWait();
		}
    	
    	
    	
    	
    	
    	

    }

    
    
private void CadastrarUsuario() throws SQLException {
    	
    	Pessoa pessoa = new Pessoa();
    	PessoaDao pessoaDao = new PessoaDao();
    	
    	
    	
    	
    	
    	Administrador administrador = new Administrador();
    	AdministradorDao administradorDao = new AdministradorDao();
    	
    	
    	Atendente atendente=  new Atendente();
    	AtendenteDao AtendenteDao  = new AtendenteDao();
    	
    	List <Pessoa>pessoas = new ArrayList<Pessoa>();

    	
    	String st_pv_TipoCadastro = comoboxCadastroUsuario.getSelectionModel().getSelectedItem();
    	
    	
    	
    


    

    	   

   // 	     BtnCadastrarUser;

    //	    

    	
    	
    	
    	
    	if(pessoa.CertificarCpf(txtCadastroCpfUser.getText()) == true) {
    		
    		
    		
    		
    		pessoa.setSt_pv_cpf(txtCadastroCpfUser.getText());
        	pessoa.setSt_pv_nome( txtCadastroNomeUser.getText());
        	pessoa.setSt_pv_rg(txtCadastroRgUser.getText());
        	pessoa.setSt_pv_telefone_celular(txtCadastroCelularUser.getText());
        	
        	pessoaDao.bo_pb_add_pessoa(pessoa);
        	
        	pessoas.add(pessoaDao.ob_pb_busca_Pessoa_cpf(txtCadastroCpfUser.getText().toString()));
        	
        	
        	System.out.println("ID "+ pessoas.get(0).getIn_pv_id());
        	///System.out.println("login "+ txtCadastroLoginUser.getText());
        	//System.out.println("senha "+ txtCadastroSenhaUser.getText());
        	
        	if( comoboxCadastroUsuario.getSelectionModel().getSelectedItem().equals("Administrador") ) {
        		System.out.println("entre adm");
        	
        		if(txtCadastroSenhaUser.getText().equals(txtCadastroSenhaUser2.getText())) {
        			
        			System.out.println("ID "+ pessoas.get(0).getIn_pv_id());
        			
        			administrador.setIn_pv_id(pessoas.get(0).getIn_pv_id());
        			administrador.setSt_pv_login(txtCadastroLoginUser.getText());
                	administrador.setSt_pv_senha(txtCadastroSenhaUser.getText());
                	
                	
                	System.out.println("id "+ administrador.getIn_pv_id());
                	System.out.println("login "+ administrador.getSt_pv_login());
                	System.out.println("senha "+ administrador.getSt_pv_senha());
                	
                	
                	if(txtSenhaAdmin.getText().equals("123456") && txtLoginAdmin.getText().equals("Admin")) {
                    	
                    	
                    	if(administradorDao.bo_pb_add_Admin(administrador) == true) {
                    		
                    		System.out.println("ADIMINISTRADOR CADASTRADA");
                    		
                    		 Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
                             dialogoAviso.setTitle("SUCESSO");
                             dialogoAviso.setHeaderText("");
                             dialogoAviso.setContentText("ADIMINISTRADOR CADASTRADO");
                             dialogoAviso.showAndWait();
                    		
                    		
                    	}else {
                    		System.out.println("ADIMINISTRADOR NAO CADASTRADA");
                    		

                    		Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
                            dialogoAviso.setTitle("ERROR");
                            dialogoAviso.setHeaderText("");
                            dialogoAviso.setContentText("NAO FOI POSSIVEL FAZER O CADASTRO,  CORRIGAR ALGUM DADO E TENTE NOVAMENTE ");
                            dialogoAviso.showAndWait();
                    	}
                	
                	
                	}else {
                    	
                    	Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
                        dialogoAviso.setTitle("ERROR");
                        dialogoAviso.setHeaderText("");
                        dialogoAviso.setContentText("LOGIN OU SENHA ADMINISTRADORA ESTAR INCORRETO");
                        dialogoAviso.showAndWait();
                		
                    }
                	
        		}else {
        			
        			Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
                    dialogoAviso.setTitle("ERROR");
                    dialogoAviso.setHeaderText("");
                    dialogoAviso.setContentText("AS SENHAS NAO SAO IGUAIS ");
                    dialogoAviso.showAndWait();
        			
        		}
        	
        		
        		
        	}else if(comoboxCadastroUsuario.getSelectionModel().getSelectedItem().equals("Atendente")) {
        		
        		
        	 if(txtCadastroSenhaUser.getText().equals(txtCadastroSenhaUser2.getText())) {
        			
        		 
        		 atendente.setIn_pv_id(pessoas.get(0).getIn_pv_id());
        		 atendente.setSt_pv_login(txtCadastroLoginUser.getText());
         		 atendente.setSt_pv_senha(txtCadastroSenhaUser.getText());
         		 
         		 
         		 
         		 

             	if(txtSenhaAdmin.getText().equals("123456") && txtLoginAdmin.getText().equals("Admin")) {
                 	
                 	
             		if(AtendenteDao.bo_pb_add_Atend(atendente) == true) {
                		System.out.println("ATENDENTE CADASTRADO");
                		
                		 Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
                         dialogoAviso.setTitle("SUCESSO");
                         dialogoAviso.setHeaderText("");
                         dialogoAviso.setContentText("ATENDENTE CADASTRADO");
                         dialogoAviso.showAndWait();
                		
                	}else {
                		System.out.println("ATENDENTE NÃO CADASTRADO");
                		
                		Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
                        dialogoAviso.setTitle("ERROR");
                        dialogoAviso.setHeaderText("");
                        dialogoAviso.setContentText("NAO FOI POSSIVEL FAZER O CADASTRO,  CORRIGAR ALGUM DADO E TENTE NOVAMENTE ");
                        dialogoAviso.showAndWait();
                		
                	}
             	
             	
             	}else {
                	
                	Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
                    dialogoAviso.setTitle("ERROR");
                    dialogoAviso.setHeaderText("");
                    dialogoAviso.setContentText("LOGIN OU SENHA ADMINISTRADORA ESTAR INCORRETO");
                    dialogoAviso.showAndWait();
            		
                }
             	
         		 
         		
        			
        		}else {
        			
        			Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
                    dialogoAviso.setTitle("ERROR");
                    dialogoAviso.setHeaderText("");
                    dialogoAviso.setContentText("AS SENHAS NAO SAO IGUAIS ");
                    dialogoAviso.showAndWait();
        			
        		}
        		
            		
        		
        	}
        	
       
        	
        	
        	
        

    	
        	
        	
    	}else {
    		
    		Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
            dialogoAviso.setTitle("DIGITE CPF CORRETAMENTE");
            dialogoAviso.setHeaderText("CPF Inválido");
            dialogoAviso.setContentText("O Erro aconteceu devido O CPF ser inválido ");
            dialogoAviso.showAndWait();
    	}
    }


    
    
    
    
    
    
    
    
    
    
    @FXML
    void tbnSairOnAction(ActionEvent event) {
    	

		TelaLoginMain TelaLogin = new TelaLoginMain();
			
		fechaar();
		try {
			
			TelaLogin.start(new Stage());
			
			
		}catch(Exception e){
			
			System.out.println("Deu Ruim");
		}
		

    }

    /*
     * @Carrega a classificaçao
     */
    public void carrregarComboBoxcomoboxCadastroUsuario() {
    	ListCadastroUser.add("Administrador");
    	ListCadastroUser.add("Atendente");
    	

    	    obsCadastroUser = FXCollections.observableArrayList(ListCadastroUser); 	
    	comoboxCadastroUsuario.setItems(obsCadastroUser);
    }
     


/*
* FUNCAO FECHAR
* está funcao fecha a pagina de login.
*/
public void fechaar() {
	
	//TelaCadastroMain.getStage().close();
	//System.exit(0);
}
    
 



@Override
public void initialize(java.net.URL arg0, ResourceBundle arg1) {
	
	
	carrregarComboBoxcomoboxCadastroUsuario();
	
}


}
