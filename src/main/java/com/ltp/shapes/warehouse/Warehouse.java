package com.ltp.shapes.warehouse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Warehouse {

    private static Map<Integer, Double> areas = new HashMap<>();
    private static Map<Integer, Double> perimeters = new HashMap<>();

    private static Warehouse instance;

    public static Warehouse getInstance(){
        if(instance == null){
            instance = new Warehouse();
        }

        return instance;
    }

    public void setParameters(int id, double perimeter, double area){
        areas.put(id, area);
        perimeters.put(id, perimeter);
    }

    public double getArea(int id){
        return areas.get(id);
    }

    public double getPerimeter(int id){
        return perimeters.get(id);
    }

}
