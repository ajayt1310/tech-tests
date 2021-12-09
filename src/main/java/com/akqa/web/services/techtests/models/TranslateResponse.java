package com.akqa.web.services.techtests.models;

/**
 * The Class TranslateResponse.
 * 
 * @author ajay.tiwari
 */
public class TranslateResponse {
    
    /** The name. */
    private String name;
    
    /** The amount. */
    private long amount;
    
    /** The amount in words. */
    private String amountInWords;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the amount in words.
     *
     * @return the amount in words
     */
    public String getAmountInWords() {
        return amountInWords;
    }

    /**
     * Sets the amount in words.
     *
     * @param amountInWords the new amount in words
     */
    public void setAmountInWords(String amountInWords) {
        this.amountInWords = amountInWords;
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     *
     * @param amount the new amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }
    
    /**
     * Instantiates a new translate response.
     */
    public TranslateResponse() {
       // Default constructor.
    }
}
