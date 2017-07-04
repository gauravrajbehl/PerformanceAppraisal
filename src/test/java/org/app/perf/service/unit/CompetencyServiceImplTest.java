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
import org.app.perf.util.TestDataGenerator;
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

    @InjectMocks
    private CompetencyServiceImpl competencyService;

    @Mock
    private ModelMapper modelMapperMock;

    @Mock
    private CompentencyRepository compentencyRepositoryMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_find_competency_by_id_should_return_one_competency() throws DataNotFoundException {

        Competency competency =  createCompetencyObj();
        CompetencyDTO competencyDTO = TestDataGenerator.createNewCompetencyDTO();

        when(compentencyRepositoryMock.findOne(anyLong())).thenReturn(competency);
        when(modelMapperMock.map(any(),any())).thenReturn(competencyDTO);

        CompetencyDTO dto = competencyService.findById(1L);

        verify(compentencyRepositoryMock,times(1)).findOne(anyLong());
        verify(modelMapperMock,times(1)).map(any(),any());

        verifyNoMoreInteractions(modelMapperMock);
        verifyNoMoreInteractions(compentencyRepositoryMock);
    }

    @Test (expected = DataNotFoundException.class)
    public void test_find_competency_by_invalid_id_should_throw_exception() throws DataNotFoundException {

        when(compentencyRepositoryMock.findOne(anyLong())).thenThrow(DataNotFoundException.class);

        CompetencyDTO dto = competencyService.findById(-1L);

        verify(compentencyRepositoryMock,times(1)).findOne(anyLong());
        verify(modelMapperMock,times(0)).map(any(),any());
    }


    @Test
    public void test_find_all_should_return_competencies() throws DataNotFoundException{

        List<CompetencyDTO> competencyDTOList = new ArrayList<CompetencyDTO>();
        competencyDTOList.add(TestDataGenerator.createNewCompetencyDTO("C1"));
        competencyDTOList.add(TestDataGenerator.createNewCompetencyDTO("C2"));

        List<Competency> competencyList = new ArrayList<Competency>();
        competencyList.add(createCompetencyObj());
        competencyList.add(createCompetencyObj());

        when(compentencyRepositoryMock.findAll()).thenReturn(competencyList);

        List<CompetencyDTO> list = competencyService.findAll();

        Assert.assertEquals(list.size(), 2);

        verify(compentencyRepositoryMock,times(1)).findAll();
        verifyNoMoreInteractions(compentencyRepositoryMock);

        verify(modelMapperMock,times(2)).map(any(),any());
        verifyNoMoreInteractions(modelMapperMock);
    }


    @Test (expected = DataNotFoundException.class)
    public void test_find_all_no_data_returned_should_throw_exception() throws DataNotFoundException{

        when(compentencyRepositoryMock.findAll()).thenThrow(DataNotFoundException.class);

        List<CompetencyDTO> list = competencyService.findAll();

        verify(compentencyRepositoryMock,times(1)).findAll();
        verifyNoMoreInteractions(compentencyRepositoryMock);

        verify(modelMapperMock,times(0)).map(any(),any());
    }

    @Test
    public void test_save_competency() {

        CompetencyDTO competencyDTO = TestDataGenerator.createNewCompetencyDTO();
        Competency competency =  createCompetencyObj();

        when(modelMapperMock.map(any(),any())).thenReturn(competency);
        when(compentencyRepositoryMock.save(competency)).thenReturn(competency);

        competencyService.save(competencyDTO);

        verify(modelMapperMock,times(1)).map(any(),any());
        verifyNoMoreInteractions(modelMapperMock);

        verify(compentencyRepositoryMock,times(1)).save(competency);
        verifyNoMoreInteractions(compentencyRepositoryMock);
    }


    @Test
    public void test_remove_competency_should_remove() {

        CompetencyDTO competencyDTO = TestDataGenerator.createNewCompetencyDTO();
        Competency competency =  createCompetencyObj();

        doNothing().when(compentencyRepositoryMock).delete(competency);
        when(modelMapperMock.map(any(),any())).thenReturn(competency);

        competencyService.remove(competencyDTO);

        verify(compentencyRepositoryMock,times(1)).delete(competency);
        verifyNoMoreInteractions(compentencyRepositoryMock);

        verify(modelMapperMock,times(1)).map(competencyDTO,Competency.class);
        verifyNoMoreInteractions(modelMapperMock);
    }

    private Competency createCompetencyObj() {

        Competency competency =  new Competency();
        competency.setId(1);
        competency.setTitle("C1");

        return competency;
    }

}
