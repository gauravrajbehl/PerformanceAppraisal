package org.app.perf.service.integration;

import org.app.perf.AbstractTests;
import org.app.perf.domain.CompentencyLevel;
import org.app.perf.domain.Competency;
import org.app.perf.domain.CompetencyType;
import org.app.perf.service.CompentencyServiceImpl;
import org.app.perf.service.CompentencyTypeServiceImpl;
import org.app.perf.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by gauravbehl on 19/5/17.
 */

public class CompetencyTest extends AbstractTests {

    @Autowired
    private CompentencyServiceImpl compentencyService;

    @Autowired
    private CompentencyTypeServiceImpl compentencyTypeService;

    private static final String COMPTENCY_TYPE_TESTING = "Testing";

    @Test
    public void testFindbyTitle() {
        Competency competency = compentencyService.findByTitle("Spring Framework");
        Assert.assertNotNull(competency);
    }

    @Test
    public void testSave() {

        String title = StringUtil.getRandomString();

        Competency competency = new Competency();
        competency.setTitle(title);
        competency.setDescription("Comp Desc");
        competency.setCompentencyLevel(CompentencyLevel.ADVANCED);
        competency.setCompetencyType(compentencyTypeService.findByTitle(COMPTENCY_TYPE_TESTING));

        compentencyService.save(competency);

        Competency c = compentencyService.findByTitle(title);
        Assert.assertEquals(c.getId(), competency.getId());
        Assert.assertEquals(c.getTitle(),competency.getTitle());
        Assert.assertEquals(c.getCompentencyLevel(), competency.getCompentencyLevel());
        Assert.assertEquals(c.getCompetencyType(), competency.getCompetencyType());
        Assert.assertEquals(c.getDescription(), competency.getDescription());
    }


    @Test (expected = DataIntegrityViolationException.class)
    public void testSaveDuplicateCompetancy() {

        Competency competency = compentencyService.findByTitle("Spring Framework");
        Assert.assertNotNull(competency);

        Competency c = new Competency();
        c.setTitle(competency.getTitle());
        c.setCompentencyLevel(competency.getCompentencyLevel());
        c.setDescription(competency.getDescription());
        c.setCompetencyType(competency.getCompetencyType());

        compentencyService.save(c);
    }


    @Test
    public void testUpdate() {

        Competency competency = compentencyService.findByTitle("Spring Framework");
        String newDescription = competency.getDescription().concat(" - Update");

        competency.setDescription(newDescription);
        compentencyService.save(competency);

        Competency c = compentencyService.findByTitle("Spring Framework");
        Assert.assertEquals(c.getDescription(),newDescription);
    }


    @Test
    public void removeCompetency() {

        String title = StringUtil.getRandomString();

        Competency competency = new Competency();
        competency.setTitle(title);
        competency.setDescription("Comp Desc");
        competency.setCompentencyLevel(CompentencyLevel.ADVANCED);
        competency.setCompetencyType(compentencyTypeService.findByTitle(COMPTENCY_TYPE_TESTING));

        compentencyService.save(competency);

        Assert.assertNotNull(competency.getId());

        compentencyService.remove(competency);

        Competency f = compentencyService.findByTitle(title);
        Assert.assertNull(f);
    }

}
