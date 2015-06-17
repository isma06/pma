package demo.service;

import demo.model.Employee;
import demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;



@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;



    public void testEmployees(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, calendar.JANUARY, 1);
        Date startDate = calendar.getTime();

        calendar.set(2015, calendar.MARCH, 1);
        Date endDate= calendar.getTime();

        calendar.set(2015, calendar.FEBRUARY, 1);
        Date dateIncor = calendar.getTime();


        Employee employee = new Employee();
        employee.setName("Arturo");
        employee.setSurname("El Kabouri");
        employee.setSalary(2400.0);
        employee.setDateIncorporation(new Date());

        employeeRepository.save(employee);


        Employee employee2 = new Employee();
        employee2.setName("Ismail");
        employee2.setSurname("El Kabouri");
        employee2.setSalary(3400.0);
        employee2.setDateIncorporation(dateIncor);

        employeeRepository.save(employee2);

        List<Employee> list = employeeRepository.findByNameAndSurname("Ismail", "El Kabouri");

        for(Employee em : list){
            System.out.println(em.toString());
        }


        Employee ismail = employeeRepository.findByDateIncorporationBetween(startDate, endDate).get(0);
        System.out.println(ismail.toString());
    }



}
