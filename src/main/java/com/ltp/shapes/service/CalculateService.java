package com.ltp.shapes.service;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.model.entity.Triangle;

public interface CalculateService {
    double calculateArea(Triangle triangle) throws ShapeException;
    double calculatePerimeter(Triangle triangle) throws ShapeException;
}
