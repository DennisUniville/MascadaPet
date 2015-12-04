package control;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.Usuario;
import ejb.UsuarioBeanLocal;
import ejb.exception.ValidationException;

@ManagedBean(name="crtTemplate")
@RequestScoped
public class CrtTemplate extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private UsuarioBeanLocal usuarioBean;
	private Usuario model = new Usuario();


	public void valida(){
		Usuario user = null;

		try {
			user = usuarioBean.validaUsuario(model.getLogin(), model.getSenha());
		} catch (ValidationException e1) {
			addMessageToRequest(e1.getMessage(), "login");
			return;
		}
		
		if(user != null){			
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
			session.setAttribute("USUARIO_LOGADO", user);
			
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			ExternalContext externalContext = fc.getExternalContext();
			try {
				externalContext.redirect(request.getContextPath() + "/Cadastros/");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void dologoff(){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		session.removeAttribute("USUARIO_LOGADO");
		ExternalContext ec = fc.getExternalContext();
		try {
		      ec.redirect("/Login/");
		} catch (IOException ex) {
		}
	}
	
	
	@PostConstruct
	public void verificaAdmin(){
		usuarioBean.criarAdmin();
	}

	public UsuarioBeanLocal getUsuarioBean() {
		return usuarioBean;
	}
	
	public Usuario getModel() { 
		return model;
	}
	public void setModel(Usuario model) {
		this.model = model;
	}


}