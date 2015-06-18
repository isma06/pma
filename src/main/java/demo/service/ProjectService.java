package demo.service;

import demo.model.Developer;
import demo.model.Manager;
import demo.model.Project;
import demo.repository.DeveloperRespository;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by poo2 on 17/06/2015.
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    DeveloperRespository developerRespository;

    public void testProject() {
        Project project;
        project = new Project();
        project.setDescription("Proyecto nuevo xD");
        project.setStartDate(new Date());
        project.setEndDate(new Date());


        Developer developer = developerRespository.findById(5).get(0);
        project.getDevelopers().add(developer);


        Manager manager1;


        manager1= managerRepository.findById(6).get(0);
        project.setManager(manager1);
        projectRepository.save(project);




    }
}
