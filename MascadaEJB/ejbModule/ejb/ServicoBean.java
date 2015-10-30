package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import dao.Servico;

/**
 * Session Bean implementation class RacaBean
 */
@Stateless
@LocalBean
public class ServicoBean implements ServicoBeanLocal {
	@PersistenceContext(name="mascadacontext")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ServicoBean() {
        // TODO Auto-generated constructor stub
    	System.out.println("fui criado!!!");
    }

	@Override
	public List<Servico> getTodosServicos() {
		Query q = em.createNamedQuery("todosServicos");
		
		List<Servico> colResult = q.getResultList();
		System.out.println("VOLTOUUUUUUUUUUUUUUUUUUUUU  " +colResult.size());
		return colResult;

	
	}

	@Override
	public List<Servico> getTodosServicosPorId(long oid) {
		System.out.println("Pelo menos passou aqui...");
		return null;
	}

	@Override
	public List<Servico> getTodosServicosPorDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Servico servico){
		if(em.find(Servico.class, servico.getOid())
				==null){
			//insert
					em.persist(servico);
		}else{
			//update
			em.merge(servico);
		}
	}
	
	@Override
	public void delete(Servico servico){
		servico = em.find(Servico.class, servico.getOid());
		if(servico != null){
			em.remove(servico);
		}
	}



}
