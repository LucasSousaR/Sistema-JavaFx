package Model;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableViewProcedimentoEstetico {

	
	private final SimpleIntegerProperty   in_pv_id ;
	private final SimpleStringProperty  st_pv_nome;
	private final SimpleFloatProperty fl_pv_valor;
	
	public TableViewProcedimentoEstetico(int in_pv_id, String st_pv_nome, float fl_pv_valor ) {
		
		super();
		this.in_pv_id = new SimpleIntegerProperty(in_pv_id);
		this.st_pv_nome = new SimpleStringProperty(st_pv_nome);
		this.fl_pv_valor = new SimpleFloatProperty(fl_pv_valor);
	}
	
	
	public int getIn_pv_id() {
		return in_pv_id.get();
	}
	public String getSt_pv_nome() {
		return st_pv_nome.get();
	}
	public float getFl_pv_valor() {
		return fl_pv_valor.get();
				
	}
	
	
	
}
