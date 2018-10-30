package br.com.cast.apilivro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.apilivro.dto.CategoriaDTO;
import br.com.cast.apilivro.service.CategoriaService;

@RestController
@RequestMapping(path="/categoria")
public class CategoriaApi {
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/buscarTodos")
	public List<CategoriaDTO> buscarTodasCategorias() {
		return categoriaService.listarCategoriasDTO();
	}
	
}
