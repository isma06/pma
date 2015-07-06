package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@PrimaryKeyJoinColumn (name= "id") // con esto le decimos que su primary key sera la de su clase base EMPLOYEE.
public class Developer extends Employee {

    @Column
    @Enumerated(EnumType.STRING) // decir que este campo es un ENUM de tipo STRING.
    private Category category;

    @JsonIgnore  //ignorar en json
    @ManyToMany(mappedBy = "developers")  //propietario de la relación
    private Set<Project> projects = new HashSet<>();


    @JsonIgnore
    @ManyToMany(mappedBy = "developers")
    private Set<Specialty> specialties = new HashSet<>();

    @OneToMany (mappedBy = "developer")
    private Set<Review> reviews = new HashSet<>();



    public Developer(){

    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        String developer = super.toString();
        return developer + " Developer{" +
                "category=" + category +
                '}';
    }


}
