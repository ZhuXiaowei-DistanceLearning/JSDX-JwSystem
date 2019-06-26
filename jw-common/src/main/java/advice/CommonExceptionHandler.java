package advice;

import exception.JwException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vo.ExceptionResult;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(JwException.class)
    public ResponseEntity<ExceptionResult> handlerException(JwException e){
        return ResponseEntity.status(e.getExceptionEnums().getCode()).body(new ExceptionResult(e.getExceptionEnums()));
    }
}
