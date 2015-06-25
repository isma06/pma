package demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by poo2 on 25/06/2015.
 */
@Entity
public class Specialty {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    private Set<Developer> developers = new HashSet<>();

    @ManyToMany
    private Set<Project> projects = new HashSet<>();

    public Specialty() {
    }


    public Set<Developer> getDevelopers() {
        return developers;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }


}
