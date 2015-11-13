package dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="todasEspecies",
			query="Select e from Especie e"),
	@NamedQuery(name="todasEspeciesPorId",
			query="Select e from Especie e where e.oid = :oid"),
	@NamedQuery(name="todasEspeciesPorDescricao",
			query="Select e from Especie e where e.descricao like :descricao")
})

@Entity
public class Especie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;
	private String descricao;
	
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		
}
