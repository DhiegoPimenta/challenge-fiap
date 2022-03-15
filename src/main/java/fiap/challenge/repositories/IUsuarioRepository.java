package fiap.challenge.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fiap.challenge.models.UsuarioPacienteModel;


@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioPacienteModel, Integer> {
	
	UsuarioPacienteModel findByUsername(String username);

	UsuarioPacienteModel findAllById(Long id);
	
}