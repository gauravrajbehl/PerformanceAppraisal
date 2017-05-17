package org.app.perf.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * An instance of <code>Competency</code> class represents a compentency or skill
 * for a job designation
 *
 * @author      Gaurav
 * @version     1.0
 * @since       16-May-2017
 */

@Entity
@Table(name = "COMPETENCY")
@Data
public class Competency {

    private static final int MAX_DESCRIPTION_LENGTH = 3000;

    /*
     Primary Key, Auto-generated using sequence
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;


    /*
      Competency Title
    */
    @Column(name = "TITLE", unique = true, nullable = false)
    private String title;


    /*
       Competency level i.e. level of compentency
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "LEVEL")
    private CompentencyLevel compentencyLevel;


    /*
        Competency type i.e. Technical, Managerial etc
     */
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "COMPETENCY_TYPE_ID")
    private CompetencyType competencyType;


    /*
        Descrition for the compentency
     */
    @Column(name = "DESCRIPTION", length = MAX_DESCRIPTION_LENGTH)
    private String description;


    /*
        Inverse side of bi-directional relationship between <code>Designation</code> and
        <code>Competency</code>. Below mappedBy reference denotes that <code>Competency</code>
        is owned by <code>Designation</code>
     */
    //ToDo Remove Eager Fetch
    @ManyToMany(mappedBy = "competencies", fetch = FetchType.EAGER)
    private Set<Designation> designations;


    /*
        Two Competencies are considered equal if their title is same.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (!(obj instanceof Competency))
            return false;

        Competency competency = (Competency)obj;

        return Objects.equals(competency.getTitle(), this.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.compentencyLevel);
    }
}
