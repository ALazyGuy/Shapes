package test.com.ltp.shapes.observer.impl;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.factory.ShapeFactory;
import com.ltp.shapes.model.entity.Point;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.service.impl.CalculateServiceImpl;
import com.ltp.shapes.warehouse.Warehouse;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class CoordinatesChangeObserverTest {

    @Test
    public void updateTest() throws ShapeException {
        Triangle triangle = ShapeFactory.getInstance().createShape("triangle", 0, 0, 1, 1, 2, 2);
        triangle.setP2(new Point(10, 10));
        double expectedArea = CalculateServiceImpl.getInstance().calculateArea(triangle);
        double actualArea = Warehouse.getInstance().getArea(triangle.getId());
        AssertJUnit.assertEquals(expectedArea, actualArea);
    }

}
