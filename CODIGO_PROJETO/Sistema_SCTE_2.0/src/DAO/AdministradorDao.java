package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Conexao.Conexao;
import Model.Administrador;
import Model.Atendente;
import Model.Pessoa;
import javafx.scene.control.Alert;

public class AdministradorDao {

	
public static Conexao conexao = new Conexao();
	
	private static Connection con;
	
	
	public AdministradorDao() {
		
		this.con = new Conexao().abreConexaoBD();
	}
	
	
	
	
	
	/*
	*@ bo_pb_add_Admin 
	* ADICIONA Admin A TABELA admin NO BANCO.
	*/
	public boolean bo_pb_add_Admin(Administrador pessoa) throws SQLException {
			
		//	Connection con = conexao.abreConexaoBD();
		
			
			String sql = "INSERT INTO administrador (in_pv_id, st_pv_login, st_pv_senha )  VALUES ( ?, ?, ?);";
	    

			
			  
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

	        	 stmt.setInt(1, pessoa.getIn_pv_id()) ;
	        	 stmt.setString(2, pessoa.getSt_pv_login() );
	             stmt.setString(3, pessoa.getSt_pv_senha());
	             
	            

	            stmt.executeUpdate();
	            stmt.close();

	            return true;

	        }catch(SQLException e){
	        	Logger.getLogger(AdministradorDao.class.getName()).log(Level.SEVERE, null, e);
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
* @bo_pb_confirmar_ADMIN
* PROCURA PELO CPF SE A PESSOA JA FOI INSERIDA NO BANDO ENTERIOMENTE
*/

public static  boolean bo_pb_confirmar(String login, String senha )throws SQLException{
   
	
	Connection con = conexao.abreConexaoBD();
	
    String sql=null;
    sql="select * from administrador where st_pv_login  ='"+ login+"' And st_pv_senha ='"+senha +"'";
    
   
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
* @bo_update_tab_atendente
* FUNCAO FAZ ATUALIZACAO DOS DADOS DA atendente.
*/
public boolean bo_update_tab_atendente(Administrador pessoa) throws SQLException {
	
//	Connection con = conexao.abreConexaoBD();

	
	String sql = "UPDATE administrador  SET st_pv_login = ?, st_pv_senha = ?  WHERE in_pv_id = ?;";


	        
    try{
    	
    	 PreparedStatement stmt = con.prepareStatement(sql);

    	 stmt.setString(1, pessoa.getSt_pv_login() );
         stmt.setString(2, pessoa.getSt_pv_senha());
        
         
         stmt.setInt(3, pessoa.getIn_pv_id());

        stmt.executeUpdate();
        stmt.close();

        return true;

    }catch(SQLException e){
    	Logger.getLogger(AdministradorDao.class.getName()).log(Level.SEVERE, null, e);
             System.out.println(e );
            //JOptionPane.showMessageDialog(null,e);
    return false;
    }finally{
        if (con != null) { con.close(); }

            //ConnectionFactory.CloseConnection(conn, st);
    }
}

	
}
