package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 07/07/2015.
 */
@ResponseStatus( value = HttpStatus.NO_CONTENT)
public class ReviewDeveloperSpecialtyException extends RuntimeException {
    public ReviewDeveloperSpecialtyException(Long idSpeciality, Long idDeveloper) {
        super("Este developer " + idDeveloper +" no trabaja la especialidad " +idSpeciality );
    }
}
