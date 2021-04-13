package com.ltp.shapes.factory;

import com.ltp.shapes.model.entity.Point;
import com.ltp.shapes.model.entity.Triangle;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TriangleFactory {

    private static TriangleFactory instance;
    private static int idCounter = 0;

    public static TriangleFactory getInstance(){
        if(instance == null){
            instance = new TriangleFactory();
        }

        return instance;
    }

    public Triangle createTriangle(int x1, int y1, int x2, int y2, int x3, int y3){
        Point p1 = new Point(x1, y1), p2 = new Point(x2, y2), p3 = new Point(x3, y3);
        Triangle result = new Triangle(p1, p2, p3, idCounter++);
        return result;
    }

}
