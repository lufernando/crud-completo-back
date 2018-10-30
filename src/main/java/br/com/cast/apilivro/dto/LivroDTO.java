package br.com.cast.apilivro.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.GroupSequence;

import com.fasterxml.jackson.annotation.JsonFormat;

interface GroupLiv1{};
interface GroupLiv2{};

@GroupSequence({LivroDTO.class, GroupLiv1.class, GroupLiv2.class})
public class LivroDTO {
	
	private Integer id;
	private String titulo;
	
	@JsonFormat(pattern="dd/MM/yyyy", shape=JsonFormat.Shape.STRING, timezone="GMT-3")
	private Date dataDePublicacao;
	
	private AutorDTO autorDTO;
	private CategoriaDTO categoriaDTO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Date getDataDePublicacao() {
		return dataDePublicacao;
	}

	public void setDataDePublicacao(Date dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public AutorDTO getAutorDTO() {
		return autorDTO;
	}

	public void setAutorDTO(AutorDTO autorDTO) {
		this.autorDTO = autorDTO;
	}

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}

	public String getDataFormatada() {
		if (getDataDePublicacao() != null) {
			return new SimpleDateFormat("dd/MM/yyyy").format(getDataDePublicacao());
		}
		return "--";
	}
	
	
	
	
	

}
