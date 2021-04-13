package com.ltp.shapes.observer.impl;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.observer.Observer;
import com.ltp.shapes.service.CalculateService;
import com.ltp.shapes.service.impl.CalculateServiceImpl;
import com.ltp.shapes.warehouse.Warehouse;

import java.util.EventObject;

public class CoordinatesChangeObserver implements Observer {

    @Override
    public void update(EventObject object) throws ShapeException {
        CalculateService calculateService = CalculateServiceImpl.getInstance();
        Triangle current = (Triangle)object.getSource();
        double area = calculateService.calculateArea(current);
        double perimeter = calculateService.calculatePerimeter(current);
        Warehouse.getInstance().setParameters(current.getId(), perimeter, area);
    }
}
