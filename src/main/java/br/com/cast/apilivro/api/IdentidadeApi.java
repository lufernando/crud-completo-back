/*package br.com.cast.apilivro.api;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cast.apilivro.entidade.Usuario;
import br.com.cast.apilivro.excecao.UsuarioInvalidoException;
import br.com.cast.apilivro.service.UsuarioBusiness;

@ManagedBean(name="identidade")
@SessionScoped
public class IdentidadeApi {
	
	private String nome;
	private String usuario;
	private String senha;
	private boolean isLogado;
	
	public IdentidadeApi() {
		System.out.println("criando identidade");
	}
	
	public String logar() {
		try {
			Usuario identidade = new UsuarioBusiness().autenticar(usuario, senha);
			//encontrou usuário válido!
			isLogado = true;
			nome = identidade.getNome();
			return "template";
		} catch (UsuarioInvalidoException e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage("usuarioInvalidoMsg", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							e.getMessage(), e.getMessage()));
			return "";
		}
	}
	
	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
			.getExternalContext()
			.getSession(true);
		
		session.invalidate();
		
		return "login?faces-redirect=true";
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
	
	public boolean isLogado() {
		return isLogado;
	}
	
	public String getNome() {
		return nome;
	}
	
}
*/