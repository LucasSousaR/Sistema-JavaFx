package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Conexao.Conexao;
import Model.Cliente;
import Model.DiaAgendado;
import Model.Pessoa;
import Model.ProcedimentoEstetico;
import Model.ProcedimentoProfissional;
import Model.ProfissionalEstetico;

public class DiaAgendadoDao {
	
	
	
	
	
	
public static Conexao conexao = new Conexao();
	
	private static Connection con;
	
	
	public  DiaAgendadoDao() {
		
		this.con = new Conexao().abreConexaoBD();
	}
	
	
	
	
	
/*
* bo_pb_add_Cliente
* ADICIONA CLIENTE A TABELA CLIENTE NO BANCO.
*/
	public boolean bo_pb_add_DiaAgendando(int id_cliente, ProcedimentoEstetico procedimentoEstetico,
			int id_profissionalEstetico, String dt_pv_data_marcada, String dt_pv_hora_marcada ) throws SQLException, ParseException {
			
		//	Connection con = conexao.abreConexaoBD();
		
		
    	
		Pessoa pessoa = new Pessoa();
    	PessoaDao pessoaDao = new PessoaDao();
    	ProfissionalEsteticoDao profissionalEsteticoDao= new ProfissionalEsteticoDao();
    	ProcedimentoEsteticoDao procedimentoEsteticoDao = new ProcedimentoEsteticoDao();
    	ProcedimentoProfissionalDao procedimentoProfissionalDao = new ProcedimentoProfissionalDao();
    	List <Pessoa>pessoaCliente = new ArrayList<Pessoa>();
    	List <Pessoa>pessoaProfissional = new ArrayList<Pessoa>();
    	List <ProcedimentoEstetico>ListProcedimentoEstetico = new ArrayList<ProcedimentoEstetico>();
    	List <ProcedimentoProfissional>ListprocedimentoProfissional= new ArrayList<ProcedimentoProfissional>();
			
			String sql = "INSERT INTO diaagendado ( in_pv_id_cliente , in_pv_id_procedimento , in_pv_id_profissional , dt_pv_data , fm_pv_hora )  VALUES ( ?, ?, ?,?, ?);";
	    
			
		
			
			//pessoaDao.ob_pb_busca_Pessoa_id();
			
			
			
	    	pessoaProfissional.add(PessoaDao.ob_pb_busca_Pessoa_id(id_profissionalEstetico));
	    	pessoaCliente.add(PessoaDao.ob_pb_busca_Pessoa_id(id_cliente));

			
	/*		  
	 if(PessoaDao.bo_pb_existe_banco_cpf(pessoa.getSt_pv_cpf())){
		 return false;
			    	   
	 }else {*/
			
	        try{
	        	
	        	 PreparedStatement stmt = con.prepareStatement(sql);

	        	 stmt.setInt(1, pessoaCliente.get(0).getIn_pv_id() );
	             stmt.setInt(2, procedimentoEstetico.getIn_pv_id());
	             stmt.setInt(3, pessoaProfissional.get(0).getIn_pv_id());
	             stmt.setString(4, dt_pv_data_marcada);
	             stmt.setString(5, dt_pv_hora_marcada);
	             
	            

	            stmt.executeUpdate();
	            stmt.close();

	            return true;

	        }catch(SQLException e){
	        	Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, e);
	                 System.out.println(e );
	                //JOptionPane.showMessageDialog(null,e);
	        return false;
	        }finally{
	            if (con != null) { con.close(); }

	                //ConnectionFactory.CloseConnection(conn, st);
	        }
			        
	 
	 		       
	}

public static  boolean bo_pb_existe_banco_Data(int in_pv_id_procedimento  ,
		int in_pv_id_profissional,String dt_pv_Data_marcada, String dt_pv_hora_marcada)throws SQLException{
   
	
	Connection con = conexao.abreConexaoBD();
	
    String sql=null;
    sql="  Select * from     diaagendado" + 
    		"   where in_pv_id_procedimento  ='"+ in_pv_id_procedimento +"' And in_pv_id_profissional = '"+ in_pv_id_profissional +"' and  dt_pv_data = '"+ dt_pv_Data_marcada +"' and fm_pv_hora = '"+ dt_pv_hora_marcada +"';";
   
    ResultSet rs = null;
    Statement st = con.createStatement();
    rs= st.executeQuery(sql);
    
    if(rs.next()){
    System.out.println(" Data  JA EXISTE");
    con.close();
   
        return true;
    }else{
        
        System.out.println(" Data AINDA  NAO EXISTE");
        con.close();
   
        return false;
    }

}
	       	

public static DiaAgendado  ob_pb_busca_DiaAgendado( String dt_pv_Data_marcada )throws SQLException{
	
	
	
	DiaAgendado diaAgendado = new DiaAgendado();
	Pessoa pessoa = new Pessoa();
	PessoaDao pessoaDao = new PessoaDao();
	ProfissionalEsteticoDao profissionalEsteticoDao= new ProfissionalEsteticoDao();
	ProcedimentoEsteticoDao procedimentoEsteticoDao = new ProcedimentoEsteticoDao();
	List <Pessoa>pessoaCliente = new ArrayList<Pessoa>();
	List <Pessoa>pessoaProfissional = new ArrayList<Pessoa>();
	List <ProcedimentoEstetico>ListProcedimentoEstetico = new ArrayList<ProcedimentoEstetico>();
	
	
	
    String sql=null;
    
    sql="select * from diaagendado  where dt_pv_data ='"+ dt_pv_Data_marcada+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	
    	
    	
    	int in_pv_id_cliente = rs.getInt("in_pv_id_cliente") ;
    	pessoaCliente.add(pessoaDao.ob_pb_busca_Pessoa_id(in_pv_id_cliente));
    	 
    	
    	int in_pv_id_profissional = rs.getInt("in_pv_id_profissional") ;
    	pessoaProfissional.add(pessoaDao.ob_pb_busca_Pessoa_id(in_pv_id_profissional));
    	 
    	
    	int in_pv_id_procedimento =  rs.getInt("in_pv_id_procedimento") ;
    	
    	ListProcedimentoEstetico.add(procedimentoEsteticoDao. ob_pb_busca_Procedimento_id(in_pv_id_procedimento));
    	
    	 diaAgendado.setIn_pv_id(rs.getInt("in_pv_id"));
    	 diaAgendado.setDt_pv_data_marcada(rs.getString("dt_pv_data"));
    	 diaAgendado.setDt_pv_hora_marcada(rs.getString("fm_pv_hora"));
    	 diaAgendado.setClienteNome(pessoaCliente.get(0).getSt_pv_nome());
    	 diaAgendado.setProfissionalEsteticoNome(pessoaProfissional.get(0).getSt_pv_nome());
    	 diaAgendado.setProcedimentoEsteticoNome(ListProcedimentoEstetico.get(0).getSt_pv_nome());
    	 
    	
    	
    	
    	
    }
    else
    	diaAgendado = null;
    conn.close();
    
	
  return diaAgendado;
 }		
	









public List<DiaAgendado> getList(){
	
	List<DiaAgendado> ListDiaAgendado = new ArrayList<>();
	
	List <Integer>IntpessoaCliente = new ArrayList<Integer>();
	List <Integer>IntpessoaProfissional = new ArrayList<Integer>();
	List <Integer>IntListProcedimentoEstetico = new ArrayList<Integer>();
	
	PessoaDao pessoaDao = new PessoaDao();
	ProcedimentoEsteticoDao procedimentoEsteticoDao = new ProcedimentoEsteticoDao();
	List <Pessoa>pessoaCliente = new ArrayList<Pessoa>();
	List <Pessoa>pessoaProfissional = new ArrayList<Pessoa>();
	List <ProcedimentoEstetico>ListProcedimentoEstetico = new ArrayList<ProcedimentoEstetico>();
	
	
	
	  String sql=null;
	
	 sql="select * from diaAgendado";
	 
	 
	 
	 
	 
	 try {
		 PreparedStatement stmt = con.prepareStatement(sql);
		 ResultSet rs = null;
		 Statement st=null;
		 st = con.createStatement();
		  rs= st.executeQuery(sql);
		 
		 
		 while(rs.next()) {
			 DiaAgendado pE = new DiaAgendado();
			   
			    int in_pv_id_cliente = rs.getInt("in_pv_id_cliente") ;
		    	int in_pv_id_profissional = rs.getInt("in_pv_id_profissional") ;
		    	int in_pv_id_procedimento =  rs.getInt("in_pv_id_procedimento") ;
		    	//System.out.println("INICIO " );
	    
		    	
		    	
		    	 
		    	/// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		    	
				    			
				    		if(rs.getString("fm_pv_hora")!= null && rs.getString("dt_pv_data") != null  && rs.getInt("in_pv_id_cliente") != 0 &&  rs.getInt("in_pv_id_profissional") != 0 && rs.getInt("in_pv_id_procedimento") != 0   ) {
				    		
								 pE.setIn_pv_id(rs.getInt("in_pv_id"));
								 pE.setDt_pv_hora_marcada(rs.getString("fm_pv_hora"));
						      	 pE.setDt_pv_data_marcada(rs.getString("dt_pv_data"));
						      	 pE.setClienteNome(pessoaDao.ob_pb_busca_Pessoa_id(in_pv_id_cliente).getSt_pv_nome());
						      	 pE.setProcedimentoEsteticoNome(procedimentoEsteticoDao. ob_pb_busca_Procedimento_id(in_pv_id_procedimento).getSt_pv_nome());
						      	 pE.setProfissionalEsteticoNome(pessoaDao.ob_pb_busca_Pessoa_id(in_pv_id_profissional).getSt_pv_nome());
						      	 
						      	
						      	 ListDiaAgendado.add(pE);
						      	 
						      	 System.out.println("AQUI DENTRO: " );
						      	 
						      	 
						      	// System.out.println(pE.getIn_pv_id());
								// System.out.println(pE.getClienteNome());
								// System.out.println(pE.getProcedimentoEsteticoNome());
								 //System.out.println(pE.getProfissionalEsteticoNome());
								 //System.out.println(pE.getDt_pv_data_marcada());
								 //System.out.println(pE.getDt_pv_hora_marcada());
				      		 
				      	 }else {
				      		rs.next();
				      		 
				      	 }
				    	
				    		// System.out.println("------------------------------------------------------- " );
		      	
		    	
		
	      
		 }
		 
		// System.out.println("Sai " );
		 
		
		 
		 
		 
		 st.close();
		 rs.close();
		 
	 }catch(SQLException e){
     	Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, e);
        System.out.println(e );
	 }
	 
	 
 System.out.println("FINALLLL");
	/*
	 for(int i =0; i< ListDiaAgendado.size(); i++) {
		 
		 System.out.println(ListDiaAgendado.get(i).getIn_pv_id());
		 System.out.println(ListDiaAgendado.get(i).getClienteNome());
		 System.out.println(ListDiaAgendado.get(i).getProcedimentoEsteticoNome());
		 System.out.println(ListDiaAgendado.get(i).getProfissionalEsteticoNome());
		 System.out.println(ListDiaAgendado.get(i).getDt_pv_data_marcada());
		 System.out.println(ListDiaAgendado.get(i).getDt_pv_hora_marcada());
	 }
	 */
	return ListDiaAgendado;
	
}










}



