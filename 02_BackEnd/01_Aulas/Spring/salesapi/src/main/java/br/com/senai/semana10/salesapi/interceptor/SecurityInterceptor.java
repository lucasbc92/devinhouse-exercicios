package br.com.senai.semana10.salesapi.interceptor;

import br.com.senai.semana10.salesapi.model.User.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

        User loggedUser = authService.tryToAuthenticate(authentication);

        if(loggedUser == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        else {
            request.setAttribute("loggedUser", loggedUser);
        }
        return true;
    }
}
