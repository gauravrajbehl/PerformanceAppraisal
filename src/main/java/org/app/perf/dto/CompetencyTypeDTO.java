package org.app.perf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by gauravbehl on 26/5/17.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompetencyTypeDTO {

    private long id;

    private String title;

}
