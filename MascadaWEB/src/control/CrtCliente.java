package control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Init;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import dao.Cliente;
import dao.Endereco;
import ejb.ClienteBeanLocal;

@ManagedBean(name="crtCliente")
@RequestScoped
public class CrtCliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ClienteBeanLocal clienteBean;
	
	private Cliente model;
	
	private transient HtmlDataTable dataTable;
	
	public void inicializaCliente(){
		model= new Cliente();
	}
	
	public void selecionarCliente(ActionEvent event) {
		model = (Cliente) dataTable.getRowData();
	}
	
	public Object save(){
		clienteBean.save(model);	
		return null;
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

	public ClienteBeanLocal getRacaBean() {
		return clienteBean;
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
