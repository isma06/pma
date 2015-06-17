package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.repository.DeveloperRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class DeveloperService {
    @Autowired
    private DeveloperRespository developerRepository;

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


        Developer jun ;
        jun= developerRepository.findByCategory(Category.JUNIOR).get(0);
        System.out.println(jun.toString());
    }
}
