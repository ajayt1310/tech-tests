package com.akqa.web.services.techtests.service;

import com.akqa.web.services.techtests.models.TranslateResponse;

/**
 * The Interface TranslateService.
 * 
 * @author ajay.tiwari
 */
public interface TranslateService {
    
    /**
     * Gets the translated amount to words.
     *
     * @param amount the amount
     * @return the translated amount to words
     */
    public String getTranslatedAmountToWords(long amount);
    
    /**
     * Gets the formatted name.
     *
     * @param name the name
     * @return the formatted name
     */
    public String getFormattedName(String name);
    
    
    /**
     * Perform translation for provided name and amount.
     *
     * @param name the name
     * @param amount the amount
     * @return the translate response
     */
    public TranslateResponse performTranslation(String name, long amount);

}
