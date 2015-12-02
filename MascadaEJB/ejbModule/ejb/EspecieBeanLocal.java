package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.Especie;

@Local
public interface EspecieBeanLocal {
	public List<Especie> getTodasEspecies();
	public List<Especie> getTodasEspeciesPorId(long oid);
	public List<Especie> getTodasEspeciesPorDescricao(String descricao);
	public Especie getEspeciePorOid(long oid);
	public void save(Especie especie);
	void delete(Especie especie);
}
