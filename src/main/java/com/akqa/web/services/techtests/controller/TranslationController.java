package com.akqa.web.services.techtests.controller;

import com.akqa.web.services.techtests.constants.RequestConstants;
import com.akqa.web.services.techtests.models.TranslateResponse;
import com.akqa.web.services.techtests.service.TranslateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslationController {
    
    @Autowired
    private TranslateService translateService;
    
    @RequestMapping("/translate")
    @CrossOrigin(origins = "http://localhost:3000")
    public TranslateResponse translate(@RequestParam(value = RequestConstants.NAME_PARAMETER, required = true) String name,
            @RequestParam(value = RequestConstants.AMOUNT_PARAMETER, required = true) String amount) {
        TranslateResponse response = new TranslateResponse();
        response.setName(name);
        response.setAmount(translateService.getTranslatedAmountToWords(Integer.parseInt(amount)));
        return response;
    }
}
