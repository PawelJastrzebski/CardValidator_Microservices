package com.jastrzab.SDA_CardValidator_App.api;

import com.jastrzab.SDA_CardValidator_App.domain.model.AnalysisResponse;
import com.jastrzab.SDA_CardValidator_App.domain.model.ChecksumServiceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataServiceControllerTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void shouldValidVisaCard() {

        // given
        final Boolean expectedValidResult = true;
        final String expecterCardIssuer = "Visa";
        String number = "4672902244044968";
        String url = "http://localhost:" + port + "/card/" + number;
        // when
        ResponseEntity<AnalysisResponse> responseEntity = testRestTemplate.getForEntity(url, AnalysisResponse.class);
        AnalysisResponse analysisResponse = responseEntity.getBody();
        // then
        assertEquals(expectedValidResult,analysisResponse.isValidationPassed());
        assertEquals(expecterCardIssuer,analysisResponse.getIssuer());

    }
}