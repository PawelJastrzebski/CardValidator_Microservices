package com.jastrzab.SDA_CardValidator_App.api;

import com.jastrzab.SDA_CardValidator_App.domain.model.ChecksumServiceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CardsumValidatorControllerTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    TestRestTemplate testRestTemplate;


    @Test
    public void shouldValidCard() {

        // given
        final Boolean expectedValidResult = true;
        String number = "4956697450905";
        String url = "http://localhost:" + port + "/checksum/" + number;
        // when
        ResponseEntity<ChecksumServiceResponse> responseEntity = testRestTemplate.getForEntity(url, ChecksumServiceResponse.class);
        ChecksumServiceResponse responseEntityBody = responseEntity.getBody();
        // then
        assertEquals(expectedValidResult,responseEntityBody.getIsCorrect());

    }

    @Test
    public void shouldValidCardTest2() {

        // given
        final Boolean expectedValidResult = true;
        String number = "5549066751568682";
        String url = "http://localhost:" + port + "/checksum/" + number;
        // when
        ResponseEntity<ChecksumServiceResponse> responseEntity = testRestTemplate.getForEntity(url, ChecksumServiceResponse.class);
        ChecksumServiceResponse responseEntityBody = responseEntity.getBody();
        // then
        assertEquals(expectedValidResult,responseEntityBody.getIsCorrect());

    }

    @Test
    public void shouldNotValidCard() {

        // given
        final Boolean expectedValidResult = false;
        String number = "4956697450904";
        String url = "http://localhost:" + port + "/checksum/" + number;
        // when
        ResponseEntity<ChecksumServiceResponse> responseEntity = testRestTemplate.getForEntity(url, ChecksumServiceResponse.class);
        ChecksumServiceResponse responseEntityBody = responseEntity.getBody();
        // then
        assertEquals(expectedValidResult,responseEntityBody.getIsCorrect());

    }

    @Test
    public void shouldNotValidCardSwapDigits() {

        // given
        final Boolean expectedValidResult = false;
        String number = "4956697450055";
        String url = "http://localhost:" + port + "/checksum/" + number;
        // when
        ResponseEntity<ChecksumServiceResponse> responseEntity = testRestTemplate.getForEntity(url, ChecksumServiceResponse.class);
        ChecksumServiceResponse responseEntityBody = responseEntity.getBody();
        // then
        assertEquals(expectedValidResult,responseEntityBody.getIsCorrect());

    }
}