package Model;

public class Convenio {
	private int in_pv_id ;
	private Cliente cliente;
	private String st_pv_nome;
	
	
	
	
  public Convenio() {
		
	}
	
	public Convenio(int in_pv_id, Cliente cliente, String st_pv_nome) {
	super();
	this.in_pv_id = in_pv_id;
	this.cliente = cliente;
	this.st_pv_nome = st_pv_nome;
}

	public String getSt_pv_nome() {
		return st_pv_nome;
	}

	public void setSt_pv_nome(String st_pv_nome) {
		this.st_pv_nome = st_pv_nome;
	}

	

	
	public int getIn_pv_id() {
		return in_pv_id;
	}


	public void setIn_pv_id(int in_pv_id) {
		this.in_pv_id = in_pv_id;
	}



	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

}
