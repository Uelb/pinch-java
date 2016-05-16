/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/16/2016
 */
package com.inchbase.pinch;

import com.inchbase.pinch.controllers.*;
import com.inchbase.pinch.http.client.HttpClient;

public class PinchClient {
    /**
     * Singleton access to WebhookType controller
     * @return	Returns the WebhookTypeController instance 
     */
    public WebhookTypeController getWebhookType() {
        return WebhookTypeController.getInstance();
    }

    /**
     * Singleton access to Webhook controller
     * @return	Returns the WebhookController instance 
     */
    public WebhookController getWebhook() {
        return WebhookController.getInstance();
    }

    /**
     * Singleton access to Ticket controller
     * @return	Returns the TicketController instance 
     */
    public TicketController getTicket() {
        return TicketController.getInstance();
    }

    /**
     * Get the shared http client currently being used for API calls
     * @return The http client instance currently being used
     */
    public HttpClient getSharedHttpClient() {
        return BaseController.getClientInstance();
    }
    
    /**
     * Set a shared http client to be used for API calls
     * @param httpClient The http client to use
     */
    public void setSharedHttpClient(HttpClient httpClient) {
        BaseController.setClientInstance(httpClient);
    }

    /**
     * Default constructor 
     */     
    public PinchClient() { }

    /**
     * Client initialization constructor 
     */     
    public PinchClient(String xAPITOKEN, String xAPIEMAIL) {
        Configuration.xAPITOKEN = xAPITOKEN;
        Configuration.xAPIEMAIL = xAPIEMAIL;
    }
}