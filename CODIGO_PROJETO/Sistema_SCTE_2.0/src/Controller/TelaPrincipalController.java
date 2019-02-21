package Controller;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import DAO.ClienteDao;
import DAO.ConvenioDao;
import DAO.DependenteClienteDao;
import DAO.DependenteDao;
import DAO.DiaAgendadoDao;
import DAO.EnderecoDao;
import DAO.EnderecoPessoaDao;
import DAO.PessoaDao;
import DAO.ProcedimentoEsteticoDao;
import DAO.ProcedimentoProfissionalDao;
import DAO.ProfissionalEsteticoDao;
import Mains.TelaLoginMain;
import Mains.TelaPrincipalMain;
import Model.Cliente;
import Model.Convenio;
import Model.Dependente;
import Model.DependenteCliente;
import Model.DiaAgendado;
import Model.EnderecoPessoa;
import Model.Endereço;
import Model.Pessoa;
import Model.ProcedimentoEstetico;
import Model.ProcedimentoProfissional;
import Model.ProfissionalEstetico;
import Model.TableDiaJaAgendando;
import Model.TableViewProcedimentoEstetico;
import Model.TipoPesquisa;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;


public class TelaPrincipalController  implements Initializable {
	 @FXML
	    private Button btnFechar;

	    @FXML
	    private TextField txtNomeCliente;

	    @FXML
	    private TextField txtCPFCliente;

	    @FXML
	    private TextField txtRGCliente;

	    @FXML
	    private TextField txtEnderecoCliente;

	    @FXML
	    private TextField txtNumEnderecoCliente;

	    @FXML
	    private TextField txtComplementoEnderCliente;

	    @FXML
	    private TextField txtBairroCliente;
	    

	    @FXML
	    private TextField txtCepEnderecoCliente;

	    @FXML
	    private TextField txtCidadeCliente;

	    @FXML
	    private TextField txtTelefoneFixoCliente;

	    @FXML
	    private TextField txtTelefoneCelularCliente;

	    @FXML
	    private Button btnCadastrarCliente;

	    @FXML
	    private Button btnAtualizarCliente;

	    @FXML
	    private Button btnExcluirCliente;

	    @FXML
	    private Button btnLimparCliente;

	    @FXML
	    private ComboBox<String> comboBoxAddConvenio;

	    @FXML
	    private Button btnSalvarConvenio;

	    @FXML
	    private ListView<String> listBoxConvenio;

	    @FXML
	    private Button btnExcluirConvenio;

	    @FXML
	    private TextField txtNomeDependente;

	    @FXML
	    private TextField txtCPFDependente;
	    
	    @FXML
	    private TextField txtRGDependente;

	    @FXML
	    private TextField txtCelularDependente;

	    @FXML
	    private Button btnCadastroDependente;

	    @FXML
	    private Button btnAtualizarDependente;

	    @FXML
	    private Button btnExcluirDependente;

	    @FXML
	    private Button btnLimparDependente;

	    @FXML
	    private TextField txtPesquisaCliente;
	    @FXML
	    private TextField txtPesquisaCliente1;
	    @FXML
	    private TextField txtPesquisaCliente2;
	    @FXML
	    private TextField txtPesquisaCliente4;
	    
	    

	    @FXML
	    private Button btnPesquisarCliente;

	    @FXML
	    private TextField txtNomePesquisaCliente;

	    @FXML
	    private TextField txtCelularPesquisa;

	    @FXML
	    private TextField txtCPFPesquisaCliente;

	    @FXML
	    private TextField txtRGPesquisa;
	    
	
	   
	    
	    @FXML
	    private TextField txtNomeProfissionalEstetico;

	    @FXML
	    private TextField txtCPFProfissionalEstetico;

	    @FXML
	    private TextField txtRGProfissionalEstetico;

	    @FXML
	    private TextField txtCelularProfissionalEstetico;

	    @FXML
	    private Button btnCadastroProfissional;

	    @FXML
	    private Button btnAtualizarProfissional;

	    @FXML
	    private Button btnExcluirProfissional;

	    @FXML
	    private Button btnLimparProfissional;

	    @FXML
	    private Button btnaddServiço;

	    @FXML
	    private ComboBox<ProcedimentoEstetico> comboBoxServicoPrestado;////////////////////

	    @FXML
	    private TextField txtNomePesquisaCliente11;

	    @FXML
	    private TextField txtCelularPesquisa11;

	    @FXML private TextField txtCPFPesquisaCliente11;

	    @FXML private TextField txtRGPesquisa11;
	    

	    @FXML private ListView<String> listBoxServicoPrestado; //--<<<<<<
	    
	    

	    @FXML private Button btnExcluirServiço;

	    @FXML private TextField txtNomeServicoProfissional;

	    @FXML private TextField txtValorServicoPofissional;

	    @FXML private TextArea txtDescricaoServicoProfissional;

	    @FXML private Button btnAddServiçoProfissional;

	    @FXML private Button btnCadastroServico;

	    @FXML  private Button btnAtualizarServico;

	    @FXML private Button btnExcluirServico;

	    @FXML private Button btnLimparServico;

	    
	    
//------------------------------ Tela Agendamento -------------------------------------------//
    
	    @FXML  private Tab tabPaneCadastro;
	    @FXML private Tab tabAgendamento;
	    
	    @FXML private Button     btnPesquisarClienteDependente;
	    @FXML private Button     btnAdicionarClienteDependente;
	    @FXML private Button     btnExcluirClienteDependente;
	    @FXML private TextField  txtPesquisaClienteDependente;
	    @FXML private TextField  txtNomePesquisaClienteDependente; 
	    @FXML private TextField  txtCPFPesquisaClienteDependente;
	    @FXML private TextField  txtRGPesquisaClienteDependente;
	   
	    @FXML private TextField  txtMin;
	    @FXML private TextField  txtHora;
	    @FXML private DatePicker dpData;
	    @FXML private Button btnCheckDisponibilidade;
	    @FXML private Button tbnCadastrarDiaAgenda;
	    
	    @FXML private TableView<TableViewProcedimentoEstetico> tabela;
	    @FXML private TableColumn<TableViewProcedimentoEstetico, String> colunaNome;
	    @FXML private TableColumn<TableViewProcedimentoEstetico, Double> colunaValor;
	    
	    @FXML private TableView<TableDiaJaAgendando> tabelaAgendado;
	    @FXML private TableColumn<TableDiaJaAgendando, String> tbAgendandoColumCliente;
	    @FXML private TableColumn<TableDiaJaAgendando, String> tbAgendandoColumServico;
	    @FXML private TableColumn<TableDiaJaAgendando, String> tbAgendandoColumData;
	    @FXML private TableColumn<TableDiaJaAgendando, String> tbAgendandoColumHora;
	    
	    @FXML private TextField  txtCelularPesquisaClienteDependete;
	    @FXML private ComboBox<String> comboBoxPesquisaClienteDependente;
	    @FXML private ComboBox<ProcedimentoEstetico> comboBoxSelecionarServicoCliDep;
	    @FXML private ListView<String>listBoxEscolhaServico;
	    @FXML private ListView<String>ListViewClienteDependente;
	    
	   
	    
	    private List<String> PesquisaCilenteDependente = new ArrayList<>();
	    private ObservableList<String >obsPesquisaClientDependente;
	    private ObservableList<ProcedimentoEstetico>obsProcedimentoEsteticoAg;
	    private List<Double> somaFloatList = new ArrayList<>();
	    private List<TableViewProcedimentoEstetico> Tabelas = new ArrayList<>();
        private ObservableList<TableViewProcedimentoEstetico> listServicosItemsTable = FXCollections.observableArrayList();
        
        private List<TableDiaJaAgendando> tabelasAgendado = new ArrayList<>();
        private ObservableList<TableDiaJaAgendando> oblistAgendaItemsTable = FXCollections.observableArrayList();


	    
	    //final ObservableList<String> listServicosItems = FXCollections.observableArrayList("SERVIÇO:                                           VALOR:"); 
	    
	    
	    
	    
	    public void carrregarComboBoxPesquaisaClienteDependente() {
	    	PesquisaCilenteDependente.add("Cliente");
	    	PesquisaCilenteDependente.add("Dependente");

	    	obsPesquisaClientDependente = FXCollections.observableArrayList(PesquisaCilenteDependente); 	
	    	comboBoxPesquisaClienteDependente.setItems(obsPesquisaClientDependente);
	    }
	    
	    
	   
	    
	    @FXML
	    void tbnCadastrarDiaAgendaOnAction(ActionEvent event) throws SQLException {
	    	
	    	//carregarTableAgendamento();
	    	Pessoa pessoa = new Pessoa();
	    	PessoaDao pessoaDao = new PessoaDao();
	    	ProfissionalEsteticoDao profissionalEsteticoDao= new ProfissionalEsteticoDao();
	    	ProcedimentoEsteticoDao procedimentoEsteticoDao = new ProcedimentoEsteticoDao();
	    	ProcedimentoProfissionalDao procedimentoProfissionalDao = new ProcedimentoProfissionalDao();
	    	List <Pessoa>pessoaCliente = new ArrayList<Pessoa>();
	    	List <Pessoa>pessoaProfissional = new ArrayList<Pessoa>();
	    	List <ProcedimentoEstetico>ListProcedimentoEstetico = new ArrayList<ProcedimentoEstetico>();
	    	List <ProcedimentoProfissional>ListprocedimentoProfissional= new ArrayList<ProcedimentoProfissional>();
	    
	     	List <Pessoa>pessoas = new ArrayList<Pessoa>();
	     	List<Dependente> dependentes = new ArrayList<Dependente>();
	    	
	    	
	    	DiaAgendadoDao diaAgendadoDao = new DiaAgendadoDao();
	    	
	    	int Hora= Integer.parseInt(txtHora.getText());
	    	int Min= Integer.parseInt(txtMin.getText());
	    	String Hm = Hora + ":" + Min+":00";
	    	
	    	String Data = dpData.getValue().toString();
	    	
			
			String NomeComboBox = comboBoxSelecionarServicoCliDep.getSelectionModel().getSelectedItem().getSt_pv_nome();
			String st_pv_TipoPesquisa = comboBoxPesquisaClienteDependente.getSelectionModel().getSelectedItem();
			System.out.println("st_pv_TipoPesquisa "+ st_pv_TipoPesquisa);
			String st_pv_servicoPegoClienteDependente = comboBoxSelecionarServicoCliDep.getSelectionModel().getSelectedItem().getSt_pv_nome();
			System.out.println("st_pv_servicoPegoClienteDependente "+ st_pv_servicoPegoClienteDependente);
			
			int AuxCliente = 0; 
			try {
					if(st_pv_TipoPesquisa == "Cliente") {
						
						pessoas.add(PessoaDao.ob_pb_busca_Pessoa_cpf(txtPesquisaClienteDependente.getText().toString()));
			    	
						pessoaCliente.add(pessoas.get(0));
						AuxCliente = pessoaCliente.get(0).getIn_pv_id();
					}else if(st_pv_TipoPesquisa == "Dependente") {
						
						dependentes.add(DependenteDao.ob_pb_busca_dependente_cpf(txtPesquisaClienteDependente.getText().toString()));
						pessoaCliente.add(dependentes.get(0));
						AuxCliente = pessoaCliente.get(0).getIn_pv_id();
					}
					
				
					
					
					txtPesquisaClienteDependente.clear();
					txtNomePesquisaClienteDependente.clear();
					txtCPFPesquisaClienteDependente.clear();
					txtRGPesquisaClienteDependente.clear();
					txtCelularPesquisaClienteDependete.clear();
					txtHora.clear();
					txtMin.clear();
					
					
					
					
					
				
				}catch (Exception e){
				
					
					Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
				    dialogoAviso.setTitle("DIGITE NOVAMENTE");
				    dialogoAviso.setHeaderText("");
				    dialogoAviso.setContentText("Cliente não Encontrado");
				    dialogoAviso.showAndWait();
					}

	    	
	    	
	    	
	    	

	    	ListProcedimentoEstetico.add(ProcedimentoEsteticoDao.ob_pb_busca_Procedimento_nome(st_pv_servicoPegoClienteDependente));
	    	ListprocedimentoProfissional.add(procedimentoProfissionalDao.ob_pb_busca__id_Procedimento(ListProcedimentoEstetico.get(0).getIn_pv_id()));
	    	
	    	///////////////////////
	    	
	    
	    	
	    	
	    	
	    	if(Hora<23 && Hora >= 0 ) {
	    		if(Min<60 && Min >= 0 ) {
	    			if(NomeComboBox != null) {
	    				if(Data != null ) {
	    					
	    					
	    						try {
									if(DiaAgendadoDao.bo_pb_existe_banco_Data(ListprocedimentoProfissional.get(0).getIn_pv_id_procedimento(), ListprocedimentoProfissional.get(0).getIn_pv_profissional(), Data, Hm)) {
									
										
									Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
									dialogoAviso.setTitle("");
									dialogoAviso.setHeaderText("");
									dialogoAviso.setContentText("Data já Resevada!");
									dialogoAviso.showAndWait();
															   
									 }else {
									
						 
									 try {
										 
										 	diaAgendadoDao.bo_pb_add_DiaAgendando(AuxCliente, ListProcedimentoEstetico.get(0), pessoaDao.ob_pb_busca_Pessoa_id(ListprocedimentoProfissional.get(0).getIn_pv_profissional()).getIn_pv_id(), Data, Hm);
									
									 } catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									}
												 
									 
						
											Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
								         dialogoAviso.setTitle("SUCESSO");
								         dialogoAviso.setHeaderText("");
								         dialogoAviso.setContentText("AGENDADO!");
								         dialogoAviso.showAndWait();
								
								  }
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	    				}
	    					
	    				}else {
	    					
	    					Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
				            dialogoAviso.setTitle("");
				            dialogoAviso.setHeaderText("");
				            dialogoAviso.setContentText("PREENCHA SERVIÇO");
				            dialogoAviso.showAndWait();
	    				}
	    			}else {
    					
    					Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
			            dialogoAviso.setTitle("");
			            dialogoAviso.setHeaderText("");
			            dialogoAviso.setContentText("MINUTOS FORA DO PADRAO. 0 À 59 ");
			            dialogoAviso.showAndWait();
    				}
	    		}else {
					
					Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
		            dialogoAviso.setTitle("");
		            dialogoAviso.setHeaderText("");
		            dialogoAviso.setContentText("HORA FORA DO PADRAO. 0 À 23 ");
		            dialogoAviso.showAndWait();
				}
	    }
	    
	    @FXML
	    void btnCheckDisponibilidadeOnAction(ActionEvent event) throws SQLException, ParseException {
	    	
	    
	    	Pessoa pessoa = new Pessoa();
	    	PessoaDao pessoaDao = new PessoaDao();
	    	ProfissionalEsteticoDao profissionalEsteticoDao= new ProfissionalEsteticoDao();
	    	ProcedimentoEsteticoDao procedimentoEsteticoDao = new ProcedimentoEsteticoDao();
	    	ProcedimentoProfissionalDao procedimentoProfissionalDao = new ProcedimentoProfissionalDao();
	    	List <Pessoa>pessoaCliente = new ArrayList<Pessoa>();
	    	List <Pessoa>pessoaProfissional = new ArrayList<Pessoa>();
	    	List <ProcedimentoEstetico>ListProcedimentoEstetico = new ArrayList<ProcedimentoEstetico>();
	    	List <ProcedimentoProfissional>ListprocedimentoProfissional= new ArrayList<ProcedimentoProfissional>();
	    	
	    	
	    	int Hora= Integer.parseInt(txtHora.getText());
	    	int Min= Integer.parseInt(txtMin.getText());
	    	String Hm = Hora + ":" + Min+":00";
	    	
	    	String Data = dpData.getValue().toString();
	    	
			
			String NomeComboBox = comboBoxSelecionarServicoCliDep.getSelectionModel().getSelectedItem().getSt_pv_nome();
			String st_pv_TipoPesquisa = comboBoxPesquisaClienteDependente.getSelectionModel().getSelectedItem();
			System.out.println("st_pv_TipoPesquisa "+ st_pv_TipoPesquisa);
			String st_pv_servicoPegoClienteDependente = comboBoxSelecionarServicoCliDep.getSelectionModel().getSelectedItem().getSt_pv_nome();
			System.out.println("st_pv_servicoPegoClienteDependente "+ st_pv_servicoPegoClienteDependente);
			

	    	

			ListProcedimentoEstetico.add(ProcedimentoEsteticoDao.ob_pb_busca_Procedimento_nome(st_pv_servicoPegoClienteDependente));
	    	ListprocedimentoProfissional.add(procedimentoProfissionalDao.ob_pb_busca__id_Procedimento(ListProcedimentoEstetico.get(0).getIn_pv_id()));
	    	
	    	///////////////////////
	    	
	    
	    	
	    	
	    	
	    	if(Hora<23 && Hora >= 0 ) {
	    		if(Min<60 && Min >= 0 ) {
	    			if(NomeComboBox != null) {
	    				if(Data != null ) {
	    					
	    					
	    						try {
									if(DiaAgendadoDao.bo_pb_existe_banco_Data(ListprocedimentoProfissional.get(0).getIn_pv_id_procedimento(), ListprocedimentoProfissional.get(0).getIn_pv_profissional(), Data, Hm)) {
									
										
									Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
									dialogoAviso.setTitle("");
									dialogoAviso.setHeaderText("");
									dialogoAviso.setContentText("Data já Resevada!");
									dialogoAviso.showAndWait();
															   
									 }else {
									
						 
									
												 
									 
						
											Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
								         dialogoAviso.setTitle("SUCESSO");
								         dialogoAviso.setHeaderText("");
								         dialogoAviso.setContentText("Disponivel!");
								         dialogoAviso.showAndWait();
								
								  }
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	    				}
	    					
	    				}else {
	    					
	    					Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
				            dialogoAviso.setTitle("");
				            dialogoAviso.setHeaderText("");
				            dialogoAviso.setContentText("PREENCHA SERVIÇO");
				            dialogoAviso.showAndWait();
	    				}
	    			}else {
    					
    					Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
			            dialogoAviso.setTitle("");
			            dialogoAviso.setHeaderText("");
			            dialogoAviso.setContentText("MINUTOS FORA DO PADRAO. 0 À 59 ");
			            dialogoAviso.showAndWait();
    				}
	    		}else {
					
					Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
		            dialogoAviso.setTitle("");
		            dialogoAviso.setHeaderText("");
		            dialogoAviso.setContentText("HORA FORA DO PADRAO. 0 À 23 ");
		            dialogoAviso.showAndWait();
				}
	    }
	    	
	    		
				
	    				

	    
	    @FXML
	    void btnExcluirClienteDependenteOnAction(ActionEvent event) {
   	
	    	TableViewProcedimentoEstetico selectItem = tabela.getSelectionModel().getSelectedItem();
	    	tabela.getItems().remove(selectItem);


	    }
	    
	    @FXML
	    void  btnPesquisarClienteDependenteOnAction(ActionEvent event) {
	    	
	    	
	    	Pessoa pessoa = new Pessoa();
	    	PessoaDao pessoaDao = new PessoaDao();
	     	List <Pessoa>pessoas = new ArrayList<Pessoa>();
	     	List<Dependente> dependentes = new ArrayList<Dependente>();
	    	
	     	
	     	String st_pv_TipoPesquisa = comboBoxPesquisaClienteDependente.getSelectionModel().getSelectedItem();
	     	System.out.println(st_pv_TipoPesquisa);
	     	
	     	try {
	     		if(st_pv_TipoPesquisa == "Cliente") {
	     			
	     			pessoas.add(PessoaDao.ob_pb_busca_Pessoa_cpf(txtPesquisaClienteDependente.getText().toString()));
		        	
		     		txtNomePesquisaClienteDependente.setText( pessoas.get(0).getSt_pv_nome());
		     		txtCPFPesquisaClienteDependente.setText( pessoas.get(0).getSt_pv_cpf());
		     		txtRGPesquisaClienteDependente.setText(pessoas.get(0).getSt_pv_rg());
		     		txtCelularPesquisaClienteDependete.setText(pessoas.get(0).getSt_pv_telefone_celular());
	     		}else if(st_pv_TipoPesquisa == "Dependente") {
	     			
	     			dependentes.add(DependenteDao.ob_pb_busca_dependente_cpf(txtPesquisaClienteDependente.getText().toString()));
	     			
	     			txtNomePesquisaClienteDependente.setText( dependentes.get(0).getSt_pv_nome());
		     		txtCPFPesquisaClienteDependente.setText( dependentes.get(0).getSt_pv_cpf());
		     		txtRGPesquisaClienteDependente.setText(dependentes.get(0).getSt_pv_rg());
		     		txtCelularPesquisaClienteDependete.setText(dependentes.get(0).getSt_pv_telefone_celular());
	     		}
	     		
	        	
	        	
	     	}catch (Exception e){
	     		
	     		
	     		Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
	            dialogoAviso.setTitle("DIGITE NOVAMENTE");
	            dialogoAviso.setHeaderText("");
	            dialogoAviso.setContentText("Cliente não Encontrado");
	            dialogoAviso.showAndWait();
	     	}
	    	
	    	
	    	

	    }
	    private String pegarComboBoxServicoClienteDependente() {
	    	
	    	
	    	System.out.println( " comboBox:  "+comboBoxSelecionarServicoCliDep.getSelectionModel().getSelectedItem().getSt_pv_nome());
	    	
	    	String st_pv_servicoPegoClienteDependente = comboBoxSelecionarServicoCliDep.getSelectionModel().getSelectedItem().getSt_pv_nome();
	    	
	    	return st_pv_servicoPegoClienteDependente;
	    }
	    
	  
	   public void carrregarComboBoxServicoClienteDependente() {
	    	
	    	
	    	
	    	List<ProcedimentoEstetico> pEsteticoList = new ProcedimentoEsteticoDao().getList();
	    	obsProcedimentoEsteticoAg = FXCollections.observableArrayList(pEsteticoList);

	    	comboBoxSelecionarServicoCliDep.setItems(obsProcedimentoEsteticoAg);
	    }

	    
	    @FXML
	    void btnAdicionarClienteDependenteOnAction(ActionEvent event){
	    	
	    	
	    	ProcedimentoEstetico procedimentoEstetico= new ProcedimentoEstetico();
	    	ProcedimentoEsteticoDao procedimentoEsteticoDao = new ProcedimentoEsteticoDao();	
	    	List <ProcedimentoEstetico>procedimentoEsteticos = new ArrayList<ProcedimentoEstetico>();
	    	
           // System.out.println("ComboBox  "+pegarComboBoxServicoClienteDependente());
    		
	    	
    		try {
				procedimentoEsteticos.add(ProcedimentoEsteticoDao.ob_pb_busca_Procedimento_nome(pegarComboBoxServicoClienteDependente()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    		System.out.println("ComboBox  "+procedimentoEsteticos.get(0).getSt_pv_nome());
    		
    		
   
    		TableViewProcedimentoEstetico pTableViewProcedimentoEstetico = new TableViewProcedimentoEstetico(procedimentoEsteticos.get(0).getIn_pv_id(), procedimentoEsteticos.get(0).getSt_pv_nome(), procedimentoEsteticos.get(0).getFl_pv_valor());
    		listServicosItemsTable.add( pTableViewProcedimentoEstetico);
    		
    		Tabelas.add(pTableViewProcedimentoEstetico);	
    		
            colunaNome.setCellValueFactory(new PropertyValueFactory<>("st_pv_nome"));
         	colunaValor.setCellValueFactory(new PropertyValueFactory<>("fl_pv_valor"));
         	tabela.setItems(listServicosItemsTable);
         		 
    			
         		
         		
    		
    		
	    }
	    
	    
	    public void carregarTableAgendamento() {
	    	
	    	  List<DiaAgendado> ListDiaAgendado = new DiaAgendadoDao().getList();

	  	   
	    	  
	    	  for(int i = 0 ; i< ListDiaAgendado.size(); i++) {
		  	    	System.out.println( ListDiaAgendado.get(i).getIn_pv_id());
		    		//
		  	    	System.out.println( ListDiaAgendado.get(i).getClienteNome());
		    		//
		  	    	System.out.println(ListDiaAgendado.get(i).getProcedimentoEsteticoNome() );
		    		//
		  	    	System.out.println( ListDiaAgendado.get(i).getProfissionalEsteticoNome());
		    		//
		  	    	System.out.println( ListDiaAgendado.get(i).getDt_pv_data_marcada());
		    		//
		  	    	System.out.println(ListDiaAgendado.get(i).getDt_pv_hora_marcada());
		  	    	}
	    	  
	    	  for(int i = 0 ; i< ListDiaAgendado.size(); i++) {

	  	    	TableDiaJaAgendando pTableViewTableDiaJaAgendando = new TableDiaJaAgendando(ListDiaAgendado.get(i).getIn_pv_id(),
	  	    			ListDiaAgendado.get(i).getClienteNome(), ListDiaAgendado.get(i).getProcedimentoEsteticoNome(),
	  	    			ListDiaAgendado.get(i).getProfissionalEsteticoNome(),ListDiaAgendado.get(i).getDt_pv_data_marcada(),
	  	    			ListDiaAgendado.get(i).getDt_pv_hora_marcada());
	  	    	
	  	    	
	  	    	oblistAgendaItemsTable.add( pTableViewTableDiaJaAgendando);
	  	    	tabelasAgendado.add(pTableViewTableDiaJaAgendando);
	    	 
	  	    	//System.out.println(tabelasAgendado);
	  	    	
	  	   	  tbAgendandoColumCliente.setCellValueFactory(new PropertyValueFactory<>("st_pv_clienteNome"));
	  	  	 tbAgendandoColumServico.setCellValueFactory(new PropertyValueFactory<>("st_pv_procedimentoEsteticoNome"));
	  	    	tbAgendandoColumData.setCellValueFactory(new PropertyValueFactory<>("dt_pv_data_marcada"));
	  	    tbAgendandoColumHora.setCellValueFactory(new PropertyValueFactory<>("dt_pv_hora_marcada"));
	  	    	
	      	tabelaAgendado.setItems(oblistAgendaItemsTable);
	      		///tabelaAgendado.getColumns().addAll(tbAgendandoColumCliente,tbAgendandoColumServico,tbAgendandoColumData,tbAgendandoColumHora);
	    	  }	
	    	  }
	  	    	
	  	    	
	  	    	
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	      		
	      		//
	      		//
	    		
	  	    	
	  	    
	    
	  	    
         		 
    			
	    @FXML
	    void btnFechouOnAction(ActionEvent event) {
	    	
	    	
	    	
	    	System.exit(0);
	    	//TelaPrincipalMain.getStage().close();
	    	
	    	
	    }
	   
	    private ObservableList<TableDiaJaAgendando> listaDeClientes() {
	    	
	    	List<DiaAgendado> ListDiaAgendado = new DiaAgendadoDao().getList();
	        return FXCollections.observableArrayList(
	                new TableDiaJaAgendando(ListDiaAgendado.get(0).getIn_pv_id(),
		  	    			ListDiaAgendado.get(0).getClienteNome(), ListDiaAgendado.get(0).getProcedimentoEsteticoNome(),
		  	    			ListDiaAgendado.get(0).getProfissionalEsteticoNome(),ListDiaAgendado.get(0).getDt_pv_data_marcada(),
		  	    			ListDiaAgendado.get(0).getDt_pv_hora_marcada())
	        		
	        		
	        		
	        		
	        		
	        		
	        );
	    }	
	
	  
 //----------------- --------------------------------------------------------- --------------------//
    
    private List<TipoPesquisa> PesquisaCliente = new ArrayList<>();
    private List<ProcedimentoEstetico> pEList = new ArrayList<>();
    
    
    ///private ObservableList<String> list = FXCollections.observableArrayList("Nome","CPF");
    
    final ObservableList<String> listItems = FXCollections.observableArrayList("Add Itens Aqui..."); 
    private ObservableList<ProcedimentoEstetico>obsProcedimentoEstetico;
 
    
    
    
    private String pegarComboBoxServico() {
    		
    	String st_pv_servicoPego = comboBoxServicoPrestado.getSelectionModel().getSelectedItem().getSt_pv_nome();
    	return st_pv_servicoPego;
    }
    
    public void carrregarComboBoxServico() {

    	List<ProcedimentoEstetico> pEsteticoList = new ProcedimentoEsteticoDao().getList();
    	obsProcedimentoEstetico= FXCollections.observableArrayList(pEsteticoList);
    	comboBoxServicoPrestado.setItems(obsProcedimentoEstetico);
    	
    }
    @FXML
    void comboBoxServicoPrestadoOnAction(ActionEvent event) {
 
    	
    	///comboBoxServicoPrestado ////////

    }


    @FXML
    void btnAtualizarClienteOnAction(ActionEvent event) {
    	
    	
    	Pessoa pessoa =new Pessoa();
    	PessoaDao pessoaDao =new PessoaDao();
    	Endereço endereco = new Endereço();
    	EnderecoDao enderecoDao = new EnderecoDao();
    	
    	if(pessoa.CertificarCpf(txtCPFCliente.getText())) {
    		
    		pessoa.setSt_pv_cpf(	txtCPFCliente.getText());
    		pessoa.setSt_pv_nome(txtNomeCliente.getText());
    		pessoa.setSt_pv_rg(txtRGCliente.getText());
    		pessoa.setSt_pv_telefone(txtTelefoneFixoCliente.getText());
    		pessoa.setSt_pv_telefone_celular(txtTelefoneCelularCliente.getText());

    		endereco.setSt_pv_bairro(txtBairroCliente.getText());
        	endereco.setSt_pv_cep(txtCepEnderecoCliente.getText());
        	endereco.setSt_pv_cidade(txtCidadeCliente.getText());
        	endereco.setSt_pv_complemento(txtComplementoEnderCliente.getText());
        	endereco.setSt_pv_numero(Integer.parseInt(txtNumEnderecoCliente.getText()));
        	endereco.setSt_pv_rua( txtEnderecoCliente.getText());
        	
        	txtPesquisaCliente2.clear();
        	txtCPFCliente.clear();
        	txtNomeCliente.clear();
        	txtRGCliente.clear();
        	txtTelefoneFixoCliente.clear();
        	txtTelefoneCelularCliente.clear();
        	
        	txtEnderecoCliente.clear();
        	txtNumEnderecoCliente.clear();
        	txtComplementoEnderCliente.clear();
        	txtCepEnderecoCliente.clear();
        	txtBairroCliente.clear();
        	txtCidadeCliente.clear();
        	
        	try {
				pessoaDao.bo_update_tab_pessoa(pessoa);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
	            dialogoAviso.setTitle("ERROR");
	            dialogoAviso.setHeaderText("");
	            dialogoAviso.setContentText("NAO FOI POSSIVEL ATUALIZAR DADOS");
	            dialogoAviso.showAndWait();
				
			}
        	try {
				enderecoDao.bo_update_tab_endereco(endereco);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
	            dialogoAviso.setTitle("ERRO");
	            dialogoAviso.setHeaderText("");
	            dialogoAviso.setContentText("NAO FOI POSSIVEL ATUALIZAR DADOS");
	            dialogoAviso.showAndWait();
			}
        	
        	Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
            dialogoAviso.setTitle("SUCESSO");
            dialogoAviso.setHeaderText("");
            dialogoAviso.setContentText("DADOS ATUALIZANDOS");
            dialogoAviso.showAndWait();
     	}
        	
    	}
    	
    	
    	
    
    
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	

    @FXML
    void btnAtualizarDependenteOnAction(ActionEvent event) {

    	
    	
    	
    	DependenteClienteDao dependenteClienteDao = new DependenteClienteDao ();
    	DependenteCliente dependenteCliente=new DependenteCliente();
    	DependenteDao dependenteDao = new DependenteDao();
    	Dependente dependente = new Dependente();
    	
    	List<Dependente> Dependentes = new ArrayList<>();
    	List<DependenteCliente> dependenteClientes = new ArrayList<>();
    	
    	
    	
    	try {
			
			
			dependente.setSt_pv_cpf(txtCPFDependente.getText());
			dependente.setSt_pv_nome(txtNomeDependente.getText());
			dependente.setSt_pv_rg(txtRGDependente.getText());
			dependente.setSt_pv_telefone_celular(txtCelularDependente.getText());
			
			
			dependenteDao.bo_update_tab_dependente(dependente);
			

					txtPesquisaCliente.clear();
			    	txtNomePesquisaCliente.clear();
			    	txtCPFPesquisaCliente.clear();
			    	txtRGPesquisa.clear();
			    	
			    	txtCelularPesquisa.clear();
			    	txtNomeDependente.clear();
			    	txtCPFDependente.clear();
			    	txtRGDependente.clear();
			    	txtCelularDependente.clear();
			    	
			    
			    	Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
		            dialogoAviso.setTitle("SUCESSO");
		            dialogoAviso.setHeaderText("");
		            dialogoAviso.setContentText("Dados do Dependente Atualizado");
		            dialogoAviso.showAndWait();
				
				
		
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

    @FXML
    void btnAtualizarProfissionalOnAction(ActionEvent event) {

    }

    @FXML
    void btnAtualizarServicoOnAction(ActionEvent event) {

    }

    @FXML
    void btnCadastrarOnActionCliente(ActionEvent event) {
  
    	try {
    		CadastrarCliente();
    		txtPesquisaCliente.clear();
    		txtCPFCliente.clear();
        	txtNomeCliente.clear();
        	txtRGCliente.clear();
        	txtTelefoneFixoCliente.clear();
        	txtTelefoneCelularCliente.clear();
        	
        	txtEnderecoCliente.clear();
        	txtNumEnderecoCliente.clear();
        	txtComplementoEnderCliente.clear();
        	txtCepEnderecoCliente.clear();
        	txtBairroCliente.clear();
        	txtCidadeCliente.clear();
    		
    	}catch (Exception e){
			
			Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setHeaderText("");
            dialogoAviso.setContentText(e.toString());
            dialogoAviso.showAndWait();
		}

    }

    @FXML
    void btnCadastroDependenteOnAction(ActionEvent event) {

    	try {
    		CadastrarDependente();
        	
        	
    		
    	}catch (Exception e){
			
			Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setHeaderText("");
            dialogoAviso.setContentText(e.toString());
            dialogoAviso.showAndWait();
		}

    	
    	
    }

    @FXML
    void btnCadastroProfissionalOnAction(ActionEvent event) {
 
    	try {
			CadastrarProfissional();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setHeaderText("");
            dialogoAviso.setContentText(e.toString());
            dialogoAviso.showAndWait();
		}
    	

    }

    @FXML
    void btnCadastroServicoOnAction(ActionEvent event) {

    }

    @FXML
    void btnExcluirCliente(ActionEvent event) {
    	
    	
    	Pessoa pessoa = new Pessoa();
    	PessoaDao pessoaDao = new PessoaDao();
    	List<Pessoa> pessoas = new ArrayList<Pessoa>();
    	List<EnderecoPessoa> enderecoPessoas = new ArrayList<EnderecoPessoa>();
    	
    	EnderecoPessoaDao  enderecoPessoaDao = new EnderecoPessoaDao();
    	
    	
    	
    	try {
			pessoas.add(PessoaDao.ob_pb_busca_Pessoa_cpf(txtCPFCliente.getText()));
			enderecoPessoas.add(enderecoPessoaDao.ob_pb_busca__id_Pessoa(pessoas.get(0).getIn_pv_id()));
			
			System.out.println("PESSOA"+pessoas.get(0));
			System.out.println("ENDERECO_PESSOA"+enderecoPessoas.get(0));
			
			if(enderecoPessoaDao.bo_pb_excluir_pessoaEndereco_(enderecoPessoas.get(0).getIn_pv_id_pessoa())) {
				
				
				
				
				if(pessoaDao.bo_pb_excluir_pessoa(pessoas.get(0).getSt_pv_cpf())) {
					
					
					
					
					Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
		            dialogoAviso.setTitle("SUCESSSO");
		            dialogoAviso.setHeaderText("");
		            dialogoAviso.setContentText("Cliente Deletado");
		            dialogoAviso.showAndWait();
					
		            
		            txtPesquisaCliente2.clear();
		        	txtCPFCliente.clear();
		        	txtNomeCliente.clear();
		        	txtRGCliente.clear();
		        	txtTelefoneFixoCliente.clear();
		        	txtTelefoneCelularCliente.clear();
		        	
		        	txtEnderecoCliente.clear();
		        	txtNumEnderecoCliente.clear();
		        	txtComplementoEnderCliente.clear();
		        	txtCepEnderecoCliente.clear();
		        	txtBairroCliente.clear();
		        	txtCidadeCliente.clear();

					
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			
			Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
            dialogoAviso.setTitle("ERRO");
            dialogoAviso.setHeaderText("");
            dialogoAviso.setContentText("Não foi possivel Deletar Cliente");
            dialogoAviso.showAndWait();
		}
    	
    	
    	
 	
    	
    	
    }

    @FXML
    void btnExcluirConvenioOnAction(ActionEvent event) {

    }

    @FXML
    void btnExcluirDependenteOnAction(ActionEvent event) {
    	
    	
    	
    	
    	
    	DependenteClienteDao dependenteClienteDao = new DependenteClienteDao ();
    	DependenteCliente dependenteCliente=new DependenteCliente();
    	DependenteDao dependenteDao = new DependenteDao();
    	Dependente dependente = new Dependente();
    	
    	List<Dependente> Dependentes = new ArrayList<>();
    	List<DependenteCliente> dependenteClientes = new ArrayList<>();
    	
    	
    	
    	try {
			Dependentes.add(dependenteDao.ob_pb_busca_dependente_cpf(txtCPFPesquisaCliente.getText()));
			
			
			
			dependenteClientes.add(dependenteClienteDao.ob_pb_busca__id_dependente(Dependentes.get(0).getIn_pv_id()));
			
			
			
			if(dependenteClienteDao.bo_pb_excluir_DependentePessoa(dependenteClientes.get(0).getIn_pv_id_dependente())) {
				
				
				if(dependenteDao.bo_pb_excluir_Dependente(txtCPFPesquisaCliente.getText())) {
				

					txtPesquisaCliente.clear();
			    	txtNomePesquisaCliente.clear();
			    	txtCPFPesquisaCliente.clear();
			    	txtRGPesquisa.clear();
			    	txtCelularPesquisa.clear();
			    	txtNomeDependente.clear();
			    	txtCPFDependente.clear();
			    	txtRGDependente.clear();
			    	txtCelularDependente.clear();
			    	
			    
			    	Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
		            dialogoAviso.setTitle("SUCESSO");
		            dialogoAviso.setHeaderText("");
		            dialogoAviso.setContentText("Dependente Deletado");
		            dialogoAviso.showAndWait();
				
				}
			}
			
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }

    @FXML
    void btnExcluirProfissionalOnAction(ActionEvent event) {
    	
    
    	Pessoa pessoa = new Pessoa();
    	PessoaDao pessoaDao = new PessoaDao();
    	   
    	
    	ProfissionalEstetico profissionalEstetico = new  ProfissionalEstetico();
    	ProfissionalEsteticoDao profissionalEsteticoDao = new  ProfissionalEsteticoDao();
    	
    	

    	ProcedimentoEstetico procedimentoEstetico= new ProcedimentoEstetico();
    	ProcedimentoEsteticoDao procedimentoEsteticoDao = new ProcedimentoEsteticoDao();

    	
    	
    	ProcedimentoProfissional procedimentoProfissional = new ProcedimentoProfissional();
    	ProcedimentoProfissionalDao procedimentoProfissionalDao = new ProcedimentoProfissionalDao();
    	
    	List <Pessoa>pessoas = new ArrayList<Pessoa>();
    	List <ProcedimentoEstetico>procedimentoEsteticos = new ArrayList<ProcedimentoEstetico>();
    	
    	List <ProfissionalEstetico>ListProfissionalEstetico = new ArrayList<ProfissionalEstetico>();
    	
    	
    	
    	try {
			try {
				pessoas.add(pessoaDao.ob_pb_busca_Pessoa_cpf(txtCPFProfissionalEstetico.getText()));
				
				if(profissionalEsteticoDao.bo_pb_existe_banco_in(pessoas.get(0).getIn_pv_id())) {
					profissionalEsteticoDao.bo_pb_excluir_Profissional(pessoas.get(0).getIn_pv_id());
					pessoaDao.bo_pb_excluir_pessoa(pessoas.get(0).getSt_pv_cpf());
					
					
					Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
		            dialogoAviso.setTitle("SUCESSO");
		            dialogoAviso.setHeaderText("");
		            dialogoAviso.setContentText("Profissional  Deletado");
		            dialogoAviso.showAndWait();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        	
        	
    }

    @FXML
    void btnExcluirServicoOnAction(ActionEvent event) {

    }

    @FXML
    void btnExcluirServiçoOnAction(ActionEvent event) {
    	

    	Pessoa pessoa = new Pessoa();
    	PessoaDao pessoaDao = new PessoaDao();
    	   
    	
    	ProfissionalEstetico profissionalEstetico = new  ProfissionalEstetico();
    	ProfissionalEsteticoDao profissionalEsteticoDao = new  ProfissionalEsteticoDao();
    	
    	

    	ProcedimentoEstetico procedimentoEstetico= new ProcedimentoEstetico();
    	ProcedimentoEsteticoDao procedimentoEsteticoDao = new ProcedimentoEsteticoDao();

    	
    	
    	ProcedimentoProfissional procedimentoProfissional = new ProcedimentoProfissional();
    	ProcedimentoProfissionalDao procedimentoProfissionalDao = new ProcedimentoProfissionalDao();
    	
    	List <Pessoa>pessoas = new ArrayList<Pessoa>();
    	List <ProcedimentoEstetico>procedimentoEsteticos = new ArrayList<ProcedimentoEstetico>();
    	List <ProcedimentoProfissional> procedimentoProfissionalList = new ArrayList<ProcedimentoProfissional>();
	
    	int selectedItem = listBoxServicoPrestado.getSelectionModel().getSelectedIndex();
    	

    	
    	try {
    		
    		
    		System.out.println("1 "+listBoxServicoPrestado.getSelectionModel().getSelectedItem());
    
    		procedimentoEsteticos.add(ProcedimentoEsteticoDao.ob_pb_busca_Procedimento_nome(listBoxServicoPrestado.getSelectionModel().getSelectedItem()));
    		
    		
    		procedimentoProfissionalList.add(procedimentoProfissionalDao.ob_pb_busca__id_Procedimento( procedimentoEsteticos.get(0).getIn_pv_id()));
    			
    		
    		//System.out.println(procedimentoProfissionalList);
    		
    		if(procedimentoProfissionalList.get(0) == null)	{
    			
    			listItems.remove(selectedItem);
    		}else {
    		
	    		if(procedimentoProfissionalDao.bo_pb_excluir_procedimentoProfissional_Servico(procedimentoEsteticos.get(0).getIn_pv_id())== true) {
	    			
	    			
	    			listItems.remove(selectedItem);
	    		}
    		
    		
    		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	       

    }

    @FXML
    void btnFecharOnAction(ActionEvent event) {

    }

    @FXML
    void btnLimparClienteOnAction(ActionEvent event) {
    	
    	txtPesquisaCliente2.clear();
    	txtCPFCliente.clear();
    	txtNomeCliente.clear();
    	txtRGCliente.clear();
    	txtTelefoneFixoCliente.clear();
    	txtTelefoneCelularCliente.clear();
    	
    	txtEnderecoCliente.clear();
    	txtNumEnderecoCliente.clear();
    	txtComplementoEnderCliente.clear();
    	txtCepEnderecoCliente.clear();
    	txtBairroCliente.clear();
    	txtCidadeCliente.clear();

    }

    @FXML
    void btnLimparDependenteOnAction(ActionEvent event) {

    	
    	txtPesquisaCliente.clear();
    	txtNomePesquisaCliente.clear();
    	txtCPFPesquisaCliente.clear();
    	txtRGPesquisa.clear();
    	txtCelularPesquisa.clear();
    	txtNomeDependente.clear();
    	txtCPFDependente.clear();
    	txtRGDependente.clear();
    	txtCelularDependente.clear();
    	
    }

    @FXML
    void btnLimparProfissionalOnAction(ActionEvent event) {
    	
    	txtPesquisaCliente4.clear();
    	txtNomeProfissionalEstetico.clear();
    	txtCPFProfissionalEstetico.clear();
    	txtRGProfissionalEstetico.clear();
    	txtCelularProfissionalEstetico.clear();
    	txtNomeServicoProfissional.clear();
    	txtValorServicoPofissional.clear();
    	txtDescricaoServicoProfissional.clear();


    }

    @FXML
    void btnLimparServicoOnAction(ActionEvent event) {

    }
    @FXML
    void btnPesquisarCliente2OnAction(ActionEvent event) {
    	
    	
    	Pessoa pessoa = new Pessoa();
    	PessoaDao pessoaDao = new PessoaDao();
    	Endereço endereco = new Endereço();
    	EnderecoDao enderecoDao = new EnderecoDao();
    	EnderecoPessoaDao enderecoPessoaDao = new EnderecoPessoaDao();
    	
     	List <Pessoa>pessoas = new ArrayList<Pessoa>();
     	List <EnderecoPessoa>enderecos = new ArrayList<EnderecoPessoa>();
     	List <Endereço>listenderecos = new ArrayList<Endereço>();
    	
    	try {
    		
     		
     		
    		
     		pessoas.add(PessoaDao.ob_pb_busca_Pessoa_cpf(txtPesquisaCliente2.getText().toString()));
     			
     		if(ClienteDao.bo_pb_existe_banco_id(pessoas.get(0).getIn_pv_id())) {
    		
     			
         		
	         	txtNomeCliente.setText( pessoas.get(0).getSt_pv_nome());
	         	txtTelefoneFixoCliente.setText(pessoas.get(0).getSt_pv_telefone());
	           	txtCPFCliente.setText( pessoas.get(0).getSt_pv_cpf());
	           	txtRGCliente.setText(pessoas.get(0).getSt_pv_rg());
	            txtTelefoneCelularCliente.setText(pessoas.get(0).getSt_pv_telefone_celular());
	            	
	           
         		listenderecos.add(enderecoDao.ob_pb_busca_Endereco_id(EnderecoPessoaDao.ob_pb_busca__id_Pessoa(pessoas.get(0).getIn_pv_id()).getIn_pv_endereco()));
         		
	              txtBairroCliente.setText(listenderecos.get(0).getSt_pv_bairro());
	            	txtCepEnderecoCliente.setText(listenderecos.get(0).getSt_pv_cep());
	            	txtCidadeCliente.setText(listenderecos.get(0).getSt_pv_cidade());
	            	txtComplementoEnderCliente.setText(listenderecos.get(0).getSt_pv_complemento());
	                txtNumEnderecoCliente.setText(Integer.toString(listenderecos.get(0).getSt_pv_numero()));
	            	 txtEnderecoCliente.setText(listenderecos.get(0).getSt_pv_rua());
	   	  	
            	
     		}
        	
     		
        	
     	}catch (Exception e){
     		
     		
     		Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
            dialogoAviso.setTitle("DIGITE NOVAMENTE");
            dialogoAviso.setHeaderText("");
            dialogoAviso.setContentText("Cliente não Encontrado");
            dialogoAviso.showAndWait();
     	}
     	
    }
    @FXML
    void btnPesquisarCliente4OnAction(ActionEvent event) {
    	
    	Pessoa pessoa = new Pessoa();
    	PessoaDao pessoaDao = new PessoaDao();
     	List <Pessoa>pessoas = new ArrayList<Pessoa>();
    	
    	try {
     		pessoas.add(PessoaDao.ob_pb_busca_Pessoa_cpf(txtPesquisaCliente4.getText().toString()));
		
     		if(ProfissionalEsteticoDao.bo_pb_existe_banco_id(pessoas.get(0).getIn_pv_id())) {
     			
     			txtNomeProfissionalEstetico.setText( pessoas.get(0).getSt_pv_nome());
         		//txtTelefoneFixoCliente.setText(pessoas.get(0).getSt_pv_telefone());
     			txtCPFProfissionalEstetico.setText( pessoas.get(0).getSt_pv_cpf());
     			txtRGProfissionalEstetico.setText(pessoas.get(0).getSt_pv_rg());
     			txtCelularProfissionalEstetico.setText(pessoas.get(0).getSt_pv_telefone_celular());
     			
     		}else {
     			Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
                dialogoAviso.setTitle("DIGITE NOVAMENTE");
                dialogoAviso.setHeaderText("");
                dialogoAviso.setContentText("Profissional Estetico não Encontrado");
                dialogoAviso.showAndWait();
     			
     		}
     		
        	
        	
     	}catch (Exception e){
     		
     		
     		Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
            dialogoAviso.setTitle("DIGITE NOVAMENTE");
            dialogoAviso.setHeaderText("");
            dialogoAviso.setContentText("Profissional não Encontrado");
            dialogoAviso.showAndWait();
     	}
    	
    	
    }

    @FXML
    void btnPesquisarClienteOnAction(ActionEvent event) {
    	
    	

       	Pessoa pessoa = new Pessoa();
    	PessoaDao pessoaDao = new PessoaDao();
     	List <Pessoa>pessoas = new ArrayList<Pessoa>();
     	DependenteClienteDao dependenteClienteDao = new DependenteClienteDao ();
    	DependenteCliente dependenteCliente=new DependenteCliente();
    	DependenteDao dependenteDao = new DependenteDao();
    	Dependente dependente = new Dependente();
    	
    	List<Dependente> Dependentes = new ArrayList<>();
    	List<DependenteCliente> dependenteClientes = new ArrayList<>();
     	
     	try {
     		pessoas.add(PessoaDao.ob_pb_busca_Pessoa_cpf(txtPesquisaCliente.getText().toString()));
        	
     		if(PessoaDao.bo_pb_existe_banco_cpf(pessoas.get(0).getSt_pv_cpf())) {
     			
		        	txtNomePesquisaCliente.setText( pessoas.get(0).getSt_pv_nome());
		        	txtCPFPesquisaCliente.setText( pessoas.get(0).getSt_pv_cpf());
		        	txtRGPesquisa.setText(pessoas.get(0).getSt_pv_rg());
		        	txtCelularPesquisa.setText(pessoas.get(0).getSt_pv_telefone_celular());
		        	

		        	try {
		    			
		    			
		    			
		    			
		    			dependenteClientes.add(dependenteClienteDao.ob_pb_busca__id_cliente(pessoas.get(0).getIn_pv_id()));
		    		
		    			Dependentes.add(dependenteDao.ob_pb_busca_dependente_id(dependenteClientes.get(0).getIn_pv_id_dependente()));
		    			
   	
		    			    	txtCelularPesquisa.setText(Dependentes.get(0).getSt_pv_telefone_celular());
		    			    	txtNomeDependente.setText(Dependentes.get(0).getSt_pv_nome());
		    			    	txtCPFDependente.setText(Dependentes.get(0).getSt_pv_cpf());
		    			    	txtRGDependente.setText(Dependentes.get(0).getSt_pv_rg());
		    			    	txtCelularDependente.setText(Dependentes.get(0).getSt_pv_telefone_celular());

		    			
		    			
		    			
		    		} catch (SQLException e) {
		    			// TODO Auto-generated catch block
		    			e.printStackTrace();
		    		}
		        	
     		}
        	
     	}catch (Exception e){
     		
     		
     		Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
            dialogoAviso.setTitle("DIGITE NOVAMENTE");
            dialogoAviso.setHeaderText("");
            dialogoAviso.setContentText("Cliente não Encontrado");
            dialogoAviso.showAndWait();
     	}
    
     	
     	
     	
     	

    }

    @FXML
    void btnSalvarConvenioOnAction(ActionEvent event) {

    }

    @FXML
    void btnSalvarServiçoOnAction(ActionEvent event) {
    	
    	listItems.add(pegarComboBoxServico());
    	
    	

    }

    @FXML
    void btnSalvarServiçoProfissionalOnAction(ActionEvent event) {
    	
    	
    	
    	
    	
    	
    	try {
			CadastrarProcedimento();
			
			
			listItems.add(txtNomeServicoProfissional.getText());
			System.out.println("add lisItems");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	txtNomeServicoProfissional.clear();
    	txtValorServicoPofissional.clear();
    	txtDescricaoServicoProfissional.clear();
    	
	     //System.out.println("Add Button Pushed");
    	

    }

    @FXML
    void comboBoxAddConvenioOnAction(ActionEvent event) {

    }

   
  
    
 private void CadastrarProfissional() throws SQLException {
    	
    	Pessoa pessoa = new Pessoa();
    	PessoaDao pessoaDao = new PessoaDao();
    	   
    	
    	ProfissionalEstetico profissionalEstetico = new  ProfissionalEstetico();
    	ProfissionalEsteticoDao profissionalEsteticoDao = new  ProfissionalEsteticoDao();
    	
    	

    	ProcedimentoEstetico procedimentoEstetico= new ProcedimentoEstetico();
    	ProcedimentoEsteticoDao procedimentoEsteticoDao = new ProcedimentoEsteticoDao();

    	
    	
    	ProcedimentoProfissional procedimentoProfissional = new ProcedimentoProfissional();
    	ProcedimentoProfissionalDao procedimentoProfissionalDao = new ProcedimentoProfissionalDao();
    	
    	List <Pessoa>pessoas = new ArrayList<Pessoa>();
    	List <ProcedimentoEstetico>procedimentoEsteticos = new ArrayList<ProcedimentoEstetico>();
    	
    	List <String>ListServico = new ArrayList<String>();
    	
    	if(pessoa.CertificarCpf(txtCPFProfissionalEstetico.getText().toString()) == true) {
    		
    		pessoa.setSt_pv_cpf(txtCPFProfissionalEstetico.getText());
    		pessoa.setSt_pv_nome( txtNomeProfissionalEstetico.getText());
    		pessoa.setSt_pv_rg(txtRGProfissionalEstetico.getText());
    		pessoa.setSt_pv_telefone_celular(txtCelularProfissionalEstetico.getText());
        	
        	System.out.println("Passou 2");
        	
        	
        	
        	
        	
        	
        	/// fazer certificação que foram adicionandos no banco
        	
        	if( pessoaDao.bo_pb_add_pessoa(pessoa)== true) {
        		
        		System.out.println("PROFISSIONAL CADASTRADO");
        		
        		
        	}else {
        		System.out.println("PROFISSIONAL NÃO CADASTRADO");
        	}
        	
        	
        	
        	
        	pessoas.add(PessoaDao.ob_pb_busca_Pessoa_cpf(txtCPFProfissionalEstetico.getText().toString()));
        	
        	
        	
        	ListServico.addAll( listBoxServicoPrestado.getItems());
        	
        	
        	profissionalEstetico.setIn_pv_id(pessoas.get(0).getIn_pv_id());
        	profissionalEsteticoDao.bo_pb_add_profissional(profissionalEstetico);
        	
        	
        	System.out.println(ListServico.size());
        	
        	
        	for(int i = 1; i <ListServico.size(); i++ ) {
        		
        		procedimentoProfissional.setIn_pv_profissional(pessoas.get(0).getIn_pv_id());
        		System.out.println(" pROFISSIONAL "+procedimentoProfissional.getIn_pv_profissional());
        		
        		
        		System.out.println(" lISTAA "+ListServico.get(i));
        		
        		
        	   procedimentoProfissional.setIn_pv_id_procedimento(procedimentoEsteticoDao.ob_pb_busca_Procedimento_nome(ListServico.get(i)).getIn_pv_id());
        		System.out.println("pROCEDIMENTO "+procedimentoProfissional.getIn_pv_id_procedimento());
        		
        		
        		
        		
        		try {
        			
        			procedimentoProfissionalDao.bo_pb_add_procedimentoProfissional(procedimentoProfissional);
        			
        		}catch (SQLException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	
        		
        	}
        	
  
   	
        	
        	 Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
             dialogoAviso.setTitle("SUCESSO!");
             dialogoAviso.setHeaderText("");
             dialogoAviso.setContentText("PROFISSIONAL CADASTRADO");
             dialogoAviso.showAndWait();
        	
    	}else {
    		
    		Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
            dialogoAviso.setTitle("DIGITE CPF CORRETAMENTE");
            dialogoAviso.setHeaderText("CPF Inválido");
            dialogoAviso.setContentText("O Erro aconteceu devido O CPF ser inválido ");
            dialogoAviso.showAndWait();
    	}
    }
  
    
 private void CadastrarProcedimento()throws SQLException {
	 

 	ProcedimentoEstetico procedimentoEstetico= new ProcedimentoEstetico();
 	ProcedimentoEsteticoDao procedimentoEsteticoDao = new ProcedimentoEsteticoDao();

 	
 	
 	procedimentoEstetico.setSt_pv_nome(txtNomeServicoProfissional.getText());
	procedimentoEstetico.setSt_pv_descricao(txtDescricaoServicoProfissional.getText());
	procedimentoEstetico.setFl_pv_valor(Float.parseFloat(txtValorServicoPofissional.getText()));
	
	
	 
	if( ProcedimentoEsteticoDao.bo_pb_add_procedimento(procedimentoEstetico)== true) {
		
		System.out.println("PROCEDIMENTO CADASTRADO");
		
		
		
		
		
		/// ENVIAR PARA ABA AO LADO
		
		
		
		
	}else {
		System.out.println("PROCEDIMENTO NÃO CADASTRADO");
		
		
		Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
        dialogoAviso.setTitle("ERRO INESPERADO");
        dialogoAviso.setHeaderText("");
        dialogoAviso.setContentText("Tente enviar Novamente ");
        dialogoAviso.showAndWait();
		
	}
	
	 
	 
 }
    
    
 private void CadastrarDependente() throws SQLException {
    	
    	Pessoa pessoa = new Pessoa();
    	PessoaDao pessoaDao = new PessoaDao();
    	
     	
    	
    	
    	List <Pessoa>pessoas = new ArrayList<Pessoa>();
    	List <Dependente>Dependentes = new ArrayList<Dependente>();
    	
    	
    	
    	Dependente dependente = new Dependente ();
    	DependenteDao dependenteDao  = new DependenteDao ();

    	DependenteCliente  dependenteCliente = new DependenteCliente ();
    	DependenteClienteDao  dependenteClienteDao = new DependenteClienteDao ();
    	
    	
    	
    	
    	
    	System.out.println("Passou 1");
    	System.out.println(txtCPFDependente.getText().toString());
    	
    	if(pessoa.CertificarCpf(txtCPFDependente.getText().toString()) == true) {
    		
    		dependente.setSt_pv_cpf(txtCPFDependente.getText());
    		dependente.setSt_pv_nome( txtNomeDependente.getText());
    		dependente.setSt_pv_rg(txtRGDependente.getText());
    		dependente.setSt_pv_telefone_celular(txtCelularDependente.getText());
        	
        	System.out.println("Passou 2");
        	
        	/// fazer certificação que foram adicionandos no banco
        	
        	if(DependenteDao.bo_pb_add_Dependente(dependente) == true) {
        		
        		System.out.println("DEPENDENTE CADASTRADO");
        		
        		
        	}else {
        		System.out.println("DEPENDENTE NÃO CADASTRADO");
        	}
        	
        	
        	
        	pessoas.add(PessoaDao.ob_pb_busca_Pessoa_cpf(txtPesquisaCliente.getText().toString()));
        	Dependentes.add(DependenteDao.ob_pb_busca_dependente_cpf(txtCPFDependente.getText().toString()));

        	
        	dependenteCliente.setIn_pv_id_cliente(pessoas.get(0).getIn_pv_id());
        	dependenteCliente.setIn_pv_id_dependente(Dependentes.get(0).getIn_pv_id());
        	
        	dependenteClienteDao.bo_pb_add_DependenteCliente(dependenteCliente);
        	
        	
        	
        	 Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
             dialogoAviso.setTitle(" SUCESSO! ");
             dialogoAviso.setHeaderText("");
             dialogoAviso.setContentText("DEPENDENTE CADASTRADO");
             dialogoAviso.showAndWait();
        	
    	}else {
    		
    		Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
            dialogoAviso.setTitle("DIGITE CPF CORRETAMENTE");
            dialogoAviso.setHeaderText("CPF Inválido");
            dialogoAviso.setContentText("O Erro aconteceu devido O CPF ser inválido ");
            dialogoAviso.showAndWait();
    	}
    }

   
    
    
    
 private void CadastrarCliente() throws SQLException {
    	
    	Pessoa pessoa = new Pessoa();
    	Endereço endereco = new Endereço ();
    	EnderecoPessoa enderecoPessoa= new EnderecoPessoa();
    	PessoaDao pessoaDao = new PessoaDao();
    	EnderecoDao enderecoDao = new EnderecoDao();
    	EnderecoPessoaDao enderecoPessoaDao = new EnderecoPessoaDao();
    	
    	
    	
    	Cliente cliente = new Cliente();
    	ClienteDao clienteDao = new ClienteDao();
    	Convenio convenio =  new Convenio();
    	ConvenioDao convenioDao  = new ConvenioDao();
    	
    	List <Pessoa>pessoas = new ArrayList<Pessoa>();
    	List <Endereço>enderecos = new ArrayList<Endereço>();
    	
    	
    	if(pessoa.CertificarCpf(txtCPFCliente.getText()) == true) {
    		
    		pessoa.setSt_pv_cpf(txtCPFCliente.getText());
        	pessoa.setSt_pv_nome( txtNomeCliente.getText());
        	pessoa.setSt_pv_rg(txtRGCliente.getText());
        	pessoa.setSt_pv_telefone(txtTelefoneFixoCliente.getText());
        	pessoa.setSt_pv_telefone_celular(txtTelefoneCelularCliente.getText());
        	
        	endereco.setSt_pv_rua(txtEnderecoCliente.getText());
        	endereco.setSt_pv_numero(Integer.parseInt(txtNumEnderecoCliente.getText()));
        	endereco.setSt_pv_complemento(txtComplementoEnderCliente.getText());
        	endereco.setSt_pv_cep(txtCepEnderecoCliente.getText());
        	endereco.setSt_pv_bairro(txtBairroCliente.getText());
        	endereco.setSt_pv_cidade(txtCidadeCliente.getText());
        	
        	/// fazer certificação que foram adicionandos no banco
        	
        	if(pessoaDao.bo_pb_add_pessoa(pessoa) == true) {
        		
        		System.out.println("PESSOA CADASTRADA");
        		
        		
        	}else {
        		System.out.println("PESSOA NAO CADASTRADA");
        	}
        	
        	if(enderecoDao.bo_pb_add_endereco(endereco) == true) {
        		System.out.println("ENDERECO CADASTRADO");
        		
        	}else {
        		System.out.println("ENDERECO NÃO CADASTRADO");
        		
        	}
        	
        	

        	 pessoas.add(pessoaDao.ob_pb_busca_Pessoa_cpf(txtCPFCliente.getText().toString()));
        	 enderecos.add(enderecoDao.ob_pb_busca_Endereco_cep(txtCepEnderecoCliente.getText().toString()));
        	 
        	 convenio.setIn_pv_id(1);
        	 convenio.setSt_pv_nome("Convenio");;
        	 
        	 convenioDao.bo_pb_add_Convenio(convenio);
        	 
        	 /// colocar certificacao se tiver mais de uma pessoa 
        	 enderecoPessoa.setIn_pv_endereco(enderecos.get(0).getIn_pv_id());
        	 enderecoPessoa.setIn_pv_id_pessoa(pessoas.get(0).getIn_pv_id());
        	 cliente.setIn_pv_id(pessoas.get(0).getIn_pv_id());
        	 cliente.setIn_pv_id_convenio(convenio.getIn_pv_id());;
        	 
        	 
        	 clienteDao.bo_pb_add_Cliente(cliente);
        	 
        	 enderecoPessoaDao.bo_pb_add_EnderecoPessoa(enderecoPessoa);
        	 
        	 
        	
        	 Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);
             dialogoAviso.setTitle("SUCESSO");
             dialogoAviso.setHeaderText("");
             dialogoAviso.setContentText("CLIENTE CADASTRADO");
             dialogoAviso.showAndWait();
        	
    	}else {
    		
    		Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
            dialogoAviso.setTitle("DIGITE CPF CORRETAMENTE");
            dialogoAviso.setHeaderText("CPF Inválido");
            dialogoAviso.setContentText("O Erro aconteceu devido O CPF ser inválido ");
            dialogoAviso.showAndWait();
    	}
    }



 
 @Override
 public void initialize(URL url, ResourceBundle rb) {
	 
	 carrregarComboBoxServico();
	 carrregarComboBoxPesquaisaClienteDependente();
	 carrregarComboBoxServicoClienteDependente();
	 carregarTableAgendamento();
	 
	
	 
	 
	
	 
	 listBoxServicoPrestado.setItems(listItems);
	// ListViewClienteDependente.setItems(listServicosItems);
	 
	 
  // Disable buttons to start /// 
	 btnAddServiçoProfissional.setDisable(true);
     btnExcluirServiço.setDisable(true);
     btnAdicionarClienteDependente.setDisable(false);
     
     if(tabela.getFocusModel().isFocused(0)) {
    	 btnAdicionarClienteDependente.setDisable(true);
     }
     
    /* 
     txtNomeServicoProfissional.focusedProperty().addListener(new ChangeListener<Boolean>() {
         public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
           if(comboBoxServicoPrestado.isFocused()){
        	   btnaddServiço.setDisable(false);
           }
        }
       });  *///
     

   // Add a ChangeListener to TextField to look for change in focus
	 txtNomeServicoProfissional.focusedProperty().addListener(new ChangeListener<Boolean>() {
     public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
       if(txtNomeServicoProfissional.isFocused()){
    	   btnAddServiçoProfissional.setDisable(false);
       }
    }
   });    

   // Add a ChangeListener to ListView to look for change in focus
	 listBoxServicoPrestado.focusedProperty().addListener(new ChangeListener<Boolean>() {
     public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
       if(listBoxServicoPrestado.isFocused()){
    	   btnExcluirServiço.setDisable(false);
       }
    }
   });    
   
 }  
    
    	
    }



