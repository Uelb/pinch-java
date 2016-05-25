/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/25/2016
 */
package com.inchbase.pinch.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Ticket 
        implements java.io.Serializable {
    private static final long serialVersionUID = 4867228571369146533L;
    private String access;
    private String agency;
    private Building building;
    private List<Person> contacts;
    private String description;
    private List<Document> documents;
    private String id;
    private String manager;
    private String name;
    private String status;
    private Unit unit;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("access")
    public String getAccess ( ) { 
        return this.access;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("access")
    private void setAccess (String value) { 
        this.access = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("agency")
    public String getAgency ( ) { 
        return this.agency;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("agency")
    private void setAgency (String value) { 
        this.agency = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("building")
    public Building getBuilding ( ) { 
        return this.building;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("building")
    private void setBuilding (Building value) { 
        this.building = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("contacts")
    public List<Person> getContacts ( ) { 
        return this.contacts;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("contacts")
    private void setContacts (List<Person> value) { 
        this.contacts = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("description")
    public String getDescription ( ) { 
        return this.description;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("description")
    private void setDescription (String value) { 
        this.description = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("documents")
    public List<Document> getDocuments ( ) { 
        return this.documents;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("documents")
    public void setDocuments (List<Document> value) { 
        this.documents = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("id")
    public String getId ( ) { 
        return this.id;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("id")
    private void setId (String value) { 
        this.id = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("manager")
    public String getManager ( ) { 
        return this.manager;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("manager")
    private void setManager (String value) { 
        this.manager = value;
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
    private void setName (String value) { 
        this.name = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("status")
    public String getStatus ( ) { 
        return this.status;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("status")
    private void setStatus (String value) { 
        this.status = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("unit")
    public Unit getUnit ( ) { 
        return this.unit;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("unit")
    private void setUnit (Unit value) { 
        this.unit = value;
    }
 
}
 