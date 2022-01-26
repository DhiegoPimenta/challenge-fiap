package fiap.challenge.repositories;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import fiap.challenge.models.PacienteModel;


public interface IPacienteRepository extends CrudRepository<PacienteModel, Integer>{

	        @Query("SELECT u FROM PacienteModel u WHERE  u.cpf = :cpf")
	        Optional<PacienteModel> buscarPorCPF(@Param("cpf") String cpf);
	        
	        
}
	

