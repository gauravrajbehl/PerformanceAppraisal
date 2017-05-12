package org.app.perf.domain;

/**
 * Created by gauravbehl on 9/5/17.
 */
public class Competency {

    private long id;

    private String title;

    private CompentencyLevel compentencyLevel;

    private CompetencyType competencyType;

    private String description;

    public CompetencyType getCompetencyType() {
        return competencyType;
    }

    public void setCompetencyType(CompetencyType competencyType) {
        this.competencyType = competencyType;
    }

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

    public CompentencyLevel getCompentencyLevel() {
        return compentencyLevel;
    }

    public void setCompentencyLevel(CompentencyLevel compentencyLevel) {
        this.compentencyLevel = compentencyLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
