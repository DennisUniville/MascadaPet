package br.com.mascada;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

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
	
	@GET
	@Path("/cpf")
	@Produces("application/json")
	public Cliente getCliente(@QueryParam("param") String cpf) {
		Cliente cliente;
		
		try {
			cliente = clienteBean.getClientePorCPF(cpf);
		} catch (NoResultException e) {
			System.err.println(e.getMessage());
			return null;
		}	
		
		return cliente;
	}
}
