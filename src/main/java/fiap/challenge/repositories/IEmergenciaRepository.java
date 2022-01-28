package fiap.challenge.repositories;

import org.springframework.data.repository.CrudRepository;

import fiap.challenge.models.EmergenciaModel;


public interface IEmergenciaRepository extends CrudRepository<EmergenciaModel, Integer>{

}