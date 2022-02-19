package br.com.senai.semana10.salesapi.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UsuarioV1Controller {

    @GetMapping
    public UsuarioBrasileiro get() {
        return new UsuarioBrasileiro("Professor Felipe", "08/02/1991", "felipe", "123456");
    }

}
