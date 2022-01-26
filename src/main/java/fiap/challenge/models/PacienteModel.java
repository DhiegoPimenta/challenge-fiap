package fiap.challenge.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TB_PACIENTES")
public class PacienteModel {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer codigo_paciente;

    public String nome;
    
    public String ultimo_nome;
    
    public String data_nascimento;
    
    public String cpf;
    
    public String nome_mae;
    
    
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
}