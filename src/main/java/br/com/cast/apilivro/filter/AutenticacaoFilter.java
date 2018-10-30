/*package br.com.cast.apilivro.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cast.apilivro.api.IdentidadeApi;

public class AutenticacaoFilter  implements Filter {
	
	private List<String> permitidas;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain) 
					throws IOException, ServletException {
		
		System.out.println("Inicializando Segurança filter...");
		// pass the request along the filter chain
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		
		String url = servletRequest.getRequestURL().toString();
		System.out.println("Url acessada: " + url);
		
		boolean isPaginaPermitida = false;
		
		for (String pagina : permitidas) {
			if (!pagina.isEmpty() && (url.endsWith(pagina) || url.contains(pagina))) {
				isPaginaPermitida = true;
				break;
			}
		}
		
		if (isPaginaPermitida) {
			//liberado para essas urls!
			chain.doFilter(request, response);
		} else {
			HttpSession session = servletRequest.getSession();
			
			IdentidadeApi identidade = (IdentidadeApi) session.getAttribute("identidade");
			if (identidade == null || !identidade.isLogado()) {
				HttpServletResponse servletResponse = (HttpServletResponse)response;
				servletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				request.getRequestDispatcher("/faces/login.xhtml")
					.forward(request, response);
			} else {
				//segue o fluxo!
				chain.doFilter(request, response);
			}
		}
		
		System.out.println("Finalizando Segurança filter...");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String paginas = fConfig.getInitParameter("paginasPermitidas");
		permitidas = Arrays.asList(paginas.split(","));
		System.out.println("Páginas permitidas" + permitidas);
	}

}
*/