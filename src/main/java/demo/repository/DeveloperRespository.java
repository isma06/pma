package demo.repository;

import demo.model.Developer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DeveloperRespository extends PagingAndSortingRepository <Developer, Long> {
    List<Developer> findByCategory (@Param("category") Enum category);
}
