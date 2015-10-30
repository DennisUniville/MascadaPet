package control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import dao.Cliente;
import dao.Endereco;
import dao.Raca;
import dao.Servico;
import ejb.ClienteBeanLocal;
import ejb.RacaBean;
import ejb.RacaBeanLocal;
import ejb.ServicoBeanLocal;

@ManagedBean(name="crtServico")
@ViewScoped
public class CrtServico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ServicoBeanLocal servicoBean;
	private Servico model = new Servico();
	private transient HtmlDataTable dataTable;
	
	public void createNewServico(){
		model= new Servico();
	}
	public void inicializaServico(ActionEvent event){
		model= new Servico();
	
	}
	
	public void selecionarServico(ActionEvent event) {
		model = (Servico) dataTable.getRowData();
	}
	
	public void save(){
		
		servicoBean.save(model);
	}
	
	public void delete(){
		servicoBean.delete(model);
	}
	
	public ServicoBeanLocal getServicoBean() {
		return servicoBean;
	}
	public Servico getModel() {
		return model;
	}

	public void setModel(Servico model) {
		this.model = model;
	}

	public void setServicoBean(ServicoBeanLocal servicoBean) {
		this.servicoBean = servicoBean;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	
}
