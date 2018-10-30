package br.com.cast.apilivro.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO", schema="livroapi")
public class Usuario {

	@Id
	@SequenceGenerator(name="gerador_usuario_seq", 
	                   sequenceName="prova.usuario_id_seq", 
	                   allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, 
					generator="gerador_usuario_seq")
	private Integer id;
	private String nome;
	private String usuario;
	private String senha;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
