package br.com.ecologic.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> argumentosInvalidos(MethodArgumentNotValidException erro){
        Map<String, String> mapaDeErros = new HashMap<String, String>();
        var campos = erro.getBindingResult().getFieldErrors();
        for(FieldError campo : campos){
            mapaDeErros.put(campo.getField(), campo.getDefaultMessage());
        }
        return mapaDeErros;
    }

}
