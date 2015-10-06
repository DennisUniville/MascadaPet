package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.Funcionario;
import dao.Raca;

@Local
public interface FuncionarioBeanLocal {
	
	public List<Funcionario> getTodosFuncionarios();
	public List<Funcionario> getTodosFuncionariosPorId(long oid);
	public List<Funcionario> getTodosFuncionariosPorLogin(String login);
	public List<Funcionario> getTodosFuncionariosPorNome(String nome);
	public List<Funcionario> getTodosFuncionariosPorRg(String rg);
	

	public void save(Funcionario funcionario);
	void delete(Funcionario funcionario);

}
