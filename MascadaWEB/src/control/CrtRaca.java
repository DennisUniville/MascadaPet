package control;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Raca;
import ejb.RacaBean;
import ejb.RacaBeanLocal;

@ManagedBean(name="crtRaca")
@ViewScoped
public class CrtRaca {
	
	@EJB
	private RacaBeanLocal racaBean;
	
	private Raca model = new Raca();
	
	public void createNewRaca(){
		model= new Raca();
	}
	public void save(){
		racaBean.save(model);
	}

	public Raca getModel() {
		return model;
	}

	public void setModel(Raca model) {
		this.model = model;
	}

	public RacaBeanLocal getRacaBean() {
		return racaBean;
	}

	public void setRacaBean(RacaBeanLocal racaBean) {
		this.racaBean = racaBean;
	}
	
	public void novaRaca(){
		Raca novinha = new Raca();
		novinha.setDescricao("Meu deus como e novo");
		racaBean.save(novinha);
	}
	
	
}
