/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 06/01/2016
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
import com.inchbase.pinch.controllers.syncwrapper.APICallBackCatcher;
import com.inchbase.pinch.*;
import com.inchbase.pinch.models.*;

public class TicketController extends BaseController {    
    //private static variables for the singleton pattern
    private static Object syncObject = new Object();
    private static TicketController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the TicketController class 
     */
    public static TicketController getInstance() {
        synchronized (syncObject) {
            if (null == instance) {
                instance = new TicketController();
            }
        }
        return instance;
    }

    /**
     * List all the opened tickets of every clients you are working for
     * @return	Returns the List<Ticket> response from the API call 
     */
    public List<Ticket> list(
    ) throws Throwable {	
		APICallBackCatcher<List<Ticket>> callback = new APICallBackCatcher<List<Ticket>>();
		listAsync(callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * List all the opened tickets of every clients you are working for
     * @return	Returns the void response from the API call 
     */
    public void listAsync(
                final APICallBack<List<Ticket>> callBack
    ) {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/tickets");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4643760470470289592L;
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
                            List<Ticket> _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<List<Ticket>>(){});

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
     * This method returns no result but the status code tells you if the operation succedded
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the Ticket response from the API call 
     */
    public Ticket acceptIntervention(
                final String ticketId
    ) throws Throwable {	
		APICallBackCatcher<Ticket> callback = new APICallBackCatcher<Ticket>();
		acceptInterventionAsync(ticketId, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * This method returns no result but the status code tells you if the operation succedded
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void acceptInterventionAsync(
                final String ticketId,
                final APICallBack<Ticket> callBack
    ) {
        //validating required parameters
        if (null == ticketId)
            throw new NullPointerException("The parameter \"ticketId\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/tickets/{ticket_id}/accept");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 4979789822735094045L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5216409976421004766L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().post(_queryUrl, _headers, null);

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
                            Ticket _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Ticket>(){});

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
     * @param    interventionDate    Required parameter: Example: 
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the Ticket response from the API call 
     */
    public Ticket setInterventionDate(
                final Date interventionDate,
                final String ticketId
    ) throws Throwable {	
		APICallBackCatcher<Ticket> callback = new APICallBackCatcher<Ticket>();
		setInterventionDateAsync(interventionDate, ticketId, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * TODO: type endpoint description here
     * @param    interventionDate    Required parameter: Example: 
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void setInterventionDateAsync(
                final Date interventionDate,
                final String ticketId,
                final APICallBack<Ticket> callBack
    ) {
        //validating required parameters
        if (null == interventionDate)
            throw new NullPointerException("The parameter \"interventionDate\" is a required parameter and cannot be null.");

        if (null == ticketId)
            throw new NullPointerException("The parameter \"ticketId\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/tickets/{ticket_id}/set_intervention_date");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5450652237569923830L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5645165838137355883L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 4990380819724233647L;
            {
                    put( "intervention_date", interventionDate );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().post(_queryUrl, _headers, APIHelper.prepareFormFields(_parameters));

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
                            Ticket _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Ticket>(){});

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
     * @param    file    Required parameter: Example: 
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the Ticket response from the API call 
     */
    public Ticket uploadQuote(
                final File file,
                final String ticketId
    ) throws Throwable {	
		APICallBackCatcher<Ticket> callback = new APICallBackCatcher<Ticket>();
		uploadQuoteAsync(file, ticketId, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * TODO: type endpoint description here
     * @param    file    Required parameter: Example: 
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void uploadQuoteAsync(
                final File file,
                final String ticketId,
                final APICallBack<Ticket> callBack
    ) {
        //validating required parameters
        if (null == file)
            throw new NullPointerException("The parameter \"file\" is a required parameter and cannot be null.");

        if (null == ticketId)
            throw new NullPointerException("The parameter \"ticketId\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/tickets/{ticket_id}/quote_upload");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5349607107435017764L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5680122318002577097L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5146802139108843354L;
            {
                    put( "file", file );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().post(_queryUrl, _headers, APIHelper.prepareFormFields(_parameters));

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
                            Ticket _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Ticket>(){});

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
     * @param    body    Required parameter: Example: 
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the Ticket response from the API call 
     */
    public Ticket sendMessage(
                final String body,
                final String ticketId
    ) throws Throwable {	
		APICallBackCatcher<Ticket> callback = new APICallBackCatcher<Ticket>();
		sendMessageAsync(body, ticketId, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * TODO: type endpoint description here
     * @param    body    Required parameter: Example: 
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void sendMessageAsync(
                final String body,
                final String ticketId,
                final APICallBack<Ticket> callBack
    ) {
        //validating required parameters
        if (null == body)
            throw new NullPointerException("The parameter \"body\" is a required parameter and cannot be null.");

        if (null == ticketId)
            throw new NullPointerException("The parameter \"ticketId\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/tickets/{ticket_id}/message");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 4768914392721385366L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4669057193371706281L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 4640395452235138229L;
            {
                    put( "body", body );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().post(_queryUrl, _headers, APIHelper.prepareFormFields(_parameters));

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
                            Ticket _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Ticket>(){});

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
     * @param    ticketId    Required parameter: Example: 
     * @param    interventionDate    Optional parameter: Example: 
     * @return	Returns the Ticket response from the API call 
     */
    public Ticket declareInterventionDone(
                final String ticketId,
                final Date interventionDate
    ) throws Throwable {	
		APICallBackCatcher<Ticket> callback = new APICallBackCatcher<Ticket>();
		declareInterventionDoneAsync(ticketId, interventionDate, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * TODO: type endpoint description here
     * @param    ticketId    Required parameter: Example: 
     * @param    interventionDate    Optional parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void declareInterventionDoneAsync(
                final String ticketId,
                final Date interventionDate,
                final APICallBack<Ticket> callBack
    ) {
        //validating required parameters
        if (null == ticketId)
            throw new NullPointerException("The parameter \"ticketId\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/tickets/{ticket_id}/intervention_done");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5332559904178447180L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5136035209287791344L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5079005346926285102L;
            {
                    put( "intervention_date", interventionDate );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().post(_queryUrl, _headers, APIHelper.prepareFormFields(_parameters));

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
                            Ticket _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Ticket>(){});

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
     * The document should not be an invoice nor a quote
     * @param    file    Required parameter: Example: 
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the Ticket response from the API call 
     */
    public Ticket uploadDocument(
                final File file,
                final String ticketId
    ) throws Throwable {	
		APICallBackCatcher<Ticket> callback = new APICallBackCatcher<Ticket>();
		uploadDocumentAsync(file, ticketId, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * The document should not be an invoice nor a quote
     * @param    file    Required parameter: Example: 
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void uploadDocumentAsync(
                final File file,
                final String ticketId,
                final APICallBack<Ticket> callBack
    ) {
        //validating required parameters
        if (null == file)
            throw new NullPointerException("The parameter \"file\" is a required parameter and cannot be null.");

        if (null == ticketId)
            throw new NullPointerException("The parameter \"ticketId\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/tickets/{ticket_id}/document_upload");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5352246868838080616L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5651583261554879878L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5600639872627603242L;
            {
                    put( "file", file );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().post(_queryUrl, _headers, APIHelper.prepareFormFields(_parameters));

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
                            Ticket _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Ticket>(){});

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
     * @param    file    Required parameter: Example: 
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the Ticket response from the API call 
     */
    public Ticket uploadPicture(
                final File file,
                final String ticketId
    ) throws Throwable {	
		APICallBackCatcher<Ticket> callback = new APICallBackCatcher<Ticket>();
		uploadPictureAsync(file, ticketId, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * TODO: type endpoint description here
     * @param    file    Required parameter: Example: 
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void uploadPictureAsync(
                final File file,
                final String ticketId,
                final APICallBack<Ticket> callBack
    ) {
        //validating required parameters
        if (null == file)
            throw new NullPointerException("The parameter \"file\" is a required parameter and cannot be null.");

        if (null == ticketId)
            throw new NullPointerException("The parameter \"ticketId\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/tickets/{ticket_id}/picture_upload");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5413260170476677434L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4808370105010379740L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5688882752010212724L;
            {
                    put( "file", file );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().post(_queryUrl, _headers, APIHelper.prepareFormFields(_parameters));

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
                            Ticket _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Ticket>(){});

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
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the Ticket response from the API call 
     */
    public Ticket get(
                final String ticketId
    ) throws Throwable {	
		APICallBackCatcher<Ticket> callback = new APICallBackCatcher<Ticket>();
		getAsync(ticketId, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * TODO: type endpoint description here
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void getAsync(
                final String ticketId,
                final APICallBack<Ticket> callBack
    ) {
        //validating required parameters
        if (null == ticketId)
            throw new NullPointerException("The parameter \"ticketId\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/tickets/{ticket_id}");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 4786573583379992120L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5044080532393549196L;
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
                            Ticket _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Ticket>(){});

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
     * @param    file    Required parameter: Example: 
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the String response from the API call 
     */
    public String uploadInvoice(
                final File file,
                final String ticketId
    ) throws Throwable {	
		APICallBackCatcher<String> callback = new APICallBackCatcher<String>();
		uploadInvoiceAsync(file, ticketId, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * TODO: type endpoint description here
     * @param    file    Required parameter: Example: 
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void uploadInvoiceAsync(
                final File file,
                final String ticketId,
                final APICallBack<String> callBack
    ) {
        //validating required parameters
        if (null == file)
            throw new NullPointerException("The parameter \"file\" is a required parameter and cannot be null.");

        if (null == ticketId)
            throw new NullPointerException("The parameter \"ticketId\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/tickets/{ticket_id}/invoice_upload");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5223824639390376612L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4893864978178170027L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5226583242436080579L;
            {
                    put( "file", file );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().post(_queryUrl, _headers, APIHelper.prepareFormFields(_parameters));

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
     * Get the documents of a ticket related to the intervention (No invoice, no quote)
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the List<Document> response from the API call 
     */
    public List<Document> documents(
                final String ticketId
    ) throws Throwable {	
		APICallBackCatcher<List<Document>> callback = new APICallBackCatcher<List<Document>>();
		documentsAsync(ticketId, callback);
		if(!callback.isSuccess())
			throw callback.getError();
		return callback.getResult();
	}

    /**
     * Get the documents of a ticket related to the intervention (No invoice, no quote)
     * @param    ticketId    Required parameter: Example: 
     * @return	Returns the void response from the API call 
     */
    public void documentsAsync(
                final String ticketId,
                final APICallBack<List<Document>> callBack
    ) {
        //validating required parameters
        if (null == ticketId)
            throw new NullPointerException("The parameter \"ticketId\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/tickets/{ticket_id}/documents");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5127012941201114105L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5128972792860017400L;
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
                            List<Document> _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<List<Document>>(){});

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