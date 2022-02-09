package fiap.challenge.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hmvcollection")
public class FilaCheckInOnline {

	 @Id
	  private String id;
	  public Integer codigo_paciente;
	  public String nome;
	  public String ultimo_nome;
	  public String data_nascimento;
	  public String cpf;
	  public String nome_mae;
	  public String data_checkin;
	  public String emergencia;
	  public String respondidas;
	  public String check;
	  
	  
	  public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getData_checkin() {
		return data_checkin;
	}

	public void setData_checkin(String data_checkin) {
		this.data_checkin = data_checkin;
	}

	public String getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(String emergencia) {
		this.emergencia = emergencia;
	}

	public String getRespondidas() {
		return respondidas;
	}

	public void setRespondidas(String respondidas) {
		this.respondidas = respondidas;
	}

	  public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	  public Integer getCodigo_paciente() {
		return codigo_paciente;
	}

	public void setCodigo_paciente(Integer codigo_paciente) {
		this.codigo_paciente = codigo_paciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUltimo_nome() {
		return ultimo_nome;
	}

	public void setUltimo_nome(String ultimo_nome) {
		this.ultimo_nome = ultimo_nome;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome_mae() {
		return nome_mae;
	}

	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}

	    
	  public FilaCheckInOnline() {
	  }
}
