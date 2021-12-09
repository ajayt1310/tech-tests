package com.akqa.web.services.techtests.service;

import org.springframework.stereotype.Service;

@Service
public class TranslateServiceImpl implements TranslateService {

    private static final String[] UNITS = { "", " one", " two", " three", " four", " five", " six", " seven", " eight",
            " nine" };
    private static final String[] DOUBLES = { " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen",
            " sixteen", " seventeen", " eighteen", " nineteen" };
    private static final String[] TENS = { "", "", " twenty", " thirty", " forty", " fifty", " sixty", " seventy",
            " eighty", " ninety" };
    private static final String[] HUNDREDS = { "", " thousand", " million", " billion" };

    private static String convertToWord(int number) {
        String word = "";
        int index = 0;
        
        // special handling for 0
        if (number == 0) {
            word = "zero";
        } else {
            do {
                // take 3 digits at a time
                int num = number % 1000;
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
    
    @Override
    public String getTranslatedAmountToWords(int amount) {
        return convertToWord(amount);
    }
}
