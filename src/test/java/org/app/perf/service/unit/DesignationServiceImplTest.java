package org.app.perf.service.unit;

import org.app.perf.domain.Designation;
import org.app.perf.repository.DesignationRepository;
import org.app.perf.service.DesignationServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

/**
 * Created by gauravbehl on 19/5/17.
 */

@RunWith(SpringRunner.class)
public class DesignationServiceImplTest {

    @InjectMocks
    private DesignationServiceImpl designationService;

    @Mock
    private DesignationRepository designationRepositoryMock;


    @Test
    public void  testFindByTitle() {

        Designation designation = new Designation();
        designation.setTitle("D1");

        when(designationRepositoryMock.findByTitle("D1")).thenReturn(designation);

        Designation d = designationRepositoryMock.findByTitle("D1");

        Assert.assertEquals(d.getTitle(), "D1");

    }


    @Test
    public void  testNoDesignationByTitleFound() {

        when(designationRepositoryMock.findByTitle("D100")).thenReturn(null);

        Designation d = designationRepositoryMock.findByTitle("D100");

        Assert.assertNull(d);
    }

}
