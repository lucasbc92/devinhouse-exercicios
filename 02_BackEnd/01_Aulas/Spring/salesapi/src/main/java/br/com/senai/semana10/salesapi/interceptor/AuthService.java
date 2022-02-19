package br.com.senai.semana10.salesapi.interceptor;

import br.com.senai.semana10.salesapi.model.User.User;
import br.com.senai.semana10.salesapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User tryToAuthenticate(String authentication) {
        if (authentication == null)
            return null;
        if (!authentication.startsWith("Basic"))
            return null;
        String credencialBase64 = authentication.substring(("Basic".length())).trim();
        byte[] bytesBase64Decodificados = Base64.getDecoder().decode(credencialBase64);
        String credencials = new String(bytesBase64Decodificados, StandardCharsets.UTF_8);

        String[] split = credencials.split(":");

        String username = split[0];
        String password = split[1];

        return userRepository.findByLoginAndPassword(username, password);
    }
}
