package com.akqa.web.services.techtests.controller;

import com.akqa.web.services.techtests.constants.RequestConstants;
import com.akqa.web.services.techtests.models.TranslateResponse;
import com.akqa.web.services.techtests.service.TranslateService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class TranslationController.
 */
@RestController
public class TranslationController {
    
    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(TranslationController.class);

    /** The translate service. */
    @Autowired
    private TranslateService translateService;

    /**
     * Translate end point.
     *
     * @param name   the name
     * @param amount the amount
     * @return the translate response
     */
    @RequestMapping("/translate")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<TranslateResponse> translate(
            @RequestParam(value = RequestConstants.NAME_PARAMETER, required = false, defaultValue = "") String name,
            @RequestParam(value = RequestConstants.AMOUNT_PARAMETER, required = false, defaultValue = "0") long amount) {
        
        LOG.info("Translate service invoked having name {} and amount {}.", name, amount);
        return ResponseEntity.ok().body(translateService.performTranslation(name, amount));
    }
}
