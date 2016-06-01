/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 06/01/2016
 */
package com.inchbase.pinch.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Document 
        implements java.io.Serializable {
    private static final long serialVersionUID = 4885264104382490537L;
    private int id;
    private String name;
    private String thumbUrl;
    private String url;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("id")
    public int getId ( ) { 
        return this.id;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("id")
    private void setId (int value) { 
        this.id = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("name")
    public String getName ( ) { 
        return this.name;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("name")
    public void setName (String value) { 
        this.name = value;
    }
 
    /** GETTER
     * If possible, a thumbnail of the document
     */
    @JsonGetter("thumb_url")
    public String getThumbUrl ( ) { 
        return this.thumbUrl;
    }
    
    /** SETTER
     * If possible, a thumbnail of the document
     */
    @JsonSetter("thumb_url")
    private void setThumbUrl (String value) { 
        this.thumbUrl = value;
    }
 
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
 