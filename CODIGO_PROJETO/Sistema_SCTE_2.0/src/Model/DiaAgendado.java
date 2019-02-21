package Model;

public class DiaAgendado {

	
	private int in_pv_id ;
	private  String clienteNome;
	private String procedimentoEsteticoNome;
	private String profissionalEsteticoNome;
	private String dt_pv_data_marcada;
	private String dt_pv_hora_marcada;
	
	
	

	
	
	public DiaAgendado() {
		
	}



	public DiaAgendado(int in_pv_id, String clienteNome, String procedimentoEsteticoNome,
			String profissionalEsteticoNome, String dt_pv_data_marcada, String dt_pv_hora_marcada) {
		super();
		this.in_pv_id = in_pv_id;
		this.clienteNome = clienteNome;
		this.procedimentoEsteticoNome = procedimentoEsteticoNome;
		this.profissionalEsteticoNome = profissionalEsteticoNome;
		this.dt_pv_data_marcada = dt_pv_data_marcada;
		this.dt_pv_hora_marcada = dt_pv_hora_marcada;
	}










	public int getIn_pv_id() {
		return in_pv_id;
	}










	public void setIn_pv_id(int in_pv_id) {
		this.in_pv_id = in_pv_id;
	}










	public String getClienteNome() {
		return clienteNome;
	}










	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}










	public String getProcedimentoEsteticoNome() {
		return procedimentoEsteticoNome;
	}










	public void setProcedimentoEsteticoNome(String procedimentoEsteticoNome) {
		this.procedimentoEsteticoNome = procedimentoEsteticoNome;
	}










	public String getProfissionalEsteticoNome() {
		return profissionalEsteticoNome;
	}










	public void setProfissionalEsteticoNome(String profissionalEsteticoNome) {
		this.profissionalEsteticoNome = profissionalEsteticoNome;
	}










	public String getDt_pv_data_marcada() {
		return dt_pv_data_marcada;
	}










	public void setDt_pv_data_marcada(String dt_pv_data_marcada) {
		this.dt_pv_data_marcada = dt_pv_data_marcada;
	}










	public String getDt_pv_hora_marcada() {
		return dt_pv_hora_marcada;
	}










	public void setDt_pv_hora_marcada(String dt_pv_hora_marcada) {
		this.dt_pv_hora_marcada = dt_pv_hora_marcada;
	}
	
	
	
}
