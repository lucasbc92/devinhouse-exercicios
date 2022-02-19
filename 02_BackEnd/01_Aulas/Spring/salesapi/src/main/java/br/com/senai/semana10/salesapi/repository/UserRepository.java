package br.com.senai.semana10.salesapi.repository;

import br.com.senai.semana10.salesapi.model.User.User;
import br.com.senai.semana10.salesapi.parameter.UserPostParameter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private Integer lastId = 0;
    private List<User> repository = new ArrayList<>();

    public UserRepository() {
        User firstUser = new User(lastId, "Admin", "admin@admin.com", "admin", "123456", 18);
        repository.add(firstUser);
        lastId++;
    }

    public Integer insert(UserPostParameter userPostParameter) {
        User user = new User(lastId, userPostParameter);
        repository.add(user);
        lastId++;
        return user.getId();
    }

    public List<User> findAll() {
        return repository;
    }

    public List<User> findByNameLike(String nome) {
        if (nome == null) {
            return repository;
        }
        List<User> retorno = new ArrayList<>();
        for (User user : repository) {
            if (user.getNome().contains(nome))
                retorno.add(user);
        }
        return retorno;
    }

    public User findById(Integer userId) {
        for (User user : repository) {
            if (user.getId() == userId)
                return user;
        }
        return null;
    }

    public Integer update(Integer userId,
                          UserPostParameter userPostParameter) {
        User user = findById(userId);
        if (user == null)
            return null;

        user.setEmail(userPostParameter.getEmail());
        user.setNome(userPostParameter.getNome());
        user.setLogin(userPostParameter.getLogin());
        user.setSenha(userPostParameter.getSenha());
        user.setIdade(userPostParameter.getIdade());
        return userId;
    }

    public Integer updateDoPatch(Integer userId,
                                 UserPostParameter userPostParameter) {
        User user = findById(userId);
        if (user == null)
            return null;

        if (userPostParameter.getEmail() != null)
            user.setEmail(userPostParameter.getEmail());
        if (userPostParameter.getNome() != null)
            user.setNome(userPostParameter.getNome());
        if(userPostParameter.getLogin() != null)
            user.setLogin(userPostParameter.getLogin());
        if (userPostParameter.getSenha() != null)
            user.setSenha(userPostParameter.getSenha());
        if (userPostParameter.getIdade() != null)
            user.setIdade(userPostParameter.getIdade());
        return userId;
    }

    public Integer updatePassword(Integer userId, String password) {
        User user = findById(userId);
        if (user == null)
            return null;

        user.setSenha(password);

        return userId;
    }

    public User findByLoginAndPassword(String username, String password) {
        for (User user : repository) {
            if (user.getLogin().equals(username) && user.getSenha().equals(password))
                return user;
        }
        return null;
    }
}
