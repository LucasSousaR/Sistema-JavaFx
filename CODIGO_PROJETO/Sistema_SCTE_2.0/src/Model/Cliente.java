package Model;

import java.util.List;

public class Cliente extends Pessoa {
	
	
	private int in_pv_id ;
	private int in_pv_id_convenio;
	//private List<Dependente> dependente;
	//private List<DiaAgendado> diaAgendado;
	
	
	
	
	
	public Cliente() {
		super();
	}
	public Cliente(int in_pv_id, int in_pv_id_convenio) {
		super();
		this.in_pv_id = in_pv_id;
		this.in_pv_id_convenio = in_pv_id_convenio;
	}
	public int getIn_pv_id() {
		return in_pv_id;
	}
	public void setIn_pv_id(int in_pv_id) {
		this.in_pv_id = in_pv_id;
	}
	public int getIn_pv_id_convenio() {
		return in_pv_id_convenio;
	}
	public void setIn_pv_id_convenio(int in_pv_id_convenio) {
		this.in_pv_id_convenio = in_pv_id_convenio;
	}
	
	
	
	

	

}
