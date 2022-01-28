package fiap.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fiap.challenge.models.AnamneseRespostasModel;
import fiap.challenge.repositories.IAnamneseRespostasRepository;

@RestController
public class AnamneseRespostasController {

	@Autowired
    private IAnamneseRespostasRepository repository;
	
	@PostMapping(path = "/api/anamnese/respostas/adicionar")
    public AnamneseRespostasModel salvar(@RequestBody AnamneseRespostasModel emergencia) {
        return repository.save(emergencia);
    }
 
 @GetMapping(path="/api/anamnese/respostas/{codigo}")
    public ResponseEntity<AnamneseRespostasModel> consultarAnamneseResposta(@PathVariable("codigo") Integer codigo) {
        return repository.findById(codigo).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
 
 @GetMapping(path="/api/anamnese/respostas/todos")
    public Iterable<AnamneseRespostasModel> todos(){
        return repository.findAll();
    }
 
 @PutMapping(path="/api/anamnese/respostas/alterar/{codigo}")
	 public AnamneseRespostasModel alterarAnamneseRespostas(@RequestBody AnamneseRespostasModel anamnese) {
	        return repository.save(anamnese);
	}
 
 @DeleteMapping(path="/api/anamnese/respostas/deletar/{codigo}")
	public void  deletarAnamneseRespostas(@PathVariable("codigo") Integer codigo) {
		repository.deleteById(codigo);
	}
}
