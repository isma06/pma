package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 07/07/2015.
 */
@ResponseStatus( value = HttpStatus.NO_CONTENT)
public class ReviewDeveloperProjectException extends RuntimeException {
    public ReviewDeveloperProjectException(Long idProject, Long idDeveloper) {
        super("Este proyecto " + idProject +" no pertence al developer " +idDeveloper );
    }
}
