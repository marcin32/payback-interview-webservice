package com.payback.interview.webservicedemo.controllers;

import com.payback.interview.webservicedemo.WebserviceDemoApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = WebserviceDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class CouponControllerTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void shouldReturnCouponsForValidUser() {

        final ResponseEntity<List> response = restTemplate.getForEntity(getEndpointUrlForPortAndMember("0"), List.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    public void shouldReturnErrorForIllegalParameter() throws Exception {


        final ResponseEntity<String> response = restTemplate.getForEntity(getEndpointUrlForPortAndMember("xyz"), String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    private String getEndpointUrlForPortAndMember(final String memberId) {
        return String.format("http://localhost:%d/GetMemberCoupons/%s", port, memberId);
    }
}
