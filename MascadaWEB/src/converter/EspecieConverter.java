package converter;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ejb.EspecieBeanLocal;

@FacesConverter("converter.especieConverter")
public class EspecieConverter implements Converter, Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private EspecieBeanLocal especieBean;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(arg2.equals(""))
			return new Object();
		int oid = Integer.parseInt(arg2);
		
		System.err.println("oid: " + oid);
		return especieBean.getEspeciePorOid(oid);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		System.out.println("converter:");
		System.out.println("arg2 string? " + arg2);
		
		if(arg2 == null)
			return "";
		return arg2.toString();
	}

	
}
