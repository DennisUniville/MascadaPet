package dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class ItensChamado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;
	
	@OneToOne(cascade= {CascadeType.PERSIST}) //TODO perguntar pro professor
	private Servico servico;
	
	
	@ManyToOne(cascade={CascadeType.PERSIST}) //TODO
	private Chamado chamado;
	

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}
	
	
}
