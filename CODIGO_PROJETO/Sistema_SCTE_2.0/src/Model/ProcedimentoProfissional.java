package Model;

public class ProcedimentoProfissional {

	
	
	private int in_pv_id;
	private int in_pv_id_procedimento;
	private int in_pv_profissional;
	
	
	
	
	
	public ProcedimentoProfissional() {
		
	}
	public ProcedimentoProfissional(int in_pv_id, int in_pv_id_procedimento, int in_pv_profissional) {
		
		this.in_pv_id = in_pv_id;
		this.in_pv_id_procedimento = in_pv_id_procedimento;
		this.in_pv_profissional = in_pv_profissional;
	}
	public int getIn_pv_id() {
		return in_pv_id;
	}
	public void setIn_pv_id(int in_pv_id) {
		this.in_pv_id = in_pv_id;
	}
	public int getIn_pv_id_procedimento() {
		return in_pv_id_procedimento;
	}
	public void setIn_pv_id_procedimento(int in_pv_id_procedimento) {
		this.in_pv_id_procedimento = in_pv_id_procedimento;
	}
	public int getIn_pv_profissional() {
		return in_pv_profissional;
	}
	public void setIn_pv_profissional(int in_pv_profissional) {
		this.in_pv_profissional = in_pv_profissional;
	}
	
	
}
