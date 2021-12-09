package com.akqa.web.services.techtests.service.impl;

import com.akqa.web.services.techtests.models.TranslateResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * The Class TranslateServiceImplTest.
 * 
 * @author ajay.tiwari
 */
@RunWith(MockitoJUnitRunner.class)
public class TranslateServiceImplTest {

    /** The translate service. */
    @InjectMocks
    TranslateServiceImpl translateService;
    
    /**
     * Initialize test data before each test.
     */
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test formatted name when name is provided in lower case expect captitalize name.
     */
    @Test
    public void testFormattedNameWhenNameIsProvidedInLowerCaseExpectCaptitalizeName() {
        // When
        String name = translateService.getFormattedName("ajay");
        // Then
        Assert.assertEquals("Ajay", name);
    }
    
    /**
     * Test translated amount to words when amount provided is expect zero.
     */
    @Test
    public void testTranslatedAmountToWordsWhenAmountProvidedIsExpectZero() {
        // When
        String amoutInWords = translateService.getTranslatedAmountToWords(0);
        // Then
        Assert.assertEquals("zero", amoutInWords);
    }
    
    /**
     * Test translated amount to words when amount provided greater than zero is expect word.
     */
    @Test
    public void testTranslatedAmountToWordsWhenAmountProvidedGreaterThanZeroIsExpectWord() {
        // Then
        Assert.assertEquals(" one", translateService.getTranslatedAmountToWords(1));
        Assert.assertEquals(" ten", translateService.getTranslatedAmountToWords(10));
        Assert.assertEquals(" one hundred", translateService.getTranslatedAmountToWords(100));
        Assert.assertEquals(" one thousand", translateService.getTranslatedAmountToWords(1000));
        Assert.assertEquals(" one hundred thousand", translateService.getTranslatedAmountToWords(100000));
        Assert.assertEquals(" one hundred million", translateService.getTranslatedAmountToWords(100000000));
    }
    
    /**
     * Testperform translation when name not provided expect null.
     */
    @Test
    public void testperformTranslationWhenNameNotProvidedExpectNull() {
        // When
        TranslateResponse response = translateService.performTranslation("", 0);
        // Then
        Assert.assertEquals(null, response.getName());
        Assert.assertEquals(0, response.getAmount());
        Assert.assertEquals(null, response.getAmountInWords());
    }
    
    /**
     * Testperform translation when name and amount provided expect captitalize name and amount.
     */
    @Test
    public void testperformTranslationWhenNameAndAmountProvidedExpectCaptitalizeNameAndAmount() {
        // When
        TranslateResponse response = translateService.performTranslation("ajay", 0);
        // Then
        Assert.assertEquals("Ajay", response.getName());
        Assert.assertEquals(0, response.getAmount());
        Assert.assertEquals("zero", response.getAmountInWords());
    }
    
    /**
     * Testperform translation when name and amount provided expect captitalize name and amount and amoun in words.
     */
    @Test
    public void testperformTranslationWhenNameAndAmountProvidedExpectCaptitalizeNameAndAmountAndAmounInWords() {
        // When
        TranslateResponse response = translateService.performTranslation("ajay", 1000000000);
        // Then
        Assert.assertEquals("Ajay", response.getName());
        Assert.assertEquals(1000000000, response.getAmount());
        Assert.assertEquals(" one billion", response.getAmountInWords());
    }
}
