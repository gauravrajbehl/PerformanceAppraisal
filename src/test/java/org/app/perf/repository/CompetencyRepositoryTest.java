package org.app.perf.repository;

import org.app.perf.domain.CompentencyLevel;
import org.app.perf.domain.Competency;
import org.app.perf.domain.CompetencyType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by gauravbehl on 17/5/17.
 */
@ActiveProfiles("dev")
@SpringBootTest
@RunWith(SpringRunner.class)
public class CompetencyRepositoryTest {

    @Autowired
    private CompentencyRepository compentencyRepository;

    @Autowired
    private CompetencyTypeRepository competencyTypeRepository;

    @Test
    public void testSaveCompentency() {

        Competency competency = new Competency();
        competency.setTitle("Spring Framework");
        competency.setCompentencyLevel(CompentencyLevel.INTERMEDIATE);
        competency.setDescription("Description");

        CompetencyType competencyType = competencyTypeRepository.findOne(1L);
        competency.setCompetencyType(competencyType);

        compentencyRepository.save(competency);

    }


}
