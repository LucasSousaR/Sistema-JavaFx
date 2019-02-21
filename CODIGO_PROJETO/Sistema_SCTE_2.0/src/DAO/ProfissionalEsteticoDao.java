package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Conexao.Conexao;
import Model.Pessoa;
import Model.ProfissionalEstetico;
import javafx.scene.control.Alert;

public class ProfissionalEsteticoDao {
	
	
	
public static Conexao conexao = new Conexao();
	
	private static Connection con;
	
	
	public  ProfissionalEsteticoDao() {
		
		this.con = new Conexao().abreConexaoBD();
	}

	
	
	/*
	* bo_pb_add_pessoa 
	* ADICIONA PESSOA A TABELA PESSOA NO BANCO.
	*/
	public static boolean bo_pb_add_profissional(ProfissionalEstetico  profissionalEstetico ) throws SQLException {
			
		//	Connection con = conexao.abreConexaoBD();
		
			
			String sql = "INSERT INTO profissionalEstetico (in_pv_id )  VALUES (?);";
	    
	     
			        
	        try{
	        	
	        	 PreparedStatement stmt = con.prepareStatement(sql);

	        	 stmt.setInt(1, profissionalEstetico.getIn_pv_id());


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
	
	public static  boolean bo_pb_existe_banco_in(int id )throws SQLException{
		   
		
		Connection con = conexao.abreConexaoBD();
		
	    String sql=null;
	    sql="select * from profissionalEstetico where in_pv_id ='"+ id+"'";
	    
	   
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


public boolean bo_pb_excluir_Profissional(int id) throws SQLException
{
    //retorna  true => exclusão ok
    //retorna  false=> erro de exclusão
	
	
	
	
	
    boolean retorno=false;
    String sql=null;
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs=null;
    Statement st = null;
    st=conn.createStatement();
    sql="DELETE FROM profissionalEstetico WHERE in_pv_id ="+id;
    int qRs = st.executeUpdate(sql);
    if (qRs !=0)
    	
        retorno=true;
    
    else
        retorno=false;
    conn.close();
    return retorno;
}

public static  boolean bo_pb_existe_banco_id(int St_pv_cpf )throws SQLException{
   
	
	Connection con = conexao.abreConexaoBD();
	
    String sql=null;
    sql="select * from profissionalEstetico where in_pv_id='"+ St_pv_cpf+"'";
    
   
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
