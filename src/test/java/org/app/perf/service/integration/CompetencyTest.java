package org.app.perf.service.integration;

import org.app.perf.AbstractTests;
import org.app.perf.domain.CompentencyLevel;
import org.app.perf.domain.Competency;
import org.app.perf.dto.CompetencyDTO;
import org.app.perf.dto.CompetencyTypeDTO;
import org.app.perf.exception.DataNotFoundException;
import org.app.perf.service.CompetencyService;
import org.app.perf.service.CompetencyServiceImpl;
import org.app.perf.service.CompetencyTypeService;
import org.app.perf.service.CompetencyTypeServiceImpl;
import org.app.perf.util.StringUtil;
import org.app.perf.util.TestDataGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

/**
 * Created by gauravbehl on 19/5/17.
 */

public class CompetencyTest extends AbstractTests {

    @Autowired
    private CompetencyService compentencyService;

    @Autowired
    private CompetencyTypeService competencyTypeService;


    //Save CompetencyType - success
    @Test
    public void test_save_competencytype_should_save() {
        CompetencyDTO competencyDTO = TestDataGenerator.createNewCompetencyDTO();
        competencyDTO.setCompetencyType(createNewCompetencyTypeDTO());

        compentencyService.save(competencyDTO);

        Assert.assertTrue(competencyDTO.getId() != 0);
        Assert.assertNotNull(competencyDTO.getId());
    }

    //Save duplicate CompetencyType - fail - throw exception
    @Test (expected = DataIntegrityViolationException.class)
    public void test_save_duplicate_competancy_should_throw_exception() {

        CompetencyDTO competencyDTO = TestDataGenerator.createNewCompetencyDTO("Duplicate");
        competencyDTO.setCompetencyType(createNewCompetencyTypeDTO("First"));

        CompetencyDTO competencyDTO2 = TestDataGenerator.createNewCompetencyDTO("Duplicate");
        competencyDTO2.setCompetencyType(createNewCompetencyTypeDTO("Second"));

        compentencyService.save(competencyDTO);
        Assert.assertTrue(competencyDTO.getId() != 0);
        compentencyService.save(competencyDTO2);
    }


    //Find competencytype by id
    @Test
    public void test_find_by_id_should_return_competency() throws DataNotFoundException {
        CompetencyDTO competencyDTO = TestDataGenerator.createNewCompetencyDTO("C2");
        competencyDTO.setCompetencyType(createNewCompetencyTypeDTO("CT3"));

        // Save competency and then find
        compentencyService.save(competencyDTO);

        CompetencyDTO c = compentencyService.findById(competencyDTO.getId());
        Assert.assertTrue(c.getId() == competencyDTO.getId());
    }

    //Find competencytype by an invalid id - throws an exception
    @Test (expected = DataNotFoundException.class)
    public void test_find_by_invalid_id_should_throw_exception() throws DataNotFoundException {
        CompetencyDTO c = compentencyService.findById(-1l);
    }


    //Save CompetencyType - success
    @Test
    public void test_update_competencytype_should_update() {
        CompetencyDTO competencyDTO = TestDataGenerator.createNewCompetencyDTO("test");
        competencyDTO.setCompetencyType(createNewCompetencyTypeDTO());

        compentencyService.save(competencyDTO);

        Assert.assertTrue(competencyDTO.getTitle().equals("test"));

        competencyDTO.setTitle("Updated-Title");

        compentencyService.save(competencyDTO);
        Assert.assertTrue(competencyDTO.getTitle().equals("Updated-Title"));
    }



    // Create, find, remove, find
    @Test(expected = DataNotFoundException.class)
    public void remove_competency_should_get_removed() throws DataNotFoundException{

        CompetencyDTO competencyDTO = TestDataGenerator.createNewCompetencyDTO("C2");
        competencyDTO.setCompetencyType(createNewCompetencyTypeDTO("CT3"));

        // Save competency and then find
        compentencyService.save(competencyDTO);

        //Find
        CompetencyDTO c = compentencyService.findById(competencyDTO.getId());
        Assert.assertNotNull(c.getId());

        //Remove
        compentencyService.remove(c);

        //Throw Exception
        CompetencyDTO d = compentencyService.findById(competencyDTO.getId());
    }

    //Test find all competencies
    @Test
    public void test_find_all_competencies_should_return_all_competencies() throws DataNotFoundException {
        CompetencyDTO c1 = TestDataGenerator.createNewCompetencyDTO("C1");
        c1.setCompetencyType(createNewCompetencyTypeDTO("CT1"));

        CompetencyDTO c2 = TestDataGenerator.createNewCompetencyDTO("C2");
        c2.setCompetencyType(createNewCompetencyTypeDTO("CT2"));

        compentencyService.save(c1);
        compentencyService.save(c2);

        List<CompetencyDTO> competencyDTOList = compentencyService.findAll();

        Assert.assertEquals(competencyDTOList.size(), 2);
    }


    //Test find all competencies - no data
    @Test (expected = DataNotFoundException.class)
    public void test_find_all_competencies_should_return_throw_exception() throws DataNotFoundException {
        List<CompetencyDTO> competencyDTOList = compentencyService.findAll();
    }



    private CompetencyTypeDTO createNewCompetencyTypeDTO() {
        CompetencyTypeDTO  competencyTypeDTO = TestDataGenerator.createNewCompetencyTypeDTO();
        competencyTypeService.save(competencyTypeDTO);
        return competencyTypeDTO;
    }


    private CompetencyTypeDTO createNewCompetencyTypeDTO(String title) {
        CompetencyTypeDTO  competencyTypeDTO = TestDataGenerator.createNewCompetencyTypeDTO(title);
        competencyTypeService.save(competencyTypeDTO);
        return competencyTypeDTO;
    }

}
