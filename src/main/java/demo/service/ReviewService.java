package demo.service;

import demo.model.*;
import demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by poo2 on 06/07/2015.
 */
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private DeveloperRespository developerRespository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private ProjectRepository projectRepository;


    public void valoracionTest(){
        Review review;
        review = new Review();
        review.setScore(6.7);

        Developer developer = developerRespository.findOne(4L);
        Project project= projectRepository.findOne(1L);
        Specialty specialty = specialtyRepository.findOne(1L);



        review.setDeveloper(developer);
        review.setSpecialty(specialty);
        review.setProject(project);


        reviewRepository.save(review);
    }
}
