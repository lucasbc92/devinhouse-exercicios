package br.com.senai.semana10.salesapi.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/healthz")
public class HealthzController {

    @GetMapping
    public ResponseEntity<String> healthz() {
        return new ResponseEntity<>("Its error", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/status")
    public String healthStatus() {
        return "Status -> All services running";
    }
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name,
                        @RequestParam(required = false) Integer idade) {
        String minhaMensagem = "Seja bem vindo(a) "+name;

        if(idade != null) {
            minhaMensagem+= " você tem "+idade+" anos!";
        }

        return minhaMensagem;
    }

    @PostMapping("/status")
    public String postStatus() {
        return "I'm saving a new status";
    }
}
