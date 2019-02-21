package Model;

public class EnderecoPessoa {
	
	private int in_pv_id;
	private int in_pv_id_pessoa;
	private int in_pv_endereco;
	
	
	
	
	
	
	
	
	public EnderecoPessoa() {
		super();
	}
	public EnderecoPessoa(int in_pv_id, int in_pv_id_pessoa, int in_pv_endereco) {
		super();
		this.in_pv_id = in_pv_id;
		this.in_pv_id_pessoa = in_pv_id_pessoa;
		this.in_pv_endereco = in_pv_endereco;
	}
	public int getIn_pv_id() {
		return in_pv_id;
	}
	public void setIn_pv_id(int in_pv_id) {
		this.in_pv_id = in_pv_id;
	}
	public int getIn_pv_id_pessoa() {
		return in_pv_id_pessoa;
	}
	public void setIn_pv_id_pessoa(int in_pv_id_pessoa) {
		this.in_pv_id_pessoa = in_pv_id_pessoa;
	}
	public int getIn_pv_endereco() {
		return in_pv_endereco;
	}
	public void setIn_pv_endereco(int in_pv_endereco) {
		this.in_pv_endereco = in_pv_endereco;
	}
	

}
