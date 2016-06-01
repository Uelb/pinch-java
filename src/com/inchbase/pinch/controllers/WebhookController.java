/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 06/01/2016
 */
package com.inchbase.pinch.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import com.inchbase.pinch.http.client.HttpClient;
import com.inchbase.pinch.http.client.HttpContext;
import com.inchbase.pinch.http.request.HttpRequest;
import com.inchbase.pinch.http.response.HttpResponse;
import com.inchbase.pinch.http.response.HttpStringResponse;
import com.inchbase.pinch.http.client.APICallBack;
import com.inchbase.pinch.controllers.syncwrapper.APICallBackCatcher;
import com.inchbase.pinch.*;
import com.inchbase.pinch.models.*;

public class WebhookController extends BaseController {    
    //private static variables for the singleton pattern
    private static Object syncObject = new Object();
    private static WebhookController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the WebhookController class 
     */
    public static WebhookController getInstance() {
        synchronized (syncObject) {
            if (null == instance) {
                instance = new WebhookController();
            }
        }
        return instance;
    }

    /**
     * List the webhooks of the current user
     * @return	Returns the List<Webhook> response from the API call 
     */
    public List<Webhook> list(
    ) throws Throwable {	
		APICallBackCatcher<List<Webhook>> callback = new APICallBackCatcher<List<Webhook>>();
		listAsync(callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * List the webhooks of the current user
     * @return	Returns the void response from the API call 
     */
    public void listAsync(
                final APICallBack<List<Webhook>> callBack
    ) {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/webhooks");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5143766832906848168L;
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
                            List<Webhook> _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<List<Webhook>>(){});

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

    /**
     * TODO: type endpoint description here
     * @param    webhook    Required parameter: Example: 
     * @return	Returns the Webhook response from the API call 
     */
    public Webhook create(
                final Webhook webhook
    ) throws Throwable {	
		APICallBackCatcher<Webhook> callback = new APICallBackCatcher<Webhook>();
		createAsync(webhook, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * TODO: type endpoint description here
     * @param    webhook    Required parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void createAsync(
                final Webhook webhook,
                final APICallBack<Webhook> callBack
    ) throws JsonProcessingException {
        //validating required parameters
        if (null == webhook)
            throw new NullPointerException("The parameter \"webhook\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/webhooks");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5630562178464287548L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(webhook));

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
                            Webhook _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Webhook>(){});

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

    /**
     * TODO: type endpoint description here
     * @param    webhookId    Required parameter: Example: 
     * @param    webhook    Optional parameter: Example: 
     * @return	Returns the Webhook response from the API call 
     */
    public Webhook update(
                final int webhookId,
                final Webhook webhook
    ) throws Throwable {	
		APICallBackCatcher<Webhook> callback = new APICallBackCatcher<Webhook>();
		updateAsync(webhookId, webhook, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * TODO: type endpoint description here
     * @param    webhookId    Required parameter: Example: 
     * @param    webhook    Optional parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void updateAsync(
                final int webhookId,
                final Webhook webhook,
                final APICallBack<Webhook> callBack
    ) throws JsonProcessingException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/webhooks/{webhook_id}");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5530876501058101109L;
            {
                    put( "webhook_id", webhookId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5189907682584285005L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().putBody(_queryUrl, _headers, APIHelper.serialize(webhook));

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
                            Webhook _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Webhook>(){});

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

    /**
     * TODO: type endpoint description here
     * @param    webhookId    Required parameter: Example: 
     * @return	Returns the String response from the API call 
     */
    public String destroy(
                final int webhookId
    ) throws Throwable {	
		APICallBackCatcher<String> callback = new APICallBackCatcher<String>();
		destroyAsync(webhookId, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * TODO: type endpoint description here
     * @param    webhookId    Required parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void destroyAsync(
                final int webhookId,
                final APICallBack<String> callBack
    ) {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/webhooks/{webhook_id}");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5645542531647955324L;
            {
                    put( "webhook_id", webhookId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4780496924040630310L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().delete(_queryUrl, _headers, null);

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
                            String _result = ((HttpStringResponse)_response).getBody();
                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
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

    /**
     * Get a specific webhook by its id
     * @param    id    Required parameter: Example: 
     * @return	Returns the Webhook response from the API call 
     */
    public Webhook get(
                final String id
    ) throws Throwable {	
		APICallBackCatcher<Webhook> callback = new APICallBackCatcher<Webhook>();
		getAsync(id, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * Get a specific webhook by its id
     * @param    id    Required parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void getAsync(
                final String id,
                final APICallBack<Webhook> callBack
    ) {
        //validating required parameters
        if (null == id)
            throw new NullPointerException("The parameter \"id\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/webhooks/{id}");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5460844192504779192L;
            {
                    put( "id", id );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5491051271299173334L;
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
                            Webhook _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Webhook>(){});

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