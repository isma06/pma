package demo;

import demo.service.DeveloperService;
import demo.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectManagementApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProjectManagementApplication.class, args);

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        DeveloperService developerService = context.getBean(DeveloperService.class);

        employeeService.testEmployees();
        developerService.testDeveloper();


    }
}
