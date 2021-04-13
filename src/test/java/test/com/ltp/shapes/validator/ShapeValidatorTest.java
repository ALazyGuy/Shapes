package test.com.ltp.shapes.validator;

import com.ltp.shapes.model.entity.Point;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.validator.ShapeValidator;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShapeValidatorTest {

    @DataProvider(name = "validateTriangleData")
    public Object[][] getObjects(){
        return new Object[][]{
                new Object[]{null, false},
                new Object[]{new Triangle(new Point(0, 0), new Point(0, 0), new Point(0, 0), -1), false},
                new Object[]{new Triangle(new Point(0, 0), new Point(1, 0), new Point(1, 1), -1), true}
        };
    }

    @Test(dataProvider = "validateTriangleData")
    public void validateTriangle(Triangle triangle, boolean expected){
        boolean actual = ShapeValidator.validateTriangle(triangle);
        AssertJUnit.assertEquals(expected, actual);
    }

}
