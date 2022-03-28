package com.qadev.automation.createUser;

import com.qadev.automation.TestApplicationConfiguration;
import com.qadev.automation.builder.UserBuilder;
import com.qadev.automation.entity.User;
import com.qadev.automation.restClient.PetStoreRestClient;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.util.Assert;

@SpringBootTest()
@SpringJUnitConfig(TestApplicationConfiguration.class)
@Feature("Pet store: Create User")
public class CreateUserTest {

    @Autowired
    PetStoreRestClient petStoreRestClient;

    @Test
    @Description("Create and retrieve user information")
    public void createAndRetrieveUser(){
        //Create a new user
        User user = new UserBuilder().randomValues().build();
        petStoreRestClient.createUser(user);

        // Retrieve User Information
        User userFromApi = petStoreRestClient.getUser(user.getUsername());
        Assert.isTrue(user.equals(userFromApi),
                "Some of the user information retrieved is not correct. " +
                        "Expected User data:" + user.toString() +
                        "\n Actual User data: "+ userFromApi.toString());
    }

}
