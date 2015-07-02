package demo.controller;

import demo.exception.ManagerException;
import demo.model.Manager;
import demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by poo2 on 01/07/2015.
 */
@RestController //decir a spring que es un controller
@RequestMapping("/managers") // url relativa para accedir a este controler
public class ManagerController {
    @Autowired
    private ManagerRepository managerRepository;


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Manager save (@RequestBody Manager manager){
        return managerRepository.save(manager);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Manager> findAll(){
        List<Manager> managers = new ArrayList<Manager>();
        Iterator<Manager> iterator = managerRepository.findAll().iterator();

        while (iterator.hasNext()){
            managers.add(iterator.next());
        }
        return  managers;
    }


    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Manager getById (@PathVariable Long id){
        Manager manager = managerRepository.findOne(id);

        if(manager== null)
            throw new ManagerException(id); // lanzar una exception cuando el manager es null.

        return manager;
    }


    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
    public void deleteOne(@PathVariable Long id){
        Manager manager = managerRepository.findOne(id);
        if(manager== null)
            throw new ManagerException(id);
        managerRepository.delete(id);
    }


    @RequestMapping(value ="/{id}", method = RequestMethod.PUT)
    public Manager updateOne(@RequestBody Manager newManager, @PathVariable Long id){
        Manager manager = managerRepository.findOne(id);
        if(manager== null)
            throw new ManagerException(id);

        newManager= managerRepository.save(newManager);
        return newManager;
    }


}

