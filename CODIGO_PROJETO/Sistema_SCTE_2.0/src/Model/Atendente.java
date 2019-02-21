package Model;

public class Atendente  extends Pessoa  {
	
	
	private int in_pv_id ;
	private String st_pv_senha;
    private String st_pv_login;
   
    
    
    
    
    
    
	public Atendente() {
		
	}
	public Atendente(int in_pv_id, String st_pv_senha, String st_pv_login) {
		
		this.in_pv_id = in_pv_id;
		this.st_pv_senha = st_pv_senha;
		this.st_pv_login = st_pv_login;
		
	}
	public int getIn_pv_id() {
		return in_pv_id;
	}
	public void setIn_pv_id(int in_pv_id) {
		this.in_pv_id = in_pv_id;
	}
	public String getSt_pv_senha() {
		return st_pv_senha;
	}
	public void setSt_pv_senha(String st_pv_senha) {
		this.st_pv_senha = st_pv_senha;
	}
	public String getSt_pv_login() {
		return st_pv_login;
	}
	public void setSt_pv_login(String st_pv_login) {
		this.st_pv_login = st_pv_login;
	}
	

}
