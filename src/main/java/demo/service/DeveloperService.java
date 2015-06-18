package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.model.Project;
import demo.repository.DeveloperRespository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class DeveloperService {
    @Autowired
    private DeveloperRespository developerRepository;
    @Autowired
    ProjectRepository projectRepository;

    public void testDeveloper(){
        Developer junior, senior, architect;
        junior= new Developer();
        senior = new Developer();
        architect= new Developer();


        junior.setName("Junior");
        junior.setSurname("Novato");
        junior.setCategory(Category.JUNIOR);
        junior.setSalary(5.1);
        junior.setDateIncorporation(new Date());

        senior.setName("Senior");
        senior.setSurname("Viejo");
        senior.setCategory(Category.SENIOR);
        senior.setSalary(2000.01);
        senior.setDateIncorporation(new Date());


        architect.setName("architect");
        architect.setSurname("Afortunado");
        architect.setCategory(Category.ARCHITECT);
        architect.setSalary(45000.1);
        architect.setDateIncorporation(new Date());


        developerRepository.save(junior);
        developerRepository.save(senior);
        developerRepository.save(architect);




        Developer developer = developerRepository.findById(5).get(0);
        //Project project = projectRepository.findById(1).get(0);

        Project project;
        project = new Project();
        project.setDescription("Proyecto developer");
        project.setStartDate(new Date());
        project.setEndDate(new Date());

        developer.getProjects().add(project);


        Developer jun ;
        jun= developerRepository.findByCategory(Category.JUNIOR).get(0);
        System.out.println(jun.toString());
    }
}
