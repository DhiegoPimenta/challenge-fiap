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

import fiap.challenge.models.AnamnesePerguntasModel;
import fiap.challenge.repositories.IAnamnesePerguntasRepository;


@RestController
public class AnamnesePerguntasController {

	@Autowired
    private IAnamnesePerguntasRepository repository;
	
	@PostMapping(path = "/api/anamnese/perguntas/adicionar")
    public AnamnesePerguntasModel salvar(@RequestBody AnamnesePerguntasModel emergencia) {
        return repository.save(emergencia);
    }
 
 @GetMapping(path="/api/anamnese/perguntas/{codigo}")
    public ResponseEntity<AnamnesePerguntasModel> consultarAnamnesePerguntas(@PathVariable("codigo") Integer codigo) {
        return repository.findById(codigo).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
 
 @GetMapping(path="/api/anamnese/perguntas/todos")
    public Iterable<AnamnesePerguntasModel> todos(){
        return repository.findAll();
    }
 
 @PutMapping(path="/api/anamnese/perguntas/alterar/{codigo}")
	 public AnamnesePerguntasModel alterarAnamnesePerguntas(@RequestBody AnamnesePerguntasModel anamnese) {
	        return repository.save(anamnese);
	}
 
 @DeleteMapping(path="/api/anamnese/perguntas/deletar/{codigo}")
	public void  deletarAnamnesePerguntas(@PathVariable("codigo") Integer codigo) {
		repository.deleteById(codigo);
	}
 
 @GetMapping(path="/api/anamnese/perguntas/verificar/{total}")
 public Map<String, String> verificarRespostas(@PathVariable("total") Integer total) {
	 HashMap<String, String> map = new HashMap<>();
	 if(total <= 25) {
		 map.put("emergencia", "2");
	     map.put("texto", "SEM PRIORIDADE");;
	     return map;
	 } else {
			 map.put("emergencia", "0");
		     map.put("texto", "PRIORIDADE MÁXIMA");;
		     return map;
		 } 
	 }
}
