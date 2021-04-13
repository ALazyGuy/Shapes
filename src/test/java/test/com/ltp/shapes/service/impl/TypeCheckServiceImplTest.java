package test.com.ltp.shapes.service.impl;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.model.entity.Point;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.service.TypeCheckService;
import com.ltp.shapes.service.impl.TypeCheckServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TypeCheckServiceImplTest {

    private Triangle triangleRight, isoscelesTriangle, acuteAngledTriangle, obtuseTriangle;
    private TypeCheckService typeCheckService;

    @BeforeClass
    public void init(){
        typeCheckService = TypeCheckServiceImpl.getInstance();
        triangleRight = new Triangle(new Point(0, 0), new Point(1, 1), new Point(1, 0));
        isoscelesTriangle = new Triangle(new Point(0, 0), new Point(1, 2), new Point(2, 0));
        acuteAngledTriangle = new Triangle(new Point(0, 0), new Point(1, 0), new Point(2, 1));
        obtuseTriangle = new Triangle(new Point(0, 0), new Point(2, 0), new Point(1, 1));
    }

    @Test
    public void isAcuteAngledTriangleTest() throws ShapeException {
        boolean actual = typeCheckService.isAcuteAngledTriangle(acuteAngledTriangle);
        AssertJUnit.assertTrue(actual);
    }

    @Test
    public void isRightTriangleTest() throws ShapeException{
        boolean actual = typeCheckService.isAcuteAngledTriangle(triangleRight);
        AssertJUnit.assertTrue(actual);
    }

    @Test
    public void isEquilateralTriangleTest() throws ShapeException{
        boolean actual = typeCheckService.isEquilateralTriangle(isoscelesTriangle);
        AssertJUnit.assertFalse(actual);
    }

    @Test
    public void isIsoscelesTriangleTest() throws ShapeException{
        boolean actual = typeCheckService.isIsoscelesTriangle(isoscelesTriangle);
        AssertJUnit.assertTrue(actual);
    }

    @Test
    public void isObtuseTriangleTest() throws ShapeException{
        boolean actual = typeCheckService.isObtuseTriangle(obtuseTriangle);
        AssertJUnit.assertTrue(actual);
    }

    @AfterClass
    public void terminate(){
        typeCheckService = null;
        triangleRight = null;
        acuteAngledTriangle = null;
        isoscelesTriangle = null;
    }

}
