package demo.repository;

import demo.model.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by poo2 on 17/06/2015.
 */
public interface ManagerRepository extends PagingAndSortingRepository<Manager, Long>{


        List<Manager> findById (@Param("id") long id);
}
