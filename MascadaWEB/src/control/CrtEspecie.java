package control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import dao.Especie;
import dao.Especie;
import ejb.EspecieBeanLocal;

import dao.Raca;
import dao.Raca;
import ejb.RacaBeanLocal;

@ManagedBean(name="crtEspecie")
@ViewScoped
public class CrtEspecie implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private EspecieBeanLocal especieBean;
	private Especie model;
	private transient HtmlDataTable dataTable;
	
	public void inicializaEspecie(ActionEvent event){
		model= new Especie();
	}
	
	public void selecionarEspecie(ActionEvent event) {
		model = (Especie) dataTable.getRowData();
	}
	
	public void save(){
		
		
		especieBean.save(model);
	}
	
	public void delete(){
		especieBean.delete(model);
	}
	
	public EspecieBeanLocal getEspecieBean() {
		return especieBean;
	}
	public Especie getModel() {
		return model;
	}

	public void setModel(Especie model) {
		this.model = model;
	}



	public void setEspecieBean(EspecieBeanLocal especieBean) {
		this.especieBean = especieBean;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

}
