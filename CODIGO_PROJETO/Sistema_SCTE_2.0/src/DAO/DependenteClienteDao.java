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
import Model.DependenteCliente;
import Model.EnderecoPessoa;
import Model.Pessoa;

public class DependenteClienteDao {
	
	

	
public static Conexao conexao = new Conexao();
	
	private static Connection con;
	
	
	public DependenteClienteDao() {
		
		this.con = new Conexao().abreConexaoBD();
	}
	
	
	
	
	/*
	* bo_pb_add_EnderecoPessoa 
	* ADICIONA EnderecoPessoa A TABELA EnderecoPessoa NO BANCO.
	*/
public boolean bo_pb_add_DependenteCliente(DependenteCliente dependenteCliente) throws SQLException {
			
		//	Connection con = conexao.abreConexaoBD();
		
			
		String sql = "INSERT INTO DependenteCliente ( in_pv_id_cliente , in_pv_id_dependente )  VALUES ( ?, ?);";
	    

	/*		
			  
	 if(PessoaDao.bo_pb_existe_banco_cpf(pessoa.getSt_pv_cpf())){
		 return false;
			    	   
	 }else {
		 */
			     
			        
	        try{
	        	
	        	 PreparedStatement stmt = con.prepareStatement(sql);
	        	 
	        	 stmt.setInt(1, dependenteCliente.getIn_pv_id_cliente() );
	        	 stmt.setInt(2, dependenteCliente.getIn_pv_id_dependente() );

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
 * FUNCAO FAZ busca  DOS DADOS Do de pessoas e enderecos por id.
 */

public static DependenteCliente  ob_pb_busca__id_cliente( int in_pv_id)throws SQLException{
	
	
	
	
	DependenteCliente dependenteCliente = new DependenteCliente();
    String sql=null;
    
    sql="select * from DependenteCliente  where in_pv_id_cliente ='"+ in_pv_id+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	
    	dependenteCliente.setIn_pv_id(rs.getInt("in_pv_id"));
    	dependenteCliente.setIn_pv_id_cliente(rs.getInt("in_pv_id_cliente"));
    	dependenteCliente.setIn_pv_id_dependente(rs.getInt("in_pv_id_dependente")); 	
    	
    	
    }
    else
    	dependenteCliente = null;
    conn.close();
    
	
  return dependenteCliente;
	 	
	
	
}

public static DependenteCliente  ob_pb_busca__id_dependente( int in_pv_id)throws SQLException{
	
	
	
	
	DependenteCliente dependenteCliente = new DependenteCliente();
    String sql=null;
    
    sql="select * from  DependenteCliente  where in_pv_id_dependente ='"+ in_pv_id+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	
    	dependenteCliente.setIn_pv_id(rs.getInt("in_pv_id"));
    	dependenteCliente.setIn_pv_id_cliente(rs.getInt("in_pv_id_cliente"));
    	dependenteCliente.setIn_pv_id_dependente(rs.getInt("in_pv_id_dependente")); 	
    	
    	
    }
    else
    	dependenteCliente = null;
    conn.close();
    
	
  return dependenteCliente;
	 	
	
	
}





public boolean bo_pb_excluir_DependentePessoa(int id ) throws SQLException
{
    //retorna  true => exclusão ok
    //retorna  false=> erro de exclusão
	
	
	
	//Pessoa pPessoa = PessoaDao.ob_pb_busca_Pessoa_cpf(St_pv_cpf);
	
	//Dependente pDependente= DependenteDao.ob_pb_busca_dependente_cpf(St_pv_cpf);
	
    boolean retorno=false;
    String sql=null;
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs=null;
    Statement st = null;
    st=conn.createStatement();
    sql="DELETE FROM DependenteCliente  WHERE in_pv_id_dependente ="+id;
    int qRs = st.executeUpdate(sql);
    if (qRs !=0)
    	
        retorno=true;
    
    else
        retorno=false;
    conn.close();
    return retorno;
}


	

}
