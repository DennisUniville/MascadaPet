package control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import dao.Cliente;
import dao.Endereco;
import ejb.ClienteBeanLocal;

@ManagedBean(name="crtCliente")
@ViewScoped
public class CrtCliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ClienteBeanLocal clienteBean;
	private Cliente model;
	private transient HtmlDataTable dataTable;
	
	public void inicializaCliente(ActionEvent event){
		model= new Cliente();
		model.setEndereco(new Endereco());
	}
	
	public void selecionarCliente(ActionEvent event) {
		model = (Cliente) dataTable.getRowData();
	}
	
	public void save(){
		Endereco endereco = model.getEndereco();
		endereco.setCliente(model);
		clienteBean.save(model);
	}
	
	public void delete(){
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
