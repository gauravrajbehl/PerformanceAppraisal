package org.app.perf.service.integration;

import org.app.perf.AbstractTests;
import org.app.perf.dto.CompetencyTypeDTO;
import org.app.perf.exception.DataNotFoundException;
import org.app.perf.service.CompetencyTypeService;
import org.app.perf.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

/**
 * Created by gauravbehl on 22/5/17.
 */
public class CompetencyTypeTest extends AbstractTests {


    @Autowired
    private CompetencyTypeService competencyTypeService;

    @Test
    public void testSaveCompetencyType() {

        CompetencyTypeDTO competencyTypeDTO = createCompetencyTypeDTO();

        competencyTypeService.save(competencyTypeDTO);

        Assert.assertNotNull(competencyTypeDTO.getId());
    }

    @Test
    public void testGetByTitle() throws DataNotFoundException {

        CompetencyTypeDTO competencyTypeDTO = createCompetencyTypeDTO();
        competencyTypeService.save(competencyTypeDTO);

        CompetencyTypeDTO savedCompetencyTypeDTO = competencyTypeService.findByTitle(competencyTypeDTO.getTitle());
        Assert.assertNotNull(savedCompetencyTypeDTO);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testSaveDuplicateCompetencyTypeShouldThrowException() {

        CompetencyTypeDTO competencyTypeDTO = createCompetencyTypeDTO();

        competencyTypeService.save(competencyTypeDTO);


        CompetencyTypeDTO competencyType2 = new CompetencyTypeDTO();
        competencyType2.setTitle(competencyTypeDTO.getTitle());

        competencyTypeService.save(competencyType2);
    }


    @Test(expected = DataNotFoundException.class)
    public void testUpdateCompetencyType() throws DataNotFoundException {

        CompetencyTypeDTO competencyTypeDTO = competencyTypeService.findById(1L);
        String oldTitle = competencyTypeDTO.getTitle();

        String newTitle = competencyTypeDTO.getTitle().concat("-UPD");

        competencyTypeDTO.setTitle(newTitle);
        competencyTypeService.save(competencyTypeDTO);

        Assert.assertEquals(newTitle, competencyTypeDTO.getTitle());
    }


    @Test
    public void testFindAll() throws DataNotFoundException{
        List<CompetencyTypeDTO> list = competencyTypeService.findAll();
        Assert.assertTrue(list.size() > 0);
        Assert.assertTrue(list.get(0) instanceof CompetencyTypeDTO);
    }

    @Test(expected = DataNotFoundException.class)
    public void testNotFoundById() throws DataNotFoundException{
        competencyTypeService.findById(-1L);
    }


    @Test(expected = DataNotFoundException.class)
    public void testNotFoundByTitle() throws DataNotFoundException{
        competencyTypeService.findByTitle("Dummy");
    }


    @Test
    public void testUserExists() {
        CompetencyTypeDTO competencyTypeDTO = createCompetencyTypeDTO();
        boolean exists = competencyTypeService.exists(competencyTypeDTO);
        Assert.assertFalse(exists);
    }


    private CompetencyTypeDTO createCompetencyTypeDTO() {
        CompetencyTypeDTO competencyTypeDTO = new CompetencyTypeDTO();
        competencyTypeDTO.setTitle(StringUtil.getRandomString());
        return competencyTypeDTO;
    }

}