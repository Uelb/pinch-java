/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/16/2016
 */
package com.inchbase.pinch.models;

import java.util.*;

public class TicketBuilder {
    //the instance to build
    private Ticket ticket;

    /**
     * Default constructor to initialize the instance
     */
    public TicketBuilder() {
        ticket = new Ticket();
    }

    public TicketBuilder documents(List<Document> documents) {
        ticket.setDocuments(documents);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Ticket build() {
        return ticket;
    }
}