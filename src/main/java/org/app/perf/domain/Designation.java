package org.app.perf.domain;

import java.util.Set;

/**
 * Created by gauravbehl on 9/5/17.
 */
public class Designation {

    private long id;

    private String title;

    private Set<Competency> competencies;

    private Set<Responsibility> responsibilities;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Competency> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(Set<Competency> competencies) {
        this.competencies = competencies;
    }

    public Set<Responsibility> getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(Set<Responsibility> responsibilities) {
        this.responsibilities = responsibilities;
    }
}
