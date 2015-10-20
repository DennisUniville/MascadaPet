package dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@NamedQueries({
	@NamedQuery(name="todosEnderecos",
			query="Select e from Endereco e"),
	@NamedQuery(name="todosEnderecosPorId",
			query="Select e from Endereco e where e.oid = :oid"),
	@NamedQuery(name="todosEnderecosPorRua",
			query="Select e from Endereco e where e.rua = :rua"),
	@NamedQuery(name="todosEnderecosPorBairro",
			query="Select e from Endereco e where e.bairro = :bairro"),
	@NamedQuery(name="todosEnderecosPorCep",
			query="Select e from Endereco e where e.cep = :cep"),
	@NamedQuery(name="todosEnderecosPorNumero",
			query="Select e from Endereco e where e.numero = :numero"),
	@NamedQuery(name="todosEnderecosPorComplemento",
			query="Select e from Endereco e where e.complemento = :complemento"),	
	@NamedQuery(name="enderecoPorClienteId",
		query="Select e from Endereco e where e.cliente.oid = :oid")
})

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;
	private String rua;
	private String bairro;
	@Column(length=9)
	private String cep; 
	private String numero;
	private String complemento;
	@OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Cliente cliente;
	
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
