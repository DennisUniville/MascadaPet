package control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import dao.Cliente;
import dao.Endereco;
import ejb.ClienteBeanLocal;

@ManagedBean(name="crtCliente")
@ViewScoped
public class CrtCliente {
	
	@EJB
	private ClienteBeanLocal clienteBean;
	
	private Cliente model = new Cliente();
	
	@PostConstruct
    public void init(){
         
    }
	
	public void createNewCliente(){
		model= new Cliente();
		model.setEndereco(new Endereco());
	}
	public void save(ActionEvent event){
		clienteBean.save(model);
	}
	
	public String atualizaPagina() {
		return "FrmCliente.xhtml";
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
	
}
