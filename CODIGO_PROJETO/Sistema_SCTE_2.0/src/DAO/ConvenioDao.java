package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Conexao.Conexao;
import Model.Cliente;
import Model.Convenio;

public class ConvenioDao {
	
public static Conexao conexao = new Conexao();
	
	private static Connection con;
	
	
	public  ConvenioDao() {
		
		this.con = new Conexao().abreConexaoBD();
	}

	
	
/*
* bo_pb_add_Cliente
* ADICIONA CLIENTE A TABELA CLIENTE NO BANCO.
*/
	public boolean bo_pb_add_Convenio(Convenio convenio) throws SQLException {
			
		//	Connection con = conexao.abreConexaoBD();
		
			
			String sql = "INSERT INTO convenio (in_pv_id, st_pv_nome )  VALUES ( ?, ?);";
	    

			
	/*		  
	 if(PessoaDao.bo_pb_existe_banco_cpf(pessoa.getSt_pv_cpf())){
		 return false;
			    	   
	 }else {*/
			     
			        
	        try{
	        	
	        	 PreparedStatement stmt = con.prepareStatement(sql);

	        	 stmt.setInt(1, 1 );
	             stmt.setString(2, "Convenio");
	             
	            

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
