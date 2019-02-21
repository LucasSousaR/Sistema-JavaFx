package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Conexao.Conexao;
import Model.Dependente;
import Model.Pessoa;
import javafx.scene.control.Alert;

public class DependenteDao {
	
public static Conexao conexao = new Conexao();
	
	private static Connection con;
	
	
	public DependenteDao() {
		
		this.con = new Conexao().abreConexaoBD();
	}
	
	
	
	
public static boolean bo_pb_add_Dependente(Dependente dependente) throws SQLException {
		
		//	Connection con = conexao.abreConexaoBD();
		
			
			String sql = "INSERT INTO dependente ( st_pv_nome, st_pv_cpf , st_pv_rg, st_pv_telefone_celular )  VALUES ( ?, ?, ?, ?);";
	    

	/*		
			  
	 if(PessoaDao.bo_pb_existe_banco_cpf(dependente.getSt_pv_cpf())){
		 
		 Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
	     dialogoAviso.setTitle("DIGITE CPF CORRETAMENTE");
	     dialogoAviso.setHeaderText("CPF já cadastrado");
	     dialogoAviso.setContentText("O Erro aconteceu devido O CPF já pertencer à um cliente ");
	     dialogoAviso.showAndWait();
		 return false;
			    	   
	 }else {*/
			     
			        
	        try{
	        	
	        	 PreparedStatement stmt = con.prepareStatement(sql);

	        	 stmt.setString(1, dependente.getSt_pv_nome() );
	             stmt.setString(2, dependente.getSt_pv_cpf());
	             stmt.setString(3, dependente.getSt_pv_rg());
	             stmt.setString(4, dependente.getSt_pv_telefone_celular());
	            

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
	       	
		
	public boolean bo_update_tab_dependente(Dependente dependente) throws SQLException {
		
		//	Connection con = conexao.abreConexaoBD();
		
			
			String sql = "UPDATE dependente  SET st_pv_nome = ?, st_pv_cpf = ?, st_pv_rg = ?, st_pv_telefone_celular = ? WHERE in_pv_id = ?;";
	    
	    
			        
	        try{
	        	
	        	 PreparedStatement stmt = con.prepareStatement(sql);

	        	 stmt.setString(1, dependente.getSt_pv_nome() );
	             stmt.setString(2, dependente.getSt_pv_cpf());
	             stmt.setString(3, dependente.getSt_pv_rg());
	             stmt.setString(4, dependente.getSt_pv_telefone_celular());
	             
	             stmt.setInt(5, dependente.getIn_pv_id());

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
	 


public static Dependente  ob_pb_busca_dependente_cpf( String St_pv_cpf )throws SQLException{
	
	
	
	Dependente objDependente= new Dependente();
    String sql=null;
    
    sql="select * from dependente  where st_pv_cpf='"+ St_pv_cpf+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	objDependente.setIn_pv_id(rs.getInt("in_pv_id"));
    	objDependente.setSt_pv_nome(rs.getString("st_pv_nome"));
    	objDependente.setSt_pv_cpf(rs.getString("st_pv_cpf"));
    	objDependente.setSt_pv_rg(rs.getString("st_pv_rg"));
    	objDependente.setSt_pv_telefone_celular(rs.getString("st_pv_telefone_celular"));
    	
    	
    	
    }
    else
    	objDependente = null;
    conn.close();
    
	
  return objDependente;
 }

	

public static Dependente  ob_pb_busca_dependente_id(int id )throws SQLException{
	
	
	
	Dependente objDependente= new Dependente();
    String sql=null;
    
    sql="select * from  dependente  where in_pv_id ='"+ id+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	objDependente.setIn_pv_id(rs.getInt("in_pv_id"));
    	objDependente.setSt_pv_nome(rs.getString("st_pv_nome"));
    	objDependente.setSt_pv_cpf(rs.getString("st_pv_cpf"));
    	objDependente.setSt_pv_rg(rs.getString("st_pv_rg"));
    	objDependente.setSt_pv_telefone_celular(rs.getString("st_pv_telefone_celular"));
    	
    	
    	
    }
    else
    	objDependente = null;
    conn.close();
    
	
  return objDependente;
 }


public boolean bo_pb_excluir_Dependente(String St_pv_cpf ) throws SQLException
{
    //retorna  true => exclusão ok
    //retorna  false=> erro de exclusão
	
	
	
	Dependente pDependente= DependenteDao.ob_pb_busca_dependente_cpf(St_pv_cpf);
	
    boolean retorno=false;
    String sql=null;
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs=null;
    Statement st = null;
    st=conn.createStatement();
    sql="DELETE FROM  dependente  WHERE  in_pv_id  ="+pDependente.getIn_pv_id();
    int qRs = st.executeUpdate(sql);
    if (qRs !=0)
    	
        retorno=true;
    
    else
        retorno=false;
    conn.close();
    return retorno;
}



}
