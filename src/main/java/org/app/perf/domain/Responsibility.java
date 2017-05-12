package org.app.perf.domain;


import javax.persistence.*;

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
public class Responsibility {

    private static final int MAX_DESCRIPTION_LENGTH = 3000;

    /*
     Primary Key, Auto-generated using sequence
    */
    @Id
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
