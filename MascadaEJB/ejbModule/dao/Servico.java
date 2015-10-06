package dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

@NamedQueries({
	@NamedQuery(name="todosServicos",
			query="Select s from Servico s"),
	@NamedQuery(name="todosServicosPorId",
			query="Select s from Servico s where s.oid = :oid"),
	@NamedQuery(name="todosServicosPorDescricao",
			query="Select s from Servico s where s.descricao like :descricao")
})



@Entity
public class Servico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;
	private String descricao;
	

	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	
	
}
