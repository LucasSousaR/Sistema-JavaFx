package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
 * CONEXAO COM O BANCO DE DADOS MYSQL / POSTGRESQL
 *  
 */
public class Conexao {
		
	// usuário e senha
		private String login = "root";
		private String senha = "";
		private String host = "localhost";
		private String dbName = "scte";
		// URL de conexao do banco
		private String url = "jdbc:mysql://" + host + "/" + dbName;

		public Connection conexao = null;

		public Conexao() {
		}

		public Connection abreConexaoBD() {
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException ex) {
					return null;
				}
				try {
					// efetua conexao com o banco de dados
					this.conexao = (Connection) DriverManager.getConnection(url, login, senha);
				} catch (SQLException ex) {
					return null;
				}
				return this.conexao;
			} catch (Exception e) {
				return null;
			}
		}
}
		

		
		
		

