package br.com.mascada;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dao.Cliente;
import ejb.ClienteBeanLocal;

@Path("/Clientes")
@javax.enterprise.context.RequestScoped
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
