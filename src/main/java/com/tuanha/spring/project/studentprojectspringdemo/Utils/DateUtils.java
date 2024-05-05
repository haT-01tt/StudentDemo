package com.tuanha.spring.project.studentprojectspringdemo.Utils;

import com.tuanha.spring.project.studentprojectspringdemo.Enum.ExceptionErrorCode;
import com.tuanha.spring.project.studentprojectspringdemo.StudentException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date convertStringToDate(String oneDate) throws StudentException {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            return dateFormat.parse(oneDate);
        } catch (ParseException e) {
            throw new StudentException(ExceptionErrorCode.DateError.DATE_007.getCode(), ExceptionErrorCode.DateError.DATE_007.getMessage());
        }
    }
    public static String convertDateToString(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }
}
