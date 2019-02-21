package Model;

public class DependenteCliente {
	
	private int in_pv_id ;
	private int in_pv_id_cliente;
	private int in_pv_id_dependente;
	
	
	
	
	public DependenteCliente() {
		
	}
	public DependenteCliente(int in_pv_id, int in_pv_id_cliente, int in_pv_id_dependente) {
		
		this.in_pv_id = in_pv_id;
		this.in_pv_id_cliente = in_pv_id_cliente;
		this.in_pv_id_dependente = in_pv_id_dependente;
	}
	public int getIn_pv_id() {
		return in_pv_id;
	}
	public void setIn_pv_id(int in_pv_id) {
		this.in_pv_id = in_pv_id;
	}
	public int getIn_pv_id_cliente() {
		return in_pv_id_cliente;
	}
	public void setIn_pv_id_cliente(int in_pv_id_cliente) {
		this.in_pv_id_cliente = in_pv_id_cliente;
	}
	public int getIn_pv_id_dependente() {
		return in_pv_id_dependente;
	}
	public void setIn_pv_id_dependente(int in_pv_id_dependente) {
		this.in_pv_id_dependente = in_pv_id_dependente;
	} 
	
	
	
}
