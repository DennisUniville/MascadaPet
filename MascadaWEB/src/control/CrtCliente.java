package control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Init;
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
	private Endereco enderecoModel;
	
	private HtmlDataTable dataTable;
	
	
	@Init
	public void init() {
		//createNewCliente();
	}
	
	public void createNewCliente(){
		enderecoModel = new Endereco();
		model= new Cliente();
		model.setEndereco(enderecoModel);
	}
	
	public void selecionarCliente(ActionEvent event) {
		model = (Cliente) dataTable.getRowData();
		model.setEndereco(enderecoModel);
		
		System.err.println("Cliente selecionado: " + model);
	}
	
	public Object save(){
		System.out.println("METODO SAVE");
		System.out.println(model.getOid());
		System.out.println(model.getNome());
		System.out.println(model.getCpf());
		System.err.println("enderecoModel:" + enderecoModel.getRua());
		
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

	public Endereco getEnderecoModel() {
		return enderecoModel;
	}

	public void setEnderecoModel(Endereco enderecoModel) {
		this.enderecoModel = enderecoModel;
	}

	
}
