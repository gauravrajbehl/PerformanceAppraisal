package org.app.perf.service.integration;

import org.app.perf.AbstractTests;
import org.app.perf.domain.Competency;
import org.app.perf.domain.Designation;
import org.app.perf.domain.Responsibility;
import org.app.perf.service.*;
import org.app.perf.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by gauravbehl on 22/5/17.
 */
public class DesignationTest extends AbstractTests {

//    @Autowired
//    private DesignationService designationService;
//
//    @Autowired
//    private ResponsibilityService responsibilityService;
//
//    @Autowired
//    private CompetencyService competencyService;
//
//    @Test
//    public void testFetchByTitle() {
//        Designation designation = designationService.findByTitle("Dummy Designation");
//        Assert.assertNotNull(designation);
//    }
//
//
//    @Test
//    public void testSave() {
//
//        Designation d = new Designation();
//        d.setTitle(StringUtil.getRandomString());
//
//        Competency c = competencyService.findByTitle("Spring Framework");
//        d.getCompetencies().add(c);
//
//        Responsibility r = responsibilityService.findResponsibilityByTitle("Software Delivery");
//        d.getResponsibilities().add(r);
//
//        designationService.save(d);
//        Assert.assertNotNull(d.getId());
//
//    }
//
//    @Test
//    public void testRemoveResponsibilityOrCompetency() {
//
//        Designation d = new Designation();
//        String title = StringUtil.getRandomString();
//        d.setTitle(title);
//
//        d.getCompetencies().add(competencyService.findByTitle("Spring Framework"));
//        d.getCompetencies().add(competencyService.findByTitle("Dummy Competency"));
//
//        Responsibility r = responsibilityService.findResponsibilityByTitle("Software Delivery");
//        d.getResponsibilities().add(r);
//
//        designationService.save(d);
//        Assert.assertNotNull(d.getId());
//
//        Designation des = designationService.findByTitle(title);
//        Assert.assertEquals(des.getCompetencies().size(),2);
//
//        d.getCompetencies().remove(competencyService.findByTitle("Dummy Competency"));
//        designationService.save(d);
//
//        Designation updDesig = designationService.findByTitle(title);
//        Assert.assertEquals(updDesig.getCompetencies().size(),1);
//    }
//
//    @Test
//    public void testRemovingDesignationShouldNotRemoveResponsibilityOrCompetency() {
//
//        Designation d = new Designation();
//        String title = StringUtil.getRandomString();
//        d.setTitle(title);
//
//        d.getCompetencies().add(competencyService.findByTitle("Spring Framework"));
//        d.getCompetencies().add(competencyService.findByTitle("Dummy Competency"));
//
//        Responsibility r = responsibilityService.findResponsibilityByTitle("Software Delivery");
//        d.getResponsibilities().add(r);
//
//        designationService.save(d);
//        Assert.assertNotNull(d.getId());
//
//        designationService.delete(d);
//        Designation delDesig = designationService.findByTitle(title);
//        Assert.assertNull(delDesig);
//
//        Competency c1 = competencyService.findByTitle("Spring Framework");
//        Competency c2 = competencyService.findByTitle("Dummy Competency");
//
//        Assert.assertNotNull(c1);
//        Assert.assertNotNull(c2);
//
//        Responsibility resp = responsibilityService.findResponsibilityByTitle("Software Delivery");
//        Assert.assertNotNull(resp);
//    }


}
