package fiap.challenge.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fiap.challenge.models.EmergenciaModel;
import fiap.challenge.repositories.IEmergenciaRepository;

@RestController
public class EmergenciaController {
	 @Autowired
	    private IEmergenciaRepository repository;
	 
	 @PostMapping(path = "/api/emergencia/adicionar")
	    public EmergenciaModel salvar(@RequestBody EmergenciaModel emergencia) {
	        return repository.save(emergencia);
	    }
	 
	 @GetMapping(path="/api/emergencia/{codigo}")
	    public ResponseEntity<EmergenciaModel> consultarPerguntaEmergencia(@PathVariable("codigo") Integer codigo) {
	        return repository.findById(codigo).map(record -> ResponseEntity.ok().body(record))
	                .orElse(ResponseEntity.notFound().build());
	    }
	 
	 @GetMapping(path="/api/emergencia/perguntas")
	    public Iterable<EmergenciaModel> todos(){
	        return repository.findAll();
	    }
	 
	 @PutMapping(path="/api/emergencia/alterar/{codigo}")
		 public EmergenciaModel alterarPerguntaEmergencia(@RequestBody EmergenciaModel emergencia) {
		        return repository.save(emergencia);
		}
	 
	 @DeleteMapping(path="/api/consulta/deletar/{codigo}")
		public void  deletarPerguntaEmergencia(@PathVariable("codigo") Integer codigo) {
			repository.deleteById(codigo);
		}

	 @GetMapping(path="/api/emergencia/verificar/emergencia/{total}")
	    public Map<String, String> verificarEmegerncia(@PathVariable("total") Integer total) {
		 HashMap<String, String> map = new HashMap<>();
		 if(total <= 5) {
			 map.put("emergencia", "2");
		     map.put("texto", "SEM PRIORIDADE");;
		     return map;
		 } else {
			 if(total >= 20) {
				 map.put("emergencia", "0");
			     map.put("texto", "PRIORIDADE MÁXIMA");;
			     return map;
			 } else {
				 map.put("emergencia", "1");
			     map.put("texto", "PRIORIDADE MODERADA");;
			     return map; 
			 }
		 }
	    }
}
