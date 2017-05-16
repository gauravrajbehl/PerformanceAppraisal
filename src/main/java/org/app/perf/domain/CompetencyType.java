package org.app.perf.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by gauravbehl on 9/5/17.
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
