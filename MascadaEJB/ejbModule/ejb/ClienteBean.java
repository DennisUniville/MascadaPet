package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.Cliente;
import dao.Endereco;
import ejb.exception.ValidationException;

/**
 * Session Bean implementation class RacaBean
 */
@Stateless
@LocalBean
public class ClienteBean implements ClienteBeanLocal {
	@PersistenceContext(name="mascadacontext")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ClienteBean() {
    }

	@Override
	public List<Cliente> getTodosClientes() {
		Query q = em.createNamedQuery("todosClientes");	
		List<Cliente> colResult = q.getResultList();
		return colResult;
	}

	@Override
	public List<Cliente> getTodosClientesPorId(long oid) {
		return null;
	}

	@Override
	public Cliente getClientePorCPF(String cpf) throws NoResultException {
		Query q = em.createNamedQuery("clientePorCPF")
				.setParameter("cpf", cpf); 
		Cliente cliente;
		try {
			cliente = (Cliente) q.getSingleResult();
		} catch (Exception e) {
			System.err.println("cpf:" + cpf + " " + e.getMessage() + " | "  + e.getCause());
			return null;
		}
		
		if(cliente.getEndereco() == null)
			cliente.setEndereco(new Endereco());
		return cliente;
	}
	
	@Override
	public List<Cliente> getTodosClientesPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Cliente> getTodosClientesPorTelefone(String telefone) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Cliente> getTodosClientesPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean existeCPF(String cpf, long oid) {
		String query = "SELECT COUNT(c) FROM Cliente C WHERE c.cpf = '" + cpf + "'";
		
		if (oid > 0) {
			query += " AND c.oid != " + oid;
		}
		
		Query q = em.createQuery(query);
		long count = (Long) q.getResultList().get(0);
		return count > 0;
	}
	
	@Override
	public void save(Cliente cliente) throws ValidationException {
		if(existeCPF(cliente.getCpf(), cliente.getOid()))
			throw new ValidationException("O CPF informado ja esta sendo utilizado!");
		
		if(em.find(Cliente.class, cliente.getOid()) == null){
			em.persist(cliente);
		}else{
			em.merge(cliente);
		}
	}
	
	@Override
	public void delete(Cliente cliente){
		cliente = em.find(Cliente.class, cliente.getOid());
		if(cliente != null){
			em.remove(cliente);
		}
	}

}
