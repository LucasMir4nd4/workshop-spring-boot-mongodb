package com.lucasmiranda.workshopmongodb.resources;

import com.lucasmiranda.workshopmongodb.domain.User;
import com.sun.source.tree.NewArrayTree;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserResources {

    @GetMapping
    public ResponseEntity <List<User>> findAll(){
        User maria = new User("1", "Maria", "maria@gmail.com");
        User lucas = new User("2", "Lucas", "lucas@gmail.com");
        List<User> list = new ArrayList<>(Arrays.asList(maria, lucas));
        return ResponseEntity.ok().body(list);
    }
}
