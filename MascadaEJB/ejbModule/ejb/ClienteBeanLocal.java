package ejb;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.NoResultException;

import dao.Cliente;
import ejb.exception.ValidationException;

@Local
public interface ClienteBeanLocal {

	public List<Cliente> getTodosClientes();
	
	public List<Cliente> getTodosClientesPorId(long oid);
	
	public Cliente getClientePorCPF(String cpf) throws NoResultException;
	
	public List<Cliente> getTodosClientesPorNome(String nome);
	
	public List<Cliente> getTodosClientesPorTelefone(String telefone);
	
	public List<Cliente> getTodosClientesPorEmail(String email);	
	
	public void save(Cliente cliente) throws ValidationException;
	
	public void delete(Cliente cliente);
	
}
