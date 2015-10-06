package dao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({
	@NamedQuery(name="todosFuncionarios",
			query="Select f from Funcionario f"),
	@NamedQuery(name="todosFuncionariosPorId",
			query="Select f from Funcionario f where f.oid = :oid"),
	@NamedQuery(name="TodosFuncionariosPorLogin",
			query="Select f from Funcionario f where f.login like :login"),
	@NamedQuery(name="todosFuncionariosPorNome",
			query="Select f from Funcionario f where f.nome like :nome"),
	@NamedQuery(name="todosFuncionariosPorRg",
			query="Select f from Funcionario f where f.rg like :rg")		
})

@Entity
public class Funcionario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;
	private String login;
	private String senha;
	private String nome;
	private String rg;
	
	
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
}
