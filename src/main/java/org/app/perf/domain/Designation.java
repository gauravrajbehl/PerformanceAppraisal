package org.app.perf.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * An instance of <code>Designation</code> class represents a job designation.
 * A job designation is composed of a mix of job responsibilities and competencies (skills)
 *
 * @author      Gaurav
 * @version     1.0
 * @since       16-May-2017
 */
@Entity
@Table(name = "DESIGNATION")
@Data
public class Designation {

    /*
     Primary Key, Auto-generated using sequence
    */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    /*
      Designation Title
    */
    @Column(name = "TITLE", unique = true, nullable = false)
    private String title;

    /*
        Designation can have a list of competencies required for the designation
     */
    //ToDo Remove Eager Fetch
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "DESIG_COMP", joinColumns = @JoinColumn(name = "DESIG_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "COMP_ID", referencedColumnName = "ID"))
    private Set<Competency> competencies = new HashSet<Competency>();

    /*
        Designation can have a list of responsibilities required for the designation
     */
    //ToDo Remove Eager Fetch
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "DESIG_RESP", joinColumns = @JoinColumn(name = "DESIG_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "RESP_ID", referencedColumnName = "ID"))
    private Set<Responsibility> responsibilities = new HashSet<Responsibility>();


    /*
        Two Designations are considered equal if their title is same.
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if ( !(obj instanceof Designation) )
            return false;

        Designation desig = (Designation) obj;

        return Objects.equals(desig.getTitle(), this.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}
