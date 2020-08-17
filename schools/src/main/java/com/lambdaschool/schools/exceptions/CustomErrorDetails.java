package com.lambdaschool.schools.exceptions;

import com.lambdaschool.schools.services.HelperFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;
import java.util.Map;

//spring framework needs to manage this file
@Component
public class CustomErrorDetails extends DefaultErrorAttributes {

    //connects this class to the helper functions
    @Autowired
    private HelperFunctions helperFunctions;

    @Override
    public Map<String, Object> getErrorAttributes(
        WebRequest webRequest,
        boolean includeStackTrace) {

        //grab error info from system
        Map<String, Object> errorAtributes = super.getErrorAttributes(webRequest, includeStackTrace);
        //linked hashmaps keep items in order
        Map<String, Object> errorDetails = new LinkedHashMap<>();
        errorDetails.put("title", errorAtributes.get("error"));
        errorDetails.put("status", errorAtributes.get("status"));
        errorDetails.put("detail", errorAtributes.get("message"));
        errorDetails.put("timestamp", errorAtributes.get("timestamp"));
        errorDetails.put("developerMessage", "path: " + errorAtributes.get("path"));

        errorDetails.put("Errors: ", helperFunctions.getConstraintViolation(this.getError(webRequest)));
        return errorDetails;
    }
}
