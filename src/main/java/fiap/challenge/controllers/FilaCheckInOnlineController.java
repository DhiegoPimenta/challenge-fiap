package fiap.challenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fiap.challenge.models.FilaCheckInOnline;
import fiap.challenge.repositories.IFilaCheckInOnlineRepository;

@RestController
public class FilaCheckInOnlineController {

	@Autowired
    private IFilaCheckInOnlineRepository repository;
	
	 @GetMapping("/fila/buscar")
	  public ResponseEntity<List<FilaCheckInOnline>> buscarFila () {
		 try {
			    List<FilaCheckInOnline> listapacientes = new ArrayList<FilaCheckInOnline>();
			    repository.findAll().forEach(listapacientes::add);
			    return new ResponseEntity<>(listapacientes, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	 
	 @PostMapping("/fila/adicionar")
	 public ResponseEntity<FilaCheckInOnline> adicionarFila(@RequestBody FilaCheckInOnline pacientelista) {
	   try {
		   FilaCheckInOnline _pacientelista = repository.save(pacientelista);
	     return new ResponseEntity<>(_pacientelista, HttpStatus.CREATED);
	   } catch (Exception e) {
	     return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	 }
}
