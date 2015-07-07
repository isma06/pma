package demo.exception;

/**
 * Created by poo2 on 07/07/2015.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NO_CONTENT)
public class ReviewProjectSpecialityException extends RuntimeException {
    public ReviewProjectSpecialityException(Long idProject, Long idSpeciality) {
        super("Este proyecto " + idProject +" no contiende la especialidad " +idSpeciality );
    }
}
