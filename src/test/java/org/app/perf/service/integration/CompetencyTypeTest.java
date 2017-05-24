package org.app.perf.service.integration;

import org.app.perf.AbstractTests;
import org.app.perf.domain.CompetencyType;
import org.app.perf.service.CompetencyTypeService;
import org.app.perf.service.CompetencyTypeServiceImpl;
import org.app.perf.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by gauravbehl on 22/5/17.
 */
public class CompetencyTypeTest extends AbstractTests {


    @Autowired
    private CompetencyTypeService competencyTypeServiceImpl;

    @Test
    public void testGetByTitle() {

        CompetencyType competencyType = competencyTypeServiceImpl.findByTitle("Technical");
        Assert.assertNotNull(competencyType);
    }

    @Test
    public void testSaveCompetencyType() {

        CompetencyType competencyType = new CompetencyType();
        competencyType.setTitle(StringUtil.getRandomString());

        competencyTypeServiceImpl.save(competencyType);

        Assert.assertNotNull(competencyType.getId());

    }

    @Test
    public void testUpdateCompetencyType() {

        String randomTitle = StringUtil.getRandomString();

        CompetencyType competencyType = new CompetencyType();
        competencyType.setTitle(randomTitle);

        competencyTypeServiceImpl.save(competencyType);

        Assert.assertNotNull(competencyType.getId());
        Assert.assertEquals(randomTitle, competencyType.getTitle());

        competencyType.setTitle(competencyType.getTitle().concat("-UPD"));
        competencyTypeServiceImpl.save(competencyType);

        Assert.assertEquals(randomTitle.concat("-UPD"), competencyType.getTitle());

    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testSaveDuplicateCompetencyTypeShouldThrowException() {

        String randomTitle = StringUtil.getRandomString();

        CompetencyType competencyType = new CompetencyType();
        competencyType.setTitle(randomTitle);

        competencyTypeServiceImpl.save(competencyType);


        CompetencyType competencyType2 = new CompetencyType();
        competencyType2.setTitle(randomTitle);

        competencyTypeServiceImpl.save(competencyType2);
    }


}
