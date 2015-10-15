package dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@NamedQueries({
	@NamedQuery(name="todosClientes",
			query="Select c from Cliente c"),
	@NamedQuery(name="todosClientesPorId",
			query="Select c from Cliente c where c.oid = :oid"),
	@NamedQuery(name="clientePorCPF",
		query="Select c from Cliente c where c.cpf = :cpf")
})


@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;
	
	@Column(length=11, unique=true)
	private String cpf;
	
	@Column(length=500)
	private String nome;
	
	@Column(length=500)
	private String telefone;
	
	@Column(length=500)
	private String email;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Endereco endereco;
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
