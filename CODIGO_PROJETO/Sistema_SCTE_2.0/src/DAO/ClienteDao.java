package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Conexao.Conexao;
import Model.Cliente;
import Model.Pessoa;

public class ClienteDao {
	
	
	
public static Conexao conexao = new Conexao();
	
	private static Connection con;
	
	
	public  ClienteDao() {
		
		this.con = new Conexao().abreConexaoBD();
	}
	
	
/*
* bo_pb_add_Cliente
* ADICIONA CLIENTE A TABELA CLIENTE NO BANCO.
*/
	public boolean bo_pb_add_Cliente(Cliente cliente) throws SQLException {
			
		//	Connection con = conexao.abreConexaoBD();
		
			
			String sql = "INSERT INTO cliente ( in_pv_id, in_pv_id_convenio )  VALUES ( ?, ?);";
	    

			
	/*		  
	 if(PessoaDao.bo_pb_existe_banco_cpf(pessoa.getSt_pv_cpf())){
		 return false;
			    	   
	 }else {*/
			     
			        
	        try{
	        	
	        	 PreparedStatement stmt = con.prepareStatement(sql);

	        	 stmt.setInt(1, cliente.getIn_pv_id() );
	             stmt.setInt(2, 1);
	             
	            

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
	

public static  boolean bo_pb_existe_banco_id(int St_pv_cpf )throws SQLException{
   
	
	Connection con = conexao.abreConexaoBD();
	
    String sql=null;
    sql="select * from cliente  where in_pv_id='"+ St_pv_cpf+"'";
    
   
    ResultSet rs = null;
    Statement st = con.createStatement();
    rs= st.executeQuery(sql);
    
    if(rs.next()){
    System.out.println(" PESSOA JA EXISTE");
    con.close();
   
        return true;
    }else{
        
        System.out.println(" PESSOA AINDA  NAO EXISTE");
        con.close();
   
        return false;
    }

}      	
		
	
	

}
