package control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.Especie;
import dao.Raca;
import ejb.EspecieBeanLocal;
import ejb.RacaBeanLocal;

@ManagedBean(name="crtRaca")
@ViewScoped
public class CrtRaca extends AbstractBean {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RacaBeanLocal racaBean;
	@EJB
	private EspecieBeanLocal especieBean;
	
	private Raca model = new Raca();
	
	private List<Especie> especiesCol = new ArrayList<Especie>();
	
	private transient HtmlDataTable dataTable;
	
	@PostConstruct
	public void postConstruct() {
		especiesCol.addAll(especieBean.getTodasEspecies());
	}

	public CrtRaca() {
		createNewRaca();
	}
	
	public void createNewRaca(){
		model= new Raca();
		model.setEspecie(new Especie());
	}
	
	public void inicializaRaca(ActionEvent event){
		createNewRaca();
	}
	
	public void selecionarRaca(ActionEvent event) {
		model = (Raca) dataTable.getRowData();
	}
	
	public String save(){
		racaBean.save(model);
		
		System.err.println("Save raca:"); 
		model = null;
		
		return redirect("FrmRaca");
	}
	
	public void delete(){
		racaBean.delete(model);
	}
	
	public RacaBeanLocal getRacaBean() {
		return racaBean;
	}
	public Raca getModel() {
		return model;
	}

	public void setModel(Raca model) {
		this.model = model;
	}

	public void setRacaBean(RacaBeanLocal racaBean) {
		this.racaBean = racaBean;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	public EspecieBeanLocal getEspecieBean() {
		return especieBean;
	}

	public void setEspecieBean(EspecieBeanLocal especieBean) {
		this.especieBean = especieBean;
	}
	
	public List<Especie> getEspeciesCol() {
		return especiesCol;
	}

	public void setEspeciesCol(List<Especie> especiesCol) {
		this.especiesCol = especiesCol;
	}

	public String objectToJson() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String jsonInString = objectMapper.writeValueAsString(model);
			System.out.println(jsonInString);
			return jsonInString;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
