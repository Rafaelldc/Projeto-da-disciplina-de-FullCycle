package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.entites.User;
import br.com.primeshoes.api.dtos.UserDTO;

public class UserMapper {
    public static UserDTO toDTO(User user){
        return new UserDTO(user.getName(), user.getEmail(), user.getPassword());
    }

    public static User toEntity(UserDTO userDTO){
        
        User user = new User();
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        return user;

    }
}
