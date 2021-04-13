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

    @Test
    public void validateLineFalseTest(){
        boolean result = ShapeValidator.validateLine("1, 3");
        AssertJUnit.assertFalse(result);
    }

    @Test
    public void validateLineTrueTest(){
        boolean result = ShapeValidator.validateLine("1 1,2 2,3 3");
        AssertJUnit.assertTrue(result);
    }
    @Test
    public void validateFileFalseTest(){
        boolean result = ShapeValidator.validateFile("ERROR HERE");
        AssertJUnit.assertFalse(result);
    }

    @Test
    public void validateFileTrueTest(){
        boolean result = ShapeValidator.validateFile("src/main/resources/data/input.txt");
        AssertJUnit.assertTrue(result);
    }



}
