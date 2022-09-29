package com.youtap.integration;

import dto.UserRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

public class UserIT {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void givenUserRequestWithIdAndUserName_when_retrievingUser_shouldReturnSuccess() {

        UserRequest userRequest = new UserRequest();
        userRequest.setUserId(2);
        userRequest.setUserName("Antonette");

        String uri = "https://jsonplaceholder.typicode.com/users?" + "id=" + userRequest.getUserId() + "&username=" + userRequest.getUserName();

        ResponseEntity<UserResponse> responseEntity = restTemplate.postForEntity(url,
                userRequest, UserResponse.class);
        UserResponse entityBody = responseEntity.getBody();

        Assertions.assertThat(entityBody.getBody()).isNotNull();
    }
}
