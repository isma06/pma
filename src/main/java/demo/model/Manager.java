package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
public class Manager extends Employee {
    @Column
    private double bonusSoccess;

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
