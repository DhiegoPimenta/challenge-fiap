package fiap.challenge.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fiap.challenge.models.UserDTO;
import fiap.challenge.models.UsuarioPacienteModel;
import fiap.challenge.repositories.IUsuarioRepository;



@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUsuarioRepository iUsuarioRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioPacienteModel user = iUsuarioRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(Long.toString(user.getId()), user.getPassword(),
				new ArrayList<>());
	}
	

	public UserDetails loadById(Long id) throws UsernameNotFoundException {
		UsuarioPacienteModel user = iUsuarioRepository.findAllById(id);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: ");
		}
		return new org.springframework.security.core.userdetails.User(Long.toString(user.getId()), user.getPassword(),
				new ArrayList<>());
	}
	
	public UsuarioPacienteModel save(UserDTO user) {
		UsuarioPacienteModel newUser = new UsuarioPacienteModel();
		newUser.setUsername(user.getUsername());
		newUser.setCpf(user.getCpf());
		newUser.setNome(user.getNome());
		newUser.setSobrenome(user.getSobrenome());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return iUsuarioRepository.save(newUser);
	}
	
	public UsuarioPacienteModel dadosUsuario(Long id) {
		return iUsuarioRepository.findAllById(id);
	}
}