package com.ltp.shapes.service.impl;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.model.entity.Point;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.service.CalculateService;
import com.ltp.shapes.validator.ShapeValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CalculateServiceImpl implements CalculateService {

    private static CalculateServiceImpl instance;

    public static CalculateServiceImpl getInstance(){
        if(instance == null){
            instance = new CalculateServiceImpl();
        }

        return instance;
    }

    @Override
    public double calculateArea(Triangle triangle) throws ShapeException{
        if(!ShapeValidator.validateTriangle(triangle)){
            throw new ShapeException("Invalid input triangle");
        }
        double a = calculateDistance(triangle.getP1(), triangle.getP2());
        double b = calculateDistance(triangle.getP2(), triangle.getP3());
        double c = calculateDistance(triangle.getP3(), triangle.getP1());
        double p = (a + b + c) / 2;
        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return result;
    }

    @Override
    public double calculatePerimeter(Triangle triangle) throws ShapeException{
        if(!ShapeValidator.validateTriangle(triangle)){
            throw new ShapeException("Invalid input triangle");
        }
        double result = calculateDistance(triangle.getP1(), triangle.getP2());
        result += calculateDistance(triangle.getP2(), triangle.getP3());
        result += calculateDistance(triangle.getP3(), triangle.getP1());
        return result;
    }

    private double calculateDistance(Point p1,Point p2){
        double dx = Math.abs(p1.getX() - p2.getX());
        double dy = Math.abs(p1.getY() - p2.getY());
        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return distance;
    }
}
