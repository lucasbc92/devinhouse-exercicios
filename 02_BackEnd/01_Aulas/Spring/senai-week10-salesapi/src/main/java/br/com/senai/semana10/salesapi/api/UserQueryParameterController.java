package br.com.senai.semana10.salesapi.api;

import br.com.senai.semana10.salesapi.api.UserInterface;
import br.com.senai.semana10.salesapi.api.v1.UsuarioBrasileiro;
import br.com.senai.semana10.salesapi.api.v2.AmericanUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/version/user")
public class UserQueryParameterController {

    @GetMapping
    public ResponseEntity<UserInterface> get(@RequestParam(required = false, defaultValue = "2.0") String version) {
        if(version.equals("1.0")) {
            UsuarioBrasileiro usuarioBrasileiro = new UsuarioBrasileiro("Professor Felipe", "08/02/1991", "felipe", "123456");

            return new ResponseEntity(usuarioBrasileiro, HttpStatus.OK);
        }
        if(version.equals("2.0")) {
            AmericanUser americanUser = new AmericanUser("Professor Felipe", "08/02/1991", "felipe", "123456");
            return new ResponseEntity(americanUser, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/header")
    public ResponseEntity<UserInterface> getVersionedByHeader(@RequestHeader(required = false, defaultValue = "2.0")
                                                                          String version) {
        return get(version);
    }
}
