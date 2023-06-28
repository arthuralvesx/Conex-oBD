package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection conectar() {
		
		try {
			System.out.println("Fazendo a conexao com o banco de dados da oracle...");
			return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","TM_ARTHUR_BARBOSA","110805");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			System.out.println("Conexao concluida");
		}
		
	}
}
