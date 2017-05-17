package org.app.perf.repository;

import org.app.perf.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gauravbehl on 16/5/17.
 */

@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignationRespositoryTest {

    @Autowired
    private DesignationRepository designationRepository;

    @Autowired
    private ResponsibilityRepository responsibilityRepository;

    @Autowired
    private CompentencyRepository compentencyRepository;

    @Autowired
    private CompetencyTypeRepository competencyTypeRepository;


//    @Test
//    public void testSaveDesignation() {
//
//        Designation designation = createDesignation("Software Engineer");
//
//        designation.getResponsibilities().add(responsibilityRepository.findOne(1L));
//        designation.getResponsibilities().add(responsibilityRepository.findOne(2L));
//        designation.getResponsibilities().add(responsibilityRepository.findOne(3L));
//        designation.getResponsibilities().add(responsibilityRepository.findOne(4L));
//
//        designation.getCompetencies().add(compentencyRepository.findOne(1L));
//
//        designationRepository.save(designation);
//    }

    @Test
    public void testRemoveResponsibilityFromDesignation() {

        Designation designation = designationRepository.findOne(1L);

        System.out.println("a");
    }




    private Designation createDesignation(String title) {
        Designation designation = new Designation();
        designation.setTitle(title);
        return designation;
    }

    private Set<Responsibility> createResponsibilities() {
        Set<Responsibility> responsibilities = new HashSet<Responsibility>();
        responsibilities.add(createResponsibility("Maintain Code", "Desc"));
        responsibilities.add(createResponsibility("Testing", "Desc"));
        return responsibilities;
    }

    private Set<Competency> createCompentencies() {
        Set<Competency> competencies = new HashSet<Competency>();
        competencies.add(createCompentency("C1","D1", "Technical"));
        competencies.add(createCompentency("C2","D2", ""));
        competencies.add(createCompentency("C3","D2", "UI"));
        return competencies;
    }


    private Competency createCompentency(String title, String description, String compentencyTitle) {
        Competency competency = new Competency();
        competency.setTitle(title);
        competency.setDescription(description);
        competency.setCompentencyLevel(CompentencyLevel.ADVANCED);
        competency.setCompetencyType(createCompentencyType(compentencyTitle));
        compentencyRepository.save(competency);
        return competency;
    }

    private CompetencyType createCompentencyType(String title) {
        CompetencyType competencyType = new CompetencyType();
        competencyType.setTitle(title);
        competencyTypeRepository.save(competencyType);
        return competencyType;
    }

    private Responsibility createResponsibility(String title, String description) {
        Responsibility responsibility = new Responsibility();
        responsibility.setTitle(title);
        responsibility.setDescription(description);
        responsibilityRepository.save(responsibility);
        return responsibility;
    }


}
