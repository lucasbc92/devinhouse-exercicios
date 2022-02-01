package com.example.cadastrousuario.servlets;

import com.example.cadastrousuario.models.User;
import com.example.cadastrousuario.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "userServlet", value = "/user-servlet/*")
public class UserServlet extends HttpServlet {

    private UserRepository userRepository;

    public void init(){
        userRepository = UserRepository.getRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        List<User> users = userRepository.getAllUsers();
        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(users);
        writer.append(response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = readBody(req);
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(body, User.class);
        user = userRepository.create(user);

        PrintWriter writer = resp.getWriter();
        String response = mapper.writeValueAsString(user);
        writer.append(response);

        resp.setStatus(201);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = readBody(req);
        String[] params = req.getPathInfo().split("/");
        int id = Integer.parseInt(params[1]);
        ObjectMapper mapper = new ObjectMapper();
        User updatedUser = mapper.readValue(body, User.class);
        User user = userRepository.update(id, updatedUser);

        PrintWriter writer = resp.getWriter();
        String response = mapper.writeValueAsString(user);
        writer.append(response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] params = req.getPathInfo().split("/");
        int id = Integer.parseInt(params[1]);
        userRepository.remove(id);
        resp.setStatus(204);
    }

    private String readBody(HttpServletRequest req) throws IOException{
        return req.getReader().lines().collect(Collectors.joining());
    }
}
