package fiap.challenge.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fiap.challenge.JwtTokenUtil;
import fiap.challenge.models.JwtRequest;
import fiap.challenge.models.JwtResponse;
import fiap.challenge.models.UserDTO;
import fiap.challenge.models.UsuarioPacienteModel;
import fiap.challenge.service.JwtUserDetailsService;


@RestController
@CrossOrigin
public class AutenticarPaciente {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		Map<String,String> dados = new HashMap<String,String>();
		new JwtResponse(token);
		dados.put("token", token);
		
		UsuarioPacienteModel dataUser = userDetailsService.dadosUsuario(Long.parseLong(userDetails.getUsername()));
		
		dados.put("id", Long.toString(dataUser.getId()));
		dados.put("username", dataUser.getUsername());
		dados.put("nome", dataUser.getNome());
		dados.put("sobrenome", dataUser.getSobrenome());
		dados.put("cpf", dataUser.getCpf());
		
		return ResponseEntity.ok(dados);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		UsuarioPacienteModel novoUser = userDetailsService.save(user);
		UserDetails userDetails = userDetailsService
				.loadUserByUsername(user.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		Map<String,Object> dados = new HashMap<String,Object>();
		new JwtResponse(token);
		
		dados.put( "token", token);
		dados.put( "id", novoUser.getId());
		dados.put( "username", novoUser.getUsername());
		dados.put( "nome", novoUser.getNome());
		dados.put( "sobrenome", novoUser.getSobrenome());
		dados.put( "cpf", novoUser.getCpf());
		
		return ResponseEntity.ok(dados);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@GetMapping(path="/auth/{codigo}")
    public ResponseEntity<?> dadosUsuario(@PathVariable("codigo") Long codigo) {
		return ResponseEntity.ok(userDetailsService.dadosUsuario(codigo));
    }
}
