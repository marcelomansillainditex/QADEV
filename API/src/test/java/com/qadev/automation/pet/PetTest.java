package com.qadev.automation.pet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qadev.automation.TestApplicationConfiguration;
import com.qadev.automation.entity.Pet;
import com.qadev.automation.restClient.PetStoreRestClient;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest()
@SpringJUnitConfig(TestApplicationConfiguration.class)
@Feature("Pet store: Pet's information")
public class PetTest {

    @Autowired
    PetStoreRestClient petStoreRestClient;

    @Test
    @Description("Names of pets that have been sold")
    public void namesOfPetsThatHaveBeenSold(){
        List<String> petStatus = new ArrayList<>();
        petStatus.add("sold");
        List<Pet> petsByStatus = petStoreRestClient.findByStatus(petStatus);
        Assert.isTrue(petsByStatus.size() > 0,"There are not pets with status sold");
        petsByStatus.stream().forEach(System.out::println);

    }

    @Test
    @Description("Names of pets")
    public void namesOfPets() throws JsonProcessingException {
        List<String> petStatus = new ArrayList<>();
        petStatus.add("available");
        petStatus.add("pending");
        petStatus.add("sold");

        List<Pet> pets = petStoreRestClient.findByStatus(petStatus);
        Assert.isTrue(pets.size() > 0,"There are not pets in the store");

        Map<String, Long> countMap = pets.stream().collect(Collectors.groupingBy(Pet::getName, Collectors.counting()));
        String json = new ObjectMapper().writeValueAsString(countMap);
        System.out.println(json);
    }

}
