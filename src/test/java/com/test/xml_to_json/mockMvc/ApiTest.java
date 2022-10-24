/*
 * Copyright (c) 2022.
 * This code was originally developed 23.10.2022, 21:55 by Valkov V.V
 */

package com.test.xml_to_json.mockMvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ApiTest {
    @Autowired
    MockMvc mockMvc;

    /**
     * Проверка содержимого properties с параметром списка с двумя элементами
     *
     * @throws Exception искключение
     */
    @Test
    public void checkApiPropertiesWithTwoParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/formatXml/getJson").content("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                "<PropertyList>\n" +
                                "    <Property>\n" +
                                "        <Name>CommandTimeout</Name>\n" +
                                "        <Value>60</Value>\n" +
                                "        <Description>Setting the timeout(in seconds)</Description>\n" +
                                "        <DefaultValue>\n" +
                                "        </DefaultValue>\n" +
                                "    </Property>\n" +
                                "    <Property>\n" +
                                "        <Name>Address</Name>\n" +
                                "        <Value>0.0.0.0</Value>\n" +
                                "        <Description>ip:port</Description>\n" +
                                "        <DefaultValue></DefaultValue>\n" +
                                "    </Property>\n" +
                                "</PropertyList>")
                .param("listValues", "12,25")
                .contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0]", hasKey("name")))
                .andExpect(jsonPath("$[0].name", isA(String.class)))
                .andExpect(jsonPath("$[0].name", is("CommandTimeout")))
                .andExpect(jsonPath("$[0]", hasKey("value")))
                .andExpect(jsonPath("$[0].value", isA(String.class)))
                .andExpect(jsonPath("$[0].value", is("60")))
                .andExpect(jsonPath("$[0]", hasKey("description")))
                .andExpect(jsonPath("$[0].description", isA(String.class)))
                .andExpect(jsonPath("$[0].description", is("Setting the timeout(in seconds)")))
                .andExpect(jsonPath("$[0]", hasKey("defaultValue")))
                .andExpect(jsonPath("$[0].defaultValue", isA(Integer.class)))
                .andExpect(jsonPath("$[0].defaultValue", is(12)))
                .andExpect(jsonPath("$[1]", hasKey("name")))
                .andExpect(jsonPath("$[1].name", isA(String.class)))
                .andExpect(jsonPath("$[1].name", is("Address")))
                .andExpect(jsonPath("$[1]", hasKey("value")))
                .andExpect(jsonPath("$[1].value", isA(String.class)))
                .andExpect(jsonPath("$[1].value", is("0.0.0.0")))
                .andExpect(jsonPath("$[1]", hasKey("description")))
                .andExpect(jsonPath("$[1].description", isA(String.class)))
                .andExpect(jsonPath("$[1].description", is("ip:port")))
                .andExpect(jsonPath("$[1]", hasKey("defaultValue")))
                .andExpect(jsonPath("$[1].defaultValue", isA(Integer.class)))
                .andExpect(jsonPath("$[1].defaultValue", is(25)));
    }

    /**
     * Проверка содержимого properties с параметром списка с одним элементом
     *
     * @throws Exception исключение
     */
    @Test
    public void checkApiPropertiesWithOneParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/formatXml/getJson").content("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                "<PropertyList>\n" +
                                "    <Property>\n" +
                                "        <Name>CommandTimeout</Name>\n" +
                                "        <Value>60</Value>\n" +
                                "        <Description>Setting the timeout(in seconds)</Description>\n" +
                                "        <DefaultValue>\n" +
                                "        </DefaultValue>\n" +
                                "    </Property>\n" +
                                "    <Property>\n" +
                                "        <Name>Address</Name>\n" +
                                "        <Value>0.0.0.0</Value>\n" +
                                "        <Description>ip:port</Description>\n" +
                                "        <DefaultValue></DefaultValue>\n" +
                                "    </Property>\n" +
                                "</PropertyList>")
                .param("listValues", "12")
                .contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0]", hasKey("name")))
                .andExpect(jsonPath("$[0].name", isA(String.class)))
                .andExpect(jsonPath("$[0].name", is("CommandTimeout")))
                .andExpect(jsonPath("$[0]", hasKey("value")))
                .andExpect(jsonPath("$[0].value", isA(String.class)))
                .andExpect(jsonPath("$[0].value", is("60")))
                .andExpect(jsonPath("$[0]", hasKey("description")))
                .andExpect(jsonPath("$[0].description", isA(String.class)))
                .andExpect(jsonPath("$[0].description", is("Setting the timeout(in seconds)")))
                .andExpect(jsonPath("$[0]", hasKey("defaultValue")))
                .andExpect(jsonPath("$[0].defaultValue", isA(Integer.class)))
                .andExpect(jsonPath("$[0].defaultValue", is(12)))
                .andExpect(jsonPath("$[1]", hasKey("name")))
                .andExpect(jsonPath("$[1].name", isA(String.class)))
                .andExpect(jsonPath("$[1].name", is("Address")))
                .andExpect(jsonPath("$[1]", hasKey("value")))
                .andExpect(jsonPath("$[1].value", isA(String.class)))
                .andExpect(jsonPath("$[1].value", is("0.0.0.0")))
                .andExpect(jsonPath("$[1]", hasKey("description")))
                .andExpect(jsonPath("$[1].description", isA(String.class)))
                .andExpect(jsonPath("$[1].description", is("ip:port")))
                .andExpect(jsonPath("$[1]", hasKey("defaultValue")))
                .andExpect(jsonPath("$[1].defaultValue", nullValue()));
    }

    /**
     * Проверка содержимого properties с параметром списка без элементов
     *
     * @throws Exception исключение
     */
    @Test
    public void checkApiPropertiesWithoutParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/formatXml/getJson").content("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                "<PropertyList>\n" +
                                "    <Property>\n" +
                                "        <Name>CommandTimeout</Name>\n" +
                                "        <Value>60</Value>\n" +
                                "        <Description>Setting the timeout(in seconds)</Description>\n" +
                                "        <DefaultValue>\n" +
                                "        </DefaultValue>\n" +
                                "    </Property>\n" +
                                "    <Property>\n" +
                                "        <Name>Address</Name>\n" +
                                "        <Value>0.0.0.0</Value>\n" +
                                "        <Description>ip:port</Description>\n" +
                                "        <DefaultValue></DefaultValue>\n" +
                                "    </Property>\n" +
                                "</PropertyList>")
                .param("listValues", "")
                .contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0]", hasKey("name")))
                .andExpect(jsonPath("$[0].name", isA(String.class)))
                .andExpect(jsonPath("$[0].name", is("CommandTimeout")))
                .andExpect(jsonPath("$[0]", hasKey("value")))
                .andExpect(jsonPath("$[0].value", isA(String.class)))
                .andExpect(jsonPath("$[0].value", is("60")))
                .andExpect(jsonPath("$[0]", hasKey("description")))
                .andExpect(jsonPath("$[0].description", isA(String.class)))
                .andExpect(jsonPath("$[0].description", is("Setting the timeout(in seconds)")))
                .andExpect(jsonPath("$[0]", hasKey("defaultValue")))
                .andExpect(jsonPath("$[0].defaultValue", nullValue()))
                .andExpect(jsonPath("$[1]", hasKey("name")))
                .andExpect(jsonPath("$[1].name", isA(String.class)))
                .andExpect(jsonPath("$[1].name", is("Address")))
                .andExpect(jsonPath("$[1]", hasKey("value")))
                .andExpect(jsonPath("$[1].value", isA(String.class)))
                .andExpect(jsonPath("$[1].value", is("0.0.0.0")))
                .andExpect(jsonPath("$[1]", hasKey("description")))
                .andExpect(jsonPath("$[1].description", isA(String.class)))
                .andExpect(jsonPath("$[1].description", is("ip:port")))
                .andExpect(jsonPath("$[1]", hasKey("defaultValue")))
                .andExpect(jsonPath("$[1].defaultValue", nullValue()));
    }
}
