/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/16/2016
 */
package com.inchbase.pinch.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Unit 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5430134276987619693L;
    private String floorNumber;
    private String frenchFloorNumber;
    private String kind;
    private String reference;
    private String tenantName;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("floor_number")
    public String getFloorNumber ( ) { 
        return this.floorNumber;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("floor_number")
    private void setFloorNumber (String value) { 
        this.floorNumber = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("french_floor_number")
    public String getFrenchFloorNumber ( ) { 
        return this.frenchFloorNumber;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("french_floor_number")
    private void setFrenchFloorNumber (String value) { 
        this.frenchFloorNumber = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("kind")
    public String getKind ( ) { 
        return this.kind;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("kind")
    private void setKind (String value) { 
        this.kind = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("reference")
    public String getReference ( ) { 
        return this.reference;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("reference")
    private void setReference (String value) { 
        this.reference = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("tenant_name")
    public String getTenantName ( ) { 
        return this.tenantName;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("tenant_name")
    private void setTenantName (String value) { 
        this.tenantName = value;
    }
 
}
 