package br.com.fiap.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CriptografiaUtils {

	public static String criptografar (String senha) throws Exception {
		//Obtêm a instanância de um algoritmo
		MessageDigest md = MessageDigest.getInstance("MD5");
		//Passa os dados a serem criptografados e estipula encondind padrã
		md.update(senha.getBytes("IOS-88591"));
		//Gera a chave criptografados em arrary de Bytes para posterior hashing
		BigInteger hash = new BigInteger(1, md.digest());
		//Retorna a senha criptografada
		return hash.toString();		
	}

}
