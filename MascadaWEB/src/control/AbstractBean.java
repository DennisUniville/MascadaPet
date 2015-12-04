package control;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Superclasse de todos os beans CDI
 */
public abstract class AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Adiciona uma mensagem ao escopo da request. Esta mensagem pode ser exibida na tela atrav�s da chamada
	 * requestParam.<message>.
	 */
	protected void addMessageToRequest(String message) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		request.setAttribute("msg", message);
	}
	
	protected void addMessageToRequest(String message, String attribute) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		request.setAttribute(attribute, message);
	}
	
	/**
	 * A partir de um outcome, retorna o outcome como sendo um redirect ao inv�s de forward
	 */
	protected String redirect(String outcome) {
		return outcome + "?faces-redirect=true";
	}
	
}
