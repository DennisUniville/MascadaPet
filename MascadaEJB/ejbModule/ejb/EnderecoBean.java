package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.Cliente;
import dao.Endereco;
import dao.Funcionario;

/**
 * Session Bean implementation class FuncionarioBean
 */

@Stateless
@LocalBean
public class EnderecoBean implements EnderecoBeanLocal {
	@PersistenceContext(name="mascadacontext")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public EnderecoBean() {
    }

	@Override
	public List<Endereco> getTodosEnderecos() {
		Query q = em.createNamedQuery("todosEnderecos");
		List<Endereco> colResult = q.getResultList();
		return colResult;
	}

	@Override
	public List<Endereco> getTodosEnderecosPorId(long oid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> getTodosEnderecosPorRua(String rua) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> getTodosFuncionariosPorBairro(String bairro) {
		// TODO Auto-generated method stub
		return null;
	}


	
	@Override
	public List<Endereco> getTodosFuncionariosPorCep(String cep) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Endereco> getTodosFuncionariosPorNumero(String numero) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Endereco> getTodosFuncionariosPorComplemento(String complemento) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void save(Endereco endereco) {
		if(em.find(Endereco.class, endereco.getOid()) == null){
			em.persist(endereco);
		}else{
			em.merge(endereco);
		}
	}

	@Override
	public void delete(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco getEnderecoPorCliente(long oid) {
		Query q = em.createNamedQuery("enderecoPorClienteId")
					.setParameter("oid", oid);
		Endereco endereco = (Endereco) q.getSingleResult();
		return endereco;
	}


}
