package denzelse.waste_management.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class for handling "not found" errors in the Waste Management Spring Boot application.
 * This exception is used to indicate that a specific resource could not be found, such as a database entity.
 * 
 */

 @ResponseStatus(value = HttpStatus.NOT_FOUND)
 public class theNotFoundException extends RuntimeException{
     private String errorName;
     private String fieldName;
     private Long fieldValue;
 
     public theNotFoundException(String errorName, String fieldName, Long fieldValue){
         super(String.format("%s not found",errorName));
         this.errorName = errorName;
         this.fieldName = fieldName;
         this.fieldValue = fieldValue;
     }
 
     public String getErrorName() {
         return errorName;
     }
     public String getFieldName() {
         return fieldName;
     }
     public Long getFieldValue() {
         return fieldValue;
     }
 }