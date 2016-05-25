/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/25/2016
 */
package com.inchbase.pinch.models;

import java.util.*;

public class WebhookTypeBuilder {
    //the instance to build
    private WebhookType webhookType;

    /**
     * Default constructor to initialize the instance
     */
    public WebhookTypeBuilder() {
        webhookType = new WebhookType();
    }

    public WebhookTypeBuilder id(int id) {
        webhookType.setId(id);
        return this;
    }

    public WebhookTypeBuilder name(String name) {
        webhookType.setName(name);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public WebhookType build() {
        return webhookType;
    }
}