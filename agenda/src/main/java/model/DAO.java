package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	
	//parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Dba@123456";
	
	//metodo de conexao
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//CREATE - aula 15
	public void inserirContato(JavaBeans contato) {
		String create  = "insert into contatos (nome, fone, email) values (?, ?, ?)";
		
		try {
			//abrindo a conexao com o banco de dados
			Connection con = conectar();
			
			//preparando a query para ser executada
			PreparedStatement pst = con.prepareStatement(create);
			
			//substituindo os parametros (?) pelo conteudo das variaves JavaBeans
			//passos 7 e 8 do diagrama
			//passo 7 sao os get - passo 8 e a query sendo executada
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			
			//passo 9 
			pst.executeUpdate();
			
			//encerrando a conexao com o banco de dados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
