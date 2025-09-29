package com.lucasmiranda.workshopmongodb.dto;

import com.lucasmiranda.workshopmongodb.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable{

    private String id;

    private String email;

    private String name;

    public UserDTO(User obj){
        this.id = obj.getId();
        this.email = obj.getEmail();
        this.name = obj.getName();
    }

}
