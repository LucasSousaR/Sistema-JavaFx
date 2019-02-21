package Model;

import java.util.List;

public class ProfissionalEstetico  extends Pessoa  {
	
	
	private int in_pv_id ;
	private List<ProcedimentoEstetico> procedimentoEstetico;
	private List<DiaAgendado> diaAgendado;
	
	
	


	public ProfissionalEstetico() {
		
	}


	public ProfissionalEstetico(int in_pv_id, List<ProcedimentoEstetico> procedimentoEstetico,
			List<DiaAgendado> diaAgendado) {
		
		this.in_pv_id = in_pv_id;
		this.procedimentoEstetico = procedimentoEstetico;
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
	public List<ProcedimentoEstetico> getProcedimentoEstetico() {
		return procedimentoEstetico;
	}
	public void setProcedimentoEstetico(List<ProcedimentoEstetico> procedimentoEstetico) {
		this.procedimentoEstetico = procedimentoEstetico;
	}
	
	

}
