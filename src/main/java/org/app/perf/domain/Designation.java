package org.app.perf.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by gauravbehl on 9/5/17.
 */
@Entity
@Table(name = "DESIGNATION")
@Data
public class Designation {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TITLE", unique = true, nullable = false)
    private String title;

    @ManyToMany
    @JoinTable(name = "DESIG_COMP", joinColumns = @JoinColumn(name = "DESIG_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "COMP_ID", referencedColumnName = "ID"))
    private Set<Competency> competencies;

    @ManyToMany
    @JoinTable(name = "DESIG_RESP", joinColumns = @JoinColumn(name = "DESIG_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "RESP_ID", referencedColumnName = "ID"))
    private Set<Responsibility> responsibilities;

}
