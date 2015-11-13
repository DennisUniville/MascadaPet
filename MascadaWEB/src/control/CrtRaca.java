package control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import dao.Raca;
import ejb.RacaBeanLocal;

@ManagedBean(name="crtRaca")
@ViewScoped
public class CrtRaca implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RacaBeanLocal racaBean;
	private Raca model = new Raca();
	private transient HtmlDataTable dataTable;
	
	public void createNewRaca(){
		model= new Raca();
	}
	
	public void inicializaRaca(ActionEvent event){
		model= new Raca();	
	}
	
	public void selecionarRaca(ActionEvent event) {
		model = (Raca) dataTable.getRowData();
	}
	
	public void save(){
		
		racaBean.save(model);
	}
	
	public void delete(){
		racaBean.delete(model);
	}
	
	public RacaBeanLocal getRacaBean() {
		return racaBean;
	}
	public Raca getModel() {
		return model;
	}

	public void setModel(Raca model) {
		this.model = model;
	}

	public void setRacaBean(RacaBeanLocal racaBean) {
		this.racaBean = racaBean;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	
}
