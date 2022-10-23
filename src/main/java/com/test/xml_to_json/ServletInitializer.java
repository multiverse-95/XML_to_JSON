/*
 * Copyright (c) 2022.
 * This code was originally developed 23.10.2022, 15:21 by Valkov V.V
 */

package com.test.xml_to_json;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(XmlToJsonApplication.class);
    }

}
