package dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="todasRacas",
			query="Select r from Raca r"),
	@NamedQuery(name="todasRacasPorId",
			query="Select r from Raca r where r.oid = :oid"),
	@NamedQuery(name="todasRacasPorDescricao",
			query="Select r from Raca r where r.descricao like :descricao")
})

@Entity
public class Raca implements Serializable{
	private static final long serialVersionUID = 1L;
	
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
