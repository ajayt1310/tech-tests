package com.akqa.web.services.techtests.service.impl;

import com.akqa.web.services.techtests.models.TranslateResponse;
import com.akqa.web.services.techtests.service.TranslateService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * The Class TranslateServiceImpl.
 */
@Service
public class TranslateServiceImpl implements TranslateService {
    
    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(TranslateServiceImpl.class);

    /** The Constant UNITS. */
    private static final String[] UNITS = { "", " one", " two", " three", " four", " five", " six", " seven", " eight",
            " nine" };
    
    /** The Constant DOUBLES. */
    private static final String[] DOUBLES = { " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen",
            " sixteen", " seventeen", " eighteen", " nineteen" };
    
    /** The Constant TENS. */
    private static final String[] TENS = { "", "", " twenty", " thirty", " forty", " fifty", " sixty", " seventy",
            " eighty", " ninety" };
    
    /** The Constant HUNDREDS. */
    private static final String[] HUNDREDS = { "", " thousand", " million", " billion" };

    /**
     * Gets the translated amount to words.
     *
     * @param amount the amount
     * @return the translated amount to words
     */
    @Override
    public String getTranslatedAmountToWords(long amount) {
        return convertToWord(amount);
    }

    /**
     * Gets the formatted name.
     *
     * @param name the name
     * @return the formatted name
     */
    @Override
    public String getFormattedName(String name) {
        return StringUtils.capitalize(name);
    }

    /**
     * Perform translation for provided name and amount.
     *
     * @param name the name
     * @param amount the amount
     * @return the translate response
     */
    @Override
    public TranslateResponse performTranslation(String name, long amount) {
        TranslateResponse response = new TranslateResponse();
        if (StringUtils.isNotBlank(name)) {
            response.setName(getFormattedName(name));
            if (amount >= 0) {
                response.setAmount(amount);
                response.setAmountInWords(getTranslatedAmountToWords(amount));
            }
        }
        return response;
    }
    
    /**
     * Convert to word.
     *
     * @param number the number
     * @return the string
     */
    private static String convertToWord(long number) {
        String word = "";
        int index = 0;
        
        // special handling for 0
        if (number == 0) {
            word = "zero";
        } else {
            do {
                // take 3 digits at a time
                int num = (int)number % 1000;
                if (num != 0) {
                    String str = convertThreeOrLessThanThreeDigitNum(num);
                    word = str + HUNDREDS[index] + word;
                }
                index++;
                // move left by 3 digits
                number = number / 1000;
            } while (number > 0);
        }
        return word;
    }

    /**
     * Convert three or less than three digit num.
     *
     * @param number the number
     * @return the string
     */
    private static String convertThreeOrLessThanThreeDigitNum(int number) {
        String word = "";
        int num = number % 100;
        // Logic to take word from appropriate array
        if (num < 10) {
            word = word + UNITS[num];
        } else if (num < 20) {
            word = word + DOUBLES[num % 10];
        } else {
            word = TENS[num / 10] + UNITS[num % 10];
        }
        word = (number / 100 > 0) ? UNITS[number / 100] + " hundred" + word : word;
        return word;
    }
}
