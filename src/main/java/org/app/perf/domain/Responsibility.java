package org.app.perf.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
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

    /*
        Inverse side of bi-directional relationship between <code>Designation</code> and
        <code>Responsibility</code>. Below mappedBy reference denotes that <code>Responsibility</code>
        is owned by <code>Designation</code>
     */
    //ToDo Remove Eager Fetch
    @ManyToMany(mappedBy = "responsibilities", fetch = FetchType.EAGER)
    private Set<Designation> designations;


    /*
        Two Responsibilities are considered equal if their title is same.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this) return true;

        if (!(obj instanceof Responsibility))
            return false;

        Responsibility responsibility = (Responsibility) obj;
        return Objects.equals(responsibility.getTitle(), this.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.title);
    }

}
