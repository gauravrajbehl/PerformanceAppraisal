package org.app.perf.service.unit;

import org.app.perf.AbstractTests;
import org.app.perf.AbstractWebTests;
import org.app.perf.config.ApplicationConfiguration;
import org.app.perf.config.RepositoryConfiguration;
import org.app.perf.domain.*;
import org.app.perf.dto.CompetencyDTO;
import org.app.perf.dto.CompetencyTypeDTO;
import org.app.perf.exception.DataNotFoundException;
import org.app.perf.repository.CompentencyRepository;
import org.app.perf.service.CompetencyService;
import org.app.perf.service.CompetencyServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by gauravbehl on 19/5/17.
 */

public class CompetencyServiceImplTest extends AbstractWebTests {

    @MockBean
    private CompetencyServiceImpl competencyService;

    @Mock
    private ModelMapper modelMapperMock;

    @Mock
    private CompentencyRepository compentencyRepositoryMock;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


//    @Test
//    public void testFindCompetencyByIdShouldReturnCompetencyDTO() throws DataNotFoundException {
//
//        Competency competency =  createCompetencyObj();
//
////        CompetencyDTO competencyDTO ;//= new CompetencyDTO();
////        competencyDTO.setTitle("C1");
////        competencyDTO.setId(1);
//
//        when(compentencyRepositoryMock.findOne(anyLong())).thenReturn(competency);
//        //when(modelMapperMock.map(any(), any())).thenReturn(competencyDTO);
//
//        CompetencyDTO c = competencyService.findById(1L);
//        verify(compentencyRepositoryMock,times(1)).findOne(anyLong());
//        verify(modelMapperMock,times(1)).map(any(),any());
//    }
//
//
//    @Test
//    public void testFindCompetencyByInvalidIdShouldThrowException() throws DataNotFoundException {
//
//        when(compentencyRepositoryMock.findOne(anyLong())).thenThrow(DataNotFoundException.class);
//
//        CompetencyDTO c = competencyService.findById(1L);
//
//        verify(compentencyRepositoryMock,times(1)).findOne(anyLong());
//        verify(modelMapperMock,times(0)).map(any(), any());        //verify(competencyService.findById(-1L))
//    }
//
//
//    @Test
//    public void testFindAllCompetenciesShouldReturnCompetencies() {
//
//        List<Competency> competencies = new ArrayList<Competency>();
//        competencies.add(createNewCompetencyObj());
//        competencies.add(createNewCompetencyObj());
//
//        CompetencyDTO competencyDTO = new CompetencyDTO();
//
//        when(compentencyRepositoryMock.findAll()).thenReturn(competencies);
////        when(modelMapperMock.map(any(Competency.class),any(CompetencyDTO.class))
//        when(modelMapperMock.map(any(),any())).thenCallRealMethod();
//
//
////        verify(modelMapperMock,times(2)).map();
//
//        List<CompetencyDTO> competencyList = competencyService.findAll();
//
//        //Assert.assertEquals();
//
//    }
//
//    @Test
//    public void testSaveCompentencyShouldSaveCompetency() {
//
//        Competency competency = createCompetencyObj();
//
//        CompetencyDTO competencyDTO = new CompetencyDTO();
//        competencyDTO.setTitle("C1");
//
//        doNothing().when(compentencyRepositoryMock).save(competency);
//        doNothing().when(modelMapperMock).map(any(),any());
//
//        competencyService.save(competencyDTO);
//
//        verify(compentencyRepositoryMock,times(1)).save(competency);
//        verify(modelMapperMock,times(1)).map(any(),any());
//    }
//
//
//    private Competency createNewCompetencyObj() {
//
//        Competency competency =  new Competency();
//        competency.setId(1);
//        competency.setTitle("C1");
//        competency.setCompentencyLevel(CompentencyLevel.ADVANCED);
//        competency.setDescription("Desc");
//        competency.setCompetencyType(createCompetencyType());
//
//        return competency;
//    }
//
//    private Competency createCompetencyObj() {
//
//        Competency competency =  new Competency();
//        competency.setId(1);
//        competency.setTitle("C1");
//        competency.setCompentencyLevel(CompentencyLevel.ADVANCED);
//        competency.setDescription("Desc");
//        competency.setCompetencyType(createCompetencyType());
//        competency.setDesignations(null);
//
//        return competency;
//    }
//
//    private CompetencyType createCompetencyType() {
//
//        CompetencyType competencyType = new CompetencyType();
//        competencyType.setTitle("title");
//        competencyType.setId(1);
//
//        return competencyType;
//    }
//
//    private Designation createDesignation() {
//
//        Set<Responsibility> responsibilities = new HashSet<Responsibility>();
//        responsibilities.add(createResponsibility());
//
//        Designation designation = new Designation();
//        designation.setTitle("Desig");
//        designation.setResponsibilities(responsibilities);
//        designation.setCompetencies(null);
//
//        return designation;
//    }
//
//    private Responsibility createResponsibility() {
//        Responsibility responsibility = new Responsibility();
//        responsibility.setTitle("Resp");
//        responsibility.setDescription("Desc");
//        responsibility.setDesignations(null);
//        return responsibility;
//    }



}
