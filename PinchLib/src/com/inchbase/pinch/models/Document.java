/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/16/2016
 */
package com.inchbase.pinch.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Document 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5059871658141570220L;
    private String url;
    /** GETTER
     * Where to retrieve the document
     */
    @JsonGetter("url")
    public String getUrl ( ) { 
        return this.url;
    }
    
    /** SETTER
     * Where to retrieve the document
     */
    @JsonSetter("url")
    private void setUrl (String value) { 
        this.url = value;
    }
 
}
 