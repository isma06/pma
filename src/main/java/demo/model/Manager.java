package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
public class Manager extends Employee {
    @Column
    private double bonusSoccess;

    @OneToMany (mappedBy = "manager")
    private Set<Project> projects = new HashSet<>();

    public Manager() {
    }



    public double getBonusSoccess() {
        return bonusSoccess;
    }

    public void setBonusSoccess(double bonusSoccess) {
        this.bonusSoccess = bonusSoccess;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonusSoccess=" + bonusSoccess +
                '}';
    }


}
