package jdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	//Atributos
	private Connection conexao;
	
	//Construtor
	public UsuarioDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}
	
	//Insert (INSERT INTO TABLE VALUES (value1, value2))
	public void insert(Usuario usuario) {
		String sql = "INSERT INTO USUARIO (nome, senha, dataCadastro) values (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, usuario.getId());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());
			stmt.setDate(4, usuario.getDataCadastro());
			//executar a query
			stmt.execute();
			//fechar a operação
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//selectAll

	public List<Usuario> selectALL() { // uma list para armazenar odos os registros do select
		
		List<Usuario> usuarios = new ArrayList<Usuario>(); // lista que recebe os dados deste select 
		
		String sql = "select * from usuario order by nome"; // variavel com o comando do sql
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql); // prepara o statement do comando 
			ResultSet rs = stmt.executeQuery();	// o resultado deste execute vou salvar nesta variavel, aqui vai ficar o retorno do banco. O ResultSet devolve uma tabela de dados
			
			// while é necessario pois posso ter mais de usuario para retornar
			while(rs.next()) {                                // enquanto tiver dados na tabela, faça:
				Usuario usuario = new Usuario();              // temos um construtor vazio para ir inserindo os outros dados que estao abaixo
				// com os dados da tabela estou construindi o objeto usuario
				
				usuario.setId(rs.getInt("id")); //            esse dado vai ir para o obj usuario que acabei de criar
				usuario.setNome(rs.getString("nome")); //     esse dado vai ir para o obj usuario que acabei de criar
				usuario.setSenha(rs.getString("senha"));//    esse dado vai ir para o obj usuario que acabei de criar
				usuario.setDataCadastro(rs.getDate("dataCadastro")); // esse dado vai ir para o obj usuario que acabei de criar
				
				usuarios.add(usuario); // cada objeto usuario vai ser adicionado a lista usuarios
			}
			rs.close(); // fecho o result
			stmt.close(); // fecho o statement
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//selectById
//	public Usuario selectById(long id) {
		
//		return null;
//	}
	//update
	public void update(Usuario usuario){
		String sql = "update usuario set nome=?, senha=? where id=? ";
		try{
			PreparedStatement stmt =conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setLong(3, usuario.getId());
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//delete
	public void delete(long id) {
		String sql = "delete from usuario where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
