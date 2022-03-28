package com.qadev.automation.builder;

import com.github.javafaker.Faker;
import com.qadev.automation.entity.User;

import java.util.Locale;

public class UserBuilder {

    private User user;
    private Faker faker;

    public User build(){
        return user;
    }

    public UserBuilder randomValues(){
        faker = new Faker(new Locale("es-ES"));

        user = new User();
        user.setId(faker.number().numberBetween(1, 999999999));
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setPhone(faker.phoneNumber().cellPhone());
        user.setEmail(user.getFirstName()+"."+user.getLastName()+"@gmail.com");
        user.setUsername(user.getFirstName()+"."+user.getLastName()+faker.number().numberBetween(10, 99));
        user.setPassword(faker.lorem().characters(8, 16));
        user.setUserStatus(0);

        return this;

    }

}
