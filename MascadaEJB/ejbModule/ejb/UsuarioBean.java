package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.Usuario;
import ejb.exception.ValidationException;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
@LocalBean
public class UsuarioBean implements UsuarioBeanLocal {

	/**
	 * Default constructor. 
	 */
	@PersistenceContext(name="mascadacontext")
	private EntityManager em;
	
	public UsuarioBean() {
		
	}

	public void criarAdmin(){
		try{
			Query q = em.createNamedQuery("findUserAdmin");
			q.setMaxResults(1);
			q.getSingleResult();
		}catch (NoResultException e){
			Usuario uAdmin = new Usuario();
			uAdmin.setLogin("admin");
			uAdmin.setSenha("admin");
			em.persist(uAdmin);
		}
	}
	public Usuario validaUsuario(String login, String senha) throws ValidationException {
		try{
			Query q = em.createNamedQuery("authUser");
			q.setParameter("login", login);
			q.setParameter("senha", senha);
			q.setMaxResults(1);
			return (Usuario)q.getSingleResult();
		}catch (NoResultException e){
			throw new ValidationException("Senha ou login estão errados.");
		}
	}
}
