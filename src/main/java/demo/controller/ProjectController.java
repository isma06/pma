package demo.controller;

/**
 * Created by poo2 on 01/07/2015.
 */

import demo.exception.ManagerException;
import demo.exception.ProjectException;
import demo.model.Manager;
import demo.model.Project;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController //decir a spring que es un controller
@RequestMapping("/projects") // url relativa para accedir a este controler
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ManagerRepository managerRepository;


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Project save (@RequestBody Project poject){
        return projectRepository.save(poject);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Project> findAll(){
        List<Project> pojects = new ArrayList<Project>();
        Iterator<Project> iterator = projectRepository.findAll().iterator();

        while (iterator.hasNext()){
            pojects.add(iterator.next());
        }
        return  pojects;
    }


    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Project getById (@PathVariable Long id){
        Project poject = projectRepository.findOne(id);

        if(poject== null)
            throw new ProjectException(id); // lanzar una exception cuando el poject es null.

        return poject;
    }


    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
    public void deleteOne(@PathVariable Long id){
        Project poject = projectRepository.findOne(id);
        if(poject== null)
            throw new ProjectException(id);
        projectRepository.delete(id);
    }


    @RequestMapping(value ="/{id}", method = RequestMethod.PUT)
    public Project updateOne(@RequestBody Project newProject, @PathVariable Long id){
        Project project = projectRepository.findOne(id);
        if(project== null)
            throw new ProjectException(id);

        newProject= projectRepository.save(newProject);
        return newProject;
    }



    @RequestMapping(value="/{idProject}/manager/{idManager}", method = RequestMethod.POST)
    public Project addManager(@PathVariable Long idProject,@PathVariable Long idManager) {

        Project project = projectRepository.findOne(idProject);

        if(project == null)
            throw new ProjectException(idProject);

        Manager manager = managerRepository.findOne(idManager);

        if(manager == null)
            throw new ManagerException(idProject);

        project.setManager(manager);
        projectRepository.save(project);

        return project;
    }


    @RequestMapping(value="/{idProject}/manager", method = RequestMethod.GET)
    public Manager getManager(@PathVariable Long idProject) {

        Project project = projectRepository.findOne(idProject);

        if(project == null)
            throw new ProjectException(idProject);

        return project.getManager();
    }



}

