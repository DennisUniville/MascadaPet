package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.Cliente;
import dao.Endereco;

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
        // TODO Auto-generated constructor stub
    	System.out.println("fui criado!!!");
    }

	@Override
	public List<Cliente> getTodosClientes() {
		Query q = em.createNamedQuery("todosClientes");
		
		List<Cliente> colResult = q.getResultList();
		System.out.println("VOLTOUUUUUUUUUUUUUUUUUUUUU  " +colResult.size());
		return colResult;

	
	}

	@Override
	public List<Cliente> getTodosClientesPorId(long oid) {
		System.out.println("Pelo menos passou aqui...");
		return null;
	}

	@Override
	public List<Cliente> getTodosClientesPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
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
	
	@Override
	public void save(Cliente cliente){
		Endereco endereco = cliente.getEndereco();
		
//		if(em.find(Endereco.class, endereco.getOid()) == null) {
//			
//		} else {
//
//		}
		
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
