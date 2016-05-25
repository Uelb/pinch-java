/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/25/2016
 */
package com.inchbase.pinch.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Document 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5135481659970607443L;
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
 