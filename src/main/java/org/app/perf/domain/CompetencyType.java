package org.app.perf.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * An instance of <code>CompetencyType</code> class represents a skill.
 *
 * @author      Gaurav
 * @version     1.0
 * @since       16-May-2017
 */
@Data
@Entity
@Table(name = "COMPETENCY_TYPE")
public class CompetencyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE", unique = true, nullable = false)
    private String title;

}
