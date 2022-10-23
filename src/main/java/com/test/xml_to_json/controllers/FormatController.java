/*
 * Copyright (c) 2022.
 * This code was originally developed 23.10.2022, 15:22 by Valkov V.V
 */

package com.test.xml_to_json.controllers;

import com.test.xml_to_json.dto.PropertyListDTO;
import com.test.xml_to_json.service.XmlParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formatXml")
public class FormatController {
    @Autowired
    private XmlParserService xmlParserService;

    /**
     * Метод получает на вход xml и возвращает Json из xml
     * @param listValues список числовых значение
     * @return json с xml
     * @throws Exception исключение
     */
    @GetMapping("/getJson")
    public ResponseEntity<Object> getJsonFromXml(@RequestParam("listValues") List<Integer> listValues) throws Exception {
        String xmlString ="<?xml version=\"1.0\" encoding=\"UTF-8\"?> <PropertyList> <Property> <Name>CommandTimeout</Name><Value>60</Value><Description>Setting the timeout(in seconds)</Description><DefaultValue></DefaultValue></Property><Property><Name>Address</Name><Value>0.0.0.0</Value><Description>ip:port</Description><DefaultValue></DefaultValue></Property> </PropertyList>";
        PropertyListDTO propertyListDTO = xmlParserService.parseXml(xmlString);
        return ResponseEntity.ok(propertyListDTO.getPropertyList());
    }
}
