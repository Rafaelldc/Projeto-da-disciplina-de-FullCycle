package br.com.primeshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.UserDTO;
import br.com.primeshoes.api.entites.User;

import br.com.primeshoes.api.mappers.UserMapper;
import br.com.primeshoes.api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
	 * Save new product
	 * @param product
	 */

    public User store(UserDTO userDTO){
        User user = UserMapper.toEntity(userDTO);
        return userRepository.save(user);
    }

    public List<UserDTO> getAll(){
        return userRepository.findAll().stream().map(UserMapper::toDTO).toList();

    }
}
