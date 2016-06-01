/*
 * PinchLib
 *
 * This file was automatically generated for Pinch by APIMATIC v2.0 ( https://apimatic.io ) on 06/01/2016
 */
package com.inchbase.pinch;

import com.inchbase.pinch.http.request.HttpRequest;

public class CustomAuthUtility {
    /**
    * Appends the necessary Custom Authentication credentials for making this authorized call
    * @param	request	The out going request to access the resource
    */
    public static void appendCustomAuthParams(HttpRequest request) {
        // TODO: Add your custom authentication here
        // The following properties are available to use
		//     Configuration.xAPITOKEN
		//     Configuration.xAPIEMAIL
        // 
        // ie. Add a header through:
        //     request.getHeaders().put("Key", "Value");
    }
}