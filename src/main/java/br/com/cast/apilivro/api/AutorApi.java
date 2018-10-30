package br.com.cast.apilivro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.apilivro.dto.AutorDTO;
import br.com.cast.apilivro.service.AutorService;

@RestController
@RequestMapping(path="/autor")
public class AutorApi {
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping("/buscarTodos")
	public List<AutorDTO> buscarTodosAutores() {
		return autorService.listarAutoresDTO();
	}

}
