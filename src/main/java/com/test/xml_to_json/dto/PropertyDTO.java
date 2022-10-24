/*
 * Copyright (c) 2022.
 * This code was originally developed 23.10.2022, 15:26 by Valkov V.V
 */

package com.test.xml_to_json.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Поля свойств
 */
public class PropertyDTO {
    @JacksonXmlProperty(localName = "Name")
    private String name;
    @JacksonXmlProperty(localName = "Value")
    private String value;
    @JacksonXmlProperty(localName = "Description")
    private String description;
    @JacksonXmlProperty(localName = "DefaultValue")
    private Integer defaultValue;

    /**
     * Конструкторы
     */
    public PropertyDTO() {
    }

    public PropertyDTO(String name, String value, String description, Integer defaultValue) {
        this.name = name;
        this.value = value;
        this.description = description;
        this.defaultValue = defaultValue;
    }

    /**
     * Геттеры и сеттеры
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Integer defaultValue) {
        this.defaultValue = defaultValue;
    }
}
