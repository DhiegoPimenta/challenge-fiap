package fiap.challenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fiap.challenge.models.PacienteModel;


public interface IPacienteRepository extends CrudRepository<PacienteModel, Integer>{

	        @Query("SELECT u FROM PacienteModel u WHERE  u.cpf = :cpf")
	        Optional<PacienteModel> buscarPorCPF(@Param("cpf") String cpf);
	        
	        @Query("SELECT u FROM PacienteModel u WHERE  u.nome = :#{#dados.nome} and  u.ultimo_nome = :#{#dados.ultimo_nome} and  u.data_nascimento = :#{#dados.data_nascimento} and  u.nome_mae = :#{#dados.nome_mae}")
	        Optional<PacienteModel> buscarPorOutrosDados(@Param("dados") PacienteModel dados);
	        
	        
}
	

