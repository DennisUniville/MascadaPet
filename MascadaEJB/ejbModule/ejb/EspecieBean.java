package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.Especie;
import dao.Raca;

/**
 * Session Bean implementation class EspecieBean
 */
@Stateless
@LocalBean
public class EspecieBean implements EspecieBeanLocal {
	@PersistenceContext(name="mascadacontext")
	private EntityManager em;

	public EspecieBean() {
    
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Especie> getTodasEspecies() {
		Query q = em.createNamedQuery("todasEspecies");
		List<Especie> colResult = q.getResultList();
		return colResult;
	}

	@Override
	public List<Especie> getTodasEspeciesPorId(long oid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Especie> getTodasEspeciesPorDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Especie especie) {
		if(em.find(Especie.class, especie.getOid()) == null){
			//insert
					em.persist(especie);
		}else{
			//update
			em.merge(especie);
		}
		
	}

	@Override
	public void delete(Especie especie) {
		especie = em.find(Especie.class, especie.getOid());
		if(especie != null){
			em.remove(especie);
		}
		
	}

}
