package com.tuanha.spring.project.studentprojectspringdemo.utils;

import com.tuanha.spring.project.studentprojectspringdemo.enumstudent.ExceptionCode;
import com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent.StudentException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date convertStringToDate(String oneDate) throws StudentException {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            return dateFormat.parse(oneDate);
        } catch (ParseException e) {
            throw new StudentException(ExceptionCode.DateError.DATE_007.getCode(), ExceptionCode.DateError.DATE_007.getMessage());
        }
    }
    public static String convertDateToString(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }
}
