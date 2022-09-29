package com.youtap.integration;

import dto.User;
import dto.request.UserRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
public class UserIT {

    private RestTemplate restTemplate;

    @BeforeEach
    void setup(){
        restTemplate = new RestTemplate();
    }

    @Test
    void givenUserRequestWithIdAndUserName_when_retrievingUser_shouldReturnSuccess() {

        UserRequest userRequest = new UserRequest();
        userRequest.setUserId(2);
        userRequest.setUserName("Antonette");

        String url = "https://jsonplaceholder.typicode.com/users?" + "id=" + userRequest.getUserId() + "&username=" + userRequest.getUserName();

        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,new ParameterizedTypeReference<List<User>>() {});

        List<User> userResponse = responseEntity.getBody();

        assert userResponse != null;
        Assertions.assertThat(userResponse).isNotNull();
    }
}
