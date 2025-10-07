package com.lucasmiranda.workshopmongodb.services;

import com.lucasmiranda.workshopmongodb.domain.User;
import com.lucasmiranda.workshopmongodb.dto.UserDTO;
import com.lucasmiranda.workshopmongodb.repository.UserRepository;
import com.lucasmiranda.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(),objDTO.getName(), objDTO.getEmail());
    }



    public User update(User obj){
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public void deleteById(String id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
