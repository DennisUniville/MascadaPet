package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.Endereco;
import dao.Funcionario;

@Local
public interface EnderecoBeanLocal {
	
	public List<Endereco> getTodosEnderecos();
	public List<Endereco> getTodosEnderecosPorId(long oid);
	public List<Endereco> getTodosEnderecosPorRua(String rua);
	public List<Endereco> getTodosFuncionariosPorBairro(String bairro);
	public List<Endereco> getTodosFuncionariosPorCep(String cep);
	public List<Endereco> getTodosFuncionariosPorNumero(String numero);
	public List<Endereco> getTodosFuncionariosPorComplemento(String complemento);

	void save(Endereco endereco);
	void delete(Endereco endereco);

}
