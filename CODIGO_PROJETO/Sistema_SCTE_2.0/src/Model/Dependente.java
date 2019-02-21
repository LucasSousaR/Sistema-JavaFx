package Model;

public class Dependente  extends Pessoa  {

	

	
	private int in_pv_id ;
	private String st_pv_nome;
	private String st_pv_cpf;
	private String st_pv_rg;
	private String st_pv_telefone_celular;
	private Cliente cliente;
	
	
	
	
	
	
	public Dependente() {
		
	}
	public Dependente(int in_pv_id, String st_pv_nome, String st_pv_cpf, String st_pv_rg, String st_pv_telefone_celular,
			Cliente cliente) {
		
		this.in_pv_id = in_pv_id;
		this.st_pv_nome = st_pv_nome;
		this.st_pv_cpf = st_pv_cpf;
		this.st_pv_rg = st_pv_rg;
		this.st_pv_telefone_celular = st_pv_telefone_celular;
		this.cliente = cliente;
	}
	public int getIn_pv_id() {
		return in_pv_id;
	}
	public void setIn_pv_id(int in_pv_id) {
		this.in_pv_id = in_pv_id;
	}
	public String getSt_pv_nome() {
		return st_pv_nome;
	}
	public void setSt_pv_nome(String st_pv_nome) {
		this.st_pv_nome = st_pv_nome;
	}
	public String getSt_pv_cpf() {
		return st_pv_cpf;
	}
	public void setSt_pv_cpf(String st_pv_cpf) {
		this.st_pv_cpf = st_pv_cpf;
	}
	public String getSt_pv_rg() {
		return st_pv_rg;
	}
	public void setSt_pv_rg(String st_pv_rg) {
		this.st_pv_rg = st_pv_rg;
	}
	public String getSt_pv_telefone_celular() {
		return st_pv_telefone_celular;
	}
	public void setSt_pv_telefone_celular(String st_pv_telefone_celular) {
		this.st_pv_telefone_celular = st_pv_telefone_celular;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
