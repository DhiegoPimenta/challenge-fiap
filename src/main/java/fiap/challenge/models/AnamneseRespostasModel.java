package fiap.challenge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="TB_ANAMNESE_RESPOSTAS")
public class AnamneseRespostasModel {

	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer codigo_anamnese_respostas;
	
    public String anamnese_resposta;
    
    public Integer pontuacao_anamnese_respostas;
    
    
	
    public Integer getCodigo_anamnese_respostas() {
		return codigo_anamnese_respostas;
	}

	public void setCodigo_anamnese_respostas(Integer codigo_anamnese_respostas) {
		this.codigo_anamnese_respostas = codigo_anamnese_respostas;
	}

	public String getAnamnese_resposta() {
		return anamnese_resposta;
	}

	public void setAnamnese_resposta(String anamnese_resposta) {
		this.anamnese_resposta = anamnese_resposta;
	}

	public Integer getPontuacao_anamnese_respostas() {
		return pontuacao_anamnese_respostas;
	}

	public void setPontuacao_anamnese_respostas(Integer pontuacao_anamnese_respostas) {
		this.pontuacao_anamnese_respostas = pontuacao_anamnese_respostas;
	}

	
    
    
	
}
