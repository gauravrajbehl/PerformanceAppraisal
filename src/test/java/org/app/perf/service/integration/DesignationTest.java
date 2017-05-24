package org.app.perf.service.integration;

import org.app.perf.AbstractTests;
import org.app.perf.domain.Designation;
import org.app.perf.service.DesignationServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gauravbehl on 22/5/17.
 */
public class DesignationTest extends AbstractTests {

    @Autowired
    private DesignationServiceImpl designationService;

    @Test
    public void testFetchByTitle() {
        Designation designation = designationService.findByTitle("Software Engineer");
        Assert.assertNotNull(designation);
    }


}
