package br.com.senai.semana10.salesapi.api.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/user")
public class UserV2Controller {

    @GetMapping
    public AmericanUser get() {
        return new AmericanUser("Professor Felipe", "08/02/1991", "felipe", "123456");
    }
}
