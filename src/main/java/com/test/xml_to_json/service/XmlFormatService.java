/*
 * Copyright (c) 2022.
 * This code was originally developed 23.10.2022, 15:25 by Valkov V.V
 */

package com.test.xml_to_json.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.test.xml_to_json.dto.PropertyDTO;
import com.test.xml_to_json.dto.PropertyListDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
/**
 * Класс для парсинга xml
 */
public class XmlFormatService {
    private final Logger logger = LoggerFactory.getLogger(XmlFormatService.class);

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
            logger.error("Error with Xml: {}", e.getMessage());
            e.getStackTrace();
            throw new Exception("Error with Xml");
        }
    }

    /**
     * Из списка listValues берет значения и добавляет в defaultValue в итоговый propertyList
     * @param propertyListDTO исходный список PropertyList
     * @param listValues список значений
     * @return propertyListFinal
     */
    public List<PropertyDTO> getFinalJsonFromXml(PropertyListDTO propertyListDTO, List<Integer> listValues) throws Exception {
        List<PropertyDTO> propertyListInput = propertyListDTO.getPropertyList();
        List<PropertyDTO> propertyListOutput = new ArrayList<PropertyDTO>();
        try {
            int sizePropertyList = propertyListInput.size();
            int sizeListValues = listValues.size();
            if (sizePropertyList > sizeListValues){
                int countElementsNull = sizePropertyList - sizeListValues;
                for (int i=0; i<countElementsNull; i++){
                    listValues.add(null);
                }
            }
            for (int i=0; i<sizePropertyList; i++){
                String name = propertyListInput.get(i).getName();
                String value = propertyListInput.get(i).getValue();
                String description = propertyListInput.get(i).getDescription();
                Integer defaultValue = listValues.get(i);
                propertyListOutput.add(new PropertyDTO(name,value,description,defaultValue));
            }
            logger.debug("getFinalJsonFromXml is Success!");
            logger.debug("sizePropertyList is {}",sizePropertyList);
            logger.debug("sizeListValues is {}",sizeListValues);
            return propertyListOutput;
        } catch (Exception e){
            logger.error("Error with format data: {}", e.getMessage());
            e.getStackTrace();
            throw new Exception("Error with format data: "+ e.getMessage());
        }
    }


}
