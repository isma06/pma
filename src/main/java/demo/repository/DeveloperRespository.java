package demo.repository;

import demo.model.Developer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by poo2 on 17/06/2015.
 */
public interface DeveloperRespository extends PagingAndSortingRepository <Developer, Long> {
    List<Developer> findById (@Param("id") long id);
}
