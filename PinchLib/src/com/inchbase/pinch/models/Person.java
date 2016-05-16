/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/16/2016
 */
package com.inchbase.pinch.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Person 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5283180251279869629L;
    private String firstname;
    private String homePhoneNumber;
    private String lastname;
    private String mobilePhoneNumber;
    private String role;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("firstname")
    public String getFirstname ( ) { 
        return this.firstname;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("firstname")
    private void setFirstname (String value) { 
        this.firstname = value;
    }
 
    /** GETTER
     * The landline phone number of the resident or manager
     */
    @JsonGetter("home_phone_number")
    public String getHomePhoneNumber ( ) { 
        return this.homePhoneNumber;
    }
    
    /** SETTER
     * The landline phone number of the resident or manager
     */
    @JsonSetter("home_phone_number")
    private void setHomePhoneNumber (String value) { 
        this.homePhoneNumber = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("lastname")
    public String getLastname ( ) { 
        return this.lastname;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("lastname")
    private void setLastname (String value) { 
        this.lastname = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("mobile_phone_number")
    public String getMobilePhoneNumber ( ) { 
        return this.mobilePhoneNumber;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("mobile_phone_number")
    private void setMobilePhoneNumber (String value) { 
        this.mobilePhoneNumber = value;
    }
 
    /** GETTER
     * Caretaker, Resident, Manager, ThirdParty
     */
    @JsonGetter("role")
    public String getRole ( ) { 
        return this.role;
    }
    
    /** SETTER
     * Caretaker, Resident, Manager, ThirdParty
     */
    @JsonSetter("role")
    private void setRole (String value) { 
        this.role = value;
    }
 
}
 