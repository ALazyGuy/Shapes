package test.com.ltp.shapes.repository;

import com.ltp.shapes.model.entity.Point;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.repository.TriangleRepository;
import com.ltp.shapes.repository.impl.TriangleRepositoryImpl;
import com.ltp.shapes.repository.specification.Specification;
import com.ltp.shapes.repository.specification.impl.IdSpecification;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

import java.util.List;

public class TriangleRepositoryTest {

    private Specification idSpecification;
    private TriangleRepository triangleRepository;

    @BeforeClass
    public void init(){
        idSpecification = new IdSpecification(1);
        triangleRepository = TriangleRepositoryImpl.getInstance();
    }

    @AfterMethod
    public void afterMethod(){
        triangleRepository.removeAll();
    }

    @BeforeMethod
    public void beforeMethod(){
        triangleRepository.save(new Triangle(new Point(0, 0), new Point(1, 1), new Point(0, 1), 1));
        triangleRepository.save(new Triangle(new Point(1, 1), new Point(2, 1), new Point(0, 1), 2));
        triangleRepository.save(new Triangle(new Point(2, 2), new Point(1, 3), new Point(1, 1), 3));
    }

    public void queryByIdTest(){
        int expected = 1;
        List<Triangle> actual = triangleRepository.query(idSpecification);
        AssertJUnit.assertEquals(expected, actual.get(0).getId());
    }

    @Test(description = "Test if returned only one element")
    public void queryByIdSizeTest(){
        int expected = 1;
        List<Triangle> actual = triangleRepository.query(idSpecification);
        AssertJUnit.assertEquals(expected, actual.size());
    }

    @Test
    public void removeTest(){
        Triangle triangle1 = triangleRepository.query(idSpecification).get(0);
        triangleRepository.remove(triangle1);
        int expected = 0;
        int actual = triangleRepository.query(idSpecification).size();
        AssertJUnit.assertEquals(expected, actual);
    }

    @AfterClass
    public void terminate(){
        idSpecification = null;
        triangleRepository = null;
    }

}
