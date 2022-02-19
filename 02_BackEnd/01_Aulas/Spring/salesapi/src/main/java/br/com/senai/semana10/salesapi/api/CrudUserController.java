package br.com.senai.semana10.salesapi.api;

import br.com.senai.semana10.salesapi.model.User.User;
import br.com.senai.semana10.salesapi.parameter.UserPostParameter;
import br.com.senai.semana10.salesapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CrudUserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<List> get(@RequestParam(required = false) String nome,
                                    @RequestAttribute("loggedUser") User loggedUser) {
        if (loggedUser.getId() != 0) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity(repository.findByNameLike(nome), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public User getById(@PathVariable Integer userId) {
        return repository.findById(userId);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity put(@PathVariable Integer userId,
                              @RequestBody UserPostParameter userPostParameter) {
        repository.update(userId, userPostParameter);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity patch(@PathVariable Integer userId,
                                @RequestBody UserPostParameter userPostParameter) {
        repository.updateDoPatch(userId, userPostParameter);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{userId}/password")
    public ResponseEntity patchPassword(@PathVariable Integer userId,
                                        @RequestBody String password) {
        repository.updatePassword(userId, password);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody UserPostParameter userPostParameter) {
        Integer userId = repository.insert(userPostParameter);
        return new ResponseEntity(userId, HttpStatus.CREATED);
    }

}
