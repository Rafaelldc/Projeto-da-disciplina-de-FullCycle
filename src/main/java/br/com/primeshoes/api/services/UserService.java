package br.com.primeshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.UserCreatedDTO;
import br.com.primeshoes.api.dtos.UserResponseDTO;
import br.com.primeshoes.api.dtos.UserUpdateDTO;
import br.com.primeshoes.api.entites.User;
import br.com.primeshoes.api.mappers.UserMapper;
import br.com.primeshoes.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserResponseDTO store(UserCreatedDTO userCreatedDTO) {
		
		User user = UserMapper.toEntity(userCreatedDTO);
		
		User userResponse = userRepository.save(user);
		
		return UserMapper.toDTO(userResponse);
	}
	
	public List<UserResponseDTO> list(){
				
		return userRepository.findAll().stream().map(UserMapper::toDTO).toList();
	}
	
	public UserResponseDTO show(long id) {
		
		User user = userRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Usuário com o id "+id+" não foi encontrado.")
		);
			
		return UserMapper.toDTO(user);
	}
	
	public UserResponseDTO update(UserUpdateDTO userUpdateDTO) {
		
		User user = userRepository
				.findById(userUpdateDTO.id())
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado para alteração"));
		
		user.setName(userUpdateDTO.name());
		user.setEmail(userUpdateDTO.email());
		user.setRole(userUpdateDTO.role());
		user.setPassword(userUpdateDTO.password());
				
		
		return UserMapper.toDTO(userRepository.save(user));
	}
	
	public void destroy(long id) {
		
		User user = userRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado para deleção"));
		
		userRepository.delete(user);
		
	}	
}