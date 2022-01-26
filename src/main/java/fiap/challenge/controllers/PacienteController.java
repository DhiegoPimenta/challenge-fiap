package fiap.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fiap.challenge.models.PacienteModel;
import fiap.challenge.repositories.IPacienteRepository;

@RestController
public class PacienteController {

	 @Autowired
	    private IPacienteRepository repository;
	 
	 @PostMapping(path = "/api/paciente/adicionar")
	    public PacienteModel salvar(@RequestBody PacienteModel paciente) {
	        return repository.save(paciente);
	    }
	 
	 @GetMapping(path="/api/paciente/{codigo}")
	    public ResponseEntity<PacienteModel> consultarPaciente(@PathVariable("codigo") Integer codigo) {
	        return repository.findById(codigo).map(record -> ResponseEntity.ok().body(record))
	                .orElse(ResponseEntity.notFound().build());
	    }
	 
	 @GetMapping(path="/api/paciente/todos")
	    public Iterable<PacienteModel> todos(){
	        return repository.findAll();
	    }
	 
	 @GetMapping(path="/api/paciente/cpf/{codigo}")
	    public ResponseEntity<PacienteModel> consultarCPF(@PathVariable("codigo") String codigo) {
	        return repository.buscarPorCPF(codigo).map(record -> ResponseEntity.ok().body(record))
	                .orElse(ResponseEntity.notFound().build());
	    }
	 
	 @PostMapping(path = "/api/paciente/buscarPorOutrosDados")
	    public ResponseEntity<PacienteModel> buscarPacienteOutrosDados(@RequestBody PacienteModel paciente) {
		 return repository.buscarPorOutrosDados(paciente).map(record -> ResponseEntity.ok().body(record))
	                .orElse(ResponseEntity.notFound().build());
	    }
	 
}
