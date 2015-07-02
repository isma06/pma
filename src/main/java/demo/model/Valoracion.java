package demo.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by poo2 on 02/07/2015.
 */
public class Valoracion {
    @ManyToOne
    @JoinColumn(name = "id_manager")
    private Developer developer;

    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

    @Column(name = "Valoración")
    private int valoracion;
}
