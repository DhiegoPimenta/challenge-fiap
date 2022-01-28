package fiap.challenge.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="TB_ANAMNESE_PERGUNTAS")
public class AnamnesePerguntasModel {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer codigo_anamnese_perguntas;
	
	public String anamnese_pergunta;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<AnamneseRespostasModel> anamnese_respostas = new ArrayList<>();
	
	public Integer getCodigo_anamnese_perguntas() {
		return codigo_anamnese_perguntas;
	}

	public void setCodigo_anamnese_perguntas(Integer codigo_anamnese_perguntas) {
		this.codigo_anamnese_perguntas = codigo_anamnese_perguntas;
	}

	public String getAnamnese_pergunta() {
		return anamnese_pergunta;
	}

	public void setAnamnese_pergunta(String anamnese_pergunta) {
		this.anamnese_pergunta = anamnese_pergunta;
	}

	public List<AnamneseRespostasModel> getAnamnese_respostas() {
		return anamnese_respostas;
	}

	public void setAnamnese_respostas(List<AnamneseRespostasModel> anamnese_respostas) {
		this.anamnese_respostas = anamnese_respostas;
	}


 
}
