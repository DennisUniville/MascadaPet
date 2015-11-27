package br.com.mascada;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dao.Cliente;
import ejb.ClienteBeanLocal;

@Path("/Clientes")
@RequestScoped
public class ClienteREST {

	@Inject
	private	ClienteBeanLocal clienteBean;
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public List<Cliente> getAllClientes() {
		return clienteBean.getTodosClientes();
	}
	

}
