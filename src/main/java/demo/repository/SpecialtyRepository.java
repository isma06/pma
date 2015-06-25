package demo.repository;

import demo.model.Specialty;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by poo2 on 25/06/2015.
 */
public interface SpecialtyRepository  extends PagingAndSortingRepository<Specialty , Long>{
    List<Specialty> findByName(@Param("name") String name);
}

