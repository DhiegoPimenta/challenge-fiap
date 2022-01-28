package fiap.challenge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TB_EMERGENCIA")
public class EmergenciaModel {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer codigo_pergunta;
	
    public String pergunta;
    
    public Integer pontuacao_pergunta;
    
    

    public Integer getCodigo_pergunta() {
		return codigo_pergunta;
	}

	public void setCodigo_pergunta(Integer codigo_pergunta) {
		this.codigo_pergunta = codigo_pergunta;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public Integer getPontuacao_pergunta() {
		return pontuacao_pergunta;
	}

	public void setPontuacao_pergunta(Integer pontuacao_pergunta) {
		this.pontuacao_pergunta = pontuacao_pergunta;
	}

	
}
