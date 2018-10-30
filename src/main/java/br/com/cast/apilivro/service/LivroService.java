package br.com.cast.apilivro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.apilivro.dto.AutorDTO;
import br.com.cast.apilivro.dto.CategoriaDTO;
import br.com.cast.apilivro.dto.LivroDTO;
import br.com.cast.apilivro.entidade.Autor;
import br.com.cast.apilivro.entidade.Categoria;
import br.com.cast.apilivro.entidade.Livro;
import br.com.cast.apilivro.exception.TitulosIguaisException;
import br.com.cast.apilivro.repository.AutorRepository;
import br.com.cast.apilivro.repository.CategoriaRepository;
import br.com.cast.apilivro.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private AutorRepository autorRepository;

	/* VERIFICA��O DE TITULO */
	public Livro validandoAlteracao(LivroDTO livroDTO) {

		Livro livroNovo = livroRepository.verificarDuplicidade(livroDTO.getTitulo(), livroDTO.getId());
		return livroNovo;

	}
	
	/* INSERIR */
	public void inserir(LivroDTO livroDTO) throws TitulosIguaisException {
			
		Livro livroNovo = validandoAlteracao(livroDTO);
		
		Autor autor = autorRepository.buscarPorId(livroDTO.getAutorDTO().getId());
		Categoria categoria = categoriaRepository.buscarPorId(livroDTO.getCategoriaDTO().getId());
		
		Livro livro = new Livro();
		livro.setTitulo(livroDTO.getTitulo());
		livro.setDataDePublicacao(livroDTO.getDataDePublicacao());
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		
		
		if(livroNovo != null) {
			throw new TitulosIguaisException();
		}else {
			livroRepository.inserir(livro);
		}
		

	}

	/* EXCLUIR */
	public void excluir(Integer id) {
		Livro livro = livroRepository.buscarPorId(id);
		livroRepository.remover(livro);
	}

	/* ALTERAR */
	public void alterar(LivroDTO livroDTO) throws TitulosIguaisException {
		
		Livro livroComparativo = validandoAlteracao(livroDTO);
		Livro livro = conversorEntidade(livroDTO);
		
		if((livroComparativo != null) && (livroComparativo.getAutor().getId().equals(livro.getAutor().getId())) 
				&& (livroComparativo.getCategoria().getId().equals(livro.getCategoria().getId()))) {
			throw new TitulosIguaisException();
		}else {
			livroRepository.alterar(livro);
		}
		

	}

	
	public Livro conversorEntidade(LivroDTO livroDTO) {

		Livro livro = new Livro();
		livro.setId(livroDTO.getId());
		livro.setTitulo(livroDTO.getTitulo());
		livro.setDataDePublicacao(livroDTO.getDataDePublicacao());

		Autor autor = new Autor();
		autor.setId(livroDTO.getAutorDTO().getId());
		autor.setNome(livroDTO.getAutorDTO().getNome());
		autor.setPseudonimo(livroDTO.getAutorDTO().getPseudonimo());

		Categoria categoria = new Categoria();
		categoria.setId(livroDTO.getCategoriaDTO().getId());
		categoria.setDescricao(livroDTO.getCategoriaDTO().getDescricao());

		livro.setAutor(autor);
		livro.setCategoria(categoria);
		
		return livro;

	}

	public LivroDTO buscarParaAlterar(Integer id) {

		Livro livro = livroRepository.buscarPorId(id);
		LivroDTO livroDTO = conversorDTO(livro);

		return livroDTO;

	}

	public LivroDTO conversorDTO(Livro livro) {

		LivroDTO livroDTO = new LivroDTO();
		livroDTO.setId(livro.getId());
		livroDTO.setTitulo(livro.getTitulo());
		livroDTO.setDataDePublicacao(livro.getDataDePublicacao());

		AutorDTO autorDTO = new AutorDTO();
		autorDTO.setId(livro.getAutor().getId());
		autorDTO.setNome(livro.getAutor().getNome());
		autorDTO.setPseudonimo(livro.getAutor().getPseudonimo());

		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setId(livro.getCategoria().getId());
		categoriaDTO.setDescricao(livro.getCategoria().getDescricao());

		livroDTO.setAutorDTO(autorDTO);
		livroDTO.setCategoriaDTO(categoriaDTO);

		return livroDTO;

	}

	public List<LivroDTO> buscarLivrosDTO() {

		List<Livro> livros = livroRepository.listarLivros();
		List<LivroDTO> livrosDTO = new ArrayList<>();

		for (Livro l : livros) {
			LivroDTO livroDTO = new LivroDTO();
			livroDTO.setId(l.getId());
			livroDTO.setTitulo(l.getTitulo());
			livroDTO.setDataDePublicacao(l.getDataDePublicacao());

			AutorDTO autorDTO = new AutorDTO();
			autorDTO.setId(l.getAutor().getId());
			autorDTO.setNome(l.getAutor().getNome());
			autorDTO.setPseudonimo(l.getAutor().getPseudonimo());

			CategoriaDTO categoriaDTO = new CategoriaDTO();
			categoriaDTO.setId(l.getCategoria().getId());
			categoriaDTO.setDescricao(l.getCategoria().getDescricao());

			livroDTO.setAutorDTO(autorDTO);
			livroDTO.setCategoriaDTO(categoriaDTO);

			livrosDTO.add(livroDTO);

		}

		return livrosDTO;

	}

}
