package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Chamado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;
	
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataHoraEntrada;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataHoraEncerramento;
	private String tipoEncerramento;
	
	@Column(length=1000)
	private String observacao;
	
	
	@ManyToOne(cascade={CascadeType.MERGE})
	private Animal animal;
	@ManyToOne(cascade={CascadeType.MERGE})
	private Funcionario funcionario;
	@ManyToOne(cascade={CascadeType.MERGE})
	private Agenda agenda;
	@OneToMany(cascade={CascadeType.PERSIST})  //TODO duvida professor
	private List<ItensChamado> itensChamado;
	
	
	
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public Date getDataHoraEntrada() {
		return dataHoraEntrada;
	}
	public void setDataHoraEntrada(Date dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}
	public Date getDataHoraEncerramento() {
		return dataHoraEncerramento;
	}
	public void setDataHoraEncerramento(Date dataHoraEncerramento) {
		this.dataHoraEncerramento = dataHoraEncerramento;
	}
	public String getTipoEncerramento() {
		return tipoEncerramento;
	}
	public void setTipoEncerramento(String tipoEncerramento) {
		this.tipoEncerramento = tipoEncerramento;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
	
	
	

}
