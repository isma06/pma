package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 01/07/2015.
 */
@ResponseStatus( value = HttpStatus.NOT_FOUND)
public class ManagerException   extends RuntimeException{
    public ManagerException(Long id) {
        super("El manager con el id " +id +" no existe");
    }
}
