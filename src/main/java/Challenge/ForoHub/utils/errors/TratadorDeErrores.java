package Challenge.ForoHub.utils.errors;

import Challenge.ForoHub.Http.ResponseError;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.sasl.AuthenticationException;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(TokenInvalidoException.class)
    public ResponseEntity tratarErrorTokenInvalido(TokenInvalidoException e){
        ResponseError responseError = new ResponseError();
        responseError.setError(e.getMessage()); // Usamos el mensaje de la excepción personalizada
        responseError.setStatus(HttpStatus.UNAUTHORIZED.value());
        responseError.setMessage("Error de autenticación: " + e.getMessage());
        responseError.setPath("/error/login");
        return new ResponseEntity<>(responseError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity tratarErrorCustom(CustomException e){
        ResponseError responseError = new ResponseError();
        responseError.setError(e.getMessage());
        responseError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseError.setMessage(e.getMessage());
        responseError.setPath("/error");
        return new ResponseEntity<>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private record DatosErrorValidacion(String campo, String error){
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }


}