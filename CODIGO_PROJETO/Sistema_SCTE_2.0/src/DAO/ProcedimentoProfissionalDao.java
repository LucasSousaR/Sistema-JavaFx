package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Conexao.Conexao;
import Model.DependenteCliente;
import Model.ProcedimentoEstetico;
import Model.ProcedimentoProfissional;

public class ProcedimentoProfissionalDao {
	
	
public static Conexao conexao = new Conexao();
	
	private static Connection con;
	
	
	public ProcedimentoProfissionalDao() {
		
		this.con = new Conexao().abreConexaoBD();
	}
	
	
	
	
	
	
	/*
	* bo_pb_add_EnderecoPessoa 
	* ADICIONA EnderecoPessoa A TABELA EnderecoPessoa NO BANCO.
	*/
public static boolean bo_pb_add_procedimentoProfissional(ProcedimentoProfissional procedimentoProfissional) throws SQLException {
			
		//	Connection con = conexao.abreConexaoBD();
		
			
		String sql = "INSERT INTO procedimentoProfissional(in_pv_id_procedimento, in_pv_id_profissional )  VALUES ( ?, ?);";
	    

	/*		
			  
	 if(PessoaDao.bo_pb_existe_banco_cpf(pessoa.getSt_pv_cpf())){
		 return false;
			    	   
	 }else {
		 */
			     
			        
	        try{
	        	
	        	 PreparedStatement stmt = con.prepareStatement(sql);
	        	 
	        	 stmt.setInt(1, procedimentoProfissional.getIn_pv_id_procedimento() );
	        	 stmt.setInt(2, procedimentoProfissional.getIn_pv_profissional() );

	            stmt.executeUpdate();
	            stmt.close();

	            return true;

	        }catch(SQLException e){
	        	Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, e);
	                 System.out.println(e );
	                //JOptionPane.showMessageDialog(null,e);
	        return false;
	        }finally{
	           // if (con != null) { con.close(); }

	                //ConnectionFactory.CloseConnection(conn, st);
	        }
	 }



/*
 *ob_pb_busca_Endereco_id
 * FUNCAO FAZ busca  DOS DADOS Do de pessoas e enderecos por id.
 */


public static ProcedimentoProfissional  ob_pb_busca__id_Profissional( int in_pv_id)throws SQLException{
	
	
	
	
	ProcedimentoProfissional procedimentoProfissional = new ProcedimentoProfissional();
    String sql=null;
    
    sql="select * from procedimentoProfissional where in_pv_id_profissional  ='"+ in_pv_id+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	
    	procedimentoProfissional.setIn_pv_id(rs.getInt("in_pv_id"));
    	procedimentoProfissional.setIn_pv_id_procedimento(rs.getInt("in_pv_id_procedimento"));
    	procedimentoProfissional.setIn_pv_profissional(rs.getInt("in_pv_id_profissional")); 	
    	
    	
    }
    else
    	procedimentoProfissional = null;
    conn.close();
    
	
  return procedimentoProfissional;
	 	
	
	
}


public ProcedimentoProfissional  ob_pb_busca__id_Procedimento( int in_pv_id)throws SQLException{
	
	
	
	
	ProcedimentoProfissional procedimentoProfissional = new ProcedimentoProfissional();
    String sql=null;
    
    sql="select * from procedimentoProfissional  where in_pv_id_procedimento ='"+ in_pv_id+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	
    	procedimentoProfissional.setIn_pv_id(rs.getInt("in_pv_id"));
    	procedimentoProfissional.setIn_pv_id_procedimento(rs.getInt("in_pv_id_procedimento"));
    	procedimentoProfissional.setIn_pv_profissional(rs.getInt("in_pv_id_profissional")); 	
    	
    	
    }
    else
    	procedimentoProfissional = null;
    conn.close();
    
	
  return procedimentoProfissional;
	 	
	
	
}


public boolean bo_pb_excluir_procedimentoProfissional_Servico(int in_pv_id  ) throws SQLException
{
    //retorna  true => exclusão ok
    //retorna  false=> erro de exclusão
	
	
	//ProcedimentoEstetico  pProcedimento = ProcedimentoEsteticoDao.ob_pb_busca_Procedimento_nome(  st_pv_nome );
	
	
    boolean retorno=false;
    String sql=null;
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs=null;
    Statement st = null;
    st=conn.createStatement();
    sql="DELETE FROM procedimentoProfissional WHERE in_pv_id_procedimento ="+in_pv_id;
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
    sql="select * from pessoa where in_pv_id'"+ St_pv_cpf+"'";
    
   
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
