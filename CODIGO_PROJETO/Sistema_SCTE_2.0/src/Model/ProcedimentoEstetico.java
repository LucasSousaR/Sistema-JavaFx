package Model;

import java.util.List;

public class ProcedimentoEstetico {

	
	private int in_pv_id ;
	private String st_pv_nome;
	private String st_pv_descricao;
	private float fl_pv_valor;
	private ProfissionalEstetico profissionalEstetico;
	private List<DiaAgendado> diaAgendado;
	
	

	
	
	public ProcedimentoEstetico() {
		
	}
	public ProcedimentoEstetico(int in_pv_id, String st_pv_nome, String st_pv_descricao, float fl_pv_valor,
			ProfissionalEstetico profissionalEstetico, List<DiaAgendado> diaAgendado) {
		
		this.in_pv_id = in_pv_id;
		this.st_pv_nome = st_pv_nome;
		this.st_pv_descricao = st_pv_descricao;
		this.fl_pv_valor = fl_pv_valor;
		this.profissionalEstetico = profissionalEstetico;
		this.diaAgendado = diaAgendado;
	}
	public List<DiaAgendado> getDiaAgendado() {
		return diaAgendado;
	}
	public void setDiaAgendado(List<DiaAgendado> diaAgendado) {
		this.diaAgendado = diaAgendado;
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
	public String getSt_pv_descricao() {
		return st_pv_descricao;
	}
	public void setSt_pv_descricao(String st_pv_descricao) {
		this.st_pv_descricao = st_pv_descricao;
	}
	public float getFl_pv_valor() {
		return fl_pv_valor;
	}
	public void setFl_pv_valor(float fl_pv_valor) {
		this.fl_pv_valor = fl_pv_valor;
	}
	public ProfissionalEstetico getProfissionalEstetico() {
		return profissionalEstetico;
	}
	public void setProfissionalEstetico(ProfissionalEstetico profissionalEstetico) {
		this.profissionalEstetico = profissionalEstetico;
	}
	@Override
	public String toString() {
		return getSt_pv_nome();
	}
	
	
	
	
}
