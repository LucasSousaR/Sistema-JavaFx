package Model;

import java.util.ArrayList;
import java.util.List;

import DAO.PessoaDao;
import DAO.ProcedimentoEsteticoDao;

public class TipoPesquisa {
	
	private int in_pv_id;
	private String st_pv_nome;
	
	
	
	
	@Override
	public String toString() {
		return getSt_pv_nome();
	}
	public TipoPesquisa() {
		
	}
	public TipoPesquisa(int in_pv_id, String st_pv_nome) {
		
		this.in_pv_id = in_pv_id;
		this.st_pv_nome = st_pv_nome;
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
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	
	  
	PessoaDao pessoaDao = new PessoaDao();
	ProcedimentoEsteticoDao procedimentoEsteticoDao = new ProcedimentoEsteticoDao();
	List <Pessoa>pessoaCliente = new ArrayList<Pessoa>();
	List <Pessoa>pessoaProfissional = new ArrayList<Pessoa>();
	List <ProcedimentoEstetico>ListProcedimentoEstetico = new ArrayList<ProcedimentoEstetico>();
	
	int cont=0;
	 int i =0;
	 while(rsAUX.next()) {
       cont++;
       
       System.out.println("PASSOU 1 ");
	   int in_pv_id_cliente = rsAUX.getInt("in_pv_id_cliente") ;
    	pessoaCliente.add(pessoaDao.ob_pb_busca_Pessoa_id(in_pv_id_cliente));

    	 System.out.println("PASSOU 2 ");
    	int in_pv_id_profissional = rsAUX.getInt("in_pv_id_profissional") ;
    	pessoaProfissional.add(pessoaDao.ob_pb_busca_Pessoa_id(in_pv_id_profissional));
    	 System.out.println("PASSOU 3 ");
    	
    	int in_pv_id_procedimento =  rsAUX.getInt("in_pv_id_procedimento") ;
      	ListProcedimentoEstetico.add(procedimentoEsteticoDao. ob_pb_busca_Procedimento_id(in_pv_id_procedimento));
      	
         
      	 System.out.println("PASSOU 4 ");
      	 
      	 
      	 
      	String nomeCliente = pessoaCliente.get(i).getSt_pv_nome();
  		System.out.println("PASSOU 5 ");
      	String nomeProssifional = pessoaProfissional.get(i).getSt_pv_nome();
      	System.out.println("PASSOU 6 ");
      	String nomeProcedimento = ListProcedimentoEstetico.get(i).getSt_pv_nome();
      	System.out.println("PASSOU 7 ");
	
	 
	 DiaAgendado pE = new DiaAgendado();
	 
	 System.out.println("Tamanho do cont "+ cont);
	 
	 

	

      		
	      	

	      	 System.out.println("id: " + rsAUX.getInt("in_pv_id"));
			// System.out.println("Cliente: "+ nomeCliente);
			 //System.out.println("Profissional: "+ nomeProssifional);
			 //System.out.println("procedimento: "+ nomeProcedimento);
			 System.out.println("Data: "+ rsAUX.getString("dt_pv_data"));
			 System.out.println("Hora:"+ rsAUX.getString("fm_pv_hora"));

	      	pE.setIn_pv_id(rs.getInt("in_pv_id")); 
	      	 pE.setDt_pv_hora_marcada(rsAUX.getString("fm_pv_hora"));
	      	pE.setDt_pv_data_marcada(rsAUX.getString("dt_pv_data")); 
			// pE.setClienteNome(nomeCliente);
			// pE.setProfissionalEsteticoNome(nomeProssifional);
			// pE.setProcedimentoEsteticoNome(nomeProcedimento);
	      	
	
	*/
	
	
}
