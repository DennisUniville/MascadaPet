package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.Raca;

@Local
public interface ServicoBeanLocal {

	public List<Raca> getTodasRacas();
	public List<Raca> getTodasRacasPorId(long oid);
	public List<Raca> getTodasRacasPorDescricao(String descricao);
	
	public void save(Raca raca);
	void delete(Raca raca);
	
}
