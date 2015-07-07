package demo.controller;

import demo.exception.*;
import demo.model.Developer;
import demo.model.Project;
import demo.model.Review;
import demo.model.Specialty;
import demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by poo2 on 06/07/2015.
 */
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private DeveloperRespository developerRespository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private SpecialtyRepository specialtyRepository;


    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Review getById (@PathVariable Long id){
        Review review = reviewRepository.findOne(id);

        if(review== null)
            throw new ReviewException(id);
        return review;
    }


    @RequestMapping(value="/projects/{idProject}/developers/{idDeveloper}/specialties/{idSpecialty}/review",method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Review save(@PathVariable Long idProject,@PathVariable Long idDeveloper,@PathVariable Long idSpecialty,@RequestBody Review review) {
        Project project = projectRepository.findOne(idProject);
        if (project==null)
            throw new ProjectException(idProject);
        Developer developer=developerRespository.findOne(idDeveloper);
        if(developer==null)
            throw new DeveloperException(idDeveloper);
        Specialty specialty=specialtyRepository.findOne(idSpecialty);
        if (specialty==null)
            throw new SpecialtyException(idSpecialty);
        if (!developer.getProjects().contains(project))
            throw new ReviewDeveloperProjectException(idProject,idDeveloper);
        if (!project.getSpecialties().contains(specialty))
            throw new ReviewProjectSpecialityException(idProject,idSpecialty);
        if (!developer.getSpecialties().contains(specialty))
            throw new ReviewDeveloperSpecialtyException(idSpecialty,idDeveloper);
        review.setProject(project);
        review.setDeveloper(developer);
        review.setSpecialty(specialty);
        return reviewRepository.save(review);
    }



    @RequestMapping(value= "/developers/{idDeveloper}/reviews", method = RequestMethod.GET)
    public Set<Review> getDevReviews(@PathVariable Long idDeveloper) {
        Developer developer=developerRespository.findOne(idDeveloper);
        if (developer==null)
            throw new DeveloperException(idDeveloper);
        Set <Review> reviews= developer.getReviews();
        return reviews;
    }


    @RequestMapping(value= "/developers/{idDeveloper}/reviewsSpecialty", method = RequestMethod.GET)
    public Map<String, List<Review>> getDevReviewsSpeciality(@PathVariable Long idDeveloper) {
        Developer developer=developerRespository.findOne(idDeveloper);
        if (developer==null)
            throw new DeveloperException(idDeveloper);

        Map<String, List<Review>> reviewsSpecialty= new HashMap<String, List<Review>>();

        Set <Review> reviews= developer.getReviews();

        for (Review rev: reviews) {
            Specialty specialty = rev.getSpecialty();

            if (!reviewsSpecialty.containsKey(specialty.getName())) {
                List<Review> reviewList = new ArrayList<Review>();
                reviewsSpecialty.put(specialty.getName(), reviewList);
            }

            List<Review> reviewList = reviewsSpecialty.get(specialty.getName());
            reviewList.add(rev);

        }
        return  reviewsSpecialty;
    }

}
