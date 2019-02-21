package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Conexao.Conexao;
import Model.Pessoa;
import Model.ProcedimentoEstetico;
import javafx.scene.control.Alert;

public class ProcedimentoEsteticoDao {
	
	
	

	public static Conexao conexao = new Conexao();
	
	private static Connection con;
	
	
	public ProcedimentoEsteticoDao() {
		
		this.con = new Conexao().abreConexaoBD();
	}
	
	
	
/*
* bo_pb_add_pessoa 
* ADICIONA PESSOA A TABELA PESSOA NO BANCO.
*/
public static boolean bo_pb_add_procedimento(ProcedimentoEstetico  procedimentoEstetico ) throws SQLException {
		
	//	Connection con = conexao.abreConexaoBD();
	
		
		String sql = "INSERT INTO procedimentoEstetico (st_pv_nome, st_pv_descricao, fl_pv_valor )  VALUES ( ?, ?, ?);";
    

		
  
		        
        try{
        	
        	 PreparedStatement stmt = con.prepareStatement(sql);

        	 stmt.setString(1, procedimentoEstetico.getSt_pv_nome() );
             stmt.setString(2, procedimentoEstetico.getSt_pv_descricao());
             stmt.setFloat(3, procedimentoEstetico.getFl_pv_valor());
             

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


public boolean bo_update_tab_procedimento(ProcedimentoEstetico  procedimentoEstetico ) throws SQLException {
	
	//	Connection con = conexao.abreConexaoBD();
	
		
		String sql = "UPDATE procedimentoEstetico SET st_pv_nome = ?, st_pv_descricao = ?, fl_pv_valor = ?   WHERE in_pv_id = ?;";
    
    
		        
        try{
        	
        	 PreparedStatement stmt = con.prepareStatement(sql);

        	 stmt.setString(1, procedimentoEstetico.getSt_pv_nome() );
             stmt.setString(2, procedimentoEstetico.getSt_pv_descricao());
             stmt.setFloat(3, procedimentoEstetico.getFl_pv_valor());
             
             stmt.setInt(4, procedimentoEstetico.getIn_pv_id());

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
 
	

public static ProcedimentoEstetico  ob_pb_busca_Procedimento_nome( String st_pv_nome )throws SQLException{
	
	
	
	
	ProcedimentoEstetico procedimentoEstetico   = new ProcedimentoEstetico ();
    String sql=null;
    
    sql="select * from procedimentoEstetico where st_pv_nome ='"+ st_pv_nome+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	procedimentoEstetico.setIn_pv_id(rs.getInt("in_pv_id"));
    	procedimentoEstetico.setSt_pv_nome(rs.getString("st_pv_nome"));
    	procedimentoEstetico.setSt_pv_descricao(rs.getString("st_pv_descricao"));
    	procedimentoEstetico.setFl_pv_valor(rs.getFloat("fl_pv_valor"));
    	    	
    	
    	
    }
    else
    	procedimentoEstetico = null;
    conn.close();
    
	
  return procedimentoEstetico;
 }

public static ProcedimentoEstetico  ob_pb_busca_Procedimento_id( int id )throws SQLException{
	
	
	
	
	ProcedimentoEstetico procedimentoEstetico   = new ProcedimentoEstetico ();
    String sql=null;
    
    sql="select * from procedimentoEstetico where in_pv_id='"+ id+"'";
    
    
    
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs = null;
    Statement st=null;
    st = conn.createStatement();
    rs= st.executeQuery(sql);
    if (rs.next())
    {
    	procedimentoEstetico.setIn_pv_id(rs.getInt("in_pv_id"));
    	procedimentoEstetico.setSt_pv_nome(rs.getString("st_pv_nome"));
    	procedimentoEstetico.setSt_pv_descricao(rs.getString("st_pv_descricao"));
    	procedimentoEstetico.setFl_pv_valor(rs.getFloat("fl_pv_valor"));
    	    	
    	
    	
    }
    else
    	procedimentoEstetico = null;
    conn.close();
    
	
  return procedimentoEstetico;
 }

public boolean bo_pb_excluir_procedimento(String st_pv_nome  ) throws SQLException
{
    //retorna  true => exclusão ok
    //retorna  false=> erro de exclusão
	
	
	ProcedimentoEstetico  pProcedimento = ProcedimentoEsteticoDao.ob_pb_busca_Procedimento_nome(  st_pv_nome );
	
	
    boolean retorno=false;
    String sql=null;
    Connection conn= conexao.abreConexaoBD();
    ResultSet rs=null;
    Statement st = null;
    st=conn.createStatement();
    sql="DELETE FROM procedimentoEstetico WHERE in_pv_id ="+pProcedimento.getIn_pv_id();
    int qRs = st.executeUpdate(sql);
    if (qRs !=0)
    	
        retorno=true;
    
    else
        retorno=false;
    conn.close();
    return retorno;
}


public List<ProcedimentoEstetico> getList(){
	
	List<ProcedimentoEstetico> ListProcedimento = new ArrayList<>();
	  String sql=null;
	
	 sql="select * from procedimentoEstetico";
	
	 try {
		 PreparedStatement stmt = con.prepareStatement(sql);
		 ResultSet rs = null;
		 Statement st=null;
		 st = con.createStatement();
		  rs= st.executeQuery(sql);
		 
		 while(rs.next()) {
			 
			 ProcedimentoEstetico pE = new ProcedimentoEstetico();
			 pE.setIn_pv_id(rs.getInt("in_pv_id"));
			 pE.setSt_pv_nome(rs.getString("st_pv_nome"));
			 pE.setFl_pv_valor(rs.getFloat("fl_pv_valor"));
			 pE.setSt_pv_descricao(rs.getString("st_pv_descricao"));
			 
			 ListProcedimento.add(pE);
	
		 }
		 st.close();
		 rs.close();
		 
	 }catch(SQLException e){
     	Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, e);
        System.out.println(e );
	 }
	 
	 
	 
	 
	return ListProcedimento;
	
}


	

}
