/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/16/2016
 */
package com.inchbase.pinch.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.type.TypeReference;

import com.inchbase.pinch.http.client.HttpClient;
import com.inchbase.pinch.http.client.HttpContext;
import com.inchbase.pinch.http.request.HttpRequest;
import com.inchbase.pinch.http.response.HttpResponse;
import com.inchbase.pinch.http.response.HttpStringResponse;
import com.inchbase.pinch.http.client.APICallBack;
import com.inchbase.pinch.*;
import com.inchbase.pinch.models.*;

public class WebhookTypeController extends BaseController {    
    //private static variables for the singleton pattern
    private static Object syncObject = new Object();
    private static WebhookTypeController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the WebhookTypeController class 
     */
    public static WebhookTypeController getInstance() {
        synchronized (syncObject) {
            if (null == instance) {
                instance = new WebhookTypeController();
            }
        }
        return instance;
    }

    /**
     * List webhook types
     * @return	Returns the void response from the API call 
     */
    public void listAsync(
                final APICallBack<List<WebhookType>> callBack
    ) {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/webhook_types");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4678051413710872689L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        //Custom Authentication to be added for authorization
        CustomAuthUtility.appendCustomAuthParams(_request);

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            List<WebhookType> _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<List<WebhookType>>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

}