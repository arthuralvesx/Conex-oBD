package jdbcConnection;

import java.sql.Date;

import br.com.fiap.util.CriptografiaUtils;

public class Usuario {
		
	
	//Atributos
	private long id;
	private String nome, senha;
	private Date dataCadastro;
	
	//Construtor
	public Usuario(String nome, String senha) {
		this.nome = nome;
		setSenha(senha);
		this.dataCadastro = new Date(System.currentTimeMillis());
	}
	
	//Getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) { 
		this.senha = CriptografiaUtils.criptografar(senha);
	}catch (Exception e) {
		
		
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
