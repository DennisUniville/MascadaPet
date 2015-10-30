package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.Raca;
import dao.Servico;

@Local
public interface ServicoBeanLocal {

	public List<Servico> getTodosServicos();
	public List<Servico> getTodosServicosPorId(long oid);
	public List<Servico> getTodosServicosPorDescricao(String descricao);
	
	public void save(Servico servico);
	void delete(Servico servico);
	
}
