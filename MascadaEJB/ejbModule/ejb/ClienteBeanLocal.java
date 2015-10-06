package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.Cliente;
import dao.Raca;

@Local
public interface ClienteBeanLocal {

	public List<Cliente> getTodosClientes();
	public List<Cliente> getTodosClientesPorId(long oid);
	public List<Cliente> getTodosClientesPorCpf(String cpf);
	public List<Cliente> getTodosClientesPorNome(String nome);
	public List<Cliente> getTodosClientesPorTelefone(String telefone);
	public List<Cliente> getTodosClientesPorEmail(String email);
	
	public void save(Cliente cliente);
	void delete(Cliente cliente);
	
	
}
