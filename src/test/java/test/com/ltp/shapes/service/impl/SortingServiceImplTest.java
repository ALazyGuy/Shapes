package test.com.ltp.shapes.service.impl;

import com.ltp.shapes.model.entity.Point;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.service.SortingService;
import com.ltp.shapes.service.impl.SortingServiceImpl;
import com.ltp.shapes.util.SortingMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SortingServiceImplTest {

    private SortingService sortingService;
    private List<Triangle> input, expectedByX, expectedByY, expectedById;

    @BeforeClass
    public void init(){
        sortingService = SortingServiceImpl.getInstance();

        expectedByX = new ArrayList<>();
        expectedByX.add(new Triangle(new Point(0, 9), new Point(1, 1), new Point(2, 2), 2));
        expectedByX.add(new Triangle(new Point(3, 5), new Point(1, 1), new Point(2, 2), 3));
        expectedByX.add(new Triangle(new Point(6, 1), new Point(1, 1), new Point(2, 2), 1));

        expectedByY = new ArrayList<>();
        expectedByY.add(new Triangle(new Point(6, 1), new Point(1, 1), new Point(2, 2), 1));
        expectedByY.add(new Triangle(new Point(3, 5), new Point(1, 1), new Point(2, 2), 3));
        expectedByY.add(new Triangle(new Point(0, 9), new Point(1, 1), new Point(2, 2), 2));

        expectedById = new ArrayList<>();
        expectedById.add(new Triangle(new Point(6, 1), new Point(1, 1), new Point(2, 2), 1));
        expectedById.add(new Triangle(new Point(0, 9), new Point(1, 1), new Point(2, 2), 2));
        expectedById.add(new Triangle(new Point(3, 5), new Point(1, 1), new Point(2, 2), 3));
    }

    @BeforeMethod
    public void initMethod(){
        input = new ArrayList<>();
        input.add(new Triangle(new Point(0, 9), new Point(1, 1), new Point(2, 2), 2));
        input.add(new Triangle(new Point(6, 1), new Point(1, 1), new Point(2, 2), 1));
        input.add(new Triangle(new Point(3, 5), new Point(1, 1), new Point(2, 2), 3));
    }

    @Test
    public void sortByXTest(){
        List<Triangle> actual = sortingService.sort(input, SortingMethod.X_COORDINATE);
        AssertJUnit.assertArrayEquals(expectedByX.toArray(), actual.toArray());
    }

    @Test
    public void sortByYTest(){
        List<Triangle> actual = sortingService.sort(input, SortingMethod.Y_COORDINATE);
        AssertJUnit.assertArrayEquals(expectedByY.toArray(), actual.toArray());
    }

    @Test
    public void sortByIdTest(){
        List<Triangle> actual = sortingService.sort(input, SortingMethod.ID);
        AssertJUnit.assertArrayEquals(expectedById.toArray(), actual.toArray());
    }

    @AfterClass
    public void terminate(){
        sortingService = null;
    }

}
