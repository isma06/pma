package demo.controller;

import demo.exception.ReviewException;
import demo.model.Review;
import demo.repository.DeveloperRespository;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by poo2 on 06/07/2015.
 */
@RestController
@RequestMapping("/valoraciones")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private DeveloperRespository developerRespository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Review getById (@PathVariable Long id){
        Review review = reviewRepository.findOne(id);

        if(review== null)
            throw new ReviewException(id);
        return review;
    }


    /*@RequestMapping(value ="/projects/{idProject}/developer/{idDeveloper}/specialty/{idSpecialty}/review", method = RequestMethod.POST)
    public Review addOne(){
        return
    }*/


}
