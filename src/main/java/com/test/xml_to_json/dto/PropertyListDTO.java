/*
 * Copyright (c) 2022.
 * This code was originally developed 23.10.2022, 15:39 by Valkov V.V
 */

package com.test.xml_to_json.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
/**
 * Список свойств
 */
public class PropertyListDTO {
    @JacksonXmlProperty(localName = "Property")
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PropertyDTO> propertyList;

    /**
     * Конструкторы
     */
    public PropertyListDTO() {
    }

    public PropertyListDTO(List<PropertyDTO> propertyList) {
        this.propertyList = propertyList;
    }

    /**
     * Геттеры и сеттеры
     */
    public List<PropertyDTO> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<PropertyDTO> propertyList) {
        this.propertyList = propertyList;
    }
}
