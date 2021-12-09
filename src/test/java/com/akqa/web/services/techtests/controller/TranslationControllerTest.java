package com.akqa.web.services.techtests.controller;


import com.akqa.web.services.techtests.models.TranslateResponse;
import com.akqa.web.services.techtests.service.TranslateService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The Class TranslationControllerTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class TranslationControllerTest {
    
    /** The translation controller. */
    @InjectMocks
    TranslationController translationController;
    
    @Mock
    TranslateService translateService;
    
    /**
     * Test perform translation when name and amount provided expect ok response.
     */
    @Test
    public void testperformTranslationWhenNameAndAmountProvidedExpectOkResponse() {
        // When
        ResponseEntity<TranslateResponse> response = translationController.translate("ajay", 100);
        // Then
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
