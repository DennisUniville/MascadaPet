package ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.Raca;

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
	public List<Raca> getTodasRacas() {
		Query q = em.createNamedQuery("todasRacas");
		
		List<Raca> colResult = q.getResultList();
		System.out.println("VOLTOUUUUUUUUUUUUUUUUUUUUU  " +colResult.size());
		return colResult;

	
	}

	@Override
	public List<Raca> getTodasRacasPorId(long oid) {
		System.out.println("Pelo menos passou aqui...");
		return null;
	}

	@Override
	public List<Raca> getTodasRacasPorDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Raca raca){
		if(em.find(Raca.class, raca.getOid())
				==null){
			//insert
					em.persist(raca);
		}else{
			//update
			em.merge(raca);
		}
	}
	
	@Override
	public void delete(Raca raca){
		raca = em.find(Raca.class, raca.getOid());
		if(raca != null){
			em.remove(raca);
		}
	}

}
