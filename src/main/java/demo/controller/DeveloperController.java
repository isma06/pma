package demo.controller;

import demo.model.Developer;
import demo.repository.DeveloperRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by poo2 on 29/06/2015.
 */
@RestController //decir a spring que es un controller
@RequestMapping("/developers") // url relativa para accedir a este controler
public class DeveloperController {
    @Autowired
    private DeveloperRespository developerRespository;


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Developer save (@RequestBody Developer developer){
        return developerRespository.save(developer);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Developer> finAll(){
        List<Developer> developers = new ArrayList<Developer>();
        Iterator<Developer> iterator = developerRespository.findAll().iterator();

        while (iterator.hasNext()){
            developers.add(iterator.next());
        }
        return  developers;
    }



}
