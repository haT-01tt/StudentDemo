package com.tuanha.spring.project.studentprojectspringdemo.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

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
}
