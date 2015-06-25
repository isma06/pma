package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.model.Project;
import demo.model.Specialty;
import demo.repository.DeveloperRespository;
import demo.repository.ProjectRepository;
import demo.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by poo2 on 25/06/2015.
 */
@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;
    @Autowired
    private DeveloperRespository developerRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public void testSpecialty() {

        Specialty specialty;
        specialty= new Specialty();
        specialty.setName("JAVA");


        Developer developer =  developerRepository.findByCategory(Category.SENIOR).get(0);
        specialty.getDevelopers().add(developer);

        Project project = projectRepository.findOne(1L);
        specialty.getProjects().add(project);
        specialtyRepository.save(specialty);
    }
}
