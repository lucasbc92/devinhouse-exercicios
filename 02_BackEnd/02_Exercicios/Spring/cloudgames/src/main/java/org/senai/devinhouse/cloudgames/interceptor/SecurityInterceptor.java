package org.senai.devinhouse.cloudgames.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.devinhouse.cloudgames.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String authentication = request.getHeader("Authorization");

        Usuario usuarioLogado = authService.tryToAuthenticate(authentication);

        if(usuarioLogado == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        else {
            request.setAttribute("usuarioLogado", usuarioLogado);
        }

        return usuarioLogado != null;
    }
}
