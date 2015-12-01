package control;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import dao.Cliente;
import dao.Endereco;
import ejb.ClienteBeanLocal;
import ejb.exception.ValidationException;

@ManagedBean(name="crtCliente")
@RequestScoped
public class CrtCliente extends AbstractBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private ClienteBeanLocal clienteBean;
	private Cliente model;
	private transient HtmlDataTable dataTable;
	
	@PostConstruct
	public void init() {
		model= new Cliente();
		model.setEndereco(new Endereco()); 
	}
	
	public void inicializaCliente(ActionEvent event){
		System.err.println("inicializaCliente");
		init();
	}
	
	public void selecionarCliente(ActionEvent event) {
		model = (Cliente) dataTable.getRowData();
	}
	
	public void save(){
		Endereco endereco = model.getEndereco();
		endereco.setCliente(model);

		try {
			clienteBean.save(model);
		} catch (ValidationException e) {		
			addMessageToRequest(e.getMessage()); 
		}
	}
	
	public void delete(){
		System.err.println("delete");
		clienteBean.delete(model);
	}
	
	public ClienteBeanLocal getClienteBean() {
		return clienteBean;
	}
	public Cliente getModel() {
		return model;
	}

	public void setModel(Cliente model) {
		this.model = model;
	}


	public void setClienteBean(ClienteBeanLocal clienteBean) {
		this.clienteBean = clienteBean;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

}
