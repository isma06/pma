package demo.service;

import demo.model.Manager;
import demo.repository.EmployeeRepository;
import demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by poo2 on 17/06/2015.
 */
@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public void testManager() {
        Manager manager;
        manager = new Manager();
        manager.setName("Manager1");
        manager.setSurname("Cal");
        manager.setSalary(31.01);
        manager.setDateIncorporation(new Date());
        manager.setBonusSoccess(5);

        managerRepository.save(manager);
    }
}
