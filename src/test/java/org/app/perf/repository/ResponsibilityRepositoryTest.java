package org.app.perf.repository;

import org.app.perf.domain.Responsibility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gauravbehl on 11/5/17.
 */
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponsibilityRepositoryTest {

    @Autowired
    private ResponsibilityRepository responsibilityRepository;

    @Test
    public void testNoResponsibilities() {
        long count = responsibilityRepository.count();
        Assert.assertEquals(count,0);
    }

//    @Test
//    public void testSaveResponsitility() {
//        Responsibility responsibility = new Responsibility();
//        responsibility.setTitle("Test Responsibility");
//        responsibility.setDescription("Set Description");
//        responsibilityRepository.save(responsibility);
//        Assert.assertNotNull(responsibility.getId());
//    }
//
//    @Test
//    public void testFindOne() {
//        Responsibility responsibility = new Responsibility();
//        responsibility.setTitle("Test Responsibility1");
//        responsibility.setDescription("Set Description");
//        responsibilityRepository.save(responsibility);
//
//        Responsibility newResponsibility = responsibilityRepository.findOne(responsibility.getId());
//        Assert.assertNotNull(newResponsibility);
//    }
//
//
//    @Test
//    public void testFindAll() {
//        Responsibility responsibilityOne = new Responsibility();
//        responsibilityOne.setTitle("Test Responsibility2");
//        responsibilityOne.setDescription("Set Description");
//        responsibilityRepository.save(responsibilityOne);
//
//        Responsibility responsibilityTwo = new Responsibility();
//        responsibilityTwo.setTitle("Test Responsibility 3");
//        responsibilityTwo.setDescription("Set Description 2");
//        responsibilityRepository.save(responsibilityTwo);
//
//        List<Responsibility> responsibilityList = (List<Responsibility>) responsibilityRepository.findAll();
//
//        Assert.assertEquals(responsibilityList.size(),2);
//
//    }
//
//
//    @Test(expected = DataIntegrityViolationException.class)
//    public void testDuplicateTitleNotPersisting() {
//
//        Responsibility responsibilityOne = new Responsibility();
//        responsibilityOne.setTitle("First Responsibility");
//        responsibilityOne.setDescription("Set Description");
//        responsibilityRepository.save(responsibilityOne);
//
//        Responsibility responsibilityTwo = new Responsibility();
//        responsibilityTwo.setTitle("First Responsibility");
//        responsibilityTwo.setDescription("Set Description 2");
//        responsibilityRepository.save(responsibilityTwo);
//    }
//
//    @Test
//    public void testDeleteById() {
//
//        responsibilityRepository.deleteAll();
//
//        Responsibility responsibility = new Responsibility();
//        responsibility.setTitle("Test Responsibility4");
//        responsibility.setDescription("Set Description");
//        responsibilityRepository.save(responsibility);
//
//        Assert.assertNotNull(responsibility);
//        Assert.assertNotNull(responsibility.getId());
//
//        responsibilityRepository.delete(responsibility.getId());
//
//        long count = responsibilityRepository.count();
//        Assert.assertEquals(count,0);
//
//    }
//
//
//    @Test
//    public void testDeleteByObjectRef() {
//
//        responsibilityRepository.deleteAll();
//
//        Responsibility responsibility = new Responsibility();
//        responsibility.setTitle("Test Responsibility5");
//        responsibility.setDescription("Set Description");
//        responsibilityRepository.save(responsibility);
//
//        Assert.assertNotNull(responsibility);
//        Assert.assertNotNull(responsibility.getId());
//
//        responsibilityRepository.delete(responsibility);
//
//        long count = responsibilityRepository.count();
//        Assert.assertEquals(count,0);
//
//    }
//
//
//
//    @After
//    public void cleanup() {
//        responsibilityRepository.deleteAll();
//    }

}
