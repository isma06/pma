package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 07/07/2015.
 */
@ResponseStatus( value = HttpStatus.NOT_FOUND)
public class SpecialtyException extends RuntimeException{
    public SpecialtyException(Long id) {
        super("No existe la especialidad con el id: " +id );
    }
}
