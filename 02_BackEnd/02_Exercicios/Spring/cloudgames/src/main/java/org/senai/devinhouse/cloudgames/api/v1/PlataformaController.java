package org.senai.devinhouse.cloudgames.api.v1;

import org.senai.devinhouse.cloudgames.model.Plataforma;
import org.senai.devinhouse.cloudgames.repository.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plataforma")
public class PlataformaController {

    @Autowired
    private PlataformaRepository repository;

    @GetMapping
    public List<Plataforma> getAll() {
        List<Plataforma> result = new ArrayList<>();

        Iterable<Plataforma> plataformaEntityIterable = repository.findAll();
        Iterator<Plataforma> iterator = plataformaEntityIterable.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        return result;
    }

    @PostMapping
    public ResponseEntity<Long> post(@RequestBody Plataforma plataforma) {
        plataforma = repository.save(plataforma);
        return new ResponseEntity<>(plataforma.getId(), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchNome(@PathVariable Long id,
                                         @RequestBody String nome) {
        Optional<Plataforma> optionalPlataforma = repository.findById(id);
        if (optionalPlataforma.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Plataforma plataformaEntity = optionalPlataforma.get();
        plataformaEntity.setNome(nome);
        repository.save(plataformaEntity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable Long id,
                                    @RequestBody Plataforma plataforma) {
        Optional<Plataforma> optionalPlataforma = repository.findById(id);
        if (optionalPlataforma.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!id.equals(plataforma.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        repository.save(plataforma);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Plataforma> optionalPlataforma = repository.findById(id);
        if (optionalPlataforma.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.delete(optionalPlataforma.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
