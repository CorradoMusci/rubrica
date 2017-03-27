package it.polito.tdp.rubrica.model;


/**
 * Un singolo elemento della rubrica
 *
 *
 *Semplice Java Bean
 *(POJO Plain Old Java Object)
 *
 * @author CorradoMusci
 */

public class Voce {
	
	private String nome;
	private String email;
	private String telefono;
	
	public Voce(String nome, String email, String telefono) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefono = telefono;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voce other = (Voce) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Voce [nome=" + nome + ", email=" + email + ", telefono=" + telefono + "]";
	}
	
	
	
}
