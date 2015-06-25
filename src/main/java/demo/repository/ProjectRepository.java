package demo.repository;

import demo.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by poo2 on 17/06/2015.
 */
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {


        Project findById (@Param("id") long id);
}
