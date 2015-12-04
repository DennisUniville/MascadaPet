package ejb;

import javax.ejb.Local;

import dao.Usuario;
import ejb.exception.ValidationException;

@Local
public interface UsuarioBeanLocal {
	public Usuario validaUsuario(String login, String senha) throws ValidationException;
	public void criarAdmin();
}
