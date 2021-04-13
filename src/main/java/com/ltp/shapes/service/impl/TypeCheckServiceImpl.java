package com.ltp.shapes.service.impl;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.service.TypeCheckService;
import com.ltp.shapes.util.Util;
import com.ltp.shapes.validator.ShapeValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TypeCheckServiceImpl implements TypeCheckService {

    private static TypeCheckServiceImpl instance;

    public static TypeCheckServiceImpl getInstance(){
        if(instance == null){
            instance = new TypeCheckServiceImpl();
        }

        return instance;
    }

    @Override
    public boolean isRightTriangle(Triangle triangle) throws ShapeException {
        if(!ShapeValidator.validateTriangle(triangle)){
            throw new ShapeException("Invalid input triangle");
        }

        double a = Math.pow(Util.calculateDistance(triangle.getP1(), triangle.getP2()), 2);
        double b = Math.pow(Util.calculateDistance(triangle.getP2(), triangle.getP3()), 2);
        double c = Math.pow(Util.calculateDistance(triangle.getP3(), triangle.getP1()), 2);

        boolean result = (a + b == c) || (a + c == b) || (b + c == a);

        return result;
    }

    @Override
    public boolean isEquilateralTriangle(Triangle triangle) throws ShapeException {
        if(!ShapeValidator.validateTriangle(triangle)){
            throw new ShapeException("Invalid input triangle");
        }
        double a = Util.calculateDistance(triangle.getP1(), triangle.getP2());
        double b = Util.calculateDistance(triangle.getP2(), triangle.getP3());
        double c = Util.calculateDistance(triangle.getP3(), triangle.getP1());
        boolean isEquilateral = (a == b) && (a == c);
        return isEquilateral;
    }

    @Override
    public boolean isIsoscelesTriangle(Triangle triangle) throws ShapeException {
        if(!ShapeValidator.validateTriangle(triangle)){
            throw new ShapeException("Invalid input triangle");
        }
        double a = Util.calculateDistance(triangle.getP1(), triangle.getP2());
        double b = Util.calculateDistance(triangle.getP2(), triangle.getP3());
        double c = Util.calculateDistance(triangle.getP3(), triangle.getP1());
        boolean isIsosceles = (a == b) || (a == c) || (b == c);
        return isIsosceles;
    }

    @Override
    public boolean isAcuteAngledTriangle(Triangle triangle) throws ShapeException {
        if(!ShapeValidator.validateTriangle(triangle)){
            throw new ShapeException("Invalid input triangle");
        }

        double a = Math.pow(Util.calculateDistance(triangle.getP1(), triangle.getP2()), 2);
        double b = Math.pow(Util.calculateDistance(triangle.getP2(), triangle.getP3()), 2);
        double c = Math.pow(Util.calculateDistance(triangle.getP3(), triangle.getP1()), 2);

        boolean result = (a + b < c) || (a + c < b) || (b + c < a);

        return result;
    }

    @Override
    public boolean isObtuseTriangle(Triangle triangle) throws ShapeException {
        if(!ShapeValidator.validateTriangle(triangle)){
            throw new ShapeException("Invalid input triangle");
        }

        double a = Math.pow(Util.calculateDistance(triangle.getP1(), triangle.getP2()), 2);
        double b = Math.pow(Util.calculateDistance(triangle.getP2(), triangle.getP3()), 2);
        double c = Math.pow(Util.calculateDistance(triangle.getP3(), triangle.getP1()), 2);

        boolean result = (a + b > c) || (a + c > b) || (b + c > a);

        return result;
    }
}
