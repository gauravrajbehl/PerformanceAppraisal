package org.app.perf.dto;

import lombok.Data;
import org.app.perf.domain.CompentencyLevel;

import java.util.Set;

/**
 * Created by gauravbehl on 21/6/17.
 */
@Data
public class CompetencyDTO {

    private long id;

    private String title;

    private CompentencyLevel compentencyLevel;

    private CompetencyTypeDTO competencyType;

    private String description;

    //private Set<DesignationDTO> designations;

}
