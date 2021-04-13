package com.ltp.shapes.service;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.model.entity.Triangle;

public interface TypeCheckService {
    boolean isRightTriangle(Triangle triangle) throws ShapeException;
    boolean isEquilateralTriangle(Triangle triangle) throws ShapeException;
    boolean isIsoscelesTriangle(Triangle triangle) throws ShapeException;
    boolean isAcuteAngledTriangle(Triangle triangle) throws ShapeException;
    boolean isObtuseTriangle(Triangle triangle) throws ShapeException;
}
