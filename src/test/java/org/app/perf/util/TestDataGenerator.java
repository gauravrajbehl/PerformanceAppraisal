package org.app.perf.util;

import org.app.perf.domain.CompentencyLevel;
import org.app.perf.dto.CompetencyDTO;
import org.app.perf.dto.CompetencyTypeDTO;

/**
 * Created by gauravbehl on 30/6/17.
 */
public class TestDataGenerator {


    public static CompetencyDTO createNewCompetencyDTO() {
        return CompetencyDTO.builder().title("test").description("Desc")
                .compentencyLevel(CompentencyLevel.ADVANCED).build();
    }

    public static CompetencyTypeDTO createNewCompetencyTypeDTO() {
        return CompetencyTypeDTO.builder().title("Test").build();
    }


    public static CompetencyDTO createNewCompetencyDTO(String title) {
        return CompetencyDTO.builder().title(title).description("Desc")
                .compentencyLevel(CompentencyLevel.ADVANCED).build();
    }

    public static CompetencyTypeDTO createNewCompetencyTypeDTO(String title) {
        return CompetencyTypeDTO.builder().title(title).build();
    }

    public static CompetencyDTO createNewCompetencyDTO(Long id, String title) {
        return CompetencyDTO.builder().id(id).title(title).description("Desc")
                .compentencyLevel(CompentencyLevel.ADVANCED).build();
    }

    public static CompetencyTypeDTO createNewCompetencyTypeDTO(Long id, String title) {
        return CompetencyTypeDTO.builder().id(id).title(title).build();
    }


}
