package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



import Conexao.Conexao;
import Model.Pessoa;
import javafx.scene.control.Alert;

public class PessoaDao {
	
	public static Conexao conexao = new Conexao();
	
	private static Connection con;
	
	
	public PessoaDao() {
		
		this.con = new Conexao().abreConexaoBD();
	}
	
	
/*
*@ bo_pb_add_pessoa 
* ADICIONA PESSOA A TABELA PESSOA NO BANCO.
*/
public boolean bo_pb_add_pessoa(Pessoa pessoa) throws SQLException {
		
	//	Connection con = conexao.abreConexaoBD();
	
		
		String sql = "INSERT INTO pessoa (st_pv_nome , st_pv_cpf, st_pv_rg,  st_pv_telefone, st_pv_telefone_celular )  VALUES ( ?, ?, ?, ?, ?);";
    

		
		  
 if(PessoaDao.bo_pb_existe_banco_cpf(pessoa.getSt_pv_cpf())){
	 
	 Alert dialogoAviso = new Alert(Alert.AlertType.ERROR);
     dialogoAviso.setTitle("DIGITE CPF CORRETAMENTE");
     dialogoAviso.setHeaderText("CPF já cadastrado");
     dialogoAviso.setContentText("O Erro aconteceu devido O CPF já pertencer à um cliente ");
     dialogoAviso.showAndWait();
	 return false;
		    	   
 }else {
		     
		        
        try{
        	
        	 PreparedStatement stmt = con.prepareStatement(sql);

        	 stmt.setString(1, pessoa.getSt_pv_nome() );
             stmt.setString(2, pessoa.getSt_pv_cpf());
             stmt.setString(3, pessoa.getSt_pv_rg());
             stmt.setString(4, pessoa.getSt_pv_telefone());
             stmt.setString(5, pessoa.getSt_pv_telefone_celular());
            

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
       	
	
	
/*
* @bo_pb_existe_banco_cpf
* PROCURA PELO CPF SE A PESSOA JA FOI INSERIDA NO BANDO ENTERIOMENTE
*/

public static  boolean bo_pb_existe_banco_cpf(String St_pv_cpf )throws SQLException{
   
	
	Connection con = conexao.abreConexaoBD();
	
    String sql=null;
    sql="select * from pessoa where st_pv_cpf ='"+ St_pv_cpf+"'";
    
   
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



/*
* @bo_update_tab_pessoa
* FUNCAO FAZ ATUALIZACAO DOS DADOS DA PESSOA.
*/
public boolean bo_update_tab_pessoa(Pessoa pessoa) throws SQLException {
		
	//	Connection con = conexao.abreConexaoBD();
	
		
		String sql = "UPDATE pessoa SET st_pv_nome = ?, st_pv_cpf = ?, st_pv_rg = ?,  st_pv_telefone = ?, st_pv_telefone_celular = ?  WHERE in_pv_id = ?;";
    
    
		        
        try{
        	
        	 PreparedStatement stmt = con.prepareStatement(sql);

        	 stmt.setString(1, pessoa.getSt_pv_nome() );
             stmt.setString(2, pessoa.getSt_pv_cpf());
             stmt.setString(3, pessoa.getSt_pv_rg());
             stmt.setString(4, pessoa.getSt_pv_telefone());
             stmt.setString(5, pessoa.getSt_pv_telefone_celular());
             
             stmt.setInt(8, pessoa.getIn_pv_id());

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
* @ob__pb_busca_Pessoa_cpf
* FUNCAO PROCURA UMA PESSOA E RETORNA UM OBJETO PESSOA.
*/

public static Pessoa  ob_pb_busca_Pessoa_cpf( String St_pv_cpf )throws SQLException{
	
	
	
	Pessoa objPessoa = new Pessoa();
    String sql=null;
    
    sql="select * from pessoa where st_pv_cpf='"+ St_pv_cpf+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	objPessoa.setIn_pv_id(rs.getInt("in_pv_id"));
    	objPessoa.setSt_pv_nome(rs.getString("st_pv_nome"));
    	objPessoa.setSt_pv_cpf(rs.getString("st_pv_cpf"));
    	objPessoa.setSt_pv_rg(rs.getString("st_pv_rg"));
    	objPessoa.setSt_pv_telefone(rs.getString("st_pv_telefone"));
    	objPessoa.setSt_pv_telefone_celular(rs.getString("st_pv_telefone_celular"));
    	
    	
    	
    }
    else
    	objPessoa = null;
    conn.close();
    
	
  return objPessoa;
 }

/*
 * @ ob_pb_busca_Pessoa_id
 * procura pessoas por id
 */
public static Pessoa  ob_pb_busca_Pessoa_id(int id )throws SQLException{
	
	
	
	Pessoa objPessoa = new Pessoa();
    String sql=null;
    
    sql="select * from pessoa where in_pv_id ='"+ id+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	objPessoa.setIn_pv_id(rs.getInt("in_pv_id"));
    	objPessoa.setSt_pv_nome(rs.getString("st_pv_nome"));
    	objPessoa.setSt_pv_cpf(rs.getString("st_pv_cpf"));
    	objPessoa.setSt_pv_rg(rs.getString("st_pv_rg"));
    	objPessoa.setSt_pv_telefone(rs.getString("st_pv_telefone"));
    	objPessoa.setSt_pv_telefone_celular(rs.getString("st_pv_telefone_celular"));
    	
    	
    	
    }
    else
    	objPessoa = null;
    conn.close();
    
	
  return objPessoa;
 }
/*
 * @bo_pb_excluir_pessoa
 * excluir pessoa por cpf
 */

public boolean bo_pb_excluir_pessoa(String St_pv_cpf ) throws SQLException
{
    //retorna  true => exclusão ok
    //retorna  false=> erro de exclusão
	
	
	
	Pessoa pPessoa = PessoaDao.ob_pb_busca_Pessoa_cpf(St_pv_cpf);
	
    boolean retorno=false;
    String sql=null;
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs=null;
    Statement st = null;
    st=conn.createStatement();
    sql="DELETE FROM pessoa WHERE in_pv_id ="+pPessoa.getIn_pv_id();
    int qRs = st.executeUpdate(sql);
    if (qRs !=0)
    	
        retorno=true;
    
    else
        retorno=false;
    conn.close();
    return retorno;
}







}


