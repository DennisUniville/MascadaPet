package control;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Funcionario;
import dao.Raca;
import ejb.FuncionarioBeanLocal;

@ManagedBean(name="crtFuncionario")
@ViewScoped
public class CrtFuncionario {
	
	@EJB
	private FuncionarioBeanLocal funcionarioBean;
	
private Funcionario model = new Funcionario();
	
	public void createNewFuncioanrio(){
		model= new Funcionario();
	}
	public void save(){
		funcionarioBean.save(model);
	}

	public Funcionario getModel() {
		return model;
	}
	public void setModel(Funcionario model) {
		this.model = model;
	}
	public FuncionarioBeanLocal getFuncionarioBean() {
		return funcionarioBean;
	}

	public void setFuncionarioBean(FuncionarioBeanLocal funcionarioBean) {
		this.funcionarioBean = funcionarioBean;
	}
	
	public void novoFuncionario(){
		Funcionario novinho = new Funcionario();
		novinho.setLogin("Dennis");
		funcionarioBean.save(novinho);
	}
	
	
}
