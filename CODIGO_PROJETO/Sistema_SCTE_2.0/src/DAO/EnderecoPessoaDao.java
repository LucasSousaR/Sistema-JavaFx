package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Conexao.Conexao;
import Model.EnderecoPessoa;
import Model.Endereço;
import Model.Pessoa;

public class EnderecoPessoaDao {

	
	
public static Conexao conexao = new Conexao();
	
	private static Connection con;
	
	
	public EnderecoPessoaDao() {
		
		this.con = new Conexao().abreConexaoBD();
	}
	
	
	
	
	/*
	* bo_pb_add_EnderecoPessoa 
	* ADICIONA EnderecoPessoa A TABELA EnderecoPessoa NO BANCO.
	*/
public boolean bo_pb_add_EnderecoPessoa(EnderecoPessoa enderecoPessoa) throws SQLException {
			
		//	Connection con = conexao.abreConexaoBD();
		
			
		String sql = "INSERT INTO enderecoPessoa (in_pv_id_pessoa, in_pv_id_endereco )  VALUES ( ?, ?);";
	    

	/*		
			  
	 if(PessoaDao.bo_pb_existe_banco_cpf(pessoa.getSt_pv_cpf())){
		 return false;
			    	   
	 }else {
		 */
			     
			        
	        try{
	        	
	        	 PreparedStatement stmt = con.prepareStatement(sql);
	        	 
	        	 stmt.setInt(1, enderecoPessoa.getIn_pv_id_pessoa() );
	        	 stmt.setInt(2, enderecoPessoa.getIn_pv_endereco() );

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

public static EnderecoPessoa  ob_pb_busca__id_Pessoa( int in_pv_id)throws SQLException{
	
	
	
	
	EnderecoPessoa enderecoPessoa = new EnderecoPessoa();
    String sql=null;
    
    sql="select * from enderecoPessoa  where in_pv_id_pessoa='"+ in_pv_id+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	
    	enderecoPessoa.setIn_pv_id(rs.getInt("in_pv_id"));
    	enderecoPessoa.setIn_pv_endereco(rs.getInt("in_pv_id_endereco"));
    	enderecoPessoa.setIn_pv_id_pessoa(rs.getInt("in_pv_id_pessoa")); 	
    	
    	
    }
    else
    	enderecoPessoa = null;
    conn.close();
    
	
  return enderecoPessoa;
	 	
	
	
}

public boolean bo_pb_excluir_pessoaEndereco_(int id ) throws SQLException
{
    //retorna  true => exclusão ok
    //retorna  false=> erro de exclusão
	
	
	
	//Pessoa pPessoa = PessoaDao.ob_pb_busca_Pessoa_cpf(St_pv_cpf);
	
    boolean retorno=false;
    String sql=null;
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs=null;
    Statement st = null;
    st=conn.createStatement();
    sql="DELETE FROM enderecoPessoa WHERE in_pv_id_pessoa ="+id;
    int qRs = st.executeUpdate(sql);
    if (qRs !=0)
    	
        retorno=true;
    
    else
        retorno=false;
    conn.close();
    return retorno;
}


}
