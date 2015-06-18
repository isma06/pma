package demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
public class Project {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String description;

    @Column (name= "startDate")
    @NotNull
    private Date startDate;

    @Column (name= "endtDate")
    @NotNull
    private Date endDate;

    public Manager getManager() {
        return manager;
    }



    @ManyToOne
    private Manager manager;

    @ManyToMany
    private Set<Developer> developers = new HashSet<>();

    public Project() {
    }


    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
