package demo.service;

import demo.model.*;
import demo.repository.DeveloperRespository;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import demo.repository.SpecialtyRepository;
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
        project.setDescription("Proyecto");
        project.setStartDate(new Date());
        project.setEndDate(new Date());

        Manager manager1;


        manager1= managerRepository.findById(6).get(0);
        project.setManager(manager1);


        Developer jun, sen ;
        jun= developerRespository.findByCategory(Category.JUNIOR).get(0);
        sen = developerRespository.findByCategory(Category.SENIOR).get(0);


        project.getDevelopers().add(sen);
        project.getDevelopers().add(jun);





        /*Specialty specialty = specialtyRepository.findOne(1L);
        project.getSpecialties().add(specialty); */

        projectRepository.save(project);
    }
}
