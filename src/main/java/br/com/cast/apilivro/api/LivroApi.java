package br.com.cast.apilivro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.apilivro.dto.LivroDTO;
import br.com.cast.apilivro.exception.TitulosIguaisException;
import br.com.cast.apilivro.service.LivroService;

@RestController
@RequestMapping(path="/livro")
public class LivroApi {
	
	@Autowired
	private LivroService livroService;
	
	/*@Autowired
	private AutorService autorService;
	
	@Autowired
	private CategoriaService categoriaService;*/
	
	@PostMapping("/inserir")
	public void inserirLivro(@RequestBody LivroDTO livroDTO) throws TitulosIguaisException  {
			livroService.inserir(livroDTO);
	}
	
	@DeleteMapping("/excluir/{id}")
	public void excluirLivro(@PathVariable Integer id) {
		livroService.excluir(id);
	}
	
	@PutMapping("/alterar")
	public void alterar(@RequestBody LivroDTO livroDTO) throws TitulosIguaisException {
			livroService.alterar(livroDTO);
	}
	
	@GetMapping("/buscarPorId/{id}")
	public LivroDTO buscarPorId(@PathVariable Integer id) {
		return livroService.buscarParaAlterar(id);
	}
	
	@GetMapping("/buscarTodos")
	public List<LivroDTO> buscarTodosLivros() {
		return livroService.buscarLivrosDTO();
	}
	
	
	
	
	

	
	
	
}
