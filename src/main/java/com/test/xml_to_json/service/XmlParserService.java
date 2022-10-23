/*
 * Copyright (c) 2022.
 * This code was originally developed 23.10.2022, 15:25 by Valkov V.V
 */

package com.test.xml_to_json.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.test.xml_to_json.dto.PropertyListDTO;
import org.springframework.stereotype.Service;

@Service
/**
 * Класс для парсинга xml
 */
public class XmlParserService {

    /**
     * Парсит xml файл в json
     * @param xmlString xml строка
     * @throws JsonProcessingException исключение
     */
    public PropertyListDTO parseXml(String xmlString) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        PropertyListDTO propertyList;
        try {
            propertyList = xmlMapper.readValue(xmlString, PropertyListDTO.class);
            return  propertyList;
        } catch (Exception e){
            e.getStackTrace();
            throw new Exception("Error with Xml");
        }
    }
}
