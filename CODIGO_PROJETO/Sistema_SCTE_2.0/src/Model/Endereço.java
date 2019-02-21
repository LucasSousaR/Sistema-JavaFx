package Model;

import java.util.List;

public class Endereço {

	
	private int in_pv_id ;
	private String st_pv_rua;
	private int st_pv_numero;
	private String st_pv_cep;	
	private String st_pv_complemento;
	private String st_pv_cidade;
	private String st_pv_bairro;
	private List<Pessoa> pessoa;
	
	
	
	
	
	


	public Endereço() {
		
	}

	public Endereço(int in_pv_id, String st_pv_rua, int st_pv_numero, String st_pv_cep, String st_pv_complemento,
			String st_pv_cidade, String st_pv_bairro, List<Pessoa> pessoa) {
		
		this.in_pv_id = in_pv_id;
		this.st_pv_rua = st_pv_rua;
		this.st_pv_numero = st_pv_numero;
		this.st_pv_cep = st_pv_cep;
		this.st_pv_complemento = st_pv_complemento;
		this.st_pv_cidade = st_pv_cidade;
		this.st_pv_bairro = st_pv_bairro;
		this.pessoa = pessoa;
	}

	public int getIn_pv_id() {
		return in_pv_id;
	}

	public void setIn_pv_id(int in_pv_id) {
		this.in_pv_id = in_pv_id;
	}

	public String getSt_pv_rua() {
		return st_pv_rua;
	}

	public void setSt_pv_rua(String st_pv_rua) {
		this.st_pv_rua = st_pv_rua;
	}

	public int getSt_pv_numero() {
		return st_pv_numero;
	}

	public void setSt_pv_numero(int st_pv_numero) {
		this.st_pv_numero = st_pv_numero;
	}

	public String getSt_pv_cep() {
		return st_pv_cep;
	}

	public void setSt_pv_cep(String st_pv_cep) {
		this.st_pv_cep = st_pv_cep;
	}

	public String getSt_pv_complemento() {
		return st_pv_complemento;
	}


	public void setSt_pv_complemento(String st_pv_complemento) {
		this.st_pv_complemento = st_pv_complemento;
	}

	public String getSt_pv_cidade() {
		return st_pv_cidade;
	}


	public void setSt_pv_cidade(String st_pv_cidade) {
		this.st_pv_cidade = st_pv_cidade;
	}


	public String getSt_pv_bairro() {
		return st_pv_bairro;
	}


	public void setSt_pv_bairro(String st_pv_bairro) {
		this.st_pv_bairro = st_pv_bairro;
	}


	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
	
	
	
	
}
