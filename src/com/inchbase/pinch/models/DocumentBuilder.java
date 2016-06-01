/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 06/01/2016
 */
package com.inchbase.pinch.models;

import java.util.*;

public class DocumentBuilder {
    //the instance to build
    private Document document;

    /**
     * Default constructor to initialize the instance
     */
    public DocumentBuilder() {
        document = new Document();
    }

    public DocumentBuilder name(String name) {
        document.setName(name);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Document build() {
        return document;
    }
}