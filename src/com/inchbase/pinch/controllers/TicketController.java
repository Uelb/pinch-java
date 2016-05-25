/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 05/25/2016
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
            private static final long serialVersionUID = 5081998465535659603L;
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
            private static final long serialVersionUID = 4841130321973632962L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5544928157840532509L;
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
            private static final long serialVersionUID = 4966940448033206111L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5459923078993796660L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5296664409197202566L;
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
            private static final long serialVersionUID = 4713839938323066890L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5631035331165219689L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5152138522149124424L;
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
            private static final long serialVersionUID = 5357106725979925175L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4951037202237799143L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 4721632303783953128L;
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
            private static final long serialVersionUID = 5056474004252439169L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5709611913913677218L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5093539130525594894L;
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
            private static final long serialVersionUID = 4679586423708351798L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4768612885089203100L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 4812551758692014502L;
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
            private static final long serialVersionUID = 4859832217502523302L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4705830340615556309L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5624480606849159037L;
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
            private static final long serialVersionUID = 5126331755680392839L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4628876141850976513L;
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
            private static final long serialVersionUID = 5404211295559685290L;
            {
                    put( "ticket_id", ticketId );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 4652090618208462443L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "X-API-TOKEN", Configuration.xAPITOKEN );
                    put( "X-API-EMAIL", Configuration.xAPIEMAIL );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 4672928540373965197L;
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

}