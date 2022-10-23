/*
 * Copyright (c) 2022.
 * This code was originally developed 23.10.2022, 15:22 by Valkov V.V
 */

package com.test.xml_to_json.controllers;

import com.test.xml_to_json.dto.PropertyDTO;
import com.test.xml_to_json.dto.PropertyListDTO;
import com.test.xml_to_json.service.XmlParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/api/formatXml")
public class FormatController {
    private final Logger logger = LoggerFactory.getLogger(FormatController.class);
    @Autowired
    private XmlParserService xmlParserService;

    /**
     * Метод получает на вход xml и возвращает Json из xml
     * @param propertyListDTO xml файл
     * @param listValues список значений
     * @return json файл из xml
     * @throws Exception исключение
     */
    @GetMapping(path="/getJson", consumes = APPLICATION_XML_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getJsonFromXml(@RequestBody PropertyListDTO propertyListDTO, @RequestParam("listValues") List<Integer> listValues) throws Exception {
        List<PropertyDTO> propertyListFinal = xmlParserService.getFinalJsonFromXml(propertyListDTO, listValues);
        logger.debug("/api/formatXml/getJson is Successful!");
        return ResponseEntity.ok(propertyListFinal);
    }
}
