package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.Funcionario;
import dao.Raca;

/**
 * Session Bean implementation class FuncionarioBean
 */

@Stateless
@LocalBean
public class FuncionarioBean implements FuncionarioBeanLocal {
	@PersistenceContext(name="mascadacontext")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public FuncionarioBean() {
        // TODO Auto-generated constructor stub
    	System.out.println("foi criado um funcionario!!!");
    }

	@Override
	public List<Funcionario> getTodosFuncionarios() {
		Query q = em.createNamedQuery("todosFuncionarios");
		List<Funcionario> colResult = q.getResultList();
		System.out.println("VOLTOUUUUUUUUUUUUUUUUUUUUU funcionario " +colResult.size());
		return colResult;
	}

	@Override
	public List<Funcionario> getTodosFuncionariosPorId(long oid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> getTodosFuncionariosPorLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> getTodosFuncionariosPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> getTodosFuncionariosPorRg(String rg) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void save(Funcionario funcionario){
		if(em.find(Raca.class, funcionario.getOid())
				==null){
			//insert
					em.persist(funcionario);
		}else{
			//update
			em.merge(funcionario);
		}
	}
	
	@Override
	public void delete(Funcionario funcionario){
		funcionario = em.find(Funcionario.class, funcionario.getOid());
		if(funcionario != null){
			em.remove(funcionario);
		}
	}



}
