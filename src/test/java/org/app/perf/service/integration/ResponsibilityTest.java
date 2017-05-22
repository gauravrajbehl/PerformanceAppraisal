package org.app.perf.service.integration;

import org.app.perf.AbstractTests;
import org.app.perf.domain.Responsibility;
import org.app.perf.service.ResponsibilityServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

/**
 * Created by gauravbehl on 19/5/17.
 */

public class ResponsibilityTest extends AbstractTests {

    @Autowired
    private ResponsibilityServiceImpl responsibilityService;

    private String titleToDelete = "To Delete";


    @Test
    public void testSave() {

        Responsibility responsibility = new Responsibility();
        responsibility.setTitle(titleToDelete);
        responsibility.setDescription("Test Desc");

        responsibilityService.saveResponsibility(responsibility);

        Assert.assertNotNull(responsibility.getId());
    }

    @Test
    public void testFindByTitle() {

        Responsibility responsibility = responsibilityService.findResponsibilityByTitle("Software Delivery");
        Assert.assertNotNull(responsibility);

    }

    @Test
    public void testFindingNotExistingResponsibilityByTitle() {

        Responsibility responsibility = responsibilityService.findResponsibilityByTitle("Junk");
        Assert.assertNull(responsibility);

    }

    @Test
    public void testFindAllResponsibilities() {

        List<Responsibility> responsibilityList = (List<Responsibility>) responsibilityService.findAllResponsibilities();
        Assert.assertTrue(responsibilityList.size() > 0);
    }

    @Test (expected = DataIntegrityViolationException.class)
    public void testSaveDuplicateTitleResponsibility() {

        Responsibility responsibility = new Responsibility();
        responsibility.setTitle("Software Delivery");
        responsibility.setDescription("Duplicate Title");

        responsibilityService.saveResponsibility(responsibility);
    }

    @Test
    public void testUpdateResponsibility() {

        Responsibility responsibility = responsibilityService.findResponsibilityByTitle("Software Delivery");

        String newDesc = responsibility.getDescription().concat(" - Update");

        responsibility.setDescription(newDesc);
        responsibilityService.saveResponsibility(responsibility);

        Assert.assertEquals(newDesc, responsibility.getDescription());
    }


    @Test
    public void deleteResponsibility() {

        Responsibility responsibility = responsibilityService.findResponsibilityByTitle(titleToDelete);

        responsibilityService.deleteResponsibility(responsibility);

        responsibility = responsibilityService.findResponsibilityByTitle(titleToDelete);

        Assert.assertNull(responsibility);

    }


}
