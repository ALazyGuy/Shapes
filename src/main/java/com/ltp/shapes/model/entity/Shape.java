package com.ltp.shapes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

enum ShapeType{
    SQUARE, CIRCLE, TRIANGLE, RECTANGLE
}

@Data
@AllArgsConstructor
public class Shape {

    private List<Point> points;
    private ShapeType type;

    public void addPoint(Point point){
        points.add(point);
    }

    @Override
    public String toString(){
        return String.format("%s -> { %s }", points.stream()
                                                    .map(Point::toString)
                                                    .collect(Collectors.joining(", ")));
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != getClass()) return false;
        Shape shape = (Shape)o;
        return (shape.getType() == type && shape.getPoints().equals(points));
    }

    @Override
    public int hashCode(){
        int result = 19 * type.name().hashCode() + points.stream().mapToInt(Point::hashCode).sum();
        return result;
    }

}
