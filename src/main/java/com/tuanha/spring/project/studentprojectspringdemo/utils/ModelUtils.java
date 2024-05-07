package com.tuanha.spring.project.studentprojectspringdemo.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class ModelUtils {
    // Get Path when call api response ERROR
    public String getPath(WebRequest request){
        return request.getDescription(false).replace("uri=", "");
    }
    // Get MESSAGE when call api response ERROR
    public String getMessage(Exception e) {return e.getMessage().substring(e.getMessage().lastIndexOf("[") + 1, e.getMessage().lastIndexOf("]") - 1);
    }

    /**
     * Get URL check log when api success.
     * example:
     *  [Service method: /api/student/getAll - getAllStudent]
     */

    public String getUrl(JoinPoint joinPoint, HttpServletRequest request) {
        String url = request.getRequestURI();
        String methodName = joinPoint.getSignature().getName();
        return url + " - " + methodName;
    }
    private String extractFieldNameFromException(InvalidDataAccessResourceUsageException ex) {
        Matcher matcher = Pattern.compile("Unknown column '(\\w+)' in 'field list'").matcher(ex.getMessage());
        return matcher.find() ? matcher.group(1) : "";
    }
}
