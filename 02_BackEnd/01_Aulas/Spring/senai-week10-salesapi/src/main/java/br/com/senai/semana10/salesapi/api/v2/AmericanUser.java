package br.com.senai.semana10.salesapi.api.v2;

import br.com.senai.semana10.salesapi.api.UserInterface;

public class AmericanUser implements UserInterface {
    private String name;
    private String birthday;
    private String username;
    private String password;

    public AmericanUser(String name, String birthday, String username, String password) {
        this.name = name;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
