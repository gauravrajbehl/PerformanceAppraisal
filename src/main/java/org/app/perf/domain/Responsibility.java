package org.app.perf.domain;



import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * An instance of <code>Responsibility</code> class represents a responsibility
 * for a job designation
 *
 * @author      Gaurav
 * @version     1.0
 * @since       10-May-2017
 */

@Entity
@Table (name = "RESPONSIBILITY")
@Data
public class Responsibility {

    private static final int MAX_DESCRIPTION_LENGTH = 3000;

    /*
     Primary Key, Auto-generated using sequence
    */
    @Id
    @Column(name = "ID")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    /*
      Responsibility Title
    */
    @Column (name = "TITLE", nullable = false, unique = true)
    private String title;

    /*
      Responsibility Description
    */
    @Column (name = "DESCRIPTION", length = MAX_DESCRIPTION_LENGTH)
    private String description;

    @ManyToMany(mappedBy = "responsibilities")
    private Set<Designation> designations;

}
