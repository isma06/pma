package demo;

import demo.service.DeveloperService;
import demo.service.EmployeeService;
import demo.service.ManagerService;
import demo.service.ProjectService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectManagementApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProjectManagementApplication.class, args);

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        DeveloperService developerService = context.getBean(DeveloperService.class);
        ManagerService managerService = context.getBean(ManagerService.class);
        ProjectService projectService = context.getBean(ProjectService.class);

        employeeService.testEmployees();
        developerService.testDeveloper();
        managerService.testManager();
        projectService.testProject();



    }
}
