package model;

import org.apache.commons.lang3.RandomStringUtils;

public class UserRequest {
    private String email;
    private String name;
    private String password;


    public UserRequest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }


    public static UserRequest createUser() {

        String name = RandomStringUtils.randomAlphabetic(6);
        String email = RandomStringUtils.randomAlphabetic(8) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(12);

        return new UserRequest(email, name, password);
    }

    public static UserRequest createUserWithWrongPassword() {

        String name = RandomStringUtils.randomAlphabetic(8);
        String email = RandomStringUtils.randomAlphabetic(8) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(4);

        return new UserRequest(email, name, password);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
