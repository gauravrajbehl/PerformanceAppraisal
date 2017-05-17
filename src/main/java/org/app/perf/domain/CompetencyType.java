package org.app.perf.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * An instance of <code>CompetencyType</code> class represents type of Competency i.e. Technical, Managerial.
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


    /*
        Two Competency types are considered equal if their title is same.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this) return true;

        if (!(obj instanceof CompetencyType))
            return false;

        CompetencyType competencyType = (CompetencyType)obj;
        return Objects.equals(competencyType.getTitle(), this.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
