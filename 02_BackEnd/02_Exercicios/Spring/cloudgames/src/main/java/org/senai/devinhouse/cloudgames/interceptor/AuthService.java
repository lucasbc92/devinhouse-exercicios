package org.senai.devinhouse.cloudgames.interceptor;

import org.senai.devinhouse.cloudgames.model.Usuario;
import org.senai.devinhouse.cloudgames.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario tryToAuthenticate(String authentication) {
        if (authentication == null)
            return null;
        if (!authentication.startsWith("Basic"))
            return null;
        String credencialBase64 = authentication.substring(("Basic".length())).trim();
        byte[] bytesBase64Decodificados = Base64.getDecoder().decode(credencialBase64);
        String credencials = new String(bytesBase64Decodificados, StandardCharsets.UTF_8);

        String[] split = credencials.split(":");

        String email = split[0];
        String senha = split[1];

        return usuarioRepository.findFirstByEmailAndSenha(email, senha);
    }
}
