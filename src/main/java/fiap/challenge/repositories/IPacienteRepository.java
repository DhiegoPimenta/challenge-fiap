package fiap.challenge.repositories;


import org.springframework.data.repository.CrudRepository;

import fiap.challenge.models.PacienteModel;


public interface IPacienteRepository extends CrudRepository<PacienteModel, Integer>{

}
