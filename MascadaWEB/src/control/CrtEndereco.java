package control;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Endereco;
import dao.Funcionario;
import ejb.EnderecoBeanLocal;
import ejb.FuncionarioBeanLocal;

@ManagedBean(name="crtEndereco")
@ViewScoped
public class CrtEndereco {
	
	@EJB
	private EnderecoBeanLocal enderecoBean;

	public EnderecoBeanLocal getEnderecoBean() {
		return enderecoBean;
	}

	public void setEnderecoBean(EnderecoBeanLocal enderecoBean) {
		this.enderecoBean = enderecoBean;
	}
	
	public void novoEndereco(){
		Endereco novinho = new Endereco();
		novinho.setRua("Dennis");
		enderecoBean.save(novinho);
	}
	
	
}
