package com.jastrzab.SDA_CardValidator_App.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class DataServiceControllerRestStaticTest {

    @Mock
    private CardIssuerService cardIssuerService;
    @Mock
    private ChecksumServiece checksumServiece;

    @InjectMocks
    private DataServiceController dataServiceController = new DataServiceController();


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAnalyseCardNumber() {

        // given
        String expectedIssuer = "Visa";
        boolean expectedValidationResult = true;
        final String cardNumber = "222222";

        Mockito.when(cardIssuerService.findIssuer(ArgumentMatchers.anyString()))
                .thenReturn(expectedIssuer);
        Mockito.when(checksumServiece.isChecksumCorrect(ArgumentMatchers.anyString()))
                .thenReturn(expectedValidationResult);
        // when
        ResponseEntity<AnalysisResponse> responseResponseEntity = dataServiceController.getCardAnalysisData(cardNumber);
        AnalysisResponse analysisResponse = responseResponseEntity.getBody();
        // then
        assertEquals(expectedIssuer,analysisResponse.getIssuer());
        assertEquals(expectedValidationResult,analysisResponse.isValidationPassed());

    }
}