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
import ejb.EnderecoBeanLocal;

@ManagedBean(name="crtCliente")
@ViewScoped
public class CrtCliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ClienteBeanLocal clienteBean;
	@EJB
	private EnderecoBeanLocal enderecoBean;
	
	private Cliente model;
	private Endereco enderecoModel;
	
	private transient HtmlDataTable dataTable;
	
	public void inicializaCliente(ActionEvent event){
		model= new Cliente();
		enderecoModel = new Endereco();
		model.setEndereco(enderecoModel);
		enderecoModel.setCliente(model);
	}
	
	public void selecionarCliente(ActionEvent event) {
		model = (Cliente) dataTable.getRowData();
		enderecoModel = enderecoBean.getEnderecoPorCliente(model.getOid());
		model.setEndereco(enderecoModel);
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

	public EnderecoBeanLocal getEnderecoBean() {
		return enderecoBean;
	}

	public void setEnderecoBean(EnderecoBeanLocal enderecoBeanLocal) {
		this.enderecoBean = enderecoBeanLocal;
	}

	public Endereco getEnderecoModel() {
		return enderecoModel;
	}

	public void setEnderecoModel(Endereco enderecoModel) {
		this.enderecoModel = enderecoModel;
	}

	
}
