/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/25/2016
 */
package com.inchbase.pinch.models;

public class WebhookBuilder {
    //the instance to build
    private Webhook webhook;

    /**
     * Default constructor to initialize the instance
     */
    public WebhookBuilder() {
        webhook = new Webhook();
    }

    public WebhookBuilder url(String url) {
        webhook.setUrl(url);
        return this;
    }

    public WebhookBuilder webhookType(int webhookType) {
        webhook.setWebhookType(webhookType);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Webhook build() {
        return webhook;
    }
}