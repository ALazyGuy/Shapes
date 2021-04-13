package com.ltp.shapes.service.impl;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.service.CalculateService;
import com.ltp.shapes.util.Util;
import com.ltp.shapes.validator.ShapeValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CalculateServiceImpl implements CalculateService {

    private static final Logger LOGGER = LogManager.getLogger(CalculateServiceImpl.class);
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
            LOGGER.log(Level.ERROR, "Invalid input array in [calculateArea]");
            throw new ShapeException("Invalid input triangle");
        }
        double a = Util.calculateDistance(triangle.getP1(), triangle.getP2());
        double b = Util.calculateDistance(triangle.getP2(), triangle.getP3());
        double c = Util.calculateDistance(triangle.getP3(), triangle.getP1());
        double p = (a + b + c) / 2;
        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        LOGGER.log(Level.INFO, String.format("Area of %s is %f", triangle.toString(), result));
        return result;
    }

    @Override
    public double calculatePerimeter(Triangle triangle) throws ShapeException{
        if(!ShapeValidator.validateTriangle(triangle)){
            LOGGER.log(Level.ERROR, "Invalid input array in [calculatePerimeter]");
            throw new ShapeException("Invalid input triangle");
        }
        double result = Util.calculateDistance(triangle.getP1(), triangle.getP2());
        result += Util.calculateDistance(triangle.getP2(), triangle.getP3());
        result += Util.calculateDistance(triangle.getP3(), triangle.getP1());
        LOGGER.log(Level.DEBUG, String.format("Perimeter of %s is %f", triangle.toString(), result));
        return result;
    }


}
