package control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import dao.Funcionario;
import dao.Raca;
import ejb.FuncionarioBeanLocal;
import ejb.RacaBeanLocal;

@ManagedBean(name="crtFuncionario")
@ViewScoped
public class CrtFuncionario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FuncionarioBeanLocal funcionarioBean;
	
private Funcionario model = new Funcionario();
private transient HtmlDataTable dataTable;
	
public void createNewFuncionario(){
	model= new Funcionario();
}
public void inicializaFuncionario(ActionEvent event){
	model= new Funcionario();

}

public void selecionarFuncionario(ActionEvent event) {
	model = (Funcionario) dataTable.getRowData();
}

public void save(){
	
	funcionarioBean.save(model);
}

public void delete(){
	funcionarioBean.delete(model);
}

public FuncionarioBeanLocal getFuncionarioBean() {
	return funcionarioBean;
}
public Funcionario getModel() {
	return model;
}

public void setModel(Funcionario model) {
	this.model = model;
}

public void setFuncionarioBean(FuncionarioBeanLocal funcionarioBean) {
	this.funcionarioBean = funcionarioBean;
}

public HtmlDataTable getDataTable() {
	return dataTable;
}

public void setDataTable(HtmlDataTable dataTable) {
	this.dataTable = dataTable;
}
}
