package demo.model;

import javax.persistence.*;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
@PrimaryKeyJoinColumn (name= "id") // con esto le decimos que su primary key sera la de su clase base EMPLOYEE.
public class Developer extends Employee {

    @Column
    @Enumerated(EnumType.STRING) // decir que este campo es un ENUM de tipo STRING.
    private Category category;

    public Developer(){

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
