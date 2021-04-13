package com.ltp.shapes.factory;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.model.entity.Point;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.observer.impl.CoordinatesChangeObserver;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShapeFactory {

    private static ShapeFactory instance;
    private static int idCounter = 0;

    public static ShapeFactory getInstance(){
        if(instance == null){
            instance = new ShapeFactory();
        }

        return instance;
    }

    public Triangle createShape(String name, int ...args) throws ShapeException {
        if(name.equals("triangle")){
            return createTriangle(args[0], args[1], args[2], args[3], args[4], args[5]);
        }
        throw new ShapeException("Unknown shape type");
    }

    private Triangle createTriangle(int x1, int y1, int x2, int y2, int x3, int y3){
        Point p1 = new Point(x1, y1), p2 = new Point(x2, y2), p3 = new Point(x3, y3);
        Triangle result = new Triangle(p1, p2, p3, idCounter++);
        result.addObserver(new CoordinatesChangeObserver());
        return result;
    }

}
