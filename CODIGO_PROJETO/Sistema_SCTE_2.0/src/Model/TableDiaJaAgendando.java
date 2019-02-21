package Model;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableDiaJaAgendando {

	
	

	private final SimpleIntegerProperty   in_pv_id ;
	private final SimpleStringProperty  st_pv_clienteNome;
	private final SimpleStringProperty  st_pv_procedimentoEsteticoNome;
	private final SimpleStringProperty  st_pv_profissionalEsteticoNome;
	private final SimpleStringProperty  dt_pv_data_marcada;
	private final SimpleStringProperty  dt_pv_hora_marcada;

	
	public TableDiaJaAgendando(int in_pv_id, String clienteNome,String procedimentoEsteticoNome ,String profissionalEsteticoNome , String dt_pv_data_marcada,String dt_pv_hora_marcada) {
		
		super();
		this.in_pv_id = new SimpleIntegerProperty(in_pv_id);
		this.st_pv_clienteNome = new SimpleStringProperty(clienteNome); 
		this.st_pv_procedimentoEsteticoNome = new SimpleStringProperty(procedimentoEsteticoNome); 
		this.st_pv_profissionalEsteticoNome =  new SimpleStringProperty(profissionalEsteticoNome); 
		this.dt_pv_data_marcada = new SimpleStringProperty(dt_pv_data_marcada); 
		this.dt_pv_hora_marcada = new SimpleStringProperty(dt_pv_hora_marcada); 
		
		
		 System.out.println(this.in_pv_id );
		 System.out.println(this.st_pv_clienteNome );
		 System.out.println(this.st_pv_procedimentoEsteticoNome);
		 System.out.println(this.st_pv_profissionalEsteticoNome );
		 System.out.println(this.dt_pv_data_marcada);
		 System.out.println(this.dt_pv_hora_marcada);
	}
	
	
	public int getIn_pv_id() {
		return in_pv_id.get();
	}
	public String getClienteNome() {
		return st_pv_clienteNome.get();
	}
	

	
	public String getProcedimentoEsteticoNome() {
		return st_pv_procedimentoEsteticoNome.get();
	}
	public String getProfissionalEsteticoNome() {
		return st_pv_profissionalEsteticoNome.get();
	}
	public String getDt_pv_data_marcada() {
		return dt_pv_data_marcada.get();
	}
	public String getDt_pv_hora_marcada() {
		return dt_pv_hora_marcada.get();
	}
	
	
}
