package br.com.senai.semana10.salesapi.api;

import br.com.senai.semana10.salesapi.entity.AlunoEntity;
import br.com.senai.semana10.salesapi.repository.AlunoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoEntityRepository repository;

    @GetMapping
    public List<AlunoEntity> getAll() {
        List<AlunoEntity> result = new ArrayList<>();

        Iterable<AlunoEntity> alunoEntityIterable = repository.findAll();
        Iterator<AlunoEntity> iterator = alunoEntityIterable.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        return result;
    }

    @PostMapping
    public ResponseEntity<Long> post(@RequestBody AlunoEntity aluno) {
        aluno = repository.save(aluno);
        return new ResponseEntity<>(aluno.getIdAluno(), HttpStatus.CREATED);
    }

    @PatchMapping("/{idAluno}")
    public ResponseEntity<Void> patchCpf(@PathVariable Long idAluno,
                                         @RequestBody String cpf) {
        Optional<AlunoEntity> optionalAluno = repository.findById(idAluno);
        if (optionalAluno.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        AlunoEntity alunoEntity = optionalAluno.get();
        alunoEntity.setCpf(cpf);
        repository.save(alunoEntity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idAluno}")
    public ResponseEntity<Void> put(@PathVariable Long idAluno,
                                    @RequestBody AlunoEntity aluno) {
        Optional<AlunoEntity> optionalAluno = repository.findById(idAluno);
        if (optionalAluno.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!idAluno.equals(aluno.getIdAluno())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        repository.save(aluno);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{idAluno}")
    public ResponseEntity<Void> delete(@PathVariable Long idAluno) {
        Optional<AlunoEntity> optionalAluno = repository.findById(idAluno);
        if (optionalAluno.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.delete(optionalAluno.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
