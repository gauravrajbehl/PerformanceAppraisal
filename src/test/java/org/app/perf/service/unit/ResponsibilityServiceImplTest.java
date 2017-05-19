package org.app.perf.service.unit;

import org.app.perf.domain.Responsibility;
import org.app.perf.repository.ResponsibilityRepository;
import org.app.perf.service.ResponsibilityServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by gauravbehl on 18/5/17.
 */
@RunWith(SpringRunner.class)
public class ResponsibilityServiceImplTest {

    @InjectMocks
    private ResponsibilityServiceImpl hibernateResponsibilityService;

    @Mock
    private ResponsibilityRepository responsibilityRepositoryMock;

    @Test
    public void testFindResponsibilityByTitle() {

        Responsibility responsibility = new Responsibility();
        responsibility.setTitle("Resp1");

        when(responsibilityRepositoryMock.findByTitle("Resp1")).thenReturn(responsibility);

        Responsibility foundResponsibility = hibernateResponsibilityService.findResponsibilityByTitle("Resp1");

        assertThat(foundResponsibility.getTitle(), is("Resp1"));
    }


    @Test
    public void testNoResponsibilityFoundByTitle() {

        String title = "Dummy";

        Responsibility responsibility = new Responsibility();
        responsibility.setTitle(title);

        when(responsibilityRepositoryMock.findByTitle(title)).thenReturn(null);

        Responsibility resp = hibernateResponsibilityService.findResponsibilityByTitle(title);

        Assert.assertNull(resp);
    }

    @Test
    public void testFindAllResponsibilities() {

        Responsibility responsibility1 = new Responsibility();
        responsibility1.setTitle("R1");
        responsibility1.setDescription("Set Description");

        Responsibility responsibility2 = new Responsibility();
        responsibility2.setTitle("R2");
        responsibility2.setDescription("Set Description");

        List<Responsibility> responsibilityArrayList = new ArrayList<Responsibility>();
        responsibilityArrayList.add(responsibility1);
        responsibilityArrayList.add(responsibility2);

        when(responsibilityRepositoryMock.findAll()).thenReturn(responsibilityArrayList);

        Iterable<Responsibility> list = hibernateResponsibilityService.findAllResponsibilities();

        List<Responsibility> found = (List<Responsibility>)list;

        Assert.assertEquals(found.size(),2);

    }

    @Test
    public void testFindAllResponsibilitiesNoResponsibilitiesExist() {

        List<Responsibility> responsibilityArrayList = new ArrayList<Responsibility>();

        when(responsibilityRepositoryMock.findAll()).thenReturn(responsibilityArrayList);

        Iterable<Responsibility> list = hibernateResponsibilityService.findAllResponsibilities();

        List<Responsibility> found = (List<Responsibility>)list;

        Assert.assertEquals(found.size(),0);

    }


    @Test
    public void testSaveResponsibility() {

        Responsibility responsibility = new Responsibility();
        responsibility.setTitle("R1");
        responsibility.setDescription("Set Description");

        responsibilityRepositoryMock.save(responsibility);

        hibernateResponsibilityService.saveResponsibility(responsibility);

        Assert.assertNotNull(responsibility);

    }

    @Test
    public void testSaveDuplicateResponsibilityTitleThrowsRunException() {

        Responsibility responsibility1 = new Responsibility();
        responsibility1.setTitle("R1");
        responsibility1.setDescription("Set Description");

        Responsibility responsibility2 = new Responsibility();
        responsibility2.setTitle("R1");
        responsibility2.setDescription("Set Description");

        responsibilityRepositoryMock.save(responsibility1);

        doThrow(DataIntegrityViolationException.class).when(responsibilityRepositoryMock).save(responsibility2);

    }

}
