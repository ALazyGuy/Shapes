package test.com.ltp.shapes.service.impl;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.model.entity.Point;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.service.impl.CalculateServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculateServiceImplTest {

    private CalculateServiceImpl calculateService;
    private Triangle triangle;

    @BeforeClass
    public void init(){
        calculateService = CalculateServiceImpl.getInstance();
        triangle = new Triangle(new Point(0, 0), new Point(1, 1), new Point(1, 0));
    }

    @Test(description = "Calculating perimeter here")
    public void calculatePerimeterTest() throws ShapeException {
        double expected = 3.42;
        double actual = calculateService.calculatePerimeter(triangle);
        AssertJUnit.assertEquals(expected, actual, 0.01);
    }

    @Test(expectedExceptions = ShapeException.class, description = "Calculating perimeter, ShapeException must be thrown")
    public void calculatePerimeterExceptionTest() throws ShapeException {
        calculateService.calculatePerimeter(null);
    }

    @Test(description = "Calculating area here")
    public void calculateAreaTest() throws ShapeException {
        double expected = 0.5;
        double actual = calculateService.calculateArea(triangle);
        AssertJUnit.assertEquals(expected, actual, 0.000001);
    }

    @Test(expectedExceptions = ShapeException.class, description = "Calculating area, ShapeException must be thrown")
    public void calculateAreaExceptionTest() throws ShapeException {
        calculateService.calculateArea(null);
    }

    @AfterClass
    public void terminate(){
        calculateService = null;
    }
}
