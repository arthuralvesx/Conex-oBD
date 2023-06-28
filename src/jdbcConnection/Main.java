package jdbcConnection;

public class Main {

	public static void main(String[] args) {
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario emerson = new Usuario("Otávio", "123456");
		dao.insert(emerson);
		
		
	}

}
