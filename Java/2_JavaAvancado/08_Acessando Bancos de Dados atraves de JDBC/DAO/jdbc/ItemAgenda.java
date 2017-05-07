package javaavancado.jdbc;

/**
 * Representa um registro da agenda
 */
public class ItemAgenda {

	/**
	 * Nome
	 */
	private String nome;

	/**
	 * Telefone
	 */
	private String telefone;
	
	/**
	 * E-mail
	 */
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
