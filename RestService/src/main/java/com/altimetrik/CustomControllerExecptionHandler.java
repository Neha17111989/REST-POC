/*
 * package com.altimetrik;
 * 
 * import java.util.Date;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ExceptionHandler; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.context.request.WebRequest; import
 * org.springframework.web.servlet.mvc.method.annotation.
 * ResponseEntityExceptionHandler;
 * 
 * @ControllerAdvice
 * 
 * @RestController public class CustomControllerExecptionHandler extends
 * ResponseEntityExceptionHandler{
 * 
 * @ExceptionHandler(Exception.class) public ResponseEntity handleOne(){
 * CustomException obj=new CustomException(new Date(), "Invalid Dogs",
 * "handle one.."); return new ResponseEntity(HttpStatus.ACCEPTED);
 * 
 * }
 * 
 * @ExceptionHandler(Exception.class) ResponseEntity<Object>
 * handleAllException(Exception ex,WebRequest wr){ CustomException exce= new
 * CustomException(new Date(),ex.getMessage(),wr.getDescription(false)); return
 * new ResponseEntity(exce, HttpStatus.INTERNAL_SERVER_ERROR);
 * 
 * 
 * }
 * 
 * }
 */