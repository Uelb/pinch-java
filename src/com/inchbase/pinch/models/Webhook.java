/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/25/2016
 */
package com.inchbase.pinch.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Webhook 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5609823176672584215L;
    private int id;
    private String url;
    private int webhookType;
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
    @JsonGetter("url")
    public String getUrl ( ) { 
        return this.url;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("url")
    public void setUrl (String value) { 
        this.url = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("webhook_type")
    public int getWebhookType ( ) { 
        return this.webhookType;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("webhook_type")
    public void setWebhookType (int value) { 
        this.webhookType = value;
    }
 
}
 