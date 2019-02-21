package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Conexao.Conexao;
import Model.Endereço;
import Model.Pessoa;

public class EnderecoDao {
	
	
	
	
public static Conexao conexao = new Conexao();
	
	private static Connection con;
	
	
	public EnderecoDao() {
		
		this.con = new Conexao().abreConexaoBD();
	}

	
	
	
	
	
	
	/*
	* bo_pb_add_endereco 
	* ADICIONA ENDERECO A TABELA ENDERECO NO BANCO.
	*/
	public boolean bo_pb_add_endereco(Endereço endereco) throws SQLException {
			
		//	Connection con = conexao.abreConexaoBD();
		
			
		String sql = "INSERT INTO endereco ( st_pv_endereco , in_pv_numendereco, st_pv_complemento ,  st_pv_bairro, st_pv_cep, st_pv_cidade )  VALUES ( ?, ?, ?, ?, ?, ?);";
	    

	/*		
			  
	 if(PessoaDao.bo_pb_existe_banco_cpf(pessoa.getSt_pv_cpf())){
		 return false;
			    	   
	 }else {
		 */
			     
			        
	        try{
	        	
	        	 PreparedStatement stmt = con.prepareStatement(sql);

	        	 stmt.setString(1, endereco.getSt_pv_rua() );
	        	 stmt.setInt(2, endereco.getSt_pv_numero() );
	        	 stmt.setString(3, endereco.getSt_pv_complemento() );
	        	 stmt.setString(4, endereco.getSt_pv_bairro() );
	        	 stmt.setString(5, endereco.getSt_pv_cep() );
	        	 stmt.setString(6, endereco.getSt_pv_cidade() );
	        	
	            
	            

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
	 
	 
/*
 * bo_update_tab_endereco
 * FUNCAO FAZ ATUALIZACAO DOS DADOS Do endereco.
 */
public boolean bo_update_tab_endereco(Endereço endereco) throws SQLException {
	        		
	        	//	Connection con = conexao.abreConexaoBD();
	        	
	        		
	  String sql = "UPDATE endereco SET st_pv_endereco = ?, in_pv_numendereco = ?, st_pv_complemento = ?,  \"st_pv_bairro  = ?, st_pv_cep  = ?, st_pv_cidade = ? WHERE in_pv_id = ?;";
	            
	            
	        		        
	                try{
	                	
	                	 PreparedStatement stmt = con.prepareStatement(sql);

	                	 stmt.setString(1, endereco.getSt_pv_rua() );
	    	        	 stmt.setInt(2, endereco.getSt_pv_numero() );
	    	        	 stmt.setString(3, endereco.getSt_pv_complemento() );
	    	        	 stmt.setString(4, endereco.getSt_pv_bairro() );
	    	        	 stmt.setString(5, endereco.getSt_pv_cep() );
	    	        	 stmt.setString(6, endereco.getSt_pv_cep() );
	    	        	 stmt.setString(7, endereco.getSt_pv_cidade() );
	                     
	                     stmt.setInt(8, endereco.getIn_pv_id());

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


/*
 *ob_pb_busca_Endereco_id
 * FUNCAO FAZ busca  DOS DADOS Do endereco por id.
 */

public static Endereço  ob_pb_busca_Endereco_cep( String st_pv_cep )throws SQLException{
	
	
	
	
	Endereço endereco = new Endereço();
    String sql=null;
    
    sql="select * from endereco where st_pv_cep ='"+ st_pv_cep+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	
    	endereco.setIn_pv_id(rs.getInt("in_pv_id"));
    	endereco.setSt_pv_bairro(rs.getString("st_pv_bairro"));
    	endereco.setSt_pv_cep(rs.getString("st_pv_cep"));
    	endereco.setSt_pv_complemento(rs.getString("st_pv_complemento"));
    	endereco.setSt_pv_numero(rs.getInt("in_pv_numendereco"));
    	endereco.setSt_pv_cidade(rs.getString("st_pv_cidade"));
    	endereco.setSt_pv_rua(rs.getString("st_pv_endereco"));
    	
    	//endereco.setPessoa(pessoa);
    	
    	
    	
    	
    	
    	
    }
    else
    	endereco = null;
    conn.close();
    
	
  return endereco;
 }	         
	        	
	        	

public static Endereço  ob_pb_busca_Endereco_id( int st_pv_cep )throws SQLException{
	
	
	
	
	Endereço endereco = new Endereço();
    String sql=null;
    
    sql="select * from endereco  where in_pv_id ='"+ st_pv_cep+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	
    	endereco.setIn_pv_id(rs.getInt("in_pv_id"));
    	endereco.setSt_pv_bairro(rs.getString("st_pv_bairro"));
    	endereco.setSt_pv_cep(rs.getString("st_pv_cep"));
    	endereco.setSt_pv_complemento(rs.getString("st_pv_complemento"));
    	endereco.setSt_pv_numero(rs.getInt("in_pv_numendereco"));
    	endereco.setSt_pv_cidade(rs.getString("st_pv_cidade"));
    	endereco.setSt_pv_rua(rs.getString("st_pv_endereco"));
    	
    	//endereco.setPessoa(pessoa);
    	
    	
    	
    	
    	
    	
    }
    else
    	endereco = null;
    conn.close();
    
	
  return endereco;
 }	         
	        	
	        	 
	 		       

























}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

