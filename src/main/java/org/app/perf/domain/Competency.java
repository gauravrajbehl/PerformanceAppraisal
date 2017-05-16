package org.app.perf.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by gauravbehl on 9/5/17.
 */
@Entity
@Table(name = "COMPETENCY")
@Data
public class Competency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE", unique = true, nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "LEVEL")
    private CompentencyLevel compentencyLevel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "COMPETENCY_TYPE_ID")
    private CompetencyType competencyType;

    @Column(name = "DESCRIPTION", length = 3000)
    private String description;

    @ManyToMany(mappedBy = "competencies")
    private Set<Designation> designations;
}
