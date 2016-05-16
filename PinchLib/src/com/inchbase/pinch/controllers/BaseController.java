/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/16/2016
 */
package com.inchbase.pinch.controllers;

import com.inchbase.pinch.APIException;
import com.inchbase.pinch.http.client.HttpClient;
import com.inchbase.pinch.http.client.HttpContext;
import com.inchbase.pinch.http.client.UnirestClient;
import com.inchbase.pinch.http.response.HttpResponse;

public abstract class BaseController {
    /**
     * Private variable to keep shared reference of client instance
     */
    private static HttpClient clientInstance = null;
    private static Object syncObject = new Object();
    
    /**
     * Shared instance of the Http client
     * @return The shared instance of the http client 
     */
    public static HttpClient getClientInstance() {
        synchronized (syncObject) {
            if (null == clientInstance) {
                clientInstance = UnirestClient.getSharedInstance();
            }
        }
        return clientInstance;
    }

    /**
     * Shared instance of the Http client
     * @param	client	The shared instance of the http client 
     */
    public static void setClientInstance(HttpClient client) {
        synchronized (syncObject) {
            if (null != client) {
                clientInstance = client;
            }
        }
    }

    /**
     * Validates the response against HTTP errors defined at the API level
     * @param	response	The response recieved
     * @param	context		Context of the request and the recieved response 
     */
    protected void validateResponse(HttpResponse response, HttpContext context) 
            throws APIException {
        //get response status code to validate
        int responseCode = response.getStatusCode();
        if (responseCode == 401)
            throw new APIException("Your API key is incorrect", context);

        else if (responseCode == 400)
            throw new APIException("There is an error in the parameters you send", context);

        else if (responseCode == 404)
            throw new APIException("Cannot find the resource specified", context);

        else if ((responseCode < 200) || (responseCode > 206)) //[200,206] = HTTP OK
            throw new APIException("HTTP Response Not OK", context);
    }
}
