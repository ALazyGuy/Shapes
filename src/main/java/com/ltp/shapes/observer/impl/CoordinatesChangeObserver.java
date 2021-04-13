package com.ltp.shapes.observer.impl;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.observer.Observer;
import com.ltp.shapes.service.CalculateService;
import com.ltp.shapes.service.impl.CalculateServiceImpl;
import com.ltp.shapes.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EventObject;

public class CoordinatesChangeObserver implements Observer {

    private static final Logger LOGGER = LogManager.getLogger(CoordinatesChangeObserver.class);

    @Override
    public void update(EventObject object){
        try {
            CalculateService calculateService = CalculateServiceImpl.getInstance();
            Triangle current = (Triangle) object.getSource();
            double area = calculateService.calculateArea(current);
            double perimeter = calculateService.calculatePerimeter(current);
            Warehouse.getInstance().setParameters(current.getId(), perimeter, area);
        }catch(ShapeException e){
            LOGGER.log(Level.WARN, e.getMessage());
        }
    }
}
