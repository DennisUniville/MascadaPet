package dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + oid);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( getClass() != obj.getClass())
			return false;
		Especie other = (Especie) obj;
		if(oid != other.oid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.valueOf(oid); 
	}
	
}
